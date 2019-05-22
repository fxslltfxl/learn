package java8;

import bean.One;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        One xww = new One("xww");
        Stream<One> stream = Stream.of(xww);
        Optional<One> fxs = stream.findFirst();
        fxs.ifPresent(one -> {
            one.setName("fxs");
            System.out.println(fxs.get().getName());
            System.out.println(xww.getName());
        });
    }
}

