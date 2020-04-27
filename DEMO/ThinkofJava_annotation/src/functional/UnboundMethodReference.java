package functional;

import org.junit.Test;

public class UnboundMethodReference
{
    private X2 x;


    @Test
    public void test(){
        X2 x = new X2();
      TransformX sp = X2::f ; //未绑定引用



        System.out.println(sp.transform(x)); //这个接口是额外的接口
        System.out.println(x.f()); //同等效果


        //  MakeString ms = X::f;
       // MakeString ms = x::f; //绑定引用

   }
}

class X2{
  String f(){return "x::f()";}

}

//interface MakeString {
//    String make();
//}

 interface  TransformX{
    String transform(X2 x);//未绑定引用不为 空参数x this


}

