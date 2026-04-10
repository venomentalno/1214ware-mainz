package neo.deobf;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface EventTarget {
    byte value() default EventPriority.MEDIUM;
}
