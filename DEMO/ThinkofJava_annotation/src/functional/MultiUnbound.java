package functional;

public class MultiUnbound  {
    public static void main(String[] args) {
        This ts = new This();
        TwoArgs tow = This::two;
        ThreeArgs three = This::three;
        FoureArgs foureArgs = This::four;
       tow.call2(ts,1,22.2);
       three.call3(ts,1,22.2,"haha");
        foureArgs.call4(ts,1,2.2,"haha",'a');

    }
}

class This {
    void two(int i, double d) {}
    void three(int i, double d, String s) {}
    void four(int i, double d, String s, char c) {}
}

interface TwoArgs{
    void call2(This athis,int i,double d);
}

interface ThreeArgs{
    void call3(This athis,int i,double d,String s);
}

interface FoureArgs{
    void call4(This four,int i,double d,String s,char c);
}

