/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.UpdateEvent
 *  neo.deobf.HandSideRenderEvent
 *  neo.deobf.EventTarget
 *  neo.deobf.Setting
 *  neo.deobf.ModuleCategory
 *  neo.deobf.ModeSetting
 *  neo.deobf.NumberSetting
 *  neo.deobf.Module
 */
package neo.deobf;

import neo.deobf.UpdateEvent;
import neo.deobf.HandSideRenderEvent;
import neo.deobf.EventTarget;
import neo.deobf.Setting;
import neo.deobf.ModuleCategory;
import neo.deobf.ModeSetting;
import neo.deobf.NumberSetting;
import neo.deobf.Module;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ItemAnimModule
extends Module {
    public static NumberSetting swingSpeed;
    public static NumberSetting spinSpeed;
    public static ModeSetting anim;
    public static NumberSetting speed;
    public static NumberSetting wrapSpeed;

    static {
        String[] stringArray = new String[8];
        stringArray[0] = "Block";
        stringArray[1] = "Swing";
        stringArray[2] = "Swipe";
        stringArray[3] = "Fap";
        stringArray[4] = "Wrap";
        stringArray[5] = "Spin";
        stringArray[6] = "y";
        stringArray[7] = "None";
        anim = new ModeSetting("Анимация", "Default", stringArray);
        speed = new NumberSetting("Swing скорость", 8.0f, 1.0f, 25.0f, 1.0f);
        swingSpeed = new NumberSetting("Fap скорость", 20.0f, 10.0f, 40.0f, 1.0f);
        wrapSpeed = new NumberSetting("Wrap скорость", 10.0f, 2.0f, 20.0f, 1.0f);
        spinSpeed = new NumberSetting("Spin скорость", 5.0f, 2.0f, 10.0f, 1.0f);
    }
public ItemAnimModule() {
        super("ItemAnim", ModuleCategory.Render);
        Setting[] settings = new Setting[5];
        settings[0] = anim;
        settings[1] = speed;
        settings[2] = swingSpeed;
        settings[3] = wrapSpeed;
        settings[4] = spinSpeed;
        this.addSetting(settings);
    }

    @EventTarget
    public void onSidePerson(HandSideRenderEvent event) {
    }

    @EventTarget
    public void onUpdate(UpdateEvent event) {
    }
}





