package leetcode

class JumpGame {

}

fun jump(nums: IntArray): Int {

    val n = nums.size
    if (nums == null || n == 0) {
        return 0
    }
    var start = 0
    var end = 0
    var maxCanJumpIndex = 0
    var maxIndex = 0
    var step = 0

    while (maxCanJumpIndex < n - 1) {
        for (i in start..end) {
            val coerceAtLeast = maxCanJumpIndex.coerceAtLeast(nums[i] + i)
            if (maxCanJumpIndex < coerceAtLeast) {
                maxIndex = i
                maxCanJumpIndex = coerceAtLeast
            }
        }
        start = maxIndex + 1
        end = nums[maxIndex] + maxIndex
        ++step
    }
    return step
}

fun main() {
    val a = intArrayOf(2, 3, 1, 1, 4)
    val jump = jump(a)
    println(jump)
}