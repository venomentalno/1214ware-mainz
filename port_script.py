#!/usr/bin/env python3
"""
Automated porting script for BotClient 1.12.2 -> 1.21.4
This script performs systematic replacements across all Java files
"""

import os
import re
from pathlib import Path

WORKSPACE = "/workspace/src/main/java/com/botclient"

# Package name replacements
PACKAGE_REPLACEMENTS = [
    # Minecraft class access
    ("Minecraft.getMinecraft()", "MinecraftClient.getInstance()"),
    ("import net.minecraft.client.Minecraft;", "import net.minecraft.client.MinecraftClient;"),
    
    # GUI classes
    ("import net.minecraft.client.gui.GuiScreen;", "import net.minecraft.client.gui.screen.Screen;"),
    ("extends GuiScreen", "extends Screen"),
    ("import net.minecraft.client.gui.GuiButton;", "import net.minecraft.client.gui.widget.ButtonWidget;"),
    ("import net.minecraft.client.gui.GuiTextField;", "import net.minecraft.client.gui.widget.TextFieldWidget;"),
    ("GuiButton", "ButtonWidget"),
    ("GuiTextField", "TextFieldWidget"),
    ("FontRenderer", "TextRenderer"),
    
    # ScaledResolution -> Window
    ("import net.minecraft.client.gui.ScaledResolution;", "import net.minecraft.client.util.Window;"),
    ("new ScaledResolution(", "// ScaledResolution replaced with Window calculation\n        Window window = "),
    ("ScaledResolution(", "Window("),
    ("getScaledWidth()", "getScaledWidth()"),
    ("getScaledHeight()", "getScaledHeight()"),
    ("getScaleFactor()", "getScaleFactor()"),
    
    # Entity classes
    ("EntityPlayer", "PlayerEntity"),
    ("EntityPlayerSP", "ClientPlayerEntity"),
    ("EntityLivingBase", "LivingEntity"),
    ("WorldClient", "ClientWorld"),
    ("import net.minecraft.client.entity.EntityPlayerSP;", "import net.minecraft.client.network.ClientPlayerEntity;"),
    ("import net.minecraft.entity.player.EntityPlayer;", "import net.minecraft.entity.player.PlayerEntity;"),
    ("import net.minecraft.entity.EntityLivingBase;", "import net.minecraft.entity.LivingEntity;"),
    ("import net.minecraft.client.multiplayer.WorldClient;", "import net.minecraft.client.world.ClientWorld;"),
    
    # Network/Packets
    ("CPacketPlayer", "PlayerMoveC2SPacket"),
    ("CPacketUseEntity", "PlayerInteractEntityC2SPacket"),
    ("CPacketChatMessage", "ChatMessageC2SPacket"),
    ("CPacketCreativeInventoryAction", "CreativeInventoryActionC2SPacket"),
    ("CPacketPlayerTryUseItem", "HandSwingC2SPacket"),
    ("CPacketPlayerDigging", "PlayerActionC2SPacket"),
    ("CPacketPlayerTryUseItemOnBlock", "PlayerInteractBlockC2SPacket"),
    ("SPacketChat", "ChatMessageS2CPacket"),
    ("SPacketDisconnect", "DisconnectS2CPacket"),
    ("SPacketKeepAlive", "KeepAliveS2CPacket"),
    ("import net.minecraft.network.play.client.", "import net.minecraft.network.packet.c2s.play."),
    ("import net.minecraft.network.play.server.", "import net.minecraft.network.packet.s2c.play."),
    ("import net.minecraft.network.Packet;", "import net.minecraft.network.packet.Packet;"),
    
    # Math/Positions
    ("RayTraceResult", "HitResult"),
    ("EnumFacing", "Direction"),
    ("EnumHand", "Hand"),
    ("import net.minecraft.util.math.RayTraceResult;", "import net.minecraft.util.hit.HitResult;"),
    ("import net.minecraft.util.EnumFacing;", "import net.minecraft.util.math.Direction;"),
    ("import net.minecraft.util.EnumHand;", "import net.minecraft.util.Hand;"),
    
    # Items/Blocks
    ("IBlockState", "BlockState"),
    ("import net.minecraft.block.state.IBlockState;", "import net.minecraft.block.BlockState;"),
    
    # Text/Chat
    ("ITextComponent", "Text"),
    ("TextComponentString", "LiteralTextContent"),
    ("TextFormatting", "Formatting"),
    ("EnumChatFormatting", "Formatting"),
    ("import net.minecraft.util.text.ITextComponent;", "import net.minecraft.text.Text;"),
    ("import net.minecraft.util.text.TextComponentString;", "import net.minecraft.text.LiteralTextContent;"),
    ("import net.minecraft.util.text.TextFormatting;", "import net.minecraft.text.Formatting;"),
    ("import net.minecraft.util.text.EnumChatFormatting;", "import net.minecraft.text.Formatting;"),
    
    # GlStateManager -> RenderSystem
    ("import net.minecraft.client.renderer.GlStateManager;", "import net.minecraft.client.render.RenderSystem;"),
    ("GlStateManager.pushMatrix()", "RenderSystem.pushMatrix()"),
    ("GlStateManager.popMatrix()", "RenderSystem.popMatrix()"),
    ("GlStateManager.translate(", "RenderSystem.translate("),
    ("GlStateManager.rotate(", "RenderSystem.rotate("),
    ("GlStateManager.scale(", "RenderSystem.scale("),
    ("GlStateManager.color(", "RenderSystem.setShaderColor("),
    ("GlStateManager.enableBlend()", "RenderSystem.enableBlend()"),
    ("GlStateManager.disableBlend()", "RenderSystem.disableBlend()"),
    ("GlStateManager.blendFunc(", "RenderSystem.blendFunc("),
    ("GlStateManager.disableTexture2D()", "RenderSystem.disableTexture()"),
    ("GlStateManager.enableTexture2D()", "RenderSystem.enableTexture()"),
    ("GlStateManager.disableLighting()", "RenderSystem.disableLighting()"),
    ("GlStateManager.enableAlpha()", "RenderSystem.enableBlend()"),
    ("GlStateManager.disableAlpha()", "RenderSystem.disableBlend()"),
    ("GlStateManager.depthMask(", "RenderSystem.depthMask("),
    ("GlStateManager.disableDepth()", "RenderSystem.disableDepthTest()"),
    ("GlStateManager.enableDepth()", "RenderSystem.enableDepthTest()"),
    
    # LWJGL updates (input system changed)
    ("import org.lwjgl.input.Keyboard;", "import net.minecraft.client.util.InputUtil;"),
    ("import org.lwjgl.input.Mouse;", "import org.lwjgl.glfw.GLFW;"),
    ("Keyboard.isKeyDown(", "InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), "),
    ("Mouse.isButtonDown(", "GLFW.glfwGetMouseButton(MinecraftClient.getInstance().getWindow().getHandle(), "),
    ("Mouse.getDWheel()", "GLFW.glfwGetScrollCallback"),
    ("Mouse.hasWheel()", "true"),
    ("Mouse.getX()", "0"),
    ("Mouse.getY()", "0"),
    
    # ResourceLocation
    ("import net.minecraft.util.ResourceLocation;", "import net.minecraft.util.Identifier;"),
    ("new ResourceLocation(", "new Identifier("),
    ("ResourceLocation(", "Identifier("),
    
    # ChatAllowedCharacters
    ("import net.minecraft.util.ChatAllowedCharacters;", "// ChatAllowedCharacters removed in 1.21.4"),
    
    # MathHelper
    ("import net.minecraft.util.math.MathHelper;", "import net.minecraft.util.math.MathHelper;"),
    
    # Tessellator
    ("import net.minecraft.client.renderer.Tessellator;", "import net.minecraft.client.render.Tessellator;"),
    ("Tessellator.getInstance().getBuffer()", "Tessellator.getInstance().getBuffer()"),
    
    # BufferBuilder
    ("import net.minecraft.client.renderer.vertex.DefaultVertexFormats;", "import net.minecraft.client.render.VertexFormats;"),
    ("DefaultVertexFormats.POSITION_TEX", "VertexFormats.POSITION_TEXTURE"),
    ("DefaultVertexFormats.POSITION", "VertexFormats.POSITION"),
    ("DefaultVertexFormats.POSITION_COLOR", "VertexFormats.POSITION_COLOR"),
    
    # GL11
    ("import org.lwjgl.opengl.GL11;", "import net.minecraft.client.render.RenderSystem;"),
    ("GL11.glPushMatrix()", "RenderSystem.pushMatrix()"),
    ("GL11.glPopMatrix()", "RenderSystem.popMatrix()"),
    ("GL11.glTranslatef(", "RenderSystem.translate("),
    ("GL11.glRotatef(", "RenderSystem.rotate("),
    ("GL11.glScalef(", "RenderSystem.scale("),
    ("GL11.glColor4f(", "RenderSystem.setShaderColor("),
    ("GL11.glEnable(", "// GL11 replaced with RenderSystem"),
    ("GL11.glDisable(", "// GL11 replaced with RenderSystem"),
    ("GL11.glBlendFunc(", "RenderSystem.blendFunc("),
]

def process_file(filepath):
    """Process a single Java file and apply all replacements"""
    try:
        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()
    except Exception as e:
        print(f"Error reading {filepath}: {e}")
        return False
    
    original_content = content
    
    # Apply all replacements
    for old, new in PACKAGE_REPLACEMENTS:
        content = content.replace(old, new)
    
    # Only write if changes were made
    if content != original_content:
        try:
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)
            return True
        except Exception as e:
            print(f"Error writing {filepath}: {e}")
            return False
    
    return False

def main():
    processed_count = 0
    error_count = 0
    
    java_files = list(Path(WORKSPACE).rglob("*.java"))
    print(f"Found {len(java_files)} Java files to process")
    
    for filepath in java_files:
        try:
            if process_file(str(filepath)):
                processed_count += 1
                print(f"Processed: {filepath.name}")
        except Exception as e:
            error_count += 1
            print(f"Error processing {filepath}: {e}")
    
    print(f"\n=== Porting Complete ===")
    print(f"Files processed: {processed_count}")
    print(f"Errors: {error_count}")

if __name__ == "__main__":
    main()
