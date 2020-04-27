package functional;

/**
 * https://objcoding.com/2019/03/04/lambda/
 */
public class LambdaVsAnonymousClass {

}

/**
 *  AnonymousClass
 *  MainAnonymousClass.class
 *  'MainAnonymousClass$1.class'
 *
 *实际编译后被封装成了主类的一个私有方法
 */
class MainAnonymousClass {
    public static void main(String[] args) {
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("Anonymous Class Thread run()");
            }
        }).start();;
    }
}

/**
 * MainLamba
 *MainLamba.class
 * just created one file
 */
class MainLamba{
    public static void main(String[] args) {
        new Thread(()-> System.out.println("Lambda run()")).start();
    }
}

/**
 * 将输出两个Hello 所以是两个 地址?
 */
class Hello {
    Runnable r1 = () -> { System.out.println(this); };
    Runnable r2 = () -> { System.out.println(toString()); };
    public static void main(String[] args) {
        new Hello().r1.run();
        new Hello().r2.run();
    }
    public String toString() { return "Hello Hoolee"; }
}