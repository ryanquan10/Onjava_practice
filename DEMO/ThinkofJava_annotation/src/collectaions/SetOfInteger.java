package collectaions;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class SetOfInteger {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet();
        Random random = new Random(47);
        for(int i=0;i<10000;i++){
            set.add(random.nextInt(30));
        }
        System.out.println(set);
    }
}
