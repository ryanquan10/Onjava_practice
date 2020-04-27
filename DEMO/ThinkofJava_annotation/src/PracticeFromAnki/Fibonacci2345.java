package PracticeFromAnki;

import functional.RecursiveFibonacci;

import java.util.function.Supplier;

public class Fibonacci2345  {
  IntCall fib;

    public Fibonacci2345() {
        fib = n->n==0?0:n==1?1:
        fib.call(n-1)+fib.call(n-2);
    }

    int fibonacci(int n){return fib.call(n);}

    public static void main(String[] args) {
        Fibonacci2345 rf = new Fibonacci2345();

        for(int i=0;i<10;i++){
            System.out.println(rf.fibonacci(i));
        }
    }
}

//interface IntCall{
//    public int call(int num);
//}