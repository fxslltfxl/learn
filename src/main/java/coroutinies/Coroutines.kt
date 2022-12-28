package coroutinies

import kotlinx.coroutines.*
import okhttp3.internal.wait
import java.util.ArrayDeque


fun main(): Unit = runBlocking {

//    GlobalScope.async(Dispatchers.Unconfined) {
//        delay(5_000)
//        println("Coroutine is done1")
//        println("I'm working in thread ${Thread.currentThread().name}")
//    }.await()
//    println("Coroutine is done")
//    delay(6_000)
//    println("I'm working in thread ${Thread.currentThread().name}")


    val arrayDeque = ArrayDeque<Int>()

    for (i in 0..16) {
        arrayDeque.addFirst(i)
    }
    arrayDeque.poll()
}