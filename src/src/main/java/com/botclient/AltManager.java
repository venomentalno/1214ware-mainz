package neo.deobf;

import java.util.concurrent.CopyOnWriteArrayList;

public class AltManager {
    public static CopyOnWriteArrayList<AltAccount> registry = new CopyOnWriteArrayList<>();

    public static AltAccount getByUsername(String username) {
        for (AltAccount acc : registry) {
            if (acc.getUsername().equalsIgnoreCase(username)) return acc;
        }
        return null;
    }
}
