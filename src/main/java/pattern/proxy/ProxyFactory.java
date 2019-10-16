package pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

public class ProxyFactory<T> {


    private T target;

    ProxyFactory(T target) {
        this.target = target;
    }

    T getProxyInstance() {

        ClassLoader classLoader = target.getClass().getClassLoader();

        Class<?>[] interfaces = target.getClass().getInterfaces();

        InvocationHandler invocationHandler = (proxy, method, args) -> {

            System.out.printf("ProxyFactory1 ProxyClassName:%s method:%s start%n", proxy.getClass().getSimpleName(),
                    method.getName());
            //The result of method
            Object result = method.invoke(target, args);
            Parameter[] parameters = method.getParameters();
            System.out.printf("ProxyClassName:%s method:%s doing %n", proxy.getClass().getSimpleName(),
                    method.getName());
            return "InvocationHandler Result";
        };

        return (T) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
