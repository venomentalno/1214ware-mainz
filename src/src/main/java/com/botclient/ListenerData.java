package neo.deobf;

import java.lang.reflect.Method;

public class ListenerData {
    private final Object source;
    private final Method target;
    private final byte priority;

    public ListenerData(Object source, Method target, byte priority) {
        this.source   = source;
        this.target   = target;
        this.priority = priority;
    }

    public Object getSource()   { return source;   }
    public Method getTarget()   { return target;   }
    public byte   getPriority() { return priority; }
}
