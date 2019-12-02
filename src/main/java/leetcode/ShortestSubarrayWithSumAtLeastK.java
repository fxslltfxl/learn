package leetcode;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/11/28
 **/
public class ShortestSubarrayWithSumAtLeastK {


    public static void main(String[] args) {
        int[] ints = {1, 2};

        int i = shortestSubarray(ints, 4);
        System.out.println(i);

    }

    public static int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int length = A.length;
        if (length == 1) {
            return A[0] >= K ? A[0] : -1;
        }
        int shortest = -1;
        for (int i = 0; i < length; i++) {
            boolean isMatch = false;
            int count = 1;
            int temp = A[i];
            if (temp >= K) {
                return 1;
            }
            for (int j = i + 1; j < length; j++) {
                temp += +A[j];
                count++;
                if (temp >= K) {
                    isMatch = true;
                    break;
                }
            }
            if (isMatch) {
                if (shortest == -1) {
                    shortest = count;
                } else {
                    if (count < shortest) {
                        shortest = count;
                    }
                }
            }
        }
        return shortest;
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