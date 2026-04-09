package com.botclient;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DiscordRichPresenceBuilder {
    public final DiscordRichPresence rpc = new DiscordRichPresence();

    public DiscordRichPresenceBuilder setDetails(String s) {
        if (s != null && !s.isEmpty()) {
            this.rpc.details = s.substring(0, Math.min(s.length(), 128));
        }
        return this;
    }

    public DiscordRichPresenceBuilder setState(String s) {
        if (s != null && !s.isEmpty()) {
            this.rpc.state = s.substring(0, Math.min(s.length(), 128));
        }
        return this;
    }

    public DiscordRichPresenceBuilder setStartTimestamp(long startTimestamp) {
        this.rpc.startTimestamp = startTimestamp;
        return this;
    }

    public DiscordRichPresenceBuilder setStartTimestamp(OffsetDateTime offsetDateTime) {
        this.rpc.startTimestamp = offsetDateTime.toEpochSecond();
        return this;
    }

    public DiscordRichPresenceBuilder setEndTimestamp(long endTimestamp) {
        this.rpc.endTimestamp = endTimestamp;
        return this;
    }

    public DiscordRichPresenceBuilder setEndTimestamp(OffsetDateTime offsetDateTime) {
        this.rpc.endTimestamp = offsetDateTime.toEpochSecond();
        return this;
    }

    public DiscordRichPresenceBuilder setLargeImage(String largeImageKey, String largeImageText) {
        this.rpc.largeImageKey = largeImageKey;
        this.rpc.largeImageText = largeImageText;
        return this;
    }

    public DiscordRichPresenceBuilder setLargeImage(String key) {
        return this.setLargeImage(key, "");
    }

    public DiscordRichPresenceBuilder setSmallImage(String smallImageKey, String smallImageText) {
        this.rpc.smallImageKey = smallImageKey;
        this.rpc.smallImageText = smallImageText;
        return this;
    }

    public DiscordRichPresenceBuilder setSmallImage(String key) {
        return this.setSmallImage(key, "");
    }

    public DiscordRichPresenceBuilder setParty(String partyId, int partySize, int partyMax) {
        this.rpc.partyId = partyId;
        this.rpc.partySize = partySize;
        this.rpc.partyMax = partyMax;
        return this;
    }

    public DiscordRichPresenceBuilder setSecrets(String joinSecret, String spectateSecret) {
        this.rpc.joinSecret = joinSecret;
        this.rpc.spectateSecret = spectateSecret;
        return this;
    }

    public DiscordRichPresenceBuilder setSecrets(String matchSecret, String joinSecret, String spectateSecret) {
        this.rpc.matchSecret = matchSecret;
        this.rpc.joinSecret = joinSecret;
        this.rpc.spectateSecret = spectateSecret;
        return this;
    }

    public DiscordRichPresenceBuilder setButtons(List<DiscordRpcButton> list) {
        if (list != null && !list.isEmpty()) {
            int min = Math.min(list.size(), 2);
            this.rpc.button_label_1 = list.get(0).getLabel();
            this.rpc.button_url_1 = list.get(0).getUrl();
            if (min == 2) {
                this.rpc.button_label_2 = list.get(1).getLabel();
                this.rpc.button_url_2 = list.get(1).getUrl();
            }
        }
        return this;
    }

    public DiscordRichPresenceBuilder setButtons(DiscordRpcButton o) {
        return this.setButtons(Collections.singletonList(o));
    }

    public DiscordRichPresenceBuilder setButtons(DiscordRpcButton rpcButton, DiscordRpcButton rpcButton2) {
        return this.setButtons(Arrays.asList(rpcButton, rpcButton2));
    }

    public DiscordRichPresenceBuilder setInstance(boolean instance) {
        this.rpc.instance = instance ? 1 : 0;
        return this;
    }

    public DiscordRichPresence build() {
        return this.rpc;
    }
}
