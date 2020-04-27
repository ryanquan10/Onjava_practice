package functional.exersices;

import org.junit.Test;

public class RecursiveFibonacci {
    IntCall fib;

    public RecursiveFibonacci(){
        fib = e ->{
            //F[n]=F[n-1]+F[n-2](n>=3,F[1]=1,F[2]=1)
            if(e==1){System.out.print("+"+ e);}
            return e==0?0:
                         e==1?1:
                        fib.call(e-1)+fib.call(e-2);
        };
    }

    public int fibonacci(int n){
      return fib.call(n);
    };

    //fibonacci


    @Test
    public void test(){
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for(int i=0;i<10;i++){
            System.out.println(rf.fibonacci(i));
        }
    }
}
