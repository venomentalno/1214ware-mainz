package com.botclient;

public enum AuthServiceType {
    MOJANG("mojang"),
    THEALTENING("thealtening");

    public final String hostname;

    AuthServiceType(String hostname) {
        this.hostname = hostname;
    }
}
