package interview.multithreding;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {
    private static ReentrantLock lock = new ReentrantLock();



    public static void main(String[] args){



        Thread aaaa = new Thread(() -> {
            try {
                lock.lock();
                Thread.sleep(10000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println("aaaa");

        });
        aaaa.start();

        new Thread(()->{
            try {
                lock.lock();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            System.out.println("b");
        }).start();
    }
}
