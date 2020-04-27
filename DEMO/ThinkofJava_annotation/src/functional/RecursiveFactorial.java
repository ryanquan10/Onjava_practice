package functional;

public class RecursiveFactorial {
    static IntCall fact;

    public static void main(String[] args) {
        fact = a -> a== 0? 1:a *fact.call(a-1);
        for(int i=0;i<10;i++){
            System.out.println(fact.call(i));
        }
    }
}
