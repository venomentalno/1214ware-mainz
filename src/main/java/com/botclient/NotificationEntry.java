/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.NotificationType
 *  neo.deobf.AnimationState
 *  neo.deobf.FontRendererEx
 *  neo.deobf.FontRegistry
 *  neo.deobf.GlowUtils
 *  neo.deobf.DrawUtils
 *  neo.deobf.RoundedUtils
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.util.ResourceLocation
 */
package neo.deobf;

import java.awt.Color;
import neo.deobf.NotificationType;
import neo.deobf.AnimationState;
import neo.deobf.FontRendererEx;
import neo.deobf.FontRegistry;
import neo.deobf.GlowUtils;
import neo.deobf.DrawUtils;
import neo.deobf.RoundedUtils;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Exception performing whole class analysis ignored.
 */
public class NotificationEntry {
    public int maxTime;
    public int ticks;
    public final String title;
    public final NotificationType type;
    public final String text;
    public final float width;
    public final AnimationState animation = new AnimationState();

    public NotificationEntry setMaxTime(int maxTime) {
        NotificationEntry.this.maxTime = maxTime;
        return this;
    }

    private static String mxtieDDnrj(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        while (n < string.length()) {
            stringBuilder.append((char)(string.charAt(n) ^ (501)));
            ++n;
        }
        return stringBuilder.toString();
    }

    public float draw(ScaledResolution res, float yOffset) {
        int w = res.getScaledWidth();
        int h = res.getScaledHeight();
        double anim = this.animation.get();
        GlowUtils.drawGlow((float)((float)((double)w - (double)(this.width + 29.0f) * anim - 2.0)), (float)((float)h + yOffset - 2.0f), (float)(this.width + 27.0f), (float)21.0f, (int)(6), (Color)new Color(12, 12, 12, 150));
        RoundedUtils.drawRound((float)((float)((double)w - (double)(this.width + 29.0f) * anim - 2.0)), (float)((float)h + yOffset - 2.0f), (float)(this.width + 27.0f), (float)21.0f, (float)2.0f, (Color)new Color(12, 12, 12, 170));
        if (this.type == NotificationType.ERROR) {
            DrawUtils.drawImage((ResourceLocation)new ResourceLocation(NotificationEntry.mxtieDDnrj("Ж›ЖђЖљЖ‚Ж”Ж‡ЖђЗљЖњЖЖ”Ж’ЖђЖ†ЗљЖ›ЖљЖЃЖњЖ“ЖЊЗљЖђЖ‡Ж‡ЖљЖ‡З›Ж…Ж›Ж’")), (float)((float)((double)w - (double)(this.width + 29.0f) * anim)), (float)((float)h + yOffset + 2.0f), (float)15.0f, (float)15.0f, (Color)new Color(255, 255, 255));
        } else if (this.type == NotificationType.INFO) {
            DrawUtils.drawImage((ResourceLocation)new ResourceLocation(NotificationEntry.mxtieDDnrj("Ж›ЖђЖљЖ‚Ж”Ж‡ЖђЗљЖњЖЖ”Ж’ЖђЖ†ЗљЖ›ЖљЖЃЖњЖ“ЖЊЗљЖњЖ›Ж“ЖљЗ›Ж…Ж›Ж’")), (float)((float)((double)w - (double)(this.width + 29.0f) * anim)), (float)((float)h + yOffset + 2.0f), (float)15.0f, (float)15.0f, (Color)new Color(255, 255, 255));
        } else if (this.type == NotificationType.SUCCESS) {
            DrawUtils.drawImage((ResourceLocation)new ResourceLocation(NotificationEntry.mxtieDDnrj("Ж›ЖђЖљЖ‚Ж”Ж‡ЖђЗљЖњЖЖ”Ж’ЖђЖ†ЗљЖ›ЖљЖЃЖњЖ“ЖЊЗљЖ†ЖЂЖ–Ж–ЖђЖ†Ж†З›Ж…Ж›Ж’")), (float)((float)((double)w - (double)(this.width + 29.0f) * anim)), (float)((float)h + yOffset + 2.0f), (float)15.0f, (float)15.0f, (Color)new Color(255, 255, 255));
        }
        FontRegistry.mnstb_14.drawString(this.text, (float)((double)w - (double)(this.width + 29.0f) * anim + 20.0), (float)h + yOffset + 12.0f, new Color(255, 255, 255).getRGB());
        FontRegistry.mnstb_14.drawString(this.title, (float)((double)w - (double)(this.width + 29.0f) * anim + 20.0), (float)h + yOffset + 4.0f, new Color(255, 255, 255).getRGB());
        return 27.0f * (float)this.animation.get();
    }

    public boolean updateAnimation() {
        AnimationState dI = this.animation;
        NotificationEntry cn = this;
        int n = cn.ticks + (1);
        NotificationEntry.cn.ticks = n;
        dI.update((n < this.maxTime ? 1 : 0) != 0);
        return (this.animation.get() == 0.0 ? 1 : 0) != 0;
    }

    public NotificationEntry(String title, String text, NotificationType type) {
        this.maxTime = 50;
        this.title = title;
        this.text = text;
        this.type = type;
        this.width = Math.max(FontRegistry.mnstb_14.getStringWidth(title), FontRegistry.mnstb_14.getStringWidth(text));
    }

    private static void setMaxTime(NotificationEntry cn, int n) {
        cn.maxTime = n;
    }

}

