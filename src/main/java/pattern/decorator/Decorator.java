package pattern.decorator;

public abstract class Decorator implements human {

    private human human;

    //#####abatruct class constructor 的意义;


    public Decorator(human human) {
        this.human = human;
    }

    @Override
    public void eat() {
        this.human.eat();
    }

    @Override
    public void say() {
        this.human.say();
    }
}
