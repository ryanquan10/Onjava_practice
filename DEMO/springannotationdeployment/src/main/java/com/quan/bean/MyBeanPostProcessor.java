package com.quan.bean;

import com.quan.config.Config4;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization  --  "+s);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization  --  "+s);
        return bean;
    }

    @Test
    public void test3256(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config4.class);

        // Stream.of(context.getBeanDefinitionNames()).forEach(e-> System.out.println(e));


    }
}
