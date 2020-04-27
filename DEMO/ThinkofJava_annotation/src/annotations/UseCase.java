package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
//@Retention(RetentionRolicy.RunTime)
public @interface UseCase {
    int id();
    String description() default"no description";
}
