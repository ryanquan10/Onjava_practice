package functional;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 *四大内置函数接口
 *
 * Consumer
 *
 * Supplier
 *
 * Function
 *
 * Predicate
 */
public class TestLambda3 {
 //Consumer<T>

    //消费 在(不知道是否功能上的总之就是设计概念上的)不该有返回值,消费掉了
    @Test
    public void test1(){
        happy(10000,(m)-> System.out.println("刚哥"+m+"元"));
    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    //供给    没有参数有返回值   例子:产生多少个,并放入集合
    @Test
    public void test2(){
                                          //次数      //自定规则
     List<Integer> numList = getNumList(10,()->(int)Math.random()*100);

                                 //返回哈哈哈
       // Comparator<Integer> comparator = (x, y) ->Integer.compare(x,y);
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup){
      List<Integer> list = new ArrayList<>();
      for (int i=0;i<num;i++){
          Integer n =sup.get();
          list.add(n);
      }
      return list;
    }

    //Function<T,R>
    //假设自定义一个字符串处理场景
    @Test
    public void test3(){
        String newStr = strHandler("\t\t\t 长者点灯",(str)->str.trim());
        System.out.println(newStr);
    }
    public String strHandler(String str, Function<String,String>fun){
        return fun.apply(str);
    }

    //Predicate<T>
    //例子场景:将满足条件的字符串,放到集合中 *
    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello","sfsf","ok","o");
        List<String> result = filterStr(list,(s)->s.indexOf("o")!=-1);
        System.out.println(result);
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();

        for(String str:list)
            if(pre.test(str)){strList.add(str);}

        return strList;
    }
}
