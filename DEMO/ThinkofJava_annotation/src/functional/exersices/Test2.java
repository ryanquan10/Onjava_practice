package functional.exersices;

import java.util.function.Function;

/**
 *  public static void main(String[] args) {
 *         System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
 *     }
 *
 *     _fter _ll _mbul_nces
 */

public class Test2 {
    static Function<String,String> f1 = (s)->{
        System.out.println(s);

        return s.replace('A','_');

    },f2 = (e)->e.toLowerCase()

            ,f3=s->s.substring(3),
    f4 = f2.compose(f1).andThen(f3);


    public static void main(String[] args) {
        System.out.println(f4.apply("AFTER ALL AMBULANCES"));
    }
}
