package functional;



import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用:
 *若 Lambda 体中的内容有方法已经实现了,可闷可以使用"方法引用"
 *
 * 三种与格式
 *Object::instancemethodName  A
 * class::staticMethodName B
 * class::instanceMethodName C
 *
 *
 * https://www.bilibili.com/video/av62117143?p=6
 */
public class TestMethodRef {
    @Test
   public void test1(){
        //Consumer
                                         //T
        //A B 必须参数列表一致 ,例如 void A(Object)  void B(Object)
        //A accept(T)                 //B  println(String x)
        Consumer<String> con = (x)-> System.out.println(x);



        PrintStream ps = System.out;
        //满足上者等于此段       out.println();      // PS  对象::实例方法名
         Consumer<String> con1 = ps::println;


         //等于前一段
         Consumer<String> con2 = System.out::println;
    }

    @Test
    public void test1_2(){
        PrintStream ps1 = System.out;

        Consumer<String> con = (x)->ps1.println(x);
        Consumer<String>con1 = ps1::println;

        con1.accept("abcd");   //console output : abcd
    }

    @Test
    public void test2(){

         Supplier<String> sup = ()->new Employee(1,"haha",8,333).getName();
        System.out.println(sup.get());

        Supplier<Integer> sup2 = ()->(int)new Random(11).nextInt();
        System.out.println(sup2.get());
    }

    @Test
    public void test3(){
        Comparator<Integer> comparator = (x,y) ->Integer.compare(x,y);

        //@FunctionalInterface方法是也
        Comparator<Integer> sup3   =  Integer::compare;

        System.out.println(sup3.compare(5,1));
    }

    public void test4(){
        //专门接口之一 相对于Predicate
        //predicate   a(x)
        //biPredicate  a(x,y)
        BiPredicate<String,String> bp = (x,y)->x.equals(y);

                                        //若 a.fun(y)  是  x.fun(y)  可当做  a.fun(x,y)来用
        BiPredicate<String,String>bp2 = String::equals;

    }

    //构造器调用
    @Test
    public void test5(){
        Supplier<Employee> sup = ()->new Employee(1,"haha",8,333);

        //构造器引用方式
        // public Employee(int id, String name, int age, double salary) ???必须另外有一个无参构造器.
        //Supplier<Employee> sup2 = Employee::new ;


    }

    @Test
    public void test6(){
                                                                     //Function<T, R>  inputType ,ReturnType
        //Function<Integer,Employee> fun = (x) -> new Employee(x);  //必须有一个单参数的构造器

        //Function<Integer,Employee>fun2 = Employee::new;   //return Type=Employee;

        //BiFunction<Integer,Integer,Employee>bf = Employee::new;  //必须有 双参数构造器
    }

    @Test
    public void test6_1(){
        //Function<Integer,String[]>....

        Employee emp = new Employee(1,"haha",8,333);

       Function<Employee,Employee> fun = (x)->x;

        System.out.println(fun.apply(emp).age);

    }


}
