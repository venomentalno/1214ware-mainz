/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.jetbrains.annotations.NotNull
 */
package neo.deobf;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public class DiscordRpcButton
implements Serializable {
    public final String label;
    public final String url;

    private static String getUrl(DiscordRpcButton instance) {
        return instance.url;
    }

    protected DiscordRpcButton(String label, String url) {
        this.label = label;
        this.url = url;
    }

    @NotNull
    public static DiscordRpcButton create(String substring, String s) {
        substring = substring.substring(0, Math.min(substring.length(), 31));
        return new DiscordRpcButton(substring, s);
    }

    public String getLabel() {
        return (this.label);
    }

    private static String getLabel(DiscordRpcButton instance) {
        return instance.label;
    }

    public String getUrl() {
        return (this.url);
    }
}

