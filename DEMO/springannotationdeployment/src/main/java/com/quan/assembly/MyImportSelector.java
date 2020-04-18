package com.quan.assembly;

import com.quan.bean.Circle;
import com.quan.bean.Shape;
import com.quan.config.Config2;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.stream.Stream;

//自定以逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值是....需要导入到容器中的组件的全类名
    //AnnotationMetedata:当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println(annotationMetadata);

        return new String[]{"com.quan.bean.Circle","com.quan.bean.Shape"};
    }





    @Test
    public void test03(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);
//        String[] names = context.getBeanDefinitionNames();
//        System.out.println(Arrays.asList(names));
        System.out.println(context.getBean(Circle.class.getName()));
        System.out.println(context.getBean(Shape.class.getName()));




      //  Stream.of(names).forEach(e-> System.out.println(e));

//        ConfigurableEnvironment environment = (ConfigurableEnvironment) context.getEnvironment();
//        System.out.println(environment.getProperty("os.name"));

    }
}

