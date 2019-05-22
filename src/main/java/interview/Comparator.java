package interview;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

public class Comparator {
    static class B {
        int i;

        public B(int i) {
            this.i = i;
        }
    }

    static class A extends B {
        int ii;

        public A(int i, int ii) {
            super(i);
            this.ii = ii;
        }


    }

    public static void main(String[] args) {
        List<A> integers = new ArrayList<>();
        integers.add(new A(4, 4));
        integers.add(new A(1, 1));
        integers.add(new A(2, 2));
        integers.add(new A(6, 6));
        integers.add(new A(3, 3));


        A max = max(integers, java.util.Comparator.comparingInt(o -> o.i));

        System.out.println(max);

    }

    public static <T> T max(List<T> ts, java.util.Comparator<? super T> c) {
        checkNotNull(ts);
        if (ts.size() == 1) {
            return ts.get(0);
        } else {
            ts.sort(c);
            return ts.get(ts.size() - 1);
        }
    }


    public static <T> T findOneByOrder(List<T> ts, int position, java.util.Comparator<? super T> c) {
        checkNotNull(ts);
        checkNotNull(c);
        int size = ts.size();
        if (size == 1) {
            return ts.get(0);
        } else {
            if (position >= size) {
                position = size - 1;
            } else if (position < 0) {
                position = 0;
            }
            ts.sort(c);
            return ts.get(position);
        }
    }
}
