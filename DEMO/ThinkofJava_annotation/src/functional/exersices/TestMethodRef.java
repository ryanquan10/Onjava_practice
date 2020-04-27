package functional.exersices;

import functional.entity.Employee;
import onjava.atunit.Test;

import java.io.PrintStream;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestMethodRef {
    @Test
    public void test1(){
        Consumer<String> con =x-> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
    }

    //String::equals;....实例方法也行
    public void test2(){
        BiPredicate<String,String> bp = (x,y)->x.equals(y);
        BiPredicate<String,String>bp2 = String::equals;
    }

    public void test5(){
        Supplier<Employee> sup = ()->new Employee();
        //sup.get();
        Supplier<Employee> sup2 = Employee::new;
    }

    public void test6(){
        Function<Integer,String[]>function =(x)->new String[x];
    }
}
