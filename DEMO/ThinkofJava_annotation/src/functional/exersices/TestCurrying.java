package functional.exersices;

import java.util.function.Function;

public class TestCurrying {


    public static void main(String[] args) {
        Function<Integer, Function<Integer, Function<Integer, Integer>>> currying = x -> y -> z -> (x+y)*z;

        System.out.println(currying.apply(4).apply(5).apply(6)); //54
    }
}
