#!/usr/bin/env python3
"""
Comprehensive porting script for BotClient: 1.12.2 → 1.21.4 Fabric
Fixes all imports, class references, and API changes
"""

import os
import re
from pathlib import Path

SRC_DIR = Path("/workspace/src/main/java/com/botclient")

# Comprehensive mapping of 1.12.2 classes to 1.21.4 equivalents
CLASS_REPLACEMENTS = {
    # Interfaces that no longer exist - remove implements
    'implements INetHandlerPlayClient': 'implements ClientPlayPacketListener',
    'implements IThreadListener': '// IThreadListener removed in 1.21.4',
    'ISnooperInfo': '// ISnooperInfo removed in 1.21.4',
    
    # Network handlers
    'INetHandlerPlayClient': 'ClientPlayPacketListener',
    'INetHandler': 'PacketListener',
    
    # Threading utilities
    'IThreadListener': 'ThreadExecutor',
    
    # Entity classes - many renamed or relocated
    'LeashKnotEntity': 'LeashKnotEntity',  # exists but may need correct import
    'ArmorStandEntity': 'ArmorStandEntity',
    'BoatEntity': 'BoatEntity',
    'EnderCrystalEntity': 'EndCrystalEntity',  # renamed
    'EnderEyeEntity': 'EyeOfEnderEntity',  # renamed
    'EnderPearlEntity': 'EnderPearlEntity',
    'ExpBottleEntity': 'ExperienceBottleEntity',  # renamed
    'FireworkRocketEntity': 'FireworkRocketEntity',
    'ItemFrameEntity': 'ItemFrameEntity',
    'MinecartEntity': 'MinecartEntity',
    'PaintingEntity': 'PaintingEntity',
    'TNTPrimedEntity': 'TntEntity',  # renamed
    'XPOrbEntity': 'ExperienceOrbEntity',  # renamed
    'EggEntity': 'EggEntity',
    'EvokerFangsEntity': 'EvokerFangsEntity',
    'FishHookEntity': 'FishingBobberEntity',  # renamed
    'LargeFireballEntity': 'LargeFireballEntity',
    'PotionEntity': 'PotionEntity',
    'SnowballEntity': 'SnowballEntity',
    'TippedArrowEntity': 'TippedArrowEntity',
    
    # Player/Entity related
    'EntityPlayerSP': 'ClientPlayerEntity',
    'EntityPlayer': 'PlayerEntity',
    'EntityLivingBase': 'LivingEntity',
    'PlayerCapabilities': '// PlayerCapabilities removed - use GameMode',
    'IJumpingMount': '// IJumpingMount removed',
    'MoverType': 'MovementType',
    'EnumPlayerModelParts': 'PlayerModelPart',
    'HandSide': 'Arm',
    'MovementInput': '// MovementInput removed - use Input',
    
    # World related
    'WorldClient': 'ClientWorld',
    'WorldProvider': 'DimensionRegistry',
    'WorldProviderSurface': 'Overworld',
    'WorldSettings': 'GameMode',
    'IInteractionObject': 'NamedScreenHandlerFactory',
    'DimensionType': 'DimensionOptions',
    'EnumDifficulty': 'Difficulty',
    'IChunkProvider': 'ChunkProvider',
    'ChunkProviderClient': 'ClientChunkManager',
    'IntHashMap': 'Int2ObjectOpenHashMap',  # from fastutil
    
    # Storage
    'ISaveHandler': 'ServerSaveHandler',
    'SaveDataMemoryStorage': '// Removed',
    'SaveHandlerMP': '// Removed',
    'WorldInfo': 'ServerWorldProperties',
    'MapData': 'MapState',
    'WorldSavedData': 'PersistentState',
    
    # Scoreboard
    'Score': 'ScoreboardCriterion',
    'ScoreObjective': 'ScoreboardObjective',
    'ScorePlayerTeam': 'Team',
    
    # Screen/Container
    'ScreenHandlerBeacon': 'BeaconScreenHandler',
    'ScreenHandlerBrewingStand': 'BrewingStandScreenHandler',
    'ScreenHandlerChest': 'GenericContainerScreenHandler',
    'ScreenHandlerDispenser': 'DispenserScreenHandler',
    'ScreenHandlerEnchantment': 'EnchantmentScreenHandler',
    'ScreenHandlerFurnace': 'FurnaceScreenHandler',
    'ScreenHandlerHopper': 'HopperScreenHandler',
    'ScreenHandlerHorseInventory': 'HorseScreenHandler',
    'ScreenHandlerMerchant': 'MerchantScreenHandler',
    'ScreenHandlerShulkerBox': 'ShulkerBoxScreenHandler',
    'Container': 'ScreenHandler',
    'InventoryPlayer': 'PlayerInventory',
    'GameSettings': 'GameOptions',
    
    # Items
    'ItemElytra': 'ElytraItem',
    'ItemMap': 'FilledMapItem',
    
    # Crafting/Recipes
    'IRecipe': 'Recipe',
    'RecipeBook': 'RecipeBook',
    
    # Stats
    'StatBase': 'Statistic',
    'StatisticsManager': 'StatHandler',
    
    # Utils
    'DamageSource': 'DamageSource',
    'SoundEvent': 'SoundEvent',
    'StringUtils': '// StringUtils removed - use Text utils',
    'EntitySelectors': 'EntityPredicates',
    
    # Packets - StatusQueryC2SPacket doesn't exist, use QueryRequestS2CPacket pattern
    'StatusQueryC2SPacket': '// Use direct packet construction',
    
    # Entity packets - these have been consolidated
    'EntityS2CPacketAttach': 'EntityPassengersSetS2CPacket',
    'EntityS2CPacketEffect': '// Consolidated',
    'EntityS2CPacketEquipment': 'EntityEquipmentUpdateS2CPacket',
    'EntityS2CPacketHeadLook': 'EntityRotationS2CPacket',
    'EntityS2CPacketMetadata': 'EntityDataTrackerUpdateS2CPacket',
    'EntityS2CPacketProperties': 'EntityAttributesS2CPacket',
    'EntityS2CPacketStatus': 'EntityAnimationS2CPacket',
    'EntityS2CPacketTeleport': 'EntityPositionS2CPacket',
    'EntityS2CPacketVelocity': 'EntityVelocityUpdateS2CPacket',
    
    # Other
    'MessageType': 'ChatType',
    'Explosion': 'Explosion',
    'GameType': 'GameMode',
    'Material': 'MapColor',
    'PlayerMoveC2SPacketAbilities': 'PlayerAbilitiesC2SPacket',
    'DataParameter': 'TrackedData',
    'EntityDataManager': 'DataTracker',
}

