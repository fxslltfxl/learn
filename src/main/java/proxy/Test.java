package proxy;

public class Test implements ITest {
    @Override
    public void say(String content) {
        System.out.println("say something" + content);
    }

    @Override
    public String eat() {
        System.out.println("xww eat something");
        return "xww eat shit";
    }

}
