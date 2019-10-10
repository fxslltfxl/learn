package concurrence;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitAndNotify {

    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        for (int i = 0; i < 10; i++) {
//            final int finalI = i;
//
//            System.out.println(i);
//
//            new Thread(() -> {
//                synchronized (lock) {
//                    System.out.println("start" + finalI);
//                    if (finalI == 0) {
//                        try {
//                            System.out.println("before lock.wait();" + finalI);
//                            lock.wait();
//                            System.out.println("after lock.wait();" + finalI);
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                    if (finalI == 8) {
//                        System.out.println("before lock.notify();" + finalI);
//                        lock.notify();
//                        System.out.println("after lock.notify();" + finalI);
//                    }
//
//                    System.out.println("end" + finalI);
//
//                }
//            }).start();
//        }
//
//        synchronized (lock) {
//            System.out.println("i'm code in main Thread");
//        }


        executorService.execute(() -> {

            synchronized (lock) {
                System.out.println("call lock first time");

                try {
                    Thread.sleep(1000);
                    lock.wait();
                    System.out.println("执行wait之后代码");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("第一个线程执行完毕");
        });

        executorService.execute(() -> {
            synchronized (lock) {
                System.out.println("call lock one time");
                lock.notifyAll();
            }


            System.out.println("第二个线程执行完毕");
        });


        Thread.sleep(5000);
        System.out.println("主线程执行完毕");
    }
}
