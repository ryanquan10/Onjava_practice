package PracticeFromAnki;



import material.Trader;
import material.Transaction;

import org.junit.Before;
import org.junit.Test;


import java.io.*;
import java.lang.reflect.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PlayGround {
    /*有问题*/
    final static String location = "H:\\OneDrive - vlity.ac.id\\DEMO\\ThinkofJava_annotation\\Redirecting.txt";
    final static String endpoint = "H:\\OneDrive - vlity.ac.id\\DEMO\\ThinkofJava_annotation\\Redirecting2.txt";

    List<Transaction> transactions;
    @Before
    public void before(){
        Trader a = new Trader("a","cambridge");
        Trader b = new Trader("b","cc");
        Trader c = new Trader("c","Milan");
        Trader d = new Trader("d","Milan");
        Trader e = new Trader("e","cambridge");

        transactions = Arrays.asList(
                new Transaction(a,2011,300d),
                new Transaction(a,2012,1000d),
                new Transaction(b,2011,300d),
                new Transaction(c,2012,700d),
                new Transaction(d,2012,5050d),
                new Transaction(e,2012,3100d)
        );
    }


    @Test
    public void test3421() throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        try(
                FileChannel fc = new FileOutputStream("H:\\OneDrive - vlity.ac.id\\DEMO\\ThinkofJava_annotation\\Redirecting2.txt").getChannel()
                ){
            fc.write(ByteBuffer.wrap("Some text".getBytes()));
        }

    }

    @Test
    public void test3345(){

        System.out.println("----------Test allocate--------");
        System.out.println("before alocate:"
                + Runtime.getRuntime().freeMemory());

        ByteBuffer buffer = ByteBuffer.allocate(245318424);
        System.out.println("buffer = " + buffer);


        System.out.println("after alocate:"
                + Runtime.getRuntime().freeMemory());

        //////
        System.out.println("****************************************");
        byte[] bytes = new byte[32];
        buffer = ByteBuffer.wrap(bytes);
        System.out.println(buffer);

        System.out.println("22222222222222222222222222222222222");

        buffer = ByteBuffer.wrap(bytes, 10, 10);
        System.out.println(buffer);

    }












    @Test
    public void test2345() throws IOException {
        String fileName = "data.txt";
        FileChannel fc = new FileOutputStream(fileName).getChannel();
        fc.write(ByteBuffer.wrap("hahahaha".getBytes()));
        fc.close();

        fc = new RandomAccessFile(fileName,"rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("some move".getBytes()));
        fc.close();

        System.out.println("**********************");

        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff  = ByteBuffer.allocate((int)fc.size()-3);
        fc.read(buff);
        System.out.println(new String(buff.array(),"utf-8")); //再来

       //buff.flip();  //注释了

        System.out.println("flip???????");
        while(buff.hasRemaining()){
            System.out.println("没有反应:"+(char)buff.get());
        }

        fc.read(buff);
        System.out.println("再来:"+new String(buff.array(),"utf-8"));//再来

    }

    @Test
    public void test3409() throws ClassNotFoundException {
        Class clazz = Class.forName("java.util.function.BiFunction");
        Method[] methods = clazz.getMethods();
        for(Method m :methods){
            Type[] types = m.getGenericParameterTypes();
            for (Type t :types){
                if(t instanceof  ParameterizedType) {
                    Type[] cs =((ParameterizedType) t).getActualTypeArguments();
                    for(Type c:cs){
                        System.out.println( c.getTypeName());
                        System.out.println(((WildcardType)c).getUpperBounds());
                        System.out.println(((WildcardType)c).getLowerBounds());
                    }
                }
            }
        }
    }








}

