package concurrence;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteReadLockTest {

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Executor executor = Executors.newFixedThreadPool(100);

    public static void main(String[] args) throws InterruptedException {

        /**
         * ReadWriteLock 可以降级的意义
         *
         * * 降级锁：持有写锁（未释放）的情况下获取读锁
         * * 必要性：
         * 1）减少线程切换，如果线程1持有写锁在未释放写锁的情况下获取读锁可以防止线程2获取写锁，阻塞线程1。
         * 2)可能存在一个事务线程不希望自己的操作被别的线程中断，而这个事务操作可能分成多部分操作更新不同的数据（或表）甚至非常耗时。
         * 如果长时间用写锁独占，显然对于某些高响应的应用是不允许的，所以在完成部分写操作后，退而使用读锁降级，来允许响应其他进程的读操作。
         * 只有当全部事务完成后才真正释放锁。
         */
        Lock readLock = readWriteLock.readLock();
        Lock writeLock = readWriteLock.writeLock();
        final int[] a = {0};
        executor.execute(() -> {
            writeLock.lock();
            try {
                a[0]++;
                readLock.lock();
                writeLock.unlock();
                System.out.println(a[0]);
                //更新缓存值
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
            System.out.println("done");
        });



        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                readLock.lock();
                System.out.println(a[0]);
                readLock.unlock();
            });
        }

    }


}
