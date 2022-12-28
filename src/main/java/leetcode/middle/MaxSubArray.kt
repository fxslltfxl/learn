package leetcode.middle

class MaxSubArray {
    fun maxSubArray(nums: IntArray?): Int {
        if (nums == null) {
            return 0
        }
        var currentMaxNum = 0
        var maxNum = 0

        for (num in nums) {
            currentMaxNum += num
            if (currentMaxNum < 0) currentMaxNum = 0
            maxNum = currentMaxNum.coerceAtLeast(maxNum)
        }
        return maxNum
    }
}