package annotations;

import annotations.pracitice.SxtField;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * 使用反射读取注解信息
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("annotations.pracitice.Employee");

            Annotation[] annos = clazz.getAnnotations();
            for(Annotation anno:annos)
                System.out.println(anno);

            Field f = clazz.getDeclaredField("salary");
            SxtField sxtField = f.getAnnotation(SxtField.class);
            System.out.println("_id:_"+sxtField.columnName()+"_type:_"+sxtField.type()+"_length:_"+sxtField.length());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
