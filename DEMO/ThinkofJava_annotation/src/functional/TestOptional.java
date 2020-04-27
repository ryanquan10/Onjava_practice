package functional;



import org.junit.Test;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;

public class TestOptional {
    /**
     *
     */
    @Test
    public void test1(){
        Optional<Employee> op = Optional.of(new Employee(1, "haha", 3, 3.3));
        Employee emp = op.get();
        System.out.println(emp);

    }
    @Test
    public void test2(){
        Optional<Employee> op=Optional.empty();
        System.out.println(op.get());//这个是没有值的是空指针异常

    }

    @Test
    public void test3(){
        Optional<Employee> op = Optional.ofNullable(new Employee("张三",18,888.88, functional.entity.Employee.Status.FREE));
        System.out.println(op.get());
    }

    @Test
    public void test4(){
        Optional<Employee> op = Optional.ofNullable(null);

        if(op.isPresent()){
            System.out.println("/do th");
        }

        Employee emp = op.orElse(new Employee("张三",18,888.88, functional.entity.Employee.Status.FREE));

         System.out.println(emp);

    }

    @Test
    public void test5(){
        //创建空
        Optional<Employee> op = Optional.ofNullable(null);
        op.orElseGet(()->{return new Employee();});//如果是空 则返回一个加料的

    }
    @Test
    public void test6(){

    }


}
