package neo.deobf;

public class ProxyInfo {
    public String    proxy;
    public String    username;
    public String    password;
    public ProxyType type;

    public ProxyInfo(String proxy, ProxyType type) {
        this.proxy    = proxy;
        this.username = "";
        this.password = "";
        this.type     = type;
    }

    public static ProxyInfo empty() {
        return new ProxyInfo("0.0.0.0", ProxyType.NO_PROXY);
    }

    public boolean isAuthenticated() {
        return !username.isEmpty() && !password.isEmpty();
    }

    public String   getProxy()    { return proxy;    }
    public String   getUsername() { return username; }
    public String   getPassword() { return password; }
    public ProxyType getType()    { return type;     }

    public void setProxy(String proxy)       { this.proxy    = proxy;    }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setType(ProxyType type)      { this.type     = type;     }

    @Override
    public String toString() {
        return "ProxyInfo{proxy='" + proxy + "', username='" + username
                + "', password='" + password + "', type=" + type + '}';
    }
}
