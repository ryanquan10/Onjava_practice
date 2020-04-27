package PracticeFromAnki;

public class Fibonacci {
  IntCall fib;

    public Fibonacci() {
        fib = n -> n == 0?0 :
                    n==1?1:
                fib.call(n-1)+fib.call(n-2);

    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();

        for (int i=0;i<10;i++){
            System.out.println(f.fib.call(i));
        }
    }


}

interface IntCall{
  public int call(int num);
}