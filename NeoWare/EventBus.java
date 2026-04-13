/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  neo.deobf.EventTarget
 *  neo.deobf.EventPriority
 *  neo.deobf.ListenerList
 *  neo.deobf.ListenerData
 *  neo.deobf.Event
 *  neo.deobf.StoppableEvent
 */
package neo.deobf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import neo.deobf.EventTarget;
import neo.deobf.EventPriority;
import neo.deobf.ListenerList;
import neo.deobf.ListenerData;
import neo.deobf.Event;
import neo.deobf.StoppableEvent;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class EventBus {
    public static final Map<Class<? extends Event>, List<ListenerData>> REGISTRY_MAP = new HashMap<Class<? extends Event>, List<ListenerData>>();

    private static void register(Method method, Object object) {
        Class<?> indexClass = method.getParameterTypes()[0];
        ListenerData data = new ListenerData(object, method, method.getAnnotation(EventTarget.class).value());
        if (!data.getTarget().isAccessible()) {
            data.getTarget().setAccessible(true);
        }
        if ((REGISTRY_MAP).containsKey(indexClass)) {
            if (!((List)(REGISTRY_MAP).get(indexClass)).contains(data)) {
                ((List)(REGISTRY_MAP).get(indexClass)).add(data);
                EventBus.sortListValue(indexClass);
            }
        } else {
            (REGISTRY_MAP).put(indexClass, new ListenerList(data));
        }
    }

    public static Event call(Event event) {
        block5: {
            List dataList = (List)(REGISTRY_MAP).get(event.getClass());
            if (dataList == null) break block5;
            if (event instanceof StoppableEvent) {
                StoppableEvent stoppable = (StoppableEvent)event;
                for (ListenerData data : dataList) {
                    EventBus.invoke(data, event);
                    if (!stoppable.isStopped()) {
                        continue;
                    }
                    break;
                }
            } else {
                for (ListenerData data : dataList) {
                    EventBus.invoke(data, event);
                }
            }
        }
        return event;
    }

    private static void sortListValue(Class<? extends Event> indexClass) {
        CopyOnWriteArrayList<ListenerData> sortedList = new CopyOnWriteArrayList<ListenerData>();
        byte[] byArray = (EventPriority.VALUE_ARRAY);
        int n = byArray.length;
        for (int i = 0; i < n; ++i) {
            byte priority = byArray[i];
            for (ListenerData data : (List)(REGISTRY_MAP).get(indexClass)) {
                if (data.getPriority() != priority) continue;
                sortedList.add(data);
            }
        }
        (REGISTRY_MAP).put(indexClass, sortedList);
    }

    public static void cleanMap(boolean onlyEmptyEntries) {
        Iterator mapIterator = (REGISTRY_MAP).entrySet().iterator();
        while (mapIterator.hasNext()) {
            if (onlyEmptyEntries && !((List)mapIterator.next().getValue()).isEmpty()) continue;
            mapIterator.remove();
        }
    }

    private static boolean isMethodBad(Method method) {
        return (method.getParameterTypes().length != (1) || !method.isAnnotationPresent(EventTarget.class) ? 1 : 0) != 0;
    }

    private static boolean isMethodBad(Method method, Class<? extends Event> eventClass) {
        return (((method.getParameterTypes().length != (1) || !method.isAnnotationPresent(EventTarget.class) ? 1 : 0) != 0) || !method.getParameterTypes()[0].equals(eventClass) ? 1 : 0) != 0;
    }

    public static void unregister(Object object) {
        for (List dataList : (REGISTRY_MAP).values()) {
            dataList.removeIf(data -> data.getSource().equals(object));
        }
        EventBus.cleanMap(true);
    }

    public static void register(Object object) {
        Method[] methodArray = object.getClass().getDeclaredMethods();
        int n = methodArray.length;
        for (int i = 0; i < n; ++i) {
            Method method = methodArray[i];
            if (((method.getParameterTypes().length != (1) || !method.isAnnotationPresent(EventTarget.class) ? 1 : 0) != 0)) continue;
            EventBus.register(method, object);
        }
    }

    private static void invoke(ListenerData data, Event argument) {
        try {
            Object[] objectArray = new Object[1];
            objectArray[0] = argument;
            data.getTarget().invoke(data.getSource(), objectArray);
        }
        catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException exception) {
            // empty catch block
        }
    }
}

