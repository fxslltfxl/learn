package actionscopefirst;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/12/5
 **/
public class Test {


    public static void main(String[] args) {

        printTree(4);
    }


    public static void printTree(int n) {
        int i = 1;
        while (i <= n) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
                System.out.print(" ");
            }
            i++;
            System.out.println(" ");
        }
    }
}