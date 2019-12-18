package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/11/30
 **/
public class Solution {


    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        //输入
        Scanner in = new Scanner(System.in);
        int a = 0;
        while (in.hasNextInt()) {
            a = in.nextInt();
            if (a == 0) break;
            list.add(a);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(maxMun(list.get(i)));
        }
    }


    public static int maxMun(int source) {
        int current, res = 0, remain = 0;

        current = source / 3;
        while (current != 0) {
            res += current;
            remain = source % 3;
            source = current + remain;
            current = source / 3;
        }
        if (source == 2) {
            res++;
        }
        return res;
    }

}
