/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.AltStatus
 *  neo.deobf.AltAccount
 *  neo.deobf.AltManager
 *  neo.deobf.CustomFile
 */
package com.botclient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.botclient.AltStatus;
import com.botclient.AltAccount;
import com.botclient.AltManager;
import com.botclient.CustomFile;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class AccountsFile
extends CustomFile {

    public void loadFile() throws IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getFile()));
        while ((line = bufferedReader.readLine()) != null) {
            String[] arguments = line.split(":");
            if (arguments.length > (2)) {
                (AltManager.registry).add(new AltAccount(arguments[0], arguments[1], arguments[2], arguments.length > (3) ? AltStatus.valueOf((String)arguments[3]) : (AltStatus.Unchecked)));
                continue;
            }
            (AltManager.registry).add(new AltAccount(arguments[0], arguments[1]));
        }
        bufferedReader.close();
    }

    public void saveFile() throws IOException {
        PrintWriter alts = new PrintWriter(new FileWriter(this.getFile()));
        for (AltAccount alt : (AltManager.registry)) {
            if (alt.getMask().equals("")) {
                alts.println(alt.getUsername() + ":" + alt.getPassword() + ":" + alt.getUsername() + ":" + alt.getStatus());
                continue;
            }
            alts.println(alt.getUsername() + ":" + alt.getPassword() + ":" + alt.getMask() + ":" + alt.getStatus());
        }
        alts.close();
    }

    public AccountsFile(String name, boolean loadOnStart) {
        super(name, loadOnStart);
    }
}

