package functional.exersices;

import java.util.function.Function;

public class Test {
    public static void main(String[] args){
        Function<Integer,Integer> times2 = i->i*2;
        Function<Integer,Integer> squared = i->i*i;

        System.out.println(times2.apply(2));
        System.out.println(squared.apply(4));

        System.out.println(times2.compose(squared).apply(3));
        System.out.println(squared.compose(times2).apply(3));
    }
}
