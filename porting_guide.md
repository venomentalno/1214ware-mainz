# BotClient Porting Guide: 1.12.2 → 1.21.4 Fabric

## Build System Setup (Completed)
- ✅ build.gradle with Fabric Loom
- ✅ gradle.properties with 1.21.4 versions
- ✅ settings.gradle
- ✅ fabric.mod.json
- ✅ botclient.mixins.json
- ✅ botclient.accesswidener

## Major API Changes

### 1. Package Migration
All classes currently use `package neo.deobf;` - needs to change to `package com.botclient;`

### 2. Minecraft Client Access
- **1.12.2**: `Minecraft.getMinecraft()`
- **1.21.4**: `MinecraftClient.getInstance()`

### 3. GUI Classes
| 1.12.2 | 1.21.4 |
|--------|--------|
| GuiScreen | Screen |
| GuiButton | ButtonWidget |
| GuiTextField | TextFieldWidget |
| FontRenderer | TextRenderer |
| ScaledResolution | Window + scaled calculations |

### 4. Rendering
| 1.12.2 | 1.21.4 |
|--------|--------|
| GlStateManager | DrawContext / RenderSystem |
| Tessellator.getInstance().getBuffer() | Tessellator.getInstance().getBuffer() (similar) |
| GL11 calls | RenderSystem calls |

### 5. Entity/Player Classes
| 1.12.2 | 1.21.4 |
|--------|--------|
| EntityPlayer | PlayerEntity |
| EntityPlayerSP | ClientPlayerEntity |
| EntityLivingBase | LivingEntity |
| Entity | Entity (same) |

### 6. World Classes
| 1.12.2 | 1.21.4 |
|--------|--------|
| WorldClient | ClientWorld |
| World | ServerWorld/World (context dependent) |

### 7. Network/Packets
| 1.12.2 | 1.21.4 |
|--------|--------|
| CPacket* | C2S* (ClientToServer) |
| SPacket* | S2C* (ServerToClient) |
| Packet | Packet (same) |

### 8. Math/Positions
| 1.12.2 | 1.21.4 |
|--------|--------|
| BlockPos | BlockPos (same) |
| Vec3d | Vec3d (same) |
| RayTraceResult | HitResult |
| EnumFacing | Direction |
| EnumHand | Hand |

### 9. Items/Blocks
| 1.12.2 | 1.21.4 |
|--------|--------|
| ItemStack | ItemStack (same) |
| IBlockState | BlockState |
| Material | MapColor/Material (changed) |

### 10. Text/Chat
| 1.12.2 | 1.21.4 |
|--------|--------|
| ITextComponent | Text |
| TextComponentString | LiteralTextContent |
| TextFormatting | Formatting |

## Files Requiring Updates

### Core Files (Priority 1)
1. PBot.java - Main bot class
2. PBotMinecraft.java - Minecraft wrapper
3. PBotPlayer.java - Player wrapper  
4. PBotWorldClient.java - World wrapper
5. Client.java - Main client class

### GUI Files (Priority 2)
1. AltLoginScreen.java → extends Screen
2. ClickGuiScreen.java → extends Screen
3. AltManagerScreen.java → extends Screen
4. All *Screen.java files

### Module Files (Priority 3)
1. Module.java - Base module class
2. All *Module.java files

### Rendering Files (Priority 4)
1. BaseFontRenderer.java
2. FontRendererEx.java
3. DrawUtils.java
4. ShaderUtils.java

## Manual Steps Required

1. **Update all package declarations** from `neo.deobf` to `com.botclient`
2. **Replace all imports** - systematic replacement needed
3. **Fix GUI screens** - extend Screen instead of GuiScreen
4. **Update rendering code** - use DrawContext instead of direct GL calls
5. **Fix packet names** - CPacket* → C2S*, SPacket* → S2C*
6. **Update entity references** - EntityPlayer → PlayerEntity, etc.
7. **Fix text rendering** - ITextComponent → Text
8. **Update key bindings** - KeyBinding system changed

## Helper Classes Created
- `MinecraftInstance.java` - Provides MinecraftClient.getInstance()
- `RenderUtils.java` - Modern rendering helpers

## Next Steps
1. Run automated find/replace for package names
2. Update imports systematically
3. Fix each class file individually
4. Test compilation after each batch
5. Fix remaining errors

