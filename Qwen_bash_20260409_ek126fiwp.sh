#!/bin/bash
# migrate_112_to_121.sh
# Automated import fixer for Minecraft 1.12.2 → 1.21.4 porting
# Usage: ./migrate_112_to_121.sh /path/to/your/src

set -e

SRC_DIR="${1:-src/main/java}"
BACKUP_DIR="${SRC_DIR}_backup_$(date +%Y%m%d_%H%M%S)"

echo "🔄 Starting 1.12.2 → 1.21.4 import migration..."
echo "📁 Source directory: $SRC_DIR"
echo "💾 Creating backup at: $BACKUP_DIR"

# Create backup
cp -r "$SRC_DIR" "$BACKUP_DIR"

# Counter for changes
CHANGES=0

# Helper function to apply sed replacement and count changes
apply_fix() {
    local pattern="$1"
    local replacement="$2"
    local description="$3"
    
    local count=$(grep -r "$pattern" "$SRC_DIR" --include="*.java" 2>/dev/null | wc -l || echo 0)
    if [ "$count" -gt 0 ]; then
        echo "🔧 $description: $count occurrences"
        find "$SRC_DIR" -name "*.java" -type f -exec sed -i "s|$pattern|$replacement|g" {} +
        CHANGES=$((CHANGES + count))
    fi
}

echo ""
echo "📦 Applying import fixes..."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

# ───────────────────────────────────────────
# TEXT & FORMATTING
# ───────────────────────────────────────────
apply_fix \
    "net\.minecraft\.text\.Formatting" \
    "net.minecraft.util.Formatting" \
    "Formatting import path"

# ───────────────────────────────────────────
# ENTITY CLASSES (1.12.2 → 1.21.4 renames)
# ───────────────────────────────────────────
apply_fix \
    "net\.minecraft\.entity\.EntityLiving" \
    "net.minecraft.entity.LivingEntity" \
    "EntityLiving → LivingEntity"

apply_fix \
    "net\.minecraft\.entity\.EntityTracker" \
    "net.minecraft.entity.tracked.TrackedEntity" \
    "EntityTracker → TrackedEntity"

apply_fix \
    "net\.minecraft\.entity\.IMerchant" \
    "net.minecraft.village.Merchant" \
    "IMerchant → Merchant"

apply_fix \
    "net\.minecraft\.entity\.NpcMerchant" \
    "net.minecraft.village.Merchant" \
    "NpcMerchant → Merchant"

apply_fix \
    "net\.minecraft\.entity\.passive\.AbstractHorse" \
    "net.minecraft.entity.passive.HorseEntity" \
    "AbstractHorse → HorseEntity"

apply_fix \
    "net\.minecraft\.entity\.EntityList" \
    "net.minecraft.registry.Registries.ENTITY_TYPE" \
    "EntityList → Registries.ENTITY_TYPE"

# Entity item classes moved from .item subpackage to main entity package
for entity in ArmorStand Boat EnderCrystal EnderEye EnderPearl ExpBottle FallingBlock FireworkRocket ItemFrame Minecart Painting TNTPrimed XPOrb; do
    apply_fix \
        "net\.minecraft\.entity\.item\.Entity${entity}" \
        "net.minecraft.entity.${entity}Entity" \
        "Entity${entity} → ${entity}Entity"
done

# Entity projectiles
for entity in Arrow DragonFireball Egg EvokerFangs FishHook LargeFireball LlamaSpit Potion ShulkerBullet SmallFireball Snowball SpectralArrow TippedArrow WitherSkull; do
    apply_fix \
        "net\.minecraft\.entity\.projectile\.Entity${entity}" \
        "net.minecraft.entity.projectile.${entity}Entity" \
        "Entity${entity} → ${entity}Entity"
done

# Special entity cases
apply_fix \
    "net\.minecraft\.entity\.effect\.EntityLightningBolt" \
    "net.minecraft.entity.LightningEntity" \
    "EntityLightningBolt → LightningEntity"

