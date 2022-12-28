package leetcode.middle;

/**
 * @Author fxs
 * @Description //TODO
 * @Date 2021/12/2
 **/
public class LongestCommonSubsequence1143 {
    /**
     * worry answer
     * @param text1
     * @param text2
     * @return
     */
//    public int longestCommonSubsequence(String text1, String text2) {
//        int res = 0;
//        if (text1.isEmpty() || text2.isEmpty()) {
//            return 0;
//        }
//        for (int i = 0; i < text1.length(); i++) {
//            int j = i, k = 0;
//            int now_j = j;
//            while (j < text1.length() && k < text2.length()) {
//                if (text1.charAt(j) == text2.charAt(k)) {
//                    j++;
//                    res = Math.max(res, j - now_j);
//                } else {
//                    now_j = j;
//                }
//                k++;
//            }
//        }
//        return res;
//    }


    // dp

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        int [][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 1; i <= len1; i++)
        {
            for(int j = 1; j <= len2; j++)
            {
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[len1][len2];
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