package decorator;

public class Decorator_First extends Decorator {

    public Decorator_First(human human) {
        super(human);
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("吃汉堡");
    }

    @Override
    public void say() {
        super.say();
        System.out.println("say decorator 1");
    }
}
