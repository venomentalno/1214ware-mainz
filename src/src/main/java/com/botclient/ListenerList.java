package neo.deobf;

import java.util.concurrent.CopyOnWriteArrayList;

public class ListenerList extends CopyOnWriteArrayList<ListenerData> {
    public ListenerList(ListenerData data) {
        add(data);
    }
}
