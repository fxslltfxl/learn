package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    //region Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //endregion
    public static int[] twoSum(int[] nums, int target) {
        //prepare
        int length = nums.length;
        Integer[] copy = new Integer[length];
        for (int i = 0; i < length; i++) {
            copy[i] = nums[i];
        }
        List<Integer> list = Arrays.asList(copy);
        List<Integer> res = new ArrayList<>();
        //start
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (list.get(i) + list.get(j) == target) {
                    if (res.contains(i) || res.contains(j)) {
                        break;
                    }
                    res.add(i);
                    res.add(j);
                    break;
                }
            }
        }
        Object[] objects = res.toArray();
        int[] ints = new int[objects.length];
        //end
        for (int k = 0; k < objects.length; k++) {
            ints[k] = (int) objects[k];
        }
        return ints;
    }

//     time complexity:O(n^2) Space complexity:O(n)
}
