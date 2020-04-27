package com.ryanchuan.core.io;


import com.ryanchuan.util.Assert;
import com.ryanchuan.util.StringUtils;

import java.net.URL;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;

public class DefalultResourceLoader implements ResourceLoader {

    private ClassLoader classLoader;
    //观察者模式?
    private final Set<ProtocolResolver> protocolResolvers = new LinkedHashSet<>(4);

    //构造方法传入一个classLoader
    public DefalultResourceLoader(ClassLoader classLoader){this.classLoader=classLoader;}


    //getter and setter
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public Set<ProtocolResolver> getProtocolResolvers() {
        return protocolResolvers;
    }




    @Override
    public Resource getResource(String location) {
        //就如 apaqiComment 的那个 StringUtil 或者其他什么的差不多
      Assert.notNull(location,"Location must not null");
        //得到一个迭代器
      Iterator var2 = this.protocolResolvers.iterator();

      Resource resource;
      do{
          //如果 String startWith / 就直接放入Resource
          if(!var2.hasNext()){
              if(location.startsWith("/")){
                  return this.getResource(location);
              }

              if(location.startsWith("classpath:")){
                  //return new ClassPathResource(location.substring("classpath:".length()),this.getClassLoader());
                  return null;
              }

              //          URL url = new URL(location);
//          return new UrlResource(url);
          }
          //配合do while
          ProtocolResolver protocolResolver = (ProtocolResolver)var2.next();
          resource=protocolResolver.resolver(location,this);



      }while(resource == null);


        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
       // return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
    }


    /**
     *
     */
//    protected Resource getResourceByPath(String path) {
//        return new DefalultResourceLoader.ClassPathContextResource(path, this.getClassLoader());
//    }

//    protected static class ClassPathContextResource extends ClassPathResource implements ContextResource {
//        public ClassPathContextResource(String path, ClassLoader classLoader) {
//            super(path, classLoader);
//        }
//
//        public String getPathWithinContext() {
//            return this.getPath();
//        }
//
//        public Resource createRelative(String relativePath) {
//            String pathToUse = StringUtils.applyRelativePath(this.getPath(), relativePath);
//            return new DefaultResourceLoader.ClassPathContextResource(pathToUse, this.getClassLoader());
//        }
//    }
}
