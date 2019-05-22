package classload;

import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class JVMCanLoadSameClassTwice {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException,
            NoSuchFieldException, IllegalAccessException {
        URL[] urls = {
                new URL("file://Users/fxs/IdeaProjects/learn/src/main/java/")
        };

        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class<?> aClass = urlClassLoader.loadClass("classload.IntProduct");
        Field age = aClass.getField("age");
//        Object o = aClass.newInstance();
//        age.set(o, age.get(aClass));
        System.out.println(aClass.getClassLoader() + ":" + age.getInt(aClass));


        URLClassLoader urlClassLoader1 = new URLClassLoader(urls);
        Class<?> aClass1 = urlClassLoader1.loadClass("classload.IntProduct");
        Field age1 = aClass1.getField("age");
//        Object o1 = aClass.newInstance();
//        age.set(o1, age.get(aClass1));
        System.out.println(aClass1.getClassLoader() + ":" + age1.getInt(aClass1));
    }
}
