package concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Synchronized {


    private static final Synchronized synchronizedFirst = new Synchronized();
    private static final Synchronized synchronizedOther = new Synchronized();
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);


    private static final Object lock = new Object();

    public static void main(String[] args) {
//        executorService.submit(Synchronized::staticMethod);
//        executorService.submit(Synchronized::lockSynchronizedFirst);
//        executorService.submit(Synchronized::lockSynchronizedOther);
//        executorService.submit(Synchronized::lockSynchronizedClassInstance);

        //todo synchronized reentrant test
        for (int i = 0; i <1 ; i++) {
            executorService.submit(new TestIsReentrantForSynchronized());
        }
    }

    //this way means lockSynchronized ClassInstance
    private static synchronized void staticMethod() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static synchronized method");
    }

    private static void lockSynchronizedFirst() {
        synchronized (synchronizedFirst) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lockSynchronizedFirst");
        }
    }

    private static void lockSynchronizedOther() {
        synchronized (synchronizedOther) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lockSynchronizedOther");
        }
    }

    private static void lockSynchronizedClassInstance() {
        synchronized (Synchronized.class) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("lockSynchronizedClassInstance");
        }
    }

    private void synchronizedThis() {
        synchronized (this) {
        }
    }


    private static class TestIsReentrantForSynchronized implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "TestIsReentrantForSynchronized start");
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + " into first synchronized");
                synchronized (lock) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " into second synchronized");
                }
                System.out.println(Thread.currentThread().getName() + " out second synchronized");
            }
            System.out.println(Thread.currentThread().getName() + " out first synchronized");
            System.out.println(Thread.currentThread().getName() + "TestIsReentrantForSynchronized end");

        }
    }
}
