package com.botclient;

import com.mojang.authlib.Agent;
import com.mojang.authlib.exceptions.AuthenticationException;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.authlib.yggdrasil.YggdrasilUserAuthentication;
import java.net.Proxy;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.session.Session;
import net.minecraft.util.Formatting;
import net.minecraft.text.Text;

public class AltLoginThread extends Thread {
    public final MinecraftClient mc = MinecraftClient.getInstance();
    public final AltAccount alt;
    public String status;

    public AltLoginThread(AltAccount alt) {
        this.alt = alt;
        this.status = Formatting.GRAY + "Waiting...";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public Session login(String name, String password) {
        YggdrasilAuthenticationService service = new YggdrasilAuthenticationService(Proxy.NO_PROXY, "");
        YggdrasilUserAuthentication auth = (YggdrasilUserAuthentication) service.createUserAuthentication(Agent.MINECRAFT);
        auth.setUsername(name);
        auth.setPassword(password);
        try {
            auth.logIn();
            return new Session(
                auth.getSelectedProfile().getName(),
                auth.getSelectedProfile().getId().toString(),
                auth.getAuthenticatedToken(),
                Session.AccountType.MOJANG
            );
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void run() {
        if (this.alt.getPassword().isEmpty()) {
            // Offline mode session
            this.mc.setSession(new Session(this.alt.getUsername(), "", "", Session.AccountType.LEGACY.name()));
            this.status = Formatting.GREEN + "Logged in - " + Formatting.WHITE + this.alt.getUsername() + Formatting.BOLD + Formatting.RED + " (Not License)";
        } else {
            this.status = "Logging in...";
            Session auth = this.login(this.alt.getUsername(), this.alt.getPassword());
            if (auth == null) {
                this.status = Formatting.RED + "Connect failed!";
                if (this.alt.getStatus().equals(AltStatus.Unchecked)) {
                    this.alt.setStatus(AltStatus.NotWorking);
                }
            } else {
                AltManager.lastAlt = new AltAccount(this.alt.getUsername(), this.alt.getPassword());
                this.mc.setSession(auth);
                this.status = Formatting.GREEN + "Logged in - " + Formatting.WHITE + auth.getUsername() + Formatting.BOLD + Formatting.RED + " (License)";
                this.alt.setMask(auth.getUsername());
            }
        }
    }
}
