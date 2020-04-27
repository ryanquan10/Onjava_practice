package functional;

import java.util.function.IntSupplier;

public class AnonymousClosure {
    IntSupplier makeFun(int x){
        int i=0;
        //i++; //是否对?
        return new IntSupplier() {
            @Override
            public int getAsInt() {
               return x+i;
            }
        };
    }
}
