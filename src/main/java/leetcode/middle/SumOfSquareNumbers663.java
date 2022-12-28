package leetcode.middle;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2021/11/18
 **/
public class SumOfSquareNumbers663 {
    public static boolean judgeSquareSum(int c) {
        double end = Math.ceil(Math.sqrt(c));
        long i = 0, j = (long) end;
        while (i <= j) {
            if (i >= 7059 || j <= 45801) {
                System.out.println("i:" + i + "j:" + j);
            }
            long res = i * i + j * j;
            if (res < c) {
                ++i;
            } else if (res > c) {
                --j;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean judgeSquareSum2(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == target) {
                return true;
            } else if (powSum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2147483600));
        System.out.println(Math.pow(2, 31) - 1);
        System.out.println(judgeSquareSum2(2147483600));

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