/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.ProxyType
 */
package neo.deobf;

import neo.deobf.ProxyType;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ProxyInfo {
    public String username;
    public String password;
    public String proxy;
    public ProxyType type;

    private static String getPassword(ProxyInfo instance) {
        return instance.password;
    }

    public void setType(ProxyType type) {
        this.type = type;
    }

    private static String getProxy(ProxyInfo instance) {
        return instance.proxy;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private static void setType(ProxyInfo eq, ProxyType ep) {
        eq.type = ep;
    }

    private static void setProxy(ProxyInfo eq, String string) {
        eq.proxy = string;
    }

    private static ProxyType getType(ProxyInfo instance) {
        return instance.type;
    }
private static String getUsername(ProxyInfo instance) {
        return instance.username;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return (this.password);
    }

    private static void setPassword(ProxyInfo eq, String string) {
        eq.password = string;
    }

    private static void setUsername(ProxyInfo eq, String string) {
        eq.username = string;
    }

    public String toString() {
        return "ProxyInfo{proxy='" + (this.proxy) + (char)(39) + ", username='" + (this.username) + (char)(39) + ", password='" + (this.password) + (char)(39) + ", type=" + (this.type) + (char)(125);
    }

    public String getUsername() {
        return (this.username);
    }

    public ProxyInfo(String proxy, ProxyType type) {
        this.proxy = proxy;
        this.username = "";
        this.password = "";
        this.type = type;
    }

    public boolean isAuthenticated() {
        return (!(this.username).equals("") && !(this.password).equals("") ? 1 : 0) != 0;
    }

    public String getProxy() {
        return (this.proxy);
    }

    public ProxyType getType() {
        return (this.type);
    }

    public static ProxyInfo empty() {
        return new ProxyInfo("0.0.0.0", (ProxyType.NO_PROXY));
    }

}

