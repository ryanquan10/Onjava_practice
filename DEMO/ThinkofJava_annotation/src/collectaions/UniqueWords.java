package collectaions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    //路径有点问题可能是因为ide文件目录的问题
    public static void
    main(String[] args) throws Exception {

        List<String> lines = Files.readAllLines(
                Paths.get("TestArray.class"));
        Set<String> words = new TreeSet<>();
        for(String line : lines)
            for(String word : line.split("\\W+"))
                if(word.trim().length() > 0)
                    words.add(word);
        System.out.println(words);
    }
}
