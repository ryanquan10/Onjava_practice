package PracticeFromAnki;



import annotations.pracitice.SxtField;
import com.sun.org.apache.bcel.internal.generic.Select;
import file.PartsOfPaths;
import functional.entity.Employee;
import functional.exersices.ForkJoinCalculate;
import material.Trader;
import material.Transaction;
import org.junit.Before;
import org.junit.Test;

import sun.rmi.transport.StreamRemoteCall;
import typeinfo.ClassInitialization;


import javax.xml.crypto.Data;
import java.io.*;
import java.lang.reflect.*;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URL;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLOutput;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.RecursiveTask;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.zip.CRC32;

import static java.util.stream.Collectors.groupingBy;

public class Practice2313 {
    List<Employee> list = Arrays.asList(
            new Employee(1, "haha", 3, 3.3, "haha", Employee.Status.BUSY),
            new Employee(2, "haha1", 2, 3.3, "haha", Employee.Status.BUSY),
            new Employee(3, "aha", 55, 3.3, "haha", Employee.Status.FREE),
            new Employee(4, "hahad", 11, 3.3, "haha", Employee.Status.FREE)
    );
    //修复
    List<Employee> emps = new ArrayList(list);

    Path dir = Paths.get("G:\\360驱动大师目录");

    final static String file = "H:\\OneDrive - vlity.ac.id\\DEMO\\ThinkofJava_annotation\\src\\PracticeFromAnki\\UnboundMethodReference2314.java";
    final static String endpoint = "data.txt";


    List<Transaction> transactions;

    @Before
    public void before() {
        Trader a = new Trader("a", "cambridge");
        Trader b = new Trader("b", "cc");
        Trader c = new Trader("c", "Milan");
        Trader d = new Trader("d", "Milan");
        Trader e = new Trader("e", "cambridge");

        transactions = Arrays.asList(
                new Transaction(a, 2011, 300d),
                new Transaction(a, 2012, 1000d),
                new Transaction(b, 2011, 300d),
                new Transaction(c, 2012, 700d),
                new Transaction(d, 2012, 5050d),
                new Transaction(e, 2012, 3100d)
        );
    }



    @Test
    public void test3453() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        Path path = Paths.get("/data/logs");
        Pattern pattern = Pattern.compile("^.+\\.log");
        List<Path> paths = Files.walk(path).filter(p -> {
            //如果不是普通的文件，则过滤掉
            if(!Files.isRegularFile(p)) {
                return false;
            }
            File file = p.toFile();
            Matcher matcher = pattern.matcher(file.getName());
            return matcher.matches();
        }).collect(Collectors.toList());

        for(Path item : paths) {
            System.out.println(item.toFile().getPath());
        }


    }

    @Test
    public void test3254() throws IOException {
        Files.walkFileTree(Paths.get("H:\\OneDrive - vlity.ac.id\\DEMO\\ThinkofJava_annotation\\src"),new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult preVisitDirectory(Path path,BasicFileAttributes attr){
                System.out.println(path);
                System.out.println(attr.fileKey());
                System.out.println(attr.isRegularFile());//...
                System.out.println("-------------");
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir,IOException exc)
            {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path path,IOException exc){
                return FileVisitResult.SKIP_SUBTREE;
            }
        });
    }

    @Test
    public void test3253() throws IOException, InterruptedException {

    }



























}






class TestNonBlockingNIO222{
    /**
     *一.使用NIO完成网络通信的三个核心
     * 1.通道(Channel):负责连接
     * 特色非阻塞模式
     * java.nio.channels.Channel 接口:
     * |--SelectableChannel
     * |--SocketChannel
     * |--ServerSocketChannel
     * |--DatagramChannel
     *
     * |--Pipe.SinkChannel
     * |--Pipe.SourceChannel
     * 2.缓冲区(Buffer):负责数据的存取
     * |--
     * 3.选择器(Selector):是SelectableChannel 的多路复用器 ,用于监控 SelectableChannel的IO 状况
     */
    @Test
    public void client() throws IOException {
//1.获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1",9898));

//2.切换成非阻塞模式*
        socketChannel.configureBlocking(false);

//3.分配指定的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

//4.发送数据给服务端
        buffer.put(new Date().toString().getBytes());
        buffer.flip();
        socketChannel.write(buffer);
        buffer.clear();

        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel server = ServerSocketChannel.open();

        //.2.切换成非阻塞模式
        server.configureBlocking(false);

        //3.绑定连接
        server.bind(new InetSocketAddress(6666));

        //4.获取选择器
        Selector selector = Selector.open();

        //4.1将通道注册到选择器上,指定接收"监听通道"事件
        server.register(selector,SelectionKey.OP_ACCEPT);

        //5.轮询地获取选择器上已"就绪"事件--->只要select()>0,说明已经就绪
        while (selector.select()>0){
            //6.获取当前选择器所注册的"选择键"(已经就绪的监听事件)
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            //7.获取已经"就绪"的时间,(不同的时间做不同的事)
            while(iterator.hasNext()){ //ture
                SelectionKey selectionKey = iterator.next();

                //接收事件就绪
                if(selectionKey.isAcceptable()){
                    //8.获取客户端连接
                    SocketChannel client = server.accept();

                    //8.1切换成非阻塞状态
                    client.configureBlocking(false);

                    //8.2注册到选择器上-->拿到客户端的链接是为了读取通道的数据(监听"听"就绪时间)
                    client.register(selector,SelectionKey.OP_READ);
                }else if(selectionKey.isReadable()){
                    //读时间就绪
                    //9.获取当前选择器读
                    SocketChannel client = (SocketChannel)selectionKey.channel();

                    //9.1读取数据
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    //9.2得到文件通道,将客户端传递过来的 文件 写到本地项目下
                    FileChannel outChannel = FileChannel.open(Paths.get(""),StandardOpenOption.WRITE,StandardOpenOption.CREATE);

                    while(client.read(buffer)>0){
                        buffer.flip();

                        outChannel.write(buffer);

                        //读完切换成写模式,能让管道继续读取文件的数据
                        buffer.clear();
                    }
                }
                iterator.remove();
            }
        }
    }
}
























class TestReflect{
    public static void test(TestReflect p0,
                            List<TestReflect> p1,
                            Map<String,TestReflect> p2,
                            List<String>[] p3,
                            Map<String,TestReflect>[] p4,
                            List<? extends TestReflect> p5,
                            Map<? extends TestReflect,? super TestReflect> p6
//T p7
    ){
    }
}



