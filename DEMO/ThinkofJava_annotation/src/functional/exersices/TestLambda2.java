package functional.exersices;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class TestLambda2 {
    @Test
    public void test(){
        Runnable runnable = ()-> System.out.println("haha");
        Thread thread = new Thread(runnable);

        thread.run();

        runnable.run();
    }

    @Test
    public void test3(){
        //(Integer x,Integer y) 由于编译器 有:类型推断
        Comparator<Integer> comparator = (x,y)->{
            System.out.println("functional");
            if(x==null)return -1;
            if(y==null)return 1;
            return Integer.compare(x,y);
        };


        System.out.println(comparator.compare(1,2));
    }

    @Test
    public void test4(){
//        execute(2,x->{
//            System.out.println("MyFun "+x);
//            return x;
//
//        });
//        String str = strHandler(" 全亮玮 ",(x)->x.trim());
//        System.out.println(str);
//
        MyFunctionImpl myFunctionImple = new MyFunctionImpl();
        //只需要方法的签名一样就可
        MyFunction myFunction = myFunctionImple::getValue;
        myFunction.getValue("全爷爷");  //我是MyFunctionImpl:全爷爷



    }
    //产生一些整数放到集合当中
    public List<Integer> test5(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
      for(int i=0 ;i<num;i++){
           list.add(supplier.get());

      }
      return list;
    };

    public void execute(Integer integer,LembdaInterface lembdaInterface){
         lembdaInterface.myFun(integer);
    }

    public String strHandler(String str ,MyFunction myFun){
      return  myFun.getValue(str);
    }


}

@FunctionalInterface
interface LembdaInterface{
    public Integer myFun(Integer integer);
}

interface MyFunction{
    public String getValue(String str);
}

class  MyFunctionImpl implements MyFunction{

    @Override
    public  String getValue(String str) {
        System.out.println("我是MyFunctionImpl:"+ str);
        return str;
    }
}