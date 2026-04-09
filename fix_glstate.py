#!/usr/bin/env python3
"""Fix incorrect GlStateManager imports to RenderSystem"""

from pathlib import Path

WORKSPACE = "/workspace/src/main/java/com/botclient"

for filepath in Path(WORKSPACE).rglob("*.java"):
    try:
        with open(filepath, 'r', encoding='utf-8') as f:
            content = f.read()
        
        original = content
        # Fix the incorrect import
        content = content.replace(
            "import net.minecraft.client.render.GlStateManager;",
            "import net.minecraft.client.render.RenderSystem;"
        )
        
        if content != original:
            with open(filepath, 'w', encoding='utf-8') as f:
                f.write(content)
            print(f"Fixed: {filepath.name}")
    except Exception as e:
        print(f"Error: {filepath}: {e}")

print("Done!")