# Import path corrections
IMPORT_FIXES = {
    # Remove non-existent imports
    'import net.minecraft.entity.LeashKnotEntity;': '// LeashKnotEntity -> check package',
    'import net.minecraft.entity.ArmorStandEntity;': '// ArmorStandEntity -> check package',
    'import net.minecraft.entity.BoatEntity;': '// BoatEntity -> check package',
    'import net.minecraft.entity.EnderCrystalEntity;': 'import net.minecraft.entity.decoration.EndCrystalEntity;',
    'import net.minecraft.entity.EnderEyeEntity;': 'import net.minecraft.entity.projectile.EyeOfEnderEntity;',
    'import net.minecraft.entity.EnderPearlEntity;': 'import net.minecraft.entity.projectile.EnderPearlEntity;',
    'import net.minecraft.entity.ExpBottleEntity;': 'import net.minecraft.entity.projectile.ExperienceBottleEntity;',
    'import net.minecraft.entity.FireworkRocketEntity;': 'import net.minecraft.entity.projectile.FireworkRocketEntity;',
    'import net.minecraft.entity.ItemFrameEntity;': 'import net.minecraft.entity.decoration.ItemFrameEntity;',
    'import net.minecraft.entity.MinecartEntity;': 'import net.minecraft.entity.vehicle.MinecartEntity;',
    'import net.minecraft.entity.PaintingEntity;': 'import net.minecraft.entity.decoration.PaintingEntity;',
    'import net.minecraft.entity.TNTPrimedEntity;': 'import net.minecraft.entity.TntEntity;',
    'import net.minecraft.entity.XPOrbEntity;': 'import net.minecraft.entity.ExperienceOrbEntity;',
    'import net.minecraft.entity.projectile.EggEntity;': 'import net.minecraft.entity.projectile.EggEntity;',
    'import net.minecraft.entity.projectile.EvokerFangsEntity;': 'import net.minecraft.entity.projectile.EvokerFangsEntity;',
    'import net.minecraft.entity.projectile.FishHookEntity;': 'import net.minecraft.entity.projectile.FishingBobberEntity;',
    'import net.minecraft.entity.projectile.LargeFireballEntity;': 'import net.minecraft.entity.projectile.LargeFireballEntity;',
    'import net.minecraft.entity.projectile.PotionEntity;': 'import net.minecraft.entity.projectile.PotionEntity;',
    'import net.minecraft.entity.projectile.SnowballEntity;': 'import net.minecraft.entity.projectile.SnowballEntity;',
    'import net.minecraft.entity.projectile.TippedArrowEntity;': 'import net.minecraft.entity.projectile.TippedArrowEntity;',
    
    # Remove non-existent packet imports
    'import net.minecraft.network.packet.s2c.play.EntityS2CPacketAttach;': '// Consolidated in 1.21.4',
    'import net.minecraft.network.packet.s2c.play.EntityS2CPacketEffect;': '// Consolidated in 1.21.4',
    'import net.minecraft.network.packet.s2c.play.EntityS2CPacketEquipment;': 'import net.minecraft.network.packet.s2c.play.EntityEquipmentUpdateS2CPacket;',
    'import net.minecraft.network.packet.s2c.play.EntityS2CPacketHeadLook;': 'import net.minecraft.network.packet.s2c.play.EntityRotationS2CPacket;',
    'import net.minecraft.network.packet.s2c.play.EntityS2CPacketMetadata;': '// Data tracker updates',
    'import net.minecraft.network.packet.s2c.play.EntityS2CPacketProperties;': 'import net.minecraft.network.packet.s2c.play.EntityAttributesS2CPacket;',
    'import net.minecraft.network.packet.s2c.play.EntityS2CPacketStatus;': 'import net.minecraft.network.packet.s2c.play.EntityAnimationS2CPacket;',
    'import net.minecraft.network.packet.s2c.play.EntityS2CPacketTeleport;': 'import net.minecraft.network.packet.s2c.play.EntityPositionS2CPacket;',
    'import net.minecraft.network.packet.s2c.play.EntityS2CPacketVelocity;': 'import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;',
    
    # Scoreboard imports
    'import net.minecraft.scoreboard.Score;': '// Score system changed',
    'import net.minecraft.scoreboard.ScoreObjective;': 'import net.minecraft.scoreboard.ScoreboardObjective;',
    'import net.minecraft.scoreboard.ScorePlayerTeam;': 'import net.minecraft.scoreboard.Team;',
    
    # Utility imports to remove
    'import net.minecraft.util.IThreadListener;': '// IThreadListener removed',
    'import net.minecraft.util.StringUtils;': '// StringUtils removed',
    
    # Text/Chat
    'import net.minecraft.text.MessageType;': 'import net.minecraft.network.message.MessageType;',
    
    # World
    'import net.minecraft.world.Explosion;': 'import net.minecraft.world.explosion.Explosion;',
    'import net.minecraft.world.GameType;': 'import net.minecraft.world.GameMode;',
    'import net.minecraft.world.IInteractionObject;': 'import net.minecraft.screen.NamedScreenHandlerFactory;',
    'import net.minecraft.world.WorldProvider;': '// Dimension handling changed',
    'import net.minecraft.world.WorldProviderSurface;': '// Overworld constant',
    'import net.minecraft.world.WorldSettings;': 'import net.minecraft.world.GameMode;',
    'import net.minecraft.world.storage.MapData;': 'import net.minecraft.item.map.MapState;',
    'import net.minecraft.world.storage.WorldSavedData;': 'import net.minecraft.server.world.PersistentState;',
    
    # Chunk/World provider
    'import net.minecraft.client.multiplayer.ChunkProviderClient;': 'import net.minecraft.client.world.ClientChunkManager;',
    'import net.minecraft.util.IntHashMap;': 'import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;',
    'import net.minecraft.world.DimensionType;': 'import net.minecraft.world.dimension.DimensionOptions;',
    'import net.minecraft.world.EnumDifficulty;': 'import net.minecraft.world.Difficulty;',
    'import net.minecraft.world.chunk.IChunkProvider;': 'import net.minecraft.world.chunk.ChunkProvider;',
    'import net.minecraft.world.storage.ISaveHandler;': 'import net.minecraft.server.SaveHandler;',
    'import net.minecraft.world.storage.SaveDataMemoryStorage;': '// Removed',
    'import net.minecraft.world.storage.SaveHandlerMP;': '// Removed',
    'import net.minecraft.world.storage.WorldInfo;': 'import net.minecraft.world.level.LevelInfo;',
    
    # Entity interfaces
    'import net.minecraft.entity.IJumpingMount;': '// Removed',
    'import net.minecraft.entity.MoverType;': 'import net.minecraft.entity.MovementType;',
    'import net.minecraft.entity.BoatEntity;': 'import net.minecraft.entity.vehicle.BoatEntity;',
    'import net.minecraft.entity.player.EnumPlayerModelParts;': 'import net.minecraft.entity.player.PlayerEntity.PlayerModelPart;',
    'import net.minecraft.util.HandSide;': 'import net.minecraft.util.Arm;',
    'import net.minecraft.util.MovementInput;': '// Use Keyboard/Input',
    
    # Screen handlers
    'import net.minecraft.screen.ScreenHandlerBeacon;': 'import net.minecraft.screen.BeaconScreenHandler;',
    'import net.minecraft.screen.ScreenHandlerBrewingStand;': 'import net.minecraft.screen.BrewingStandScreenHandler;',
    'import net.minecraft.screen.ScreenHandlerChest;': 'import net.minecraft.screen.GenericContainerScreenHandler;',
    'import net.minecraft.screen.ScreenHandlerDispenser;': 'import net.minecraft.screen.DispenserScreenHandler;',
    'import net.minecraft.screen.ScreenHandlerEnchantment;': 'import net.minecraft.screen.EnchantmentScreenHandler;',
    'import net.minecraft.screen.ScreenHandlerFurnace;': 'import net.minecraft.screen.FurnaceScreenHandler;',
    'import net.minecraft.screen.ScreenHandlerHopper;': 'import net.minecraft.screen.HopperScreenHandler;',
    'import net.minecraft.screen.ScreenHandlerHorseInventory;': 'import net.minecraft.screen.HorseScreenHandler;',
    'import net.minecraft.screen.ScreenHandlerMerchant;': 'import net.minecraft.screen.MerchantScreenHandler;',
    'import net.minecraft.screen.ScreenHandlerShulkerBox;': 'import net.minecraft.screen.ShulkerBoxScreenHandler;',
    
    # Items
    'import net.minecraft.item.ItemElytra;': 'import net.minecraft.item.ElytraItem;',
    'import net.minecraft.item.crafting.IRecipe;': 'import net.minecraft.recipe.Recipe;',
    
    # Network data sync
    'import net.minecraft.network.datasync.DataParameter;': 'import net.minecraft.entity.data.TrackedData;',
    'import net.minecraft.network.datasync.EntityDataManager;': 'import net.minecraft.entity.data.DataTracker;',
    
    # Stats
    'import net.minecraft.stats.RecipeBook;': 'import net.minecraft.recipe.book.RecipeBook;',
    'import net.minecraft.stats.StatBase;': 'import net.minecraft.stat.Stat;',
    'import net.minecraft.stats.StatisticsManager;': 'import net.minecraft.stat.Stats;',
    
    # Utils
    'import net.minecraft.util.DamageSource;': 'import net.minecraft.entity.damage.DamageSource;',
    'import net.minecraft.util.SoundEvent;': 'import net.minecraft.sound.SoundEvent;',
    'import net.minecraft.block.material.Material;': 'import net.minecraft.block.MapColor;',
    'import net.minecraft.util.EntitySelectors;': 'import net.minecraft.entity.EntityPredicates;',
    
    # Player abilities packet
    'import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacketAbilities;': 'import net.minecraft.network.packet.c2s.play.PlayerAbilitiesC2SPacket;',
    
    # Status query packet - doesn't exist in this form
    'import net.minecraft.network.packet.status.client.StatusQueryC2SPacket;': '// Handled differently in 1.21.4',
    
    # javax.annotation
    'import javax.annotation.Nullable;': 'import org.jetbrains.annotations.Nullable;',
}

