package concurrence;

public class Test {

    static class Thread1 extends Thread {
        @Override
        public synchronized void run() {
            super.run();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }

    static class Thread2 extends Thread {
        @Override
        public synchronized void run() {
            super.run();
            System.out.println("222" + Thread.currentThread().getName());

        }
    }

    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
}
