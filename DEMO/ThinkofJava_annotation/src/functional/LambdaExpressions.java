package functional;
/*
->之后的内容都是方法体
->可以视作"产出"
->单行并且 return内容就是方法体的 不需要"return"关键字

 功能性接口 = (参数)  -> 方法体
 */
public class LambdaExpressions {

    static Body bod = h ->h+" No Parens!";
    static Body bod2 = (h)->h+" More details";
    static Description desc = ()-> "haha";
    static Multi multi = (a,b) ->a+b;
    static Description moreLines = ()->{
        System.out.println("moreLines()");
        return "from moreLines()";
    };



    public static void main(String[] args) {
        System.out.println(bod.detailed("OH"));
        System.out.println(bod2.detailed("haha "));
        System.out.println(desc.brief());
        System.out.println(multi.twoArg("6.6",6d));
        System.out.println(moreLines.brief());



    }

}

@FunctionalInterface
interface Description{
    String brief();
}

@FunctionalInterface
interface Body{
    String detailed(String head);

}

@FunctionalInterface
interface Multi{
    static int i= 0;
    String twoArg(String head,Double d);
//    String twoArg2(String head,Double d); 不可以
}

//@FunctionalInterface
abstract class A{
   public abstract String printf();


}



