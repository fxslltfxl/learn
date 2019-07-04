import interview.Sub;

import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;

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


        Sub sub = null;

        Optional<Sub> sub1 = Optional.ofNullable(sub);
        sub1.map(new Function<Sub, Object>() {
            @Override
            public Object apply(Sub sub) {
                return null;
            }
        });

    }
}
