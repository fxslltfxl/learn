package reflection;

import bean.One;
import interview.Sup;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodOfGetClassInstance {

    public static void main(String[] args) throws Exception {
        One one = One.getInstance();
        Method setAge = one.getClass().getMethod("setName", String.class);
        setAge.invoke(one, "");
        System.out.print(one.getName());

        // 通过反射 调用私有构造方法

        Class<? extends One> aClass = one.getClass();

        Constructor constructor = aClass.getDeclaredConstructor(String.class);

        constructor.setAccessible(true);

        One fxs = (One) constructor.newInstance("xww");
        String name = fxs.getName();
        System.out.print(name);

        //region 四种方法生成Class对象,反射API
        //1. 通过这种方式时，只会加载类，并不会触发其类构造器的初始化。
        Class cla = Sup.class;
        System.out.println(cla.getField("i"));

        //2. sup.getClass()
        Sup sup = new Sup();
        Constructor<? extends Sup> declaredConstructor = sup.getClass().getDeclaredConstructor();
        declaredConstructor.setAccessible(true);


        //3. Class.forName("interview.Sup");
        Class supClass = Class.forName("interview.Sup");
        System.out.println(cla == supClass);
        Sup o = null;
        try {
            o = (Sup) cla.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println();

        Method normalMethod = supClass.getMethod("normalMethod");
        Field i = supClass.getDeclaredField("i");
        i.setAccessible(true);
        Class<?> returnType = normalMethod.getReturnType();
        String simpleName = returnType.getSimpleName();
        try {
            normalMethod.invoke(o);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        //endregion
        System.out.println(1_000);


        //4.Type
        Class<Boolean> type = Boolean.TYPE;
        System.out.println(type);
    }
}
