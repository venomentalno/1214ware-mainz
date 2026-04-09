#!/usr/bin/env python3
"""Final import fixes for Minecraft 1.21.4 Fabric"""
from pathlib import Path
import re

WORKSPACE = Path("/workspace/src/main/java/com/botclient")

# Correct import mappings for 1.21.4
IMPORT_FIXES = {
    # Minecraft client
    r'import net\.minecraft\.client\.Minecraft;': 'import net.minecraft.client.MinecraftClient;',
    r'Minecraft\.getMinecraft\(\)': 'MinecraftClient.getInstance()',
    r'Minecraft\.player': 'MinecraftClient.getInstance().player',
    
    # Text/Chat
    r'import net\.minecraft\.util\.text\.(TextFormatting|Formatting|EnumChatFormatting);': 'import net.minecraft.text.Formatting;',
    r'import net\.minecraft\.util\.text\.ITextComponent;': 'import net.minecraft.text.Text;',
    r'new LiteralTextContent\(': 'Text.literal(',
    r'TextFormat\.': 'Formatting.',
    
    # GUI
    r'import net\.minecraft\.client\.gui\.GuiScreen;': 'import net.minecraft.client.gui.screen.Screen;',
    r'extends GuiScreen': 'extends Screen',
    r'\.displayGuiScreen\(': '.setScreen(',
    r'\.fontRenderer': '.textRenderer',
    
    # Entities
    r'import net\.minecraft\.entity\.player\.EntityPlayer;': 'import net.minecraft.entity.player.PlayerEntity;',
    r'import net\.minecraft\.client\.entity\.EntityPlayerSP;': 'import net.minecraft.client.network.ClientPlayerEntity;',
    r'import net\.minecraft\.entity\.EntityLivingBase;': 'import net.minecraft.entity.LivingEntity;',
    
    # World
    r'import net\.minecraft\.client\.multiplayer\.WorldClient;': 'import net.minecraft.client.world.ClientWorld;',
    r'import net\.minecraft\.world\.IBlockAccess;': 'import net.minecraft.world.BlockView;',
    
    # Blocks/Items
    r'import net\.minecraft\.block\.state\.IBlockState;': 'import net.minecraft.block.BlockState;',
    r'import net\.minecraft\.item\.ItemStack;': 'import net.minecraft.item.ItemStack;',
    
    # Network/Packets
    r'import net\.minecraft\.network\.play\.client\.': 'import net.minecraft.network.packet.c2s.play.',
    r'import net\.minecraft\.network\.play\.server\.': 'import net.minecraft.network.packet.s2c.play.',
    r'import net\.minecraft\.network\.Packet;': 'import net.minecraft.network.packet.Packet;',
    r'import net\.minecraft\.network\.PacketBuffer;': 'import net.minecraft.network.PacketByteBuf;',
    
    # Math/Utils
    r'import net\.minecraft\.util\.math\.RayTraceResult;': 'import net.minecraft.util.hit.HitResult;',
    r'import net\.minecraft\.util\.EnumFacing;': 'import net.minecraft.util.math.Direction;',
    r'import net\.minecraft\.util\.EnumHand;': 'import net.minecraft.util.Hand;',
    r'import net\.minecraft\.util\.ResourceLocation;': 'import net.minecraft.util.Identifier;',
    r'new ResourceLocation\(': 'new Identifier(',
    
    # Rendering
    r'import net\.minecraft\.client\.renderer\.GlStateManager;': 'import net.minecraft.client.render.RenderSystem;',
    r'GlStateManager\.': 'RenderSystem.',
    r'import org\.lwjgl\.opengl\.GL11;': '// GL11 replaced with RenderSystem in 1.21.4',
    
    # Input
    r'import org\.lwjgl\.input\.Keyboard;': 'import net.minecraft.client.util.InputUtil;',
    r'import org\.lwjgl\.input\.Mouse;': 'import org.lwjgl.glfw.GLFW;',
    r'Keyboard\.isKeyDown\(': 'InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), ',
    r'Mouse\.isButtonDown\(': 'GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), ',
    
    # Inventory
    r'import net\.minecraft\.inventory\.EntityEquipmentSlot;': 'import net.minecraft.entity.EquipmentSlot;',
    r'import net\.minecraft\.util\.NonNullList;': 'import net.minecraft.util.collection.DefaultedList;',
    
    # Session
    r'import net\.minecraft\.util\.Session;': 'import net.minecraft.client.session.Session;',
    
    # Chat GUI
    r'\.ingameGUI': '.inGameHud',
    r'\.getChatGUI\(\)': '.getChatHud()',
    r'\.printChatMessage\(': '.addMessage(',
    
    # Vecmath -> JOML
    r'import javax\.vecmath\.Vector2f;': 'import org.joml.Vector2f;',
    r'import javax\.vecmath\.Vector3i;': 'import org.joml.Vector3i;',
}

def process_file(filepath):
    try:
        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()
    except:
        return False
    
    original = content
    for pattern, replacement in IMPORT_FIXES.items():
        content = re.sub(pattern, replacement, content)
    
    if content != original:
        with open(filepath, 'w', encoding='utf-8') as f:
            f.write(content)
        return True
    return False

def main():
    count = 0
    for filepath in WORKSPACE.rglob("*.java"):
        if process_file(filepath):
            count += 1
            print(f"Fixed: {filepath.name}")
    print(f"Total files fixed: {count}")

if __name__ == "__main__":
    main()
