package pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ImmutablePattern {

    public static void main(String[] args) {
//        int[] ints = {-1, 0, 1, 2, -1, -4};
        int[] ints = {0, 0, 0, 0};
        System.out.println(threeSum(ints));
    }

    /**
     * 从数组中选出3个数 相加结果为某个特定数或者接近某个数
     * eg.Given array nums = [-1, 0, 1, 2, -1, -4],
     * <p>
     * A solution set is:
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     * <p>
     * <p>
     * solution：[a0,a1,a2,a3,a4,a5...an]
     * l,m,r 三个指针 m从a1到a(n-1)遍历 l从0到m，r从
     *
     * @param nums 数组
     * @return jieguo
     */
    private static List<List<Integer>> threeSumWrongAnswer(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int size = nums.length, l = 0, m;
        for (m = 1; m < size - 1; m++) {
            int r = m + 1;
            while (l < m) {
                while (r < size) {
                    if (nums[l] + nums[m] + nums[r] == 0) {
                        if (l < size - 1 && nums[l] == nums[l + 1]) {
                            l++;
                            continue;
                        }
                        if (r < size - 1 && nums[r] == nums[r + 1]) {
                            r++;
                            continue;
                        }
                        ArrayList<Integer> innerResult = new ArrayList<>();
                        innerResult.add(nums[l]);
                        innerResult.add(nums[m]);
                        innerResult.add(nums[r]);
                        result.add(innerResult);
                    }
                    r++;
                }
                r = m + 1;
                l++;
            }
            l = 0;
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();//sure no result
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int cursum = 0, sum, i, j, k;
        for (i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            j = i + 1;
            k = nums.length - 1;
            sum = -nums[i];
            while (j < k) {
                cursum = nums[j] + nums[k];
                if (cursum == sum) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    //because we have to find all the solutions, so j and k have to move on
                    while (j < k && nums[j] == nums[j - 1])
                        j++;// avoid duplication without using hashset to save more time
                    while (j < k && nums[k] == nums[k + 1]) k--;// skip it

                } else if (cursum < sum) j++;
                else k--;
            }

        }
        return res;
    }
}

