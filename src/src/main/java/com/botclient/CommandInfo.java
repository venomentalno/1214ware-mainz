package neo.deobf;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface CommandInfo {
    String name();
    String description() default "";
}
