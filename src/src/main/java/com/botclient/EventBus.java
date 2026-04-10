package neo.deobf;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    public static final Map<Class<? extends Event>, List<ListenerData>> REGISTRY_MAP = new HashMap<>();

    public static void register(Object object) {
        for (Method method : object.getClass().getDeclaredMethods()) {
            if (method.getParameterTypes().length != 1 || !method.isAnnotationPresent(EventTarget.class)) continue;
            register(method, object);
        }
    }

    private static void register(Method method, Object object) {
        Class<?> indexClass = method.getParameterTypes()[0];
        //noinspection unchecked
        ListenerData data = new ListenerData(object, method, method.getAnnotation(EventTarget.class).value());
        if (!data.getTarget().isAccessible()) data.getTarget().setAccessible(true);
        if (REGISTRY_MAP.containsKey(indexClass)) {
            if (!REGISTRY_MAP.get(indexClass).contains(data)) {
                REGISTRY_MAP.get(indexClass).add(data);
                sortListValue((Class<? extends Event>) indexClass);
            }
        } else {
            REGISTRY_MAP.put((Class<? extends Event>) indexClass, new ListenerList(data));
        }
    }

    public static void unregister(Object object) {
        for (List<ListenerData> list : REGISTRY_MAP.values()) {
            list.removeIf(d -> d.getSource().equals(object));
        }
        cleanMap(true);
    }

    public static Event call(Event event) {
        List<ListenerData> dataList = REGISTRY_MAP.get(event.getClass());
        if (dataList == null) return event;
        if (event instanceof StoppableEvent stoppable) {
            for (ListenerData data : dataList) {
                invoke(data, event);
                if (stoppable.isStopped()) break;
            }
        } else {
            for (ListenerData data : dataList) invoke(data, event);
        }
        return event;
    }

    private static void sortListValue(Class<? extends Event> indexClass) {
        CopyOnWriteArrayList<ListenerData> sorted = new CopyOnWriteArrayList<>();
        for (byte priority : EventPriority.VALUE_ARRAY) {
            for (ListenerData data : REGISTRY_MAP.get(indexClass)) {
                if (data.getPriority() == priority) sorted.add(data);
            }
        }
        REGISTRY_MAP.put(indexClass, sorted);
    }

    public static void cleanMap(boolean onlyEmpty) {
        Iterator<Map.Entry<Class<? extends Event>, List<ListenerData>>> it = REGISTRY_MAP.entrySet().iterator();
        while (it.hasNext()) {
            if (onlyEmpty && !it.next().getValue().isEmpty()) continue;
            it.remove();
        }
    }

    private static void invoke(ListenerData data, Event argument) {
        try {
            data.getTarget().invoke(data.getSource(), argument);
        } catch (IllegalAccessException | InvocationTargetException ignored) {}
    }
}
