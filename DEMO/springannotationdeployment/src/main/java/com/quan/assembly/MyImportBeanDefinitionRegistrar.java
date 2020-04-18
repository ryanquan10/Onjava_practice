package com.quan.assembly;

import com.quan.bean.Circle;
import com.quan.config.Config;
import com.quan.config.Config3;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    /**
     *
     * @param annotationMetadata 当前类的注解信息
     * @param beanDefinitionRegistry  当前类的其他信息:BeanDefinition 注册类
     *
     *                                调用bean:BeanDefinitionRegistry 注册到容器
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        boolean definition = beanDefinitionRegistry.containsBeanDefinition("com.quan.bean.Circle");
        boolean definition2 = beanDefinitionRegistry.containsBeanDefinition("com.quan.bean.Triangle");//bean名因为import的规则限定名作了bean名
        if(definition && definition2){
            BeanDefinition beanDefinition =new RootBeanDefinition(Circle.class);
            beanDefinitionRegistry.registerBeanDefinition("Circle",beanDefinition);
        }
    }

    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
//        Object bean = context.getBean("person");
//        System.out.println(bean);

        ApplicationContext context = new AnnotationConfigApplicationContext(Config3.class);
        //Object bean = context.getBean("person");
        //System.out.println(bean);

        Stream.of(context.getBeanDefinitionNames()).forEach(e-> System.out.println(e));
    }
}
