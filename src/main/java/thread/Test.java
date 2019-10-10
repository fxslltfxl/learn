package thread;

public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        synchronized (new Object()){
            System.out.println("test");
        }
    }

}
