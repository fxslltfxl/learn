package interview.multithreding;

public class Java2KotlinTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadGroup("test"), ()-> System.out.println("run test"),"test-test1");


    }


}
