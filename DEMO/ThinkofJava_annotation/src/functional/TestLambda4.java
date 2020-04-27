package functional;

import onjava.atunit.Test;

/**
 * package functional;
 *
 * class Go{
 *     static void go(){
 *         System.out.println("Go::go()");
 *     }
 * }
 *
 *
 *
 * public class RunnableMethodReference {
 *     public static void main(String[] args) {
 *         new Thread(new Runnable() {
 *             @Override
 *             public void run() {
 *                 System.out.println("Anonymous");
 *             }
 *         }).start();
 *
 *         new Thread(()->{
 *             System.out.println("lambda");
 *         }).start();
 *
 *         new Thread(Go::go).start(); //go 没有继承 Runnable 接口 怎么回事呢?
 *     }
 * }
 */

public class TestLambda4 {
    @Test
  public void test1(){
    new Face(GG::go).start();
    }
}

class Face{
    Face(Runnable runnable){

    }

    public void start(){
        System.out.println("run");
    }
}

class GG{
    static void go(){
        System.out.println("I m  gg .go");
    }
}