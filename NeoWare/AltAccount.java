/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.AltStatus
 */
package neo.deobf;

import neo.deobf.AltStatus;

public class AltAccount {
    public String password;
    public String mask;
    public AltStatus status;
    public final String username;

    public void setStatus(AltStatus status) {
        this.status = status;
    }

    private static String getMask(AltAccount instance) {
        return instance.mask;
    }

    public String getMask() {
        return (this.mask);
    }

    public AltAccount(String username, String password, AltStatus status) {
        this(username, password, "", status);
    }

    public String getPassword() {
        return (this.password);
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public AltAccount(String username, String password) {
        this(username, password, AltStatus.Unchecked);
    }
public String getUsername() {
        return (this.username);
    }

    private static String getUsername(AltAccount instance) {
        return instance.username;
    }

    private static AltStatus getStatus(AltAccount instance) {
        return instance.status;
    }

    private static void setPassword(AltAccount bb, String string) {
        bb.password = string;
    }

    public AltStatus getStatus() {
        return (this.status);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private static void setMask(AltAccount bb, String string) {
        bb.mask = string;
    }

    private static String getPassword(AltAccount instance) {
        return instance.password;
    }

    public AltAccount(String username, String password, String mask, AltStatus status) {
        this.username = username;
        this.password = password;
        this.mask = mask;
        this.status = status;
    }

    private static void setStatus(AltAccount bb, AltStatus ba) {
        bb.status = ba;
    }
}

