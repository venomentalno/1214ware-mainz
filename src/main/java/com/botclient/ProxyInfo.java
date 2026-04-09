package com.botclient;

import java.net.InetSocketAddress;
import java.net.Proxy;

public class ProxyInfo {
    public ProxyType type;
    public String address;
    public int port;
    public String username;
    public String password;
    
    public ProxyInfo(ProxyType type, String address, int port, String username, String password) {
        this.type = type;
        this.address = address;
        this.port = port;
        this.username = username;
        this.password = password;
    }
    
    public Proxy toJavaProxy() {
        if (this.type == ProxyType.HTTP) {
            return new Proxy(Proxy.Type.HTTP, new InetSocketAddress(this.address, this.port));
        } else {
            return new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(this.address, this.port));
        }
    }
    
    public boolean hasAuthentication() {
        return this.username != null && !this.username.isEmpty();
    }
}