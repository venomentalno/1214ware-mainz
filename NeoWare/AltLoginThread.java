/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.Agent
 *  com.mojang.authlib.exceptions.AuthenticationException
 *  com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService
 *  com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication
 *  com.mojang.realmsclient.gui.ChatFormatting
 *  neo.deobf.AltStatus
 *  neo.deobf.AltAccount
 *  neo.deobf.AltManager
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.Session
 *  net.minecraft.util.text.TextFormatting
 */
package neo.deobf;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import com.mojang.realmsclient.gui.ChatFormatting;
import java.net.Proxy;
import neo.deobf.AltStatus;
import neo.deobf.AltAccount;
import neo.deobf.AltManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minecraft.util.text.TextFormatting;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AltLoginThread
extends Thread {
    public final Minecraft mc = Minecraft.getMinecraft();
    public final AltAccount alt;
    public String status;

    private static AltAccount getAlt(AltLoginThread instance) {
        return instance.alt;
    }

    private static void setStatus(AltLoginThread bc, String string) {
        bc.status = string;
    }

    private static TextFormatting getGREEN() {
        return TextFormatting.GREEN;
    }

    private static Minecraft getMc(AltLoginThread instance) {
        return instance.mc;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private static AltAccount getAlt2(AltLoginThread instance) {
        return instance.alt;
    }

    public AltLoginThread(AltAccount alt) {
        this.alt = alt;
        this.status = "§7Waiting...";
    }

    private static TextFormatting getGREEN2() {
        return TextFormatting.GREEN;
    }

    private static AltAccount getAlt3(AltLoginThread instance) {
        return instance.alt;
    }
private static AltAccount getAlt4(AltLoginThread instance) {
        return instance.alt;
    }

    private static ChatFormatting getRED() {
        return ChatFormatting.RED;
    }

    public Session login(String name, String password) {
        YggdrasilUserAuthentication authentication;
        YggdrasilAuthenticationService service = new YggdrasilAuthenticationService((Proxy.NO_PROXY), "");
        YggdrasilUserAuthentication auth = authentication = new YggdrasilUserAuthentication(service, (Agent.MINECRAFT));
        auth.setUsername(name);
        auth.setPassword(password);
        try {
            auth.logIn();
            return new Session(auth.getSelectedProfile().getName(), auth.getSelectedProfile().getId().toString(), auth.getAuthenticatedToken(), "mojang");
        }
        catch (AuthenticationException var8) {
            var8.printStackTrace();
            return null;
        }
    }

    @Override
    public void run() {
        if ((this.alt).getPassword().equals("")) {
            AltLoginThread.getMc(this).new Session(AltLoginThread.getAlt2(this).getUsername(), "", "", "mojang") = new Session(AltLoginThread.getAlt2(this).getUsername(), "", "", "mojang");
            this.status = AltLoginThread.getGREEN() + "Logged in - " + AltLoginThread.getWHITE2() + AltLoginThread.getAlt3(this).getUsername() + AltLoginThread.getBOLD2() + AltLoginThread.getRED() + " (Not License)";
        } else {
            this.status = "Logging in...";
            Session auth = this.login((this.alt).getUsername(), (this.alt).getPassword());
            if (auth == null) {
                this.status = "Connect failed!";
                if ((this.alt).getStatus().equals((Object)(AltStatus.Unchecked))) {
                    (this.alt).setStatus((AltStatus.NotWorking));
                }
            } else {
                AltManager.lastAlt = new AltAccount(AltLoginThread.getAlt4(this).getUsername(), AltLoginThread.getAlt(this).getPassword());
                this.status = AltLoginThread.getGREEN2() + "Logged in - " + AltLoginThread.getWHITE() + auth.getUsername() + AltLoginThread.getBOLD() + AltLoginThread.getRED2() + " (License)";
                (this.alt).setMask(auth.getUsername());
                AltLoginThread.getMc2(this).auth = auth;
            }
        }
    }

    private static ChatFormatting getBOLD() {
        return ChatFormatting.BOLD;
    }

    private static String getStatus(AltLoginThread instance) {
        return instance.status;
    }

    private static ChatFormatting getRED2() {
        return ChatFormatting.RED;
    }

    public String getStatus() {
        return (this.status);
    }

    private static ChatFormatting getBOLD2() {
        return ChatFormatting.BOLD;
    }

    private static Minecraft getMc2(AltLoginThread instance) {
        return instance.mc;
    }

    private static ChatFormatting getWHITE() {
        return ChatFormatting.WHITE;
    }

    private static ChatFormatting getWHITE2() {
        return ChatFormatting.WHITE;
    }

}

