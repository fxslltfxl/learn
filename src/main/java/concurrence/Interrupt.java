package concurrence;

/**
 * 线程中断测试
 */
public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();

        worker.start();

        Thread.sleep(5000);
        System.out.println("interrupt");
        worker.interrupt();
        System.out.println("main thread done");
    }


    static class Worker extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (i < 50) {
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
                i++;
                System.out.println("this thread name is" + Thread.currentThread().getName() + "the value of i is" + i);
                try {
                    /*
                      Causes the currently executing thread to sleep (temporarily cease
                      execution) for the specified number of milliseconds, subject to
                      the precision and accuracy of system timers and schedulers. The thread
                      does not lose ownership of any monitors.

                      @param  millis
                     *         the length of time to sleep in milliseconds
                     *
                     * @throws  IllegalArgumentException
                     *          if the value of {@code millis} is negative
                     *
                     * @throws  InterruptedException（TODO 看这  抛出异常会重置中断状态）
                     *          if any thread has interrupted the current thread. The
                     *          <i>interrupted status</i> of the current thread is
                     *          cleared when this exception is thrown.
                     */
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("catch a InterruptedException from method of sleep");
//                    if any thread has interrupted the current thread. The interrupted status of the current thread
//                    is cleared when this exception is thrown.
                    e.printStackTrace();
                }
            }
        }
    }

}
