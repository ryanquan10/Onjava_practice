package functional;

import java.util.function.IntSupplier;

public class Closure1 {
    int i;
    public IntSupplier makeFun(int x){
        return ()-> +i++;
    }


}
