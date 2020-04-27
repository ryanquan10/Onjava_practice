package functional;


import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

//函数式接口:当借口中只有一个抽象方法的接口时候称为函数式接口
class TestLambda2 {
    public static void main(String[] args) {
        new TestLambda2().test1();
        new TestLambda2().test2();
        new TestLambda2().test3();
        new TestLambda2().test4();
    }

  public void test1(){
        int num =0;//内部类情况下默认final
      Runnable r = new Runnable(){
          @Override
          public void run() {
              System.out.println("hi"+num); // can not num++
          }
      };
      r.run();


      System.out.println("--------------");

      //run()
      Runnable r1 =() -> System.out.println("Hello Llambda!"); // can not num++ 证明这写法是一个匿名内部类语法糖

      r1.run();
  }

  @Test
  public void test2(){
      System.out.println("----------------");
        Consumer<String> con=(x)-> System.out.println(x);
        con.accept("dada");
  }

    public void test3(){
        System.out.println("----------------");
        Consumer<String> con=x-> System.out.println(x);
        con.accept("dada");
    }
    public void test4(){
        System.out.println("----------------");
        Comparator<Integer> com = (x,y)->{ //x,y final
          //多条语句
            System.out.println("函数接口");
            return Integer.compare(x,y);
        };
    }

}

@FunctionalInterface  //函数式接口
interface MyPredicate<T>{
    public boolean test(T t);

    //public boolean test2();
}