package com.quan.config;

import com.quan.bean.Person;
import com.quan.service.serviceImpl.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.stream.Stream;

@Configuration
                                                   //测试用这个写法
//@ComponentScan(value ={"com.quan"},excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,classes= Controller.class)},useDefaultFilters = false)
//@ComponentScan(value ={"com.quan"},excludeFilters = {@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,classes = BookService.class)},useDefaultFilters = true)
@ComponentScan(value ={"com.quan.service.serviceImpl"},excludeFilters = {@ComponentScan.Filter(type= FilterType.CUSTOM,classes = MyTypeFilter.class)})
public class Config {
    @Bean
    public Person person(){
        Person person = new Person("liangwe","quan","chognwei");
        return person;
    }
}


class Test3425{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Stream.of(context.getBeanDefinitionNames()).forEach(e-> System.out.println(e));
    }
}