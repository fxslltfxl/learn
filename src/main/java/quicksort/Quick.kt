package quicksort

import java.util.*

fun sort(list: MutableList<Int>) {

    if (list.size > 0) {
        val small: MutableList<Int> = ArrayList()
        val same: MutableList<Int> = ArrayList()
        val larger: MutableList<Int> = ArrayList()
        val i = list[list.size / 2]
        list.forEach {
            when {
                it < i -> small.add(it)
                it > i -> larger.add(it)
                else -> same.add(it)
            }
        }
        sort(small)
        sort(larger)
        list.clear()
        list.addAll(small)
        list.addAll(same)
        list.addAll(larger)
    }
}

fun main(args: Array<String>) {
//    val list = ArrayList<Int>()
//    for (i:Int in 1..1000){
//        for (j:Int in 1..1000)
//            list.add(Random().nextInt(1000000))
//    }
//    sort(list)
//
//    list.forEach {
//        println(it)
//    }
    getDate()

}

fun getDate(){
    Thread.sleep(1000*60*60*24)
    println(Date().toString())
}