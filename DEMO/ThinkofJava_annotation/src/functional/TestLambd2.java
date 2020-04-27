package functional;

import org.junit.Test;

public class TestLambd2 {
    @Test
    public void test6(){
      Integer num = operation(100,(x)->x*x);
        System.out.println(num);
    }

    public Integer operation(Integer num,MyFun mf){
        return mf.getValue(num);
    }
}

