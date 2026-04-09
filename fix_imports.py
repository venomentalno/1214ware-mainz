#!/usr/bin/env python3
import os
import re

# Mapping of old 1.12.2 imports to 1.21.4 Fabric equivalents
import_replacements = {
    # Client classes
    'import net.minecraft.client.MinecraftClient;': 'import net.minecraft.client.MinecraftClient;',
    'import net.minecraft.text.TextFormat;': 'import net.minecraft.text.Formatting;',
    
    # Network - EnumConnectionState doesn't exist in 1.21.4, use NetworkPhase
    'import net.minecraft.network.EnumConnectionState;': '// Removed: EnumConnectionState not in 1.21.4',
    
    # Packet imports - these are correct for 1.21.4 but may need fixes
    'import net.minecraft.network.packet.Packet;': 'import net.minecraft.network.packet.Packet;',
    
    # Vecmath - use Fabric's built-in math or Apache Commons Math
    'import javax.vecmath.Vector2f;': 'import org.joml.Vector2f;',
    
    # Block properties removed in newer versions
    'import net.minecraft.block.BlockColored;': '// Removed: BlockColored not in 1.21.4',
    'import net.minecraft.block.properties.IProperty;': '// Removed: IProperty not in 1.21.4',
    'import net.minecraft.block.properties.PropertyEnum;': '// Removed: PropertyEnum not in 1.21.4',
    
    # Entity/Player classes - already updated
    'import net.minecraft.entity.player.InventoryPlayer;': 'import net.minecraft.entity.player.PlayerInventory;',
    'import net.minecraft.entity.player.PlayerCapabilities;': '// Removed: PlayerCapabilities replaced',
    
    # Item classes
    'import net.minecraft.item.EnumDyeColor;': 'import net.minecraft.util.DyeColor;',
    'import net.minecraft.item.ArmorItem;': 'import net.minecraft.item.ArmorItem;',
    'import net.minecraft.item.ItemMap;': 'import net.minecraft.item.FilledMapItem;',
    
    # Network packets - CPacket naming is outdated
    'import net.minecraft.network.handshake.client.C00Handshake;': 'import net.minecraft.network.packet.c2s.handshake.HandshakeC2SPacket;',
    'import net.minecraft.network.login.client.CPacketLoginStart;': 'import net.minecraft.network.packet.c2s.login.LoginQueryResponseC2SPacket;',
    
    # Inventory
    'import net.minecraft.inventory.ContainerRepair;': 'import net.minecraft.screen.AnvilScreenHandler;',
    'import net.minecraft.inventory.EntityEquipmentSlot;': 'import net.minecraft.entity.EquipmentSlot;',
    
    # World
    'import net.minecraft.world.IBlockAccess;': 'import net.minecraft.world.BlockView;',
    'import net.minecraft.world.World;': 'import net.minecraft.world.World;',
    
    # Utils
    'import net.minecraft.util.NonNullList;': 'import net.minecraft.util.collection.DefaultedList;',
    'import net.minecraft.util.ITickable;': '// Removed: ITickable not in 1.21.4',
    
    # Network internals
    'import net.minecraft.network.NettyCompressionDecoder;': '// Internal - handled by Fabric',
    'import net.minecraft.network.NettyCompressionEncoder;': '// Internal - handled by Fabric',
    'import net.minecraft.network.ThreadQuickExitException;': '// Removed',
    'import net.minecraft.network.PacketBuffer;': 'import net.minecraft.network.PacketByteBuf;',
    
    # Session
    'import net.minecraft.client.session.Session;': 'import net.minecraft.client.session.Session;',
    
    # Text
    'import net.minecraft.text.Text;': 'import net.minecraft.text.Text;',
    'import net.minecraft.text.TranslatableText;': 'import net.minecraft.text.MutableText;',
}

# Additional replacements for specific packet classes
packet_replacements = {
    'CPacketCloseWindow': 'CloseHandledScreenC2SPacket',
    'CPacketCustomPayload': 'CustomPayloadC2SPacket',
    'CPacketHeldItemChange': 'SelectedSlotChangeC2SPacket',
    'PlayerMoveC2SPacketDigging': 'PlayerActionC2SPacket',
    'PlayerMoveC2SPacketTryUseItemOnBlock': 'PlayerInteractBlockC2SPacket',
    'PlayerInteractEntityC2SPacket': 'PlayerInteractEntityC2SPacket',
    'ChatMessageC2SPacket': 'ChatMessageC2SPacket',
}

src_dir = '/workspace/src/main/java/com/botclient'

for root, dirs, files in os.walk(src_dir):
    for file in files:
        if file.endswith('.java'):
            filepath = os.path.join(root, file)
            with open(filepath, 'r', encoding='utf-8') as f:
                content = f.read()
            
            original = content
            
            # Apply import replacements
            for old, new in import_replacements.items():
                content = content.replace(old, new)
            
            # Apply packet class name replacements
            for old, new in packet_replacements.items():
                content = content.replace(old, new)
            
            if content != original:
                with open(filepath, 'w', encoding='utf-8') as f:
                    f.write(content)
                print(f"Fixed: {file}")

print("Import fixing complete!")
