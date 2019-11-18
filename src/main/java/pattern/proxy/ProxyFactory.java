package pattern.proxy;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.net.Socket;

public class ProxyFactory<T> {


    private T target;

    ProxyFactory(T target) {
        this.target = target;
    }

    T getProxyInstance() throws IOException {

        Socket socket = new Socket("",1099);

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