apply_fix \
    "net\.minecraft\.entity\.EntityAreaEffectCloud" \
    "net.minecraft.entity.AreaEffectCloudEntity" \
    "EntityAreaEffectCloud → AreaEffectCloudEntity"

apply_fix \
    "net\.minecraft\.entity\.EntityLeashKnot" \
    "net.minecraft.entity.LeashKnotEntity" \
    "EntityLeashKnot → LeashKnotEntity"

# ───────────────────────────────────────────
# CLIENT-SIDE CLASSES
# ───────────────────────────────────────────
apply_fix \
    "net\.minecraft\.client\.entity\.EntityOtherPlayerMP" \
    "net.minecraft.client.network.OtherClientPlayerEntity" \
    "EntityOtherPlayerMP → OtherClientPlayerEntity"

apply_fix \
    "net\.minecraft\.client\.network\.NetworkPlayerInfo" \
    "net.minecraft.client.network.PlayerListEntry" \
    "NetworkPlayerInfo → PlayerListEntry"

# ───────────────────────────────────────────
# INVENTORY & SCREENS
# ───────────────────────────────────────────
apply_fix \
    "net\.minecraft\.inventory\.Container" \
    "net.minecraft.screen.ScreenHandler" \
    "Container → ScreenHandler (base)"

apply_fix \
    "net\.minecraft\.inventory\.ContainerHorseChest" \
    "net.minecraft.screen.HorseScreenHandler" \
    "ContainerHorseChest → HorseScreenHandler"

apply_fix \
    "net\.minecraft\.inventory\.InventoryBasic" \
    "net.minecraft.inventory.SimpleInventory" \
    "InventoryBasic → SimpleInventory"

apply_fix \
    "net\.minecraft\.client\.player\.inventory\.ContainerLocalMenu" \
    "net.minecraft.client.gui.screen.ingame.HandledScreen" \
    "ContainerLocalMenu → HandledScreen"

apply_fix \
    "net\.minecraft\.client\.player\.inventory\.LocalBlockIntercommunication" \
    "net.minecraft.client.gui.screen.ingame.HandledScreen" \
    "LocalBlockIntercommunication → HandledScreen"

# ───────────────────────────────────────────
# NETWORK & PACKETS
# ───────────────────────────────────────────
apply_fix \
    "net\.minecraft\.network\.play\.INetHandlerPlayClient" \
    "net.minecraft.network.listener.ClientPlayPacketListener" \
    "INetHandlerPlayClient → ClientPlayPacketListener"

apply_fix \
    "net\.minecraft\.network\.PacketThreadUtil" \
    "net.minecraft.util.thread.ThreadExecutor" \
    "PacketThreadUtil → ThreadExecutor"

# Packet renaming: CPacket* → *C2SPacket (Client to Server)
for packet in ClientStatus ConfirmTeleport ConfirmTransaction KeepAlive ResourcePackStatus VehicleMove; do
    apply_fix \
        "net\.minecraft\.network\.packet\.c2s\.play\.CPacket${packet}" \
        "net.minecraft.network.packet.c2s.play.${packet}C2SPacket" \
        "CPacket${packet} → ${packet}C2SPacket"
done

# Custom payload packet
apply_fix \
    "net\.minecraft\.network\.packet\.c2s\.play\.CustomPayloadC2SPacket" \
    "net.minecraft.network.packet.c2s.play.CustomPayloadC2SPacket" \
    "CustomPayloadC2SPacket (verify usage)"

apply_fix \
    "net\.minecraft\.network\.packet\.c2s\.play\.SelectedSlotChangeC2SPacket" \
    "net.minecraft.network.packet.c2s.play.SelectedSlotChangeC2SPacket" \
    "SelectedSlotChangeC2SPacket (verify)"

