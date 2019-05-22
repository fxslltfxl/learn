package thread;

import java.util.concurrent.atomic.AtomicInteger;


/*volatile是轻量级的synchronized（volatile不会引起线程上下文的切换和调度），
它在多处理器开发中保证了共享变量的“可见性”。可见性的意思是当一个线程修改一个共享变量时，
另外一个线程能读到这个修改的值。由于内存访问速度远不及CPU处理速度，
为了提高处理速度，处理器不直接和内存进行通信，而是先将系统内存的数据读到内部缓存后在进行操作，
但操作完不知道何时会写到内存。普通共享变量被修改之后，什么时候被写入主存是不确定的，当其他线程去读取时，
此时内存中可能还是原来的旧值，因此无法保证可见性。如果对声明了volatile的变量进行写操作，
JVM就会想处理器发送一条Lock前缀的指令，表示将当前处理器缓存行的数据写回到系统内存。
*/
public class SynchronizedTest {
    static AtomicInteger atomici = new AtomicInteger(0);
    //可见性
    static volatile int i;
    static volatile int j;


    public static void main(String[] args) {

        while (true) {
            i = 1;
            j = 2;
            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (SynchronizedTest.class) {
                        i = 100;
                        j = i;
                    }

                }
            }.start();

            new Thread() {
                @Override
                public void run() {
                    super.run();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (SynchronizedTest.class){
                        if (i != j) {
                            System.out.println("i的值为：" + i + "   " + "J的值为" + j);
                        }
                    }
                }
            }.start();

        }


    }
}