/*
 * Decompiled with CFR 0.152.
 */
package neo.deobf;

import java.lang.reflect.Method;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Exception performing whole class analysis ignored.
 */
final class ListenerData {
    public final byte priority;
    public final Object source;
    public final Method target;

    public byte getPriority() {
        return this.priority;
    }

    public Method getTarget() {
        return this.target;
    }

    public ListenerData(Object source, Method target, byte priority) {
        this.source = source;
        this.target = target;
        this.priority = priority;
    }

    private static Object getSource(ListenerData instance) {
        return instance.source;
    }

    private static byte getPriority(ListenerData instance) {
        return instance.priority;
    }

    public Object getSource() {
        return this.source;
    }

    private static Method getTarget(ListenerData instance) {
        return instance.target;
    }
}

