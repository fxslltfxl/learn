package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore当前在多线程环境下被扩放使用，操作系统的信号量是个很重要的概念，
 * 在进程控制方面都有应用。Java 并发库 的Semaphore 可以很轻松完成信号量控制，
 * Semaphore可以控制某个资源可被同时访问的个数，通过 acquire() 获取一个许可，
 * 如果没有就等待，而 release() 释放一个许可。
 * 比如在Windows下可以设置共享文件的最大客户端访问个数。
 */
public class SemaphoreTest {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("Accessing: " + Thread.currentThread().getName() + Thread.currentThread().getId());
                    Thread.sleep((long) (Math.random() * 10000));
                    // 访问完后，释放
                    semaphore.release();
                    System.out.println("-----------------" + semaphore.availablePermits());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
