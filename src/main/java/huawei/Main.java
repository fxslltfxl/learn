package huawei;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/12/12
 **/
public class Main {
    static TreeMap<Integer, Integer> hashSet = new TreeMap<>();


    public static void main(String[] args) {
        //输入
        Scanner in = new Scanner(System.in);
        int a;
        int index = 0;
        int length = 0;

        while (in.hasNextInt()) {
            a = in.nextInt();
            if (index == 0) {
                length = a;
            } else if (length == index) {
                hashSet.put(a, a);
                break;
            } else {
                hashSet.put(a, a);
            }
            index++;
        }
        for (Integer integer : hashSet.keySet()) {
            System.out.println(integer);
        }

    }
}