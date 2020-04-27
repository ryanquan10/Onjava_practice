package functional.exersices;

import org.junit.Test;

public class RecursiveFactorial {

    static IntCall fact;
    @Test
    public void  execute(){
        fact = e->e==0?1:e*fact.call(e-1);

        for(int i=0;i<10;i++){
            System.out.println(fact.call(i));
        }
    }
}

interface IntCall{
    int call(int arg);
}
