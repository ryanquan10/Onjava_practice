package com.quan.config;

import com.quan.assembly.MyImportBeanDefinitionRegistrar;
import com.quan.bean.Circle;
import com.quan.bean.ShapeFactoryBean;
import com.quan.bean.Triangle;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.stream.Stream;

@Configuration
@Import({MyImportBeanDefinitionRegistrar.class, Circle.class, Triangle.class})
public class Config3 {

    @Bean //注:这个方式同样是加@Bean注解
    public ShapeFactoryBean shapeFactoryBean(){
     return new ShapeFactoryBean();
    }

    @Test
    public void test3225(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Config3.class);

        //Stream.of(context.getBeanDefinitionNames()).forEach(e-> System.out.println(e));
        Object obj =context.getBean("shapeFactoryBean");
        System.out.println(obj.getClass());
    }

}


