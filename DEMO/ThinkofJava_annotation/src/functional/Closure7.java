package functional;

import java.util.function.IntSupplier;

public class Closure7 {
    IntSupplier makeFun(int x){
        Integer i=0;
        i=i+1;
        Integer finalI = i;
        return()->x+ finalI;
    }
}
