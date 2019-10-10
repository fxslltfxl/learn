package concurrence;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
        BlockingQueue<Runnable> q = new ArrayBlockingQueue<>(100);
        ArrayList<Runnable> taskList = new ArrayList<>();
        q.drainTo(taskList);
        if (!q.isEmpty()) {
            for (Runnable r : q.toArray(new Runnable[0])) {
                if (q.remove(r))
                    taskList.add(r);
            }
        }
        return taskList;
    }
}
