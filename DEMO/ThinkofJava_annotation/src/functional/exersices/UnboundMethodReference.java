package functional.exersices;

public class UnboundMethodReference {
  private X x;

    public static void main(String[] args) {
         TransformX sp = X::f;
         X x = new X();

        System.out.println(sp.transform(x));
        System.out.println(x.f());
    }

}

class X{
    String f(){return "X::f";}
}

interface TransformX{
   String transform(X x);
}