# Packet renaming: SPacket* → *S2CPacket (Server to Client)
for packet in AdvancementInfo Animation BlockAction BlockBreakAnim BlockChange Camera ChangeGameState ChunkData CloseWindow CollectItem CombatEvent ConfirmTransaction Cooldown CustomPayload CustomSound DestroyEntities DisplayObjective Effect Entity EntityAttach EntityEffect EntityEquipment EntityHeadLook EntityMetadata EntityProperties EntityStatus EntityTeleport EntityVelocity Explosion HeldItemChange JoinGame Maps MoveVehicle MultiBlockChange OpenWindow Particles; do
    apply_fix \
        "net\.minecraft\.network\.packet\.s2c\.play\.SPacket${packet}" \
        "net.minecraft.network.packet.s2c.play.${packet}S2CPacket" \
        "SPacket${packet} → ${packet}S2CPacket"
done

# Special packet cases
apply_fix \
    "net\.minecraft\.network\.packet\.s2c\.play\.DisconnectS2CPacket" \
    "net.minecraft.network.packet.s2c.play.DisconnectS2CPacket" \
    "DisconnectS2CPacket (verify)"

apply_fix \
    "net\.minecraft\.network\.packet\.s2c\.play\.KeepAliveS2CPacket" \
    "net.minecraft.network.packet.s2c.play.KeepAliveS2CPacket" \
    "KeepAliveS2CPacket (verify)"

# Status packets
apply_fix \
    "net\.minecraft\.network\.status\.client\.StatusQueryC2SPacket" \
    "net.minecraft.network.packet.status.client.StatusQueryC2SPacket" \
    "StatusQueryC2SPacket path fix"

# ───────────────────────────────────────────
# ATTRIBUTES (1.12.2 → 1.21.4)
# ───────────────────────────────────────────
apply_fix \
    "net\.minecraft\.entity\.ai\.attributes\.AbstractAttributeMap" \
    "net.minecraft.entity.attribute.DefaultAttributeContainer" \
    "AbstractAttributeMap → DefaultAttributeContainer"

apply_fix \
    "net\.minecraft\.entity\.ai\.attributes\.AttributeModifier" \
    "net.minecraft.entity.attribute.EntityAttributeModifier" \
    "AttributeModifier → EntityAttributeModifier"

apply_fix \
    "net\.minecraft\.entity\.ai\.attributes\.IAttribute" \
    "net.minecraft.entity.attribute.EntityAttribute" \
    "IAttribute → EntityAttribute"

apply_fix \
    "net\.minecraft\.entity\.ai\.attributes\.IAttributeInstance" \
    "net.minecraft.entity.attribute.EntityAttributeInstance" \
    "IAttributeInstance → EntityAttributeInstance"

apply_fix \
    "net\.minecraft\.entity\.ai\.attributes\.RangedAttribute" \
    "net.minecraft.entity.attribute.ClampedEntityAttribute" \
    "RangedAttribute → ClampedEntityAttribute"

# ───────────────────────────────────────────
# UTIL & MISC
# ───────────────────────────────────────────
apply_fix \
    "net\.minecraft\.util\.Direction" \
    "net.minecraft.util.math.Direction" \
    "Direction → math.Direction (if needed)"

echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo "✅ Migration complete!"
echo "📊 Total replacements made: ~$CHANGES"
echo ""
echo "🔍 Next steps:"
echo "   1. Review changes: diff -r $BACKUP_DIR $SRC_DIR"
echo "   2. Fix any remaining manual mappings"
echo "   3. Update packet handler method signatures"
echo "   4. Rebuild: ./gradlew clean build"
echo ""
echo "⚠️  IMPORTANT: Some classes require code logic changes beyond imports!"
echo "   - Packet handling now uses interfaces, not direct method calls"
echo "   - Entity spawning/registration uses Registries API"
echo "   - Text components use Text.literal() / Text.translatable()"
echo ""