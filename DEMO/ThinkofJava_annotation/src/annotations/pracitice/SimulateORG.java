package annotations.pracitice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulateORG {

    String table();
    int id() default 0;
    String name() default "NoN";
    int age() default 0;
    double salary() default 0d;
    String departement() default  "NoN";
}
