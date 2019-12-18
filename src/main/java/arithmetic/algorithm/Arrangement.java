package arithmetic.algorithm;

import java.util.Scanner;

/**
 * @Author fxs
 * @Description //全排列 无重复算法
 * @Date 2019/12/17
 **/
public class Arrangement {
    static int m, n;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a;
        while (in.hasNext()) {
            a = in.nextLine();
            String[] split = a.split(",");
            if (split == null || split.length != 2) {
                System.out.println("invalid");
                return;
            }

            m = Integer.parseInt(split[0]);
            n = Integer.parseInt(split[1]);

            int i = n - 5 * m;
            if (i > 0) {
                System.out.println(i);
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    if (j == m - 1) {
                        str.append("5");
                    } else {
                        str.append("5,");
                    }
                }
                System.out.println(str.toString());
            } else {
                System.out.println(0);
                method(m, n);
            }

        }
    }


    public static void method(int m, int n) {

        float a = ((float) n) / m;
        double floor = Math.floor(a);
        double ceil = Math.ceil(a);
        if (floor == ceil) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < m; j++) {
                if (j == m - 1) {
                    str.append(a);
                } else {
                    str.append(String.format("%s,", a));
                }
            }
            System.out.println(str.toString());
        }

        int floorNum = (int) (ceil * m - n);
        int ceilNum = m - floorNum;


        //TODO 动态规划 输出排列组合内容
        int[] ints = new int[floorNum + ceilNum];
        for (int i = 0; i < floorNum; i++) {
            ints[i] = (int) floor;
        }
        for (int i = floorNum; i < floorNum + ceilNum; i++) {
            ints[i] = (int) ceil;
        }
        getAllPermutation(ints, 0);
    }

    /* index用于控制如上述分析中2加上13的所有全列的 */
    public static void getAllPermutation(int[] a, int index) {
        /* 与a的元素个数相同则输出 */
        if (index == a.length - 1) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");//打印数组中所有元素
            }
            System.out.println();
            return;
        }
        //每次打印前先交换一次，如第一次是a[0]与a[0]交换，然后打印出23的组合
        //之后再交换回来，第二次先交换a[0]与a[1]，打印之后再还原数组
        for (int i = index; i < a.length; i++) {
            if (isSwap(a, index, i)) {
                swap(a, index, i);
                getAllPermutation(a, index + 1);
                swap(a, index, i);
            }

        }
    }

    static boolean isSwap(int[] str, int start, int end) {
        for (; start < end; start++) {
            if (str[start] == str[end])
                return false;
        }
        return true;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
//写字楼里写字间，写字间里程序员；  
//程序人员写程序，又拿程序换酒钱。  
//酒醒只在网上坐，酒醉还来网下眠；  
//酒醉酒醒日复日，网上网下年复年。  
//但愿老死电脑间，不愿鞠躬老板前；  
//奔驰宝马贵者趣，公交自行程序员。  
//别人笑我忒疯癫，我笑自己命太贱；  
//不见满街漂亮妹，哪个归得程序员？ 