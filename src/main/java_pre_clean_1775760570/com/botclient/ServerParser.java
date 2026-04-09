/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.RandomUtils
 *  net.minecraft.client.multiplayer.ServerData
 *  net.minecraft.client.network.ServerPinger
 *  org.jsoup.Jsoup
 *  org.jsoup.nodes.Document
 *  org.jsoup.nodes.Element
 *  org.jsoup.select.Elements
 */
package com.botclient;

import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import com.botclient.RandomUtils;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.ServerPinger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class ServerParser {
    public static final ServerPinger serverPinger;
    public static final List<ServerData> servers;

public static void init() {
        Thread thread = new Thread(() -> {
            ServerParser.parseServers();
            for (ServerData serverData : (servers)) {
                try {
                    (serverPinger).ping(serverData, true);
                    (System.out).println((serverData.serverIP) + " >> " + (serverData.serverMOTD));
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setName("ServerParser-" + RandomUtils.randomNumber((int)(5)));
        thread.start();
    }

    public static List<ServerData> getServers() {
        return (servers).stream().filter(serverData -> ((serverData.pingToServer) > GenericCancelableEventB ? 1 : 0) != 0).collect(Collectors.toList());
    }

    private static void parseServers() {
        String server;
        ServerData serverData;
        Elements elements;
        Document document2;
        String url;
        int n;
        String[] stringArray = new String[3];
        stringArray[0] = "https://minecraftrating.ru/new-servers/1.12.2";
        stringArray[1] = "https://minecraftrating.ru/new-servers/1.12.2";
        stringArray[2] = "https://minecraftrating.ru/new-servers/";
        String[] stringArray2 = stringArray;
        int n2 = stringArray2.length;
        for (n = 0; n < n2; ++n) {
            url = stringArray2[n];
            try {
                document2 = Jsoup.connect((String)url).get();
                elements = document2.getElementsByAttributeValue("class", "tooltip");
                for (Element element : elements) {
                    if (!element.text().contains(".") || ServerParser.contains(serverData = new ServerData(server = element.text(), server, false))) continue;
                    (servers).add(serverData);
                }
                continue;
            }
            catch (Throwable document2) {
                // empty catch block
            }
        }
        String[] stringArray3 = new String[3];
        stringArray3[0] = "https://misterlauncher.org/servera-novye-1.12.2/";
        stringArray3[1] = "https://misterlauncher.org/servera-novye-1.16.5/";
        stringArray3[2] = "https://misterlauncher.org/servera-novye/";
        stringArray2 = stringArray3;
        n2 = stringArray2.length;
        for (n = 0; n < n2; ++n) {
            url = stringArray2[n];
            try {
                document2 = Jsoup.connect((String)url).get();
                elements = document2.getElementsByAttributeValue("data-toggle", "tooltip");
                for (Element element : elements) {
                    if (!element.text().contains(".") || ServerParser.contains(serverData = new ServerData(server = element.text(), server, false))) continue;
                    (servers).add(serverData);
                }
                continue;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
    }

    static {
        servers = new CopyOnWriteArrayList<ServerData>();
        serverPinger = new ServerPinger();
    }

    public static boolean contains(ServerData server) {
        for (ServerData serverData : (servers)) {
            if (!(serverData.serverIP).equalsIgnoreCase((server.serverIP))) continue;
            return true;
        }
        return false;
    }
}

