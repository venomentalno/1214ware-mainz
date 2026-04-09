#!/bin/bash
# clean_broken_imports.sh
# Removes imports that don't exist in 1.21.4 to force manual rewriting

set -e
SRC_DIR="${1:-src/main/java}"

echo "🧹 Removing broken 1.12.2 imports from $SRC_DIR..."

# Backup first
cp -r "$SRC_DIR" "${SRC_DIR}_pre_clean_$(date +%s)"

# Remove ALL imports that reference non-existent 1.21.4 classes
# This forces you to manually add correct imports as you rewrite

find "$SRC_DIR" -name "*.java" -type f -exec sed -i \
  -e '/import net\.minecraft\.text\.Formatting;/d' \
  -e '/import net\.minecraft\.entity\.EntityLiving;/d' \
  -e '/import net\.minecraft\.entity\.EntityTracker;/d' \
  -e '/import net\.minecraft\.entity\.IMerchant;/d' \
  -e '/import net\.minecraft\.entity\.NpcMerchant;/d' \
  -e '/import net\.minecraft\.entity\.EntityList;/d' \
  -e '/import net\.minecraft\.entity\.item\.Entity/d' \
  -e '/import net\.minecraft\.entity\.projectile\.Entity/d' \
  -e '/import net\.minecraft\.entity\.effect\.EntityLightningBolt;/d' \
  -e '/import net\.minecraft\.entity\.EntityAreaEffectCloud;/d' \
  -e '/import net\.minecraft\.entity\.EntityLeashKnot;/d' \
  -e '/import net\.minecraft\.client\.entity\.EntityOtherPlayerMP;/d' \
  -e '/import net\.minecraft\.client\.network\.NetworkPlayerInfo;/d' \
  -e '/import net\.minecraft\.inventory\.Container/d' \
  -e '/import net\.minecraft\.inventory\.InventoryBasic;/d' \
  -e '/import net\.minecraft\.client\.player\.inventory\./d' \
  -e '/import net\.minecraft\.network\.play\.INetHandlerPlayClient;/d' \
  -e '/import net\.minecraft\.network\.PacketThreadUtil;/d' \
  -e '/import net\.minecraft\.network\.packet\.c2s\.play\.CPacket/d' \
  -e '/import net\.minecraft\.network\.packet\.s2c\.play\.SPacket/d' \
  -e '/import net\.minecraft\.network\.packet\.c2s\.play\.\w*C2SPacket;/d' \
  -e '/import net\.minecraft\.network\.packet\.s2c\.play\.\w*S2CPacket;/d' \
  -e '/import net\.minecraft\.network\.status\.client\./d' \
  -e '/import net\.minecraft\.entity\.ai\.attributes\./d' \
  -e '/import net\.minecraft\.util\.Direction;/d' \
  -e '/import net\.minecraft\.registry\.Registries\.ENTITY_TYPE;/d' \
  -e '/import net\.minecraft\.entity\.tracked\./d' \
  -e '/import net\.minecraft\.screen\.ScreenHandlerHorseChest;/d' \
  {} +

echo "✅ Broken imports removed."
echo ""
echo "📋 Next: Manually rewrite using 1.21.4 correct patterns:"
echo ""