# Code pattern replacements
CODE_REPLACEMENTS = {
    # Minecraft instance
    r'Minecraft\.getMinecraft\(\)': 'MinecraftClient.getInstance()',
    r'MinecraftClient\.getMinecraft\(\)': 'MinecraftClient.getInstance()',
    
    # Player access
    r'\.player': '.player',
    
    # GUI methods
    r'\.displayGuiScreen\(': '.setScreen(',
    r'\.fontRenderer': '.textRenderer',
    r'\.ingameGUI': '.inGameHud',
    r'\.getChatGUI\(\)': '.getChatHud()',
    r'\.printChatMessage\(': '.addMessage(',
    
    # Text formatting
    r'TextFormatting\.': 'Formatting.',
    r'EnumChatFormatting\.': 'Formatting.',
    
    # Resource locations
    r'new ResourceLocation\(': 'new Identifier(',
    
    # Math
    r'RayTraceResult': 'HitResult',
    r'EnumFacing': 'Direction',
    r'EnumHand': 'Hand',
    
    # Block state
    r'IBlockState': 'BlockState',
    r'getBlockState': 'getBlockState',
    
    # NonNullList
    r'NonNullList': 'DefaultedList',
    
    # Vecmath to JOML
    r'javax\.vecmath\.Vector': 'org.joml.Vector',
}


