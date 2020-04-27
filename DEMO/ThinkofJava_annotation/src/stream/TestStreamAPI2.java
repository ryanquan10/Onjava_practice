package stream;

import functional.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 中间操作:
 * filter
 * limit
 * skip
 * distinct
 *
 * https://www.bilibili.com/video/av62117143?p=8
 */
public class TestStreamAPI2 {
    List<Employee> emps = Arrays.asList(

            new Employee(2, "haha1", 33, 300000.3),
            new Employee(3, "aha", 55, 111113.3),
            new Employee(1, "haha", 3, 30000.3),
            new Employee(1, "haha", 3, 30000.3),
            new Employee(10, "haha", 3, 30300.3),
            new Employee(4, "hahad", 11, 3.3)
    );

    /**
     * 中间可以有A连缀(中间操作) , B最终方法(终止操作 )   中止操作(中止操作并非filter过滤之类的操作)
     *
     * 终止操作是          " stream.forEach(printer::print);"
     *                 惰性求值
     *
     *                 期初 中间操作并不会出发任何的操作
     *                 当  运行到 终止操作行 再出发之前一些列 中间操作
     */
    //@Test
    public void test1(){

        Stream<Employee> stream = emps.stream().filter((e)->e.getAge()>22);
        //stream.forEach(System.out::println);

        // 此流它会自动关闭  java.lang.IllegalStateException: stream has already been operated upon or closed
        Printer printer = new Printer();

        //终止操作
        stream.forEach(printer::print); //内部迭代,由API自动完成 等价 Iterator  it....while(it.hasNext())



    }

    //@Test
    public void test3(){
        emps.stream().filter((e)->{System.out.println("短路  "+e) ;return e.getName().equals("haha"); }).
                limit(2).
                forEach(System.out::println);

    }

    //@Test
    public void test4(){
        emps.stream().filter((e)->e.getSalary()>5000)
                .skip(2)  //跳过前两个
                .forEach(System.out::println);
    }

    //@Test
    public void test5(){
        emps.stream().filter(e->e.getName().equals("haha")).
                distinct().  //需要重写hashcode
                forEach(System.out::println);
    }

    @Test
    public void test6(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","ccc");
         //list 1,2,3,4  ...       AAA,BBB,CCC..
        list.stream().map((str)->str.toUpperCase()).forEach(System.out::println);
        System.out.println("---------------------");

        emps.stream().map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("---------------------");

        //!!                                                     //map本身是返回流
         Stream<Stream<Character>> stream= stream=list.stream().map(TestStreamAPI2::Characterfilter);

    }

    @Test
    public void test7(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd");
        list.stream().map((str)->str.toUpperCase()).forEach(System.out::println);
        System.out.println("--------");
        emps.stream().map(Employee::getName).forEach(System.out::println);
        System.out.println("---------");
        Stream<Stream<Character>> stream = list.stream().map(TestStreamAPI2::Characterfilter);
        //for(...)....

        list.stream().flatMap(TestStreamAPI2::Characterfilter).forEach(System.out::println);

    }

    @Test
    public void test8(){
//        List list = Arrays.asList("aaa","bbb","ccc","ddd");
//        List list2= Arrays.asList("aaa","bbb","ccc","ddd");
//        list.add(list2);
//
//        System.out.println(list);

    }

    //排序,1.自然排序
    @Test
    public void test9(){
        //List list = Arrays.asList("kkk","aaa","bbb","ccc","ddd");

        emps.stream().sorted((e1,e2)-> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return e1.getAge()-e2.getAge();
            }

        }).forEach(System.out::println);
    }



    public static Stream<Character> Characterfilter (String str){
        List<Character> list =  new ArrayList<>();


        for(Character character:str.toCharArray()){
            list.add(character);
        }
        return list.stream();
    }

}


class Printer<T>{
    public void print(T t){
        System.out.println(t);
    }
}