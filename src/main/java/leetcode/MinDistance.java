package leetcode;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2019/11/21
 **/
public class MinDistance {


    public static void main(String[] args) {

        int i = minDistance("horse", "ros");
        System.out.println(i);
    }


    /**
     * Runtime: 7 ms
     * Memory Usage: 35.9 MB.
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1, String word2) {
        boolean isNull1 = word1 == null || "".equals(word1);
        boolean isNull2 = word2 == null || "".equals(word2);
        if (isNull1 && isNull2) {
            return 0;
        }
        assert word1 != null;
        assert word2 != null;
        int size2 = word2.length();
        int size1 = word1.length();
        if (isNull2) return size1;
        if (isNull1) return size2;
        //1.定义二维数组含义
        //3.寻找f(n)与f(n-1) f(n-2)的关系
        //2. 初始值
        int[][] dp = new int[size1 + 1][size2 + 1];
        for (int i = 1; i <= size1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int i = 1; i <= size2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = Math.min(dp[i - 1][j], dp[i][j - 1]);

                    dp[i][j] = Math.min(min, dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[size1][size2];
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