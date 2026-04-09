/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.UpdateEvent
 *  neo.deobf.Render2DEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.NumberSetting
 *  neo.deobf.Module
 *  neo.deobf.MovementUtils
 *  neo.deobf.PacketReceiveEvent
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.network.OtherClientPlayerEntity
 *  net.minecraft.client.entity.PlayerEntitySP
 *  net.minecraft.client.multiplayer.ClientWorld
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.entity.player.PlayerCapabilities
 *  net.minecraft.screen.ScreenHandler
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.PlayerMoveC2SPacket$Position
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.world.World
 */
package com.botclient;

import com.botclient.UpdateEvent;
import com.botclient.Render2DEvent;
import com.botclient.EventTarget;
import com.botclient.Setting;
import com.botclient.ModuleCategory;
import com.botclient.NumberSetting;
import com.botclient.Module;
import com.botclient.MovementUtils;
import com.botclient.PacketReceiveEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerInventory;
// Removed: PlayerCapabilities replaced
import net.minecraft.screen.ScreenHandler;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class FreeCamModule
extends Module {
    public double z;
    public final NumberSetting speed = new NumberSetting("РЎРєРѕСЂРѕСЃС‚СЊ РїРѕР»РµС‚Р°", 0.5f, 0.100000001f, 1.0f, 0.100000001f);
    public double y;
    public double x;

    private static float getRotationYawHead(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.rotationYawHead;
    }

    @EventTarget
    public void onScreen(Render2DEvent e) {
    }

    private static PlayerEntitySP getPlayer() {
        return Minecraft.player;
    }
@EventTarget
    public void onPacket(PacketReceiveEvent event) {
        if ((FreeCamModule.getPlayer14().isDead)) {
            this.toggle();
        }
    }

    private static PlayerEntitySP getPlayer2() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer3() {
        return Minecraft.player;
    }

    public FreeCamModule() {
        super("FreeCam", ModuleCategory.Player);
        Setting[] settings = new Setting[1];
        settings[0] = this.speed;
        this.addSetting(settings);
    }

    private static double getPosX(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.posX;
    }

    private static double getPosY(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.posY;
    }

    private static PlayerEntitySP getPlayer4() {
        return Minecraft.player;
    }

    private static PlayerCapabilities getCapabilities(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.capabilities;
    }

    public void onEnable() {
        super.onEnable();
        if ((FreeCamModule.getPlayer15().isDead)) {
            this.toggle();
        }
        this.x = FreeCamModule.getPosX(FreeCamModule.getPlayer18());
        this.y = FreeCamModule.getPosY(FreeCamModule.getPlayer11());
        this.z = FreeCamModule.getPosZ2(FreeCamModule.getPlayer16());
        ClientWorld worldClient = ((mc).world);
        EntityOtherPlayerMP ent = new EntityOtherPlayerMP((World)worldClient, (Minecraft.player).getGameProfile());
        ent.inventory = FreeCamModule.getInventory(FreeCamModule.getPlayer20());
        ent.inventoryContainer = FreeCamModule.getInventoryContainer(FreeCamModule.getPlayer10());
        ent.setHealth((Minecraft.player).getHealth());
        double d = (this.x);
        double d2 = (FreeCamModule.getPlayer6().getEntityBoundingBox().minY);
        double d3 = (this.z);
        float f = (FreeCamModule.getPlayer13().rotationYaw);
        ent.setPositionAndRotation(d, d2, d3, f, (FreeCamModule.player.rotationPitch));
        ent.rotationYawHead = FreeCamModule.getRotationYawHead(FreeCamModule.getPlayer3());
        ((mc).world).addEntityToWorld(-1, (Entity)ent);
    }

    private static PlayerEntitySP getPlayer5() {
        return Minecraft.player;
    }

    @EventTarget
    public void onPreMotion(UpdateEvent e) {
        if ((Minecraft.player) == null || ((mc).world) == null) {
            return;
        }
        FreeCamModule.getPlayer2().motionY = 0.0;
        if ((FreeCamModule.getKeyBindJump(FreeCamModule.getGameSettings()).pressed)) {
            FreeCamModule.getPlayer12().motionY = FreeCamModule.getValue3(FreeCamModule.getSpeed(this));
        }
        if ((FreeCamModule.getKeyBindSneak(FreeCamModule.getGameSettings2()).pressed)) {
            FreeCamModule.getPlayer23().motionY = -FreeCamModule.getValue2(FreeCamModule.getSpeed3(this));
        }
        FreeCamModule.getPlayer22().noClip = true;
        MovementUtils.setSpeed((double)(FreeCamModule.getSpeed2(this).value));
    }

    private static PlayerEntitySP getPlayer6() {
        return Minecraft.player;
    }

    private static NumberSetting getSpeed(FreeCamModule instance) {
        return instance.speed;
    }

    private static PlayerEntitySP getPlayer8() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer9() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer10() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer11() {
        return Minecraft.player;
    }

    private static NumberSetting getSpeed2(FreeCamModule instance) {
        return instance.speed;
    }

    private static KeyBinding getKeyBindSneak(GameSettings gameSettings) {
        return gameSettings.keyBindSneak;
    }

    private static PlayerEntitySP getPlayer12() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer13() {
        return Minecraft.player;
    }

    private static float getValue2(NumberSetting instance) {
        return instance.value;
    }

    private static PlayerEntitySP getPlayer14() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer15() {
        return Minecraft.player;
    }

    private static double getPosZ2(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.posZ;
    }

    private static PlayerEntitySP getPlayer16() {
        return Minecraft.player;
    }

    private static Container getInventoryContainer(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.inventoryContainer;
    }

    private static InventoryPlayer getInventory(PlayerEntitySP entityPlayerSP) {
        return entityPlayerSP.inventory;
    }

    private static PlayerEntitySP getPlayer18() {
        return Minecraft.player;
    }

    private static KeyBinding getKeyBindJump(GameSettings gameSettings) {
        return gameSettings.keyBindJump;
    }

    private static float getValue3(NumberSetting instance) {
        return instance.value;
    }

    private static PlayerEntitySP getPlayer20() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer21() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer22() {
        return Minecraft.player;
    }

    private static PlayerEntitySP getPlayer23() {
        return Minecraft.player;
    }

    private static GameSettings getGameSettings() {
        return Minecraft.gameSettings;
    }

    private static NumberSetting getSpeed3(FreeCamModule instance) {
        return instance.speed;
    }

    private static PlayerEntitySP getPlayer25() {
        return Minecraft.player;
    }

    public void onDisable() {
        super.onDisable();
        (Minecraft.player).setPosition((this.x), (this.y), (this.z));
        NetHandlerPlayClient netHandlerPlayClient = (mc).getConnection();
        double d = (FreeCamModule.getPlayer21().posX);
        double d2 = (FreeCamModule.getPlayer4().posY) + 0.01;
        double d3 = (FreeCamModule.getPlayer25().posZ);
        netHandlerPlayClient.sendPacket((Packet)new PlayerMoveC2SPacket.Position(d, d2, d3, (FreeCamModule.getPlayer5().onGround)));
        FreeCamModule.getCapabilities(FreeCamModule.getPlayer9()).isFlying = false;
        FreeCamModule.getPlayer8().noClip = false;
        ((mc).world).removeEntityFromWorld(-1);
    }

    private static GameSettings getGameSettings2() {
        return Minecraft.gameSettings;
    }

}