def process_file(filepath: Path):
    """Process a single Java file and apply all fixes."""
    try:
        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()
    except Exception as e:
        print(f"Error reading {filepath}: {e}")
        return False
    
    original = content
    
    # Apply import fixes first
    for old, new in IMPORT_FIXES.items():
        content = content.replace(old, new)
    
    # Apply class replacements
    for old, new in CLASS_REPLACEMENTS.items():
        content = content.replace(old, new)
    
    # Apply code pattern replacements (regex)
    for pattern, replacement in CODE_REPLACEMENTS.items():
        content = re.sub(pattern, replacement, content)
    
    # Fix duplicate imports
    lines = content.split('\n')
    seen_imports = set()
    unique_lines = []
    in_import_section = False
    
    for line in lines:
        if line.strip().startswith('import '):
            in_import_section = True
            if line not in seen_imports and '//' not in line:
                seen_imports.add(line)
                unique_lines.append(line)
            elif '//' in line:
                unique_lines.append(line)
        else:
            if in_import_section and line.strip() == '':
                pass
            in_import_section = False
            unique_lines.append(line)
    
    content = '\n'.join(unique_lines)
    
    if content != original:
        try:
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)
            return True
        except Exception as e:
            print(f"Error writing {filepath}: {e}")
            return False
    
    return False


def main():
    """Main function to process all Java files."""
    fixed_count = 0
    total_count = 0
    
    java_files = list(SRC_DIR.rglob("*.java"))
    total_count = len(java_files)
    
    print(f"Processing {total_count} Java files...")
    
    for filepath in java_files:
        if process_file(filepath):
            fixed_count += 1
            print(f"Fixed: {filepath.relative_to(SRC_DIR)}")
    
    print(f"\nCompleted! Fixed {fixed_count}/{total_count} files.")


if __name__ == "__main__":
    main()
