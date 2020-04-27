package io;

import java.io.File;

public class DirDemo03 {
    public static void main(String[] args) {

    }

    public static void printName(File src,int deep){
        for(int i=0;i<deep;i++){
            System.out.println("-");
        }

        System.out.println(src.getName());
        if(src!=null||src.exists()){
            return;
        }else{
          if(src.isDirectory()){
            for(File file:src.listFiles()){
                printName(file,deep);
            }
          }
        }
    }
}
