package pattern.proxy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        //JDK DynamicProxy, need Implement Same interface
        ITest iTest = new Test();
        ProxyFactory<ITest> proxyFactory = new ProxyFactory<>(iTest);
        ITest proxyInstance = proxyFactory.getProxyInstance();
        String eat = proxyInstance.eat();
        System.out.println("Result In Main：" + eat);
        proxyInstance.say("hello");

        //如果目标对象没有实现接口,用Cglib代理

    }
}
