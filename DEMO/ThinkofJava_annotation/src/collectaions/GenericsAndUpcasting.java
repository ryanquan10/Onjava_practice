package collectaions;

import java.util.ArrayList;

class GrannySmith extends Apple{}
class Gala extends Apple {}
class Fuji extends Apple {}
class Braeburn extends Apple {}

public class GenericsAndUpcasting {
    public static void main(String[] args) {
        ArrayList<Apple> apples = new ArrayList<>();
        class Gala extends Apple {}
        class Fuji extends Apple {}
        class Braeburn extends Apple {}
        for(Apple apple:apples)
            System.out.println(apple);
    }
}
