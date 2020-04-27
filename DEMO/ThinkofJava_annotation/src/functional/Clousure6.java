package functional;

import java.util.function.IntSupplier;

public class Clousure6 {
        IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        x++;
        Integer ag = 0;
        Integer ag2 = 0;

        final int iFinal = i;
        final int xFinal = x;

        return ()-> ag2 +ag;
    }
}
