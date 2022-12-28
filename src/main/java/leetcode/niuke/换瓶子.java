package leetcode.niuke;

import java.util.Scanner;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2021/12/13
 **/
public class 换瓶子 {

    public static int bottle(int n) {
        if (n < 2) {
            return 0;
        }
        int consult;
        int remainder;
        int res = 0;
        while (n >= 2) {
            consult = n / 3;
            remainder = n % 3;
            n = consult + remainder;
            res += consult;
            if (n == 2) {
                res++;
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            if (i <= 0) break;
            System.out.println(bottle(i));
        }
    }
}

