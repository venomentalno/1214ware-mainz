package com.botclient;

import com.mojang.authlib.GameProfile;

public class AltAccount {
    private String username;
    private String password;
    private String uuid;
    private String token;
    private AltStatus status;
    
    public AltAccount(String username, String password) {
        this.username = username;
        this.password = password;
        this.status = AltStatus.PENDING;
    }
    
    public AltAccount(String username, String uuid, String token) {
        this.username = username;
        this.uuid = uuid;
        this.token = token;
        this.status = AltStatus.LOGGED_IN;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getUuid() {
        return this.uuid;
    }
    
    public String getToken() {
        return this.token;
    }
    
    public AltStatus getStatus() {
        return this.status;
    }
    
    public void setStatus(AltStatus status) {
        this.status = status;
    }
    
    public GameProfile toGameProfile() {
        return new GameProfile(this.uuid != null ? java.util.UUID.fromString(this.uuid) : null, this.username);
    }
}