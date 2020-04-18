package com.quan.config;

import com.quan.bean.Car;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

/**
 * LisffeCycle of config
 */
@ComponentScan(value = "com.quan.bean")
@Configuration
public class Config4 {

// @Bean(initMethod="init",destroyMethod = "destroy")
// public Car car(){
//   return new Car();
// }

 @Test
 public void test3256(){
     AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config4.class);

    // Stream.of(context.getBeanDefinitionNames()).forEach(e-> System.out.println(e));
     context.getBean("car");
     context.getBean("car2");
     context.getBean("cat");
     context.close();

 }
}

