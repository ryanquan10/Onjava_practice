package file;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class ByteBufferTest {

    public static void main(String[] args) {
        System.out.println("--------Test reset----------");
        byte[] array = new byte[10];
        ByteBuffer buffer = ByteBuffer.wrap(array);
        buffer.clear();
        System.out.println("before clear:         "+buffer);
        buffer.position(5);
        System.out.println("before position(5):   "+buffer);
        buffer.mark();
        System.out.println("before mark:          "+buffer);
        System.out.println("读取完毕后我们使用mark，这个时候mark会从-1移动到和position指向同一个元素，可以看见Limit是不会发生改变的。");
        buffer.position(10);
        System.out.println("before reset:       " + buffer);
        System.out.println("reset方法 是把当前位置position设置为当前mark");
        buffer.reset();
        System.out.println("after reset:        " + buffer);

        System.out.println("-------Test rewind----------");



    }
}
