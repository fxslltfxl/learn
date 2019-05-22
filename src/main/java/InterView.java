import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InterView {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        try {
            executorService.submit(() -> {
                throw new RuntimeException("TEST");
            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
