/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.Client
 *  neo.deobf.AltAccount
 *  neo.deobf.FileManager
 */
package com.botclient;

import java.util.ArrayList;
import com.botclient.Client;
import com.botclient.AltAccount;
import com.botclient.FileManager;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AltManager {
    public static ArrayList<AltAccount> registry = new ArrayList();
    public static AltAccount lastAlt;

    public static void removeAccount(AltAccount alt) {
        (registry).remove(alt);
        try {
            (Client.getInstance().fileManager).saveFiles();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setLastAlt(AltAccount alt) {
        lastAlt = alt;
    }

    public ArrayList<AltAccount> getRegistry() {
        return (registry);
    }

    public static void clearAccounts() {
        (registry).clear();
        try {
            (Client.getInstance().fileManager).saveFiles();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addAccount(AltAccount alt) {
        (registry).add(alt);
        try {
            (Client.getInstance().fileManager).saveFiles();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

