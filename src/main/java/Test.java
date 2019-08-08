import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static volatile boolean isConnect = false;

    static ExecutorService mExecutorService = Executors.newFixedThreadPool(100);


    public static void main(String[] args) {

//
//        String nf7q8Mig = "Nf7q8Mig";
//
//
//        char[] chars = new char[nf7q8Mig.length()];
//        nf7q8Mig.getChars(0,nf7q8Mig.length(),chars,0);
//
//        for (int i = 0; i < nf7q8Mig.length(); i++) {
//            System.out.println(Integer.toHexString(nf7q8Mig.codePointAt(i)));
//        }
//
//        for (int i = 0; i <5 ; i++) {
//
//        }

        try {
            throw new OutOfMemoryError("test");
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    private static void repeateTcp() {
        try {
            TimeUnit.SECONDS.sleep(5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        start();
    }

    public static void start() {
        mExecutorService.execute(() -> connect());
    }

    private static void connect() {
        if (!isConnect) {
            System.out.println("进入第一个判断条件" + Thread.currentThread().getId());
            synchronized (Test.class) {
                System.out.println("进入同步代码块" + Thread.currentThread().getId());
                if (!isConnect) {
                    System.out.println("进入第二个判断条件" + Thread.currentThread().getId() + "连接状态为" + isConnect);
                    try {
                        Thread.sleep(5000);
                        isConnect = true;
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        repeateTcp();
                    }
                    System.out.println("退出第二个判断条件" + Thread.currentThread().getId());
                }
            }
            System.out.println("退出同步代码块" + Thread.currentThread().getId());
        }
        System.out.println("退出第一个判断条件" + Thread.currentThread().getId());
    }
}
