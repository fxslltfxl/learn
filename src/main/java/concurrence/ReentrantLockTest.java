package concurrence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {

        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            reentrantLock.lock();
            System.out.println("call lock first time");

            try {
                Thread.sleep(1000);
                condition.await();
                System.out.println("执行await之后代码");
                reentrantLock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            System.out.println("call lock single time");
            condition.signalAll();
            reentrantLock.unlock();
        }).start();
    }
}
