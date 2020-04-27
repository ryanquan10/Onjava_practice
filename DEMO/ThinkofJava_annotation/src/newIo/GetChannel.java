package newIo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class GetChannel {
    private static String name = "Redirecting2.txt";
    private static final int BSIZE = 1024;
    public static void main(String[] args) {
        // 写入一个文件:
        try(
                FileChannel fc = new FileOutputStream(name).getChannel()
        ) {
            fc.write(ByteBuffer.wrap("Some text ".getBytes()));

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        // 在文件尾添加：
        try(
                FileChannel fc = new RandomAccessFile(
                        name, "rw").getChannel()
        ) {
            fc.position(fc.size()); // 移动到结尾

            fc.write(ByteBuffer
                    .wrap("Some more".getBytes()));
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
        // 读取文件e:
        try(
           FileChannel fc = new FileInputStream(name)
           .getChannel()
           ) {
           ByteBuffer buff = ByteBuffer.allocate(BSIZE);
           fc.read(buff);
           buff.flip();
           while(buff.hasRemaining())
           System.out.write(buff.get());
           } catch(IOException e) {
           throw new RuntimeException(e);
           }
           System.out.flush();
           }
           }
