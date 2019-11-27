package interview.leetcode

class MedianofTwoSortedArraysForKotlin {

    fun findMedianSortedArrays(A: IntArray, B: IntArray): Double {
        var intsA = A
        var intsB = B
        var m = intsA.size
        var n = intsB.size
        if (m > n) {
            // to ensure m<=n
            val temp = intsA
            intsA = intsB
            intsB = temp
            val tmp = m
            m = n
            n = tmp
        }
        var iMin = 0
        var iMax = m
        val halfLen = (m + n + 1) / 2
        while (iMin <= iMax) {
            val i = (iMin + iMax) / 2
            val j = halfLen - i
            if (i < iMax && intsB[j - 1] > intsA[i]) {
                iMin = i + 1 // i is too small
            } else if (i > iMin && intsA[i - 1] > intsB[j]) {
                iMax = i - 1 // i is too big
            } else {
                // i is perfect
                val maxLeft: Int = when {
                    i == 0 -> intsB[j - 1]
                    j == 0 -> intsA[i - 1]
                    else -> Math.max(intsA[i - 1], intsB[j - 1])
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft.toDouble()
                }

                val minRight: Int = when {
                    i == m -> intsB[j]
                    j == n -> intsA[i]
                    else -> Math.min(intsB[j], intsA[i])
                }
                return (maxLeft + minRight) / 2.0
            }
        }
        return 0.0
    }
}