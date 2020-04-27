package PracticeFromAnki;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value=ElementType.METHOD)
public @interface MyAnnotation01 {

    String studentName();
    String teacher();
}
