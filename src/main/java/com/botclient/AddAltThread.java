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
 *  neo.deobf.AddAltScreen
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
import neo.deobf.AddAltScreen;
import net.minecraft.util.text.TextFormatting;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Exception performing whole class analysis ignored.
 */
class AddAltThread
extends Thread {
    public final String password;
    public final AddAltScreen this$0;
    public final String username;

AddAltThread(AddAltScreen bl, String username, String password) {
        this.this$0 = bl;
        this.username = username;
        this.password = password;
        AddAltScreen.access$000((AddAltScreen)bl, (String)(TextFormatting.GRAY + "Idle..."));
    }

    @Override
    public void run() {
        if (this.password.equals("")) {
            AltManager.addAccount((AltAccount)new AltAccount(this.username, ""));
            AddAltScreen.access$000((AddAltScreen)this.this$0, (String)(TextFormatting.GREEN + "Added alt - " + ChatFormatting.RED + this.username + ChatFormatting.BOLD + "(non license)"));
        } else {
            AddAltScreen.access$000((AddAltScreen)this.this$0, (String)(TextFormatting.AQUA + "Trying connect..."));
            this.callGetNO_PROXY(this.username, this.password);
        }
    }

    private void callGetNO_PROXY(String username, String password) {
        try {
            YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
            YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication)service.createUserAuthentication(Agent.MINECRAFT);
            auth.setUsername(username);
            auth.setPassword(password);
            try {
                auth.logIn();
                AltManager.addAccount((AltAccount)new AltAccount(username, password, auth.getSelectedProfile().getName(), AltStatus.Working));
                AddAltScreen.access$000((AddAltScreen)this.this$0, (String)(TextFormatting.GREEN + "Added alt - " + ChatFormatting.RED + this.username + ChatFormatting.BOLD + "(license)"));
            }
            catch (AuthenticationException var7) {
                AddAltScreen.access$000((AddAltScreen)this.this$0, (String)(TextFormatting.RED + "Connect failed!"));
                var7.printStackTrace();
            }
        }
        catch (Throwable e) {
            AddAltScreen.access$000((AddAltScreen)this.this$0, (String)(TextFormatting.RED + "Error"));
            e.printStackTrace();
        }
    }

}

