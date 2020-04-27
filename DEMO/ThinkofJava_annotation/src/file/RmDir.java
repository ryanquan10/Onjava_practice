package file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class RmDir {
    public static void rmdir(Path dir) throws IOException {
        Files.walkFileTree(dir, new SimpleFileVisitor<Path>() {
            @Override
            //在一个 目录或文件 被处理前
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;

            }

            //在一个目录被处理前
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                    throws IOException
            {

                return FileVisitResult.CONTINUE;
                //FileVisitResult.SKIP_SUBTREE; //继续但不再访问 此文件的子文件
                //FileVisitResult.SKIP_SUBTREE; //跳过词文件的兄弟节点
                //FileVisitResult.SKIP_SUBTREE; //中止
            }

            //在一个目录被处理后
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException { //当访问发生错误例如无权限抛异常
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
