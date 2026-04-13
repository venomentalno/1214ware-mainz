/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.sun.jna.Structure
 */
package neo.deobf;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class DiscordUser
extends Structure {
    public String userId;
    public String avatar;
    public String username;
    @Deprecated
    public String discriminator;
protected List<String> getFieldOrder() {
        String[] stringArray = new String[4];
        stringArray[0] = "userId";
        stringArray[1] = "username";
        stringArray[2] = "discriminator";
        stringArray[3] = "avatar";
        return Arrays.asList(stringArray);
    }
}



