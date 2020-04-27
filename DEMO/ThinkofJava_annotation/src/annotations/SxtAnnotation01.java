package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SxtAnnotation01 {

  String studentName() default"";
  int age() default 0;
  int id() default -1; //String indexOf("abc") -1

    String[] schools() default {"hahaha","eee"};

}
