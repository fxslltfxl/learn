package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Synchronized {


    private static final Synchronized synchronizedFirst = new Synchronized();
    private static final Synchronized synchronizedOther = new Synchronized();
    private static ExecutorService executorService = Executors.newFixedThreadPool(20);

    public static void main(String[] args) {
        executorService.submit(Synchronized::staticMethod);
        executorService.submit(Synchronized::lockSynchronizedFirst);
        executorService.submit(Synchronized::lockSynchronizedOther);
        executorService.submit(Synchronized::lockSynchronizedClassInstance);
    }

    //this way means lockSynchronizedClassInstance
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
}
