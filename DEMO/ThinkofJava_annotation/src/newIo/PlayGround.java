package newIo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class PlayGround {
    public static void main(String[] args) throws FileNotFoundException {
        CharBuffer charBuffer = CharBuffer.wrap(new char[]{'a','b','c','d'});
        symmetricScramble(charBuffer);
        char c;
        charBuffer.flip();
        while (charBuffer.hasRemaining()){
            System.out.println(charBuffer.get());
        }
    }

    private static void symmetricScramble(CharBuffer buffer){


        while(buffer.hasRemaining()){
            buffer.mark();
            char c1 = buffer.get();
            char c2 = buffer.get();
            buffer.reset();
            buffer.put(c2).put(c1);


        }
    }
}
