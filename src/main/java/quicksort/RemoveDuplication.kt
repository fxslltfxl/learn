package quicksort

import java.util.*
import kotlin.collections.ArrayList

val list: HashSet<Int> = HashSet()

fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    if (read.hasNextInt()) {
        val size = read.nextInt()
        var i = 0
        while (i < size) {
            val item = read.nextInt()
            list.add(item)
            i++
        }
    }

    val quickSortForSpace = quickSortForSpace(list.toMutableList())
    quickSortForSpace.forEach {
        println(it)
    }
}


fun quickSortForSpace(list: MutableList<Int>): List<Int> {
    if (list.size == 0) {
        return ArrayList()
    }
    val current = list[list.size / 2]

    val low = ArrayList<Int>()
    val same = ArrayList<Int>()
    val high = ArrayList<Int>()
    list.forEach {
        when {
            it < current -> {
                low.add(it)
            }
            it == current -> {
                same.add(it)
            }
            it > current -> {
                high.add(it)
            }
        }
    }

    val quickSortForSpace = quickSortForSpace(low)
    val quickSortForSpace1 = quickSortForSpace(high)
    return quickSortForSpace + same + quickSortForSpace1
}

fun quickSort(list: MutableList<Int>, low: Int, high: Int) {

}