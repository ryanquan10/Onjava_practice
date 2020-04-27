package functional;// functional/Strategize.java

/**
 * 提供了一个单一的approach()方法来承载函数式功能.通过创建不同的Strategy对象,我们可以创建不同的行为
 */
interface Strategy {
    String approach(String msg);
}

/**
 *Soft 作为默认策略 ,在函数中赋值
 */
class Soft implements Strategy {
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

/**
 *
 */
class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

/**
 *
 */
public class Strategize {
    Strategy strategy;
    String msg;
    Strategize(String msg) {
        strategy = new Soft(); // [1]
        this.msg = msg;
    }

    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }


    public static void main(String[] args) {
        Strategy[] strategies = {
                //覆盖了
                new Strategy() { // [2]
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                //杉树左边是参数,右边是从Lambda返回的表达式(函数体).这是想了定义类,匿名内部类相同的效果,但是代码较少
                msg -> msg.substring(0, 5), // [3]
                //方法引用 类:: ?方法
                Unrelated::twice // [4]
        };
        Strategize s = new Strategize("Hello there");
        s.communicate();

        for(Strategy newStrategy : strategies) {
            s.changeStrategy(newStrategy); // [5]
            s.communicate(); // [6]
        }
    }
}