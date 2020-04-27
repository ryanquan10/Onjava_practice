package stream;




import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 创建流
 * 1.创建
 * 2.操作
 * 3.关闭
 */
//public class TestStreamAPI1 {
//  //创建
//    @Test
//    public void test(){
//        List<String> list = new ArrayList<>();
//        Stream<String> stream1 = list.stream();
//
//        //2.通过Arrays中的静态方法stream() 获取数组流
//        Employee[] emps = new Employee[10];
//       Stream<Employee> stream = Arrays.stream(emps);
//
//       //3.通过Stream勒种的静态方法of()
//        Stream<String> stream3 = Stream.of("aa","bb","cc");
//
//        //4.创建无限流
//        //迭代
//        Stream<Integer> stream4 = Stream.iterate(0,(x)-> x+2);
//        //stream4.limit(10);
//        //stream4.forEach(System.out::println);
//
//        //生成
//        Stream stream5 = Stream.generate(()->Math.random());
//        stream5.forEach(System.out::println);
//
//    }
//}
//
//class Employee{
//    int id;
//    String name;
//}
