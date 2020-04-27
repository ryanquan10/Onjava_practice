package PracticeFromAnki;

public class UnboundMethodReference2314 {
    public static void main(String[] args) {
        X x = new X();
        TransformX transformX = X::f;
        transformX.cell(x);
    }

}
class X{
    String f(){return "X::f";}
}

interface TransformX{
   String cell(X x);
}