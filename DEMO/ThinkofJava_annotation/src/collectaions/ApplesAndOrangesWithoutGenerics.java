package collectaions;

import java.util.ArrayList;

public class ApplesAndOrangesWithoutGenerics {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList();
        for(int i=0;i<3;i++){
            apples.add(new Apple());
            //No problem adding an Orange to apples if have not Generics check
            //Compile-time error;
           // apples.add(new Orange());

        }

        for(Object apple:apples){
            ((Apple)apple).id();
            //Orange is detected only at run time
        }

    }
}

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id() { return id; }
}

class Orange{}

