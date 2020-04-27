package functional.exersices;

import java.util.function.Function;

public class TestCurrying2 {
    public static void main(String[] args) {
        Function<Integer, Function<Integer,Integer>> curr = x -> y ->x+y;
        System.out.println(curr.apply(3).apply(4));
    }

}
