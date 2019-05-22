package interview.multithreding;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MonitorLock implements Runnable {


    private static final Object obj = new Object();

    private static int sup = 1;
    private static volatile int sup1 = 1;


    @Override
    public void run() {

        //region 拥有一个对象的monitor的三种方法
        //1.执行该对象的同步方法；
        //2.执行该对象的同步代码块；
        //3.执行对象对应类的static synchronized 方法
        //endregion
        synchronized (obj) {
            //调用时 出错 这个synchronized 块中只获得了obj的monitor对象
            //notify();
            try {
                obj.wait();
                System.out.println("wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static synchronized void print(Object o) {
        try {
            Thread.sleep(5000);
            System.out.println("static synchronized");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        //region 直接用于方法： 实际获取的是Thread1类的monitor。更进一步，如果修饰的是static方法，则锁定该类所有实例。
        new Thread(() -> print("1")).start();
        // print 方法执行完成后 才执行
        new Thread(() -> {
            synchronized (MonitorLock.class) {
                System.out.println("MonitorLock.class");
            }
        }).start();
        //endregion


        new Thread(new MonitorLock()).start();
        new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("notify");
                obj.notify();
            }
        }).start();


        catchExceptionInThread();

    }

    private static void catchExceptionInThread() {
        try {
            new Thread(() -> {
                try {
                    throw new Exception("exception");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void callable() {

//        var executorService = Executors.newFixedThreadPool(3);
//        Future<Object> submit = executorService.submit(() -> null);
//        //non—block
//        var done = submit.isDone();
//        try {
//            //block
//            var a = submit.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

    }
}
