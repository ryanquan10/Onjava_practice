package PracticeFromAnki;

public class Dog{
  String name;
  float price;
  int age;

    public Dog() {
    }

    public Dog(String name, float price, int age) {
        this.name = name;
        this.price = price;
        this.age = age;
    }

    public   String modity( String name, float price, int age){
        System.out.println("modify");
       return "OK";
    }
}