package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Modifier;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class GsonFactory {


    public static Gson getInstance() {
        return Holder.gson;
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1);
        blockingQueue.add("1");
        while (true) {
            String msg = blockingQueue.take();
            System.out.println(msg);
        }
    }

    private static class Holder {

        private static final Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setVersion(4.5)
                .excludeFieldsWithModifiers(Modifier.FINAL)
                .create();
    }
}
