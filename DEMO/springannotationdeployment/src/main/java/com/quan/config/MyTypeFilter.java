package com.quan.config;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 *
 */
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader  读取当前"正在"扫描的类的型芯
     * @param metadataReaderFactory 可以获取到其他任何信息的
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        /**
         *   Resource getResource();
         *
         *     ClassMetadata getClassMetadata();
         *
         *     AnnotationMetadata getAnnotationMetadata();
         */
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

        ClassMetadata classMetadata = metadataReader.getClassMetadata();

        System.out.println("from match visit:"+classMetadata.getClassName());
        if(classMetadata.getClassName().contains("Book")){
            System.out.println("there have BookService");
            return true;
        }




    //返回ture 代表匹配
        return false;
    }
}
