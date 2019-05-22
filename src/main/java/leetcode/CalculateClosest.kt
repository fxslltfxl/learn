package leetcode

import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.util.*

data class TwoSumClosestResult(var start: Int, var end: Int, var result: Int)

@Suppress("UNUSED")
data class ThreeSumClosestResult(var start: Int, var mid: Int, var end: Int, var result: Int)

@Suppress("UNUSED")
data class CalculateOnWeightChangeResult(var cellNo: String, var number: Int)

private fun twoSumClosest(num: Array<Int>, target: Int): TwoSumClosestResult? {
    num.sort()
    if (num.size < 3) return null
    if (target <= 0) throw RuntimeException("target must greater then zero")
    var startIndex = 0
    var endIndex = num.size - 1
    var (start, end, result) = TwoSumClosestResult(1, num.size - 1, num[startIndex] + num[endIndex])
    while (start < end) {
        val sum = num[start] + num[end]
        val i = start
        val j = end
        if (sum < target) start++ else end--

        if (abs(sum - target) < abs(result - target)) {
            startIndex = i//记录最小索引
            endIndex = j

            result = sum//记录最小值
        }
    }
    return TwoSumClosestResult(startIndex, endIndex, result)
}

@Suppress("UNUSED")
private fun threeSumClosest(num: Array<Int>, target: Int): Int {
    var result = num[0] + num[1] + num[num.size - 1]
    num.sort()
    for (i in 0 until num.size - 2) {
        var start = i + 1
        var end = num.size - 1
        while (start < end) {
            val sum = num[i] + num[start] + num[end]
            if (sum > target) {
                end--
            } else {
                start++
            }
            if (Math.abs(sum - target) < Math.abs(result - target)) {
                result = sum
            }
        }
    }
    return result
}

fun main(args: Array<String>) {
    val array = Array(size = 20) {
        val nextInt = Random().nextInt(50)
        nextInt
    }
    array.sort()
    array.forEachIndexed { index, i ->
        println("$index:$i")
    }
    println(twoSumClosest(array, 10))
}