package apitest;

import java.util.concurrent.*;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/12/19
 **/
public class SynchronousQueueTest {


    private static ExecutorService executor = new ThreadPoolExecutor(1, 1,
            1000, TimeUnit.SECONDS,
            new SynchronousQueue<Runnable>(),
            new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            kickOffEntry(i);

            Thread.sleep(200);
        }

        executor.shutdown();
    }

    private static void kickOffEntry(final int index) {
        executor.submit((Callable<Void>) () -> {
            System.out.println("start " + index);
            Thread.sleep(1000); // pretend to do work
            System.out.println("stop " + index);
            return null;
        });
    }

}
//写字楼里写字间，写字间里程序员；  
//程序人员写程序，又拿程序换酒钱。  
//酒醒只在网上坐，酒醉还来网下眠；  
//酒醉酒醒日复日，网上网下年复年。  
//但愿老死电脑间，不愿鞠躬老板前；  
//奔驰宝马贵者趣，公交自行程序员。  
//别人笑我忒疯癫，我笑自己命太贱；  
//不见满街漂亮妹，哪个归得程序员？ 