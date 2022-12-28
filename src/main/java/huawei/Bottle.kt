package huawei

import java.util.*

var list: MutableList<Int> = ArrayList()
var list1: MutableList<Int> = ArrayList()

class Bottle

fun main(args: Array<String>) {
    val read = Scanner(System.`in`)
    while (read.hasNextInt()) {
        val a = read.nextInt()
        if (a == 0) break
        list.add(a)
    }
    list.forEachIndexed { _, item ->
        println(sum(item))
    }
    list + list1
}

fun sum(bottle: Int): Int {
    var result = 0

    var totalRemain = bottle
    var newEmptyBottle = totalRemain / 3
    while (newEmptyBottle != 0) {
        result += newEmptyBottle
        totalRemain = newEmptyBottle + totalRemain % 3
        newEmptyBottle = totalRemain / 3
    }

    if (totalRemain == 2) {
        result++
    }
    return result
}