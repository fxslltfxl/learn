package decorator;

public class FXS implements human {
    public String aaa;

    public static void main(String[] args) {
        FXS fxs = new FXS();
        Decorator decorator = new Decorator_First(fxs);
        Decorator decorator1 = new Decorator_Second(decorator);
        decorator1.eat();
        decorator1.say();
    }

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    @Override
    public void eat() {
        System.out.println("fxs 吃 llr");
    }

    @Override
    public void say() {
        System.out.println("fxs");
    }
}
