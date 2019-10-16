package pattern.decorator;

public class Decorator_Second extends Decorator {
    public Decorator_Second(human human) {
        super(human);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("吃尼玛");
    }

    @Override
    public void say() {
        super.say();
        System.out.println("say pattern.decorator 2");
    }
}
