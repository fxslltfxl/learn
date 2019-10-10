package concurrence;

public class ThreadPoolExecutorInsight {
    public static void main(String[] args) {
        int i = -1 << 29;
        int a=0;
        String string = Integer.toBinaryString(i);

        System.out.println(string);

        retry:
        for (;;){
            System.out.println("out loop execute");
            for (;;){
                a++;
                if (a==5){
                    continue retry;
                }
                if (a==8){
                    break retry;
                }
                System.out.println(a);
            }
        }

    }
}
