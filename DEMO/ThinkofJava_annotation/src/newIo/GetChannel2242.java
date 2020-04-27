package newIo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel2242 {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        //write
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("hahaha".getBytes()));
        fc.close();

        //写文件 append
        fc = new RandomAccessFile("data.txt","rw").getChannel();
        fc.position(fc.size());//move to the end
        fc.write(ByteBuffer.wrap(" Some move".getBytes()));
        fc.close();


        System.out.println("************************************************************");
        //read
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate((int)fc.size());
        fc.read(buff);

        System.out.println("读取");
        String str = new String(buff.array(),"utf-8");
        System.out.println(str);


        buff.flip();
        System.out.println("读取2");
        while(buff.hasRemaining()){
            System.out.println((char)buff.get());
        }
    }


}
