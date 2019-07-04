package interview;

public class Cycles {
    public static void main(String[] args) {
        int i = 10;
        do {
            i--;
        } while (i >= 5);
        {
            System.out.println(i);
        }
    }
}
