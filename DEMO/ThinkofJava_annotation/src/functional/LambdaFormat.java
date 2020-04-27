package functional;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.function.BinaryOperator;

public class LambdaFormat {
//    Runnable run = ()-> System.out.println("hi");//1
//    ActionListener listener = event -> System.out.println("button clicked");//2
//    Runnable multiLine = ()->{
//        System.out.println("line1");
//        System.out.println("line2");
//    };
//    BinaryOperator<Long> add = (Long x,Long y)->x+y;
//    BinaryOperator<Long> addImplicit = (Long x,Long y)->x+y;

    void test(){
        ConsumerInterface<String> consumer = (str)->str.toUpperCase();
        consumer.accept("haha");
    }
}

@FunctionalInterface
interface ConsumerInterface<T>{
    void accept(T t);
}

class MyStream<T>{
    private List<T> list;
    public void myForEach(ConsumerInterface<T> consumer){
        for(T t:list){
            consumer.accept(t);
        }
    }

    static MyStream<String> stream = new MyStream<String>();

    public void execute(){
        stream.myForEach(str-> System.out.println());
    }
}


