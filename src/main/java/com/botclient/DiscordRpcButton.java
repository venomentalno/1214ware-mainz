package com.botclient;

public class DiscordRpcButton {
    private final String label;
    private final String url;
    
    public DiscordRpcButton(String label, String url) {
        this.label = label;
        this.url = url;
    }
    
    public String getLabel() {
        return this.label;
    }
    
    public String getUrl() {
        return this.url;
    }
}