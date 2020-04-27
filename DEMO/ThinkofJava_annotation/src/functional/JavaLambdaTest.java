package functional;

public class JavaLambdaTest {
    //interface
    public static void main(String[] args) {
      MathOperation mathOperation = (int a,int b)->a+b;
    }
}
interface MathOperation{
    int operation(int a,int b);
}