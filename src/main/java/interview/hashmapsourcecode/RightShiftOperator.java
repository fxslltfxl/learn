package interview.hashmapsourcecode;

import java.util.Random;

public class RightShiftOperator {

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            int randomInt = new Random().nextInt(100);
            System.out.println(randomInt + ":最接近2的次幂并且比本身大的数字是：" + tableSizeFor(randomInt));

        }
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        return (n < 0) ? 1 : n + 1;
    }
}
