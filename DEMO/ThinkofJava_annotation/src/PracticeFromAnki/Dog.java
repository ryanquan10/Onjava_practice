package PracticeFromAnki;

public class Dog {
    String name;
    int age = -1;

    Dog(){   name ="stray";}
    Dog(String nm) { name = nm; }
    Dog(String nm, int yrs) { name = nm; age = yrs; }

    public static void main(String[] args) {
        MakeNoArgs m1 = Dog::new;
        MakeOneArgs m2 =  Dog::new;
        Dog d1 =(Dog) m1.makeWithNoArgs();

        System.out.println(d1.name);

        Dog d2 = (Dog)m2.makeWithOneArgs("haha");

        System.out.println(d2.name);

        System.out.println();
    }

}

interface MakeNoArgs{
  public Object  makeWithNoArgs();
}

interface MakeOneArgs{
    public Object makeWithOneArgs(String set);
}