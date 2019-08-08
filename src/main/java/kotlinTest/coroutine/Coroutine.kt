package kotlinTest.coroutine

import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*

val job = GlobalScope.launch {
    println("job start")
    println(SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
    delay(5000L)
    //coroutine 中直接启动协程
    launch {
        println("inner coroutine start")
        println(SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
        delay(2000)
        println("inner coroutine end")
        println(SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
    }
    // 创建一个协程作用域
    coroutineScope {
        launch {
            delay(500L)
            println("Task from nested launch")
        }

        delay(100L)
        println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
    }
    println("job done")
    println(SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
}

fun main() {
    println("main start")
    println(SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
    runBlocking {
        println("runBlocking start")
        println(SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
        job.start()
        Thread.sleep(2000)
        println("runBlocking end")
        println(SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
    }
    Thread.sleep(10000L)
    println("main done")
    println(SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Date()))
}