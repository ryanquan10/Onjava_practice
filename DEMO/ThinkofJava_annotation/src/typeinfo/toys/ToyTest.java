package typeinfo.toys;

public class ToyTest {
  static void printInfo(Class cc){
      System.out.println("Class name: "+cc.getName()+
              "\n is interface?["+cc.isInterface()+"]");
      System.out.println("Simple name:."+cc.getSimpleName());
      System.out.println("Cannonical name:"+cc.getCanonicalName());
  }

  public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
      Class c = null;
//
      c = Class.forName("typeinfo.toys.FancyToy");
//      printInfo(c);

//      for(Class face:c.getInterfaces()){
//          printInfo(face);

      //}
//      System.out.println("---------------------------");
//      System.out.println(c.getSuperclass());

     // System.out.println(SubFancyToy.class.getSuperclass());

    Object obj = c.newInstance();

    printInfo(obj.getClass());
  }
}

class Toy{
        Toy(){}

        Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
    FancyToy(){super(1);}
}

class SubFancyToy extends FancyToy{

}



interface HasBatteries {}
interface Waterproof {}
interface Shoots {}