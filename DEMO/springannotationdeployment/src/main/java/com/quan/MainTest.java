package com.quan;

import com.quan.bean.Person;
import com.quan.config.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Object bean = context.getBean("person");
//        System.out.println(bean);

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        //Object bean = context.getBean("person");
        //System.out.println(bean);

        Stream.of(context.getBeanDefinitionNames()).forEach(e-> System.out.println(e));
    }
}
