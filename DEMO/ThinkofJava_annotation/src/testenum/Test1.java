package testenum;


import org.junit.Test;

public class Test1 {
    @Test
    public  void testImplementsInterface(){
        for(Food.Dessert dessertEnum:Food.Dessert.values())
        System.out.println(" "+dessertEnum);

        System.out.println();

        for(Food.Coffee coffeeEnum:Food.Coffee.values())
        System.out.println(" "+coffeeEnum);

        System.out.println();

        Food food = Food.Dessert.CAKA;

        System.out.println(food);

        food = Food.Coffee.BLACK;
        System.out.println(food);
    }
}

interface Food{
    enum Coffee implements Food{
        BLACK,DECAF,LATIE
    }

    enum Dessert implements Food{
        FRUIT,CAKA,GELATO
    }
}