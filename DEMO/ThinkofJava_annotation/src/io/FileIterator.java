package io;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileIterator {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\80669\\Documents\\WeChat Files");
        find(file,0);
    }
    public static void find(File file,int num){
        int lay=0;
        System.out.println(file.toString());
        if(file.exists()){
            if(file.isDirectory()){
                List<File> files = Arrays.asList(file.listFiles());

                while(lay<=num){
                    System.out.print("-");
                    lay++;
                }

                for(File subFolder : files){
                   find(subFolder,lay);
                }
            }
        }
    }
}
