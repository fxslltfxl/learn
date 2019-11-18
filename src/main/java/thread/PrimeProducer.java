package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static concurrence.PrimeProducer.getRunnables;

public class PrimeProducer extends Thread {

    private final BlockingQueue blockingQueue;

    private volatile boolean flag = true;

    public PrimeProducer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        super.run();

        //TODO implement
        while (flag) {

        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
    }


    private List<Runnable> drainQueue() {
        return getRunnables();
    }
}
