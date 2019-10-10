package concurrence;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.park();
//            LockSupport.park();
            System.out.println("11111");

        });
        thread.start();

        LockSupport.unpark(thread);
    }
}
