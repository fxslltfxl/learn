package concurrence;

import java.util.concurrent.CountDownLatch;

public class CAS {
    static volatile int count;

    static final CountDownLatch countDownLatch = new CountDownLatch(1000);

    static void addOne() {
        int newValue, oldValue;
        // 自旋
        do {
            oldValue = count;
            newValue = oldValue + 1;
        } while (oldValue != cas(oldValue, newValue));
    }

    /**
     * 模拟CPU CAS指令（CAS指令具有原子性）
     *
     * @param expect   期望值（测试值）
     * @param newValue 新值
     * @return 返回写入前的值
     */
    static synchronized int cas(int expect, int newValue) {
        //内存单元当前值
        int curValue = count;
        if (curValue == expect) {
            count = newValue;
        }
        return curValue;
    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //CAS
                addOne();
                //i++ 不是原子操作，存在'竞争条件'
//                count++;
                countDownLatch.countDown();
            }).start();
        }

        int b = 0;
        for (int i = 0; i < 1000; i++) {
            b++;
        }

        countDownLatch.await();
        System.out.println(b);
        System.out.println(count);
    }
}
