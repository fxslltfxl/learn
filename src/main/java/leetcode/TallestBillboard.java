package leetcode;

import org.jetbrains.annotations.NotNull;

public class TallestBillboard {
    /**
     * Question Description
     * <p>
     * You are installing a billboard and want it to have the largest height.  The billboard will have two steel supports, one on each side.  Each steel support must be an equal height.
     * <p>
     * You have a collection of rods which can be welded together.  For example, if you have rods of lengths 1, 2, and 3, you can weld them together to make a support of length 6.
     * <p>
     * Return the largest possible height of your billboard installation.  If you cannot support the billboard, return 0
     */

    //  not mine submission
    static int NINF = Integer.MIN_VALUE / 3;
    static Integer[][] memo;


    public static void main(String[] args) {
        int i = tallestBillboard(new int[]{1, 2,3});
        System.out.print(i);
    }


    public static int tallestBillboard(@NotNull int[] rods) {
        int N = rods.length;
        // "memo[n][x]" will be stored at memo[n][5000+x]
        // Using Integer for default `val` null
        memo = new Integer[N][10001];
        return (int) dp(rods, 0, 5000);
    }

    public static int dp(@NotNull int[] rods, int i, int s) {
        if (i == rods.length) {
            return s == 5000 ? 0 : NINF;
        } else if (memo[i][s] != null) {
            return memo[i][s];
        } else {
            int ans = dp(rods, i + 1, s);
            ans = Math.max(ans, dp(rods, i + 1, s - rods[i]));
            ans = Math.max(ans, rods[i] + dp(rods, i + 1, s + rods[i]));
            memo[i][s] = ans;
            return ans;
        }
    }
}
