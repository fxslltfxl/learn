package bean;

public class Son extends Father {

    protected void eat() {
    }

    protected void test() {
        System.out.println("i' m son");
    }

    public static void main(String[] args) {

        new Son().eat();
    }
}
