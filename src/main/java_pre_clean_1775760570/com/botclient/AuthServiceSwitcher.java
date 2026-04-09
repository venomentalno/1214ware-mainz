/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.ReflectionHelper
 *  neo.deobf.AuthServiceType
 */
package com.botclient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import com.botclient.ReflectionHelper;
import com.botclient.AuthServiceType;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AuthServiceSwitcher {
    public AuthServiceType currentService;
    public final ReflectionHelper userAuthentication = new ReflectionHelper("com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication");
    public final ReflectionHelper minecraftSession = new ReflectionHelper("com.mojang.authlib.yggdrasil.YggdrasilMinecraftSessionService");

    private void reflectionFields(String v666) throws NoSuchFieldException, IllegalAccessException {
        HashMap<String, URL> v2 = new HashMap<String, URL>();
        String v3 = v666.contains("thealtening") ? "http" : "https";
        v2.put("ROUTE_AUTHENTICATE", this.toUrl(v3 + "://authserver." + v666 + ".com/authenticate"));
        v2.put("ROUTE_INVALIDATE", this.toUrl(v3 + "://authserver" + v666 + "com/invalidate"));
        v2.put("ROUTE_REFRESH", this.toUrl(v3 + "://authserver." + v666 + ".com/refresh"));
        v2.put("ROUTE_VALIDATE", this.toUrl(v3 + "://authserver." + v666 + ".com/validate"));
        v2.put("ROUTE_SIGNOUT", this.toUrl(v3 + "://authserver." + v666 + ".com/signout"));
        v2.forEach((a2, v1) -> {
            try {
                (this.userAuthentication).setStaticField(a2, v1);
            }
            catch (Exception v4) {
                v4.printStackTrace();
            }
        });
        (this.userAuthentication).setStaticField("BASE_URL", (Object)(v3 + "://authserver." + v666 + ".com/"));
        (this.minecraftSession).setStaticField("BASE_URL", (Object)(v3 + "://sessionserver." + v666 + ".com/session/minecraft/"));
        (this.minecraftSession).setStaticField("JOIN_URL", (Object)this.toUrl(v3 + "://sessionserver." + v666 + ".com/session/minecraft/join"));
        (this.minecraftSession).setStaticField("CHECK_URL", (Object)this.toUrl(v3 + "://sessionserver." + v666 + ".com/session/minecraft/hasJoined"));
        String[] stringArray = new String[3];
        stringArray[0] = ".minecraft.net";
        stringArray[1] = ".mojang.com";
        stringArray[2] = ".thealtening.com";
        (this.minecraftSession).setStaticField("WHITELISTED_DOMAINS", (Object)stringArray);
    }

    private URL toUrl(String url) {
        try {
            return new URL(url);
        }
        catch (MalformedURLException v2) {
            return null;
        }
    }

    public void switchService(AuthServiceType v1) throws NoSuchFieldException, IllegalAccessException {
        if ((this.currentService) == v1) {
            return;
        }
        this.reflectionFields((v1.hostname));
        this.currentService = v1;
    }

}

