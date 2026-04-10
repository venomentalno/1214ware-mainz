package neo.deobf;

import java.io.*;
import java.util.ArrayList;

public class AccountsFile extends CustomFile {

    public void loadFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.getFile()));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] args = line.split(":");
            if (args.length > 2) {
                AltManager.registry.add(new AltAccount(args[0], args[1], args[2],
                        args.length > 3 ? AltStatus.valueOf(args[3]) : AltStatus.Unchecked));
            } else {
                AltManager.registry.add(new AltAccount(args[0], args[1]));
            }
        }
        reader.close();
    }

    public void saveFile() throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(this.getFile()));
        for (AltAccount alt : AltManager.registry) {
            String mask = alt.getMask().isEmpty() ? alt.getUsername() : alt.getMask();
            writer.println(alt.getUsername() + ":" + alt.getPassword() + ":" + mask + ":" + alt.getStatus());
        }
        writer.close();
    }

    public AccountsFile(String name, boolean loadOnStart) {
        super(name, loadOnStart);
    }
}
