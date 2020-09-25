package kotlinTest

import kotlinx.coroutines.*
import kotlin.jvm.internal.Ref

class kotlinTest {

    companion object {
        val intArray = intArrayOf(2, 3, 4, 5, 6, 7)
        @JvmStatic
        fun main(args: Array<String>) {
        }

        @JvmStatic
        private fun test() {


            val intRef = Ref.IntRef()

            intRef.element = 1000

//          coroutine 
            GlobalScope.launch {

            }

            runBlocking {
                delay(2000L)
            }

            out@ for (out in 1..5) {
                for ((index, value) in intArray.withIndex()) {
                    if (out == 3) break@out
                    println("下标为：$index，值为$value")
//                    println(int * out)
                }
            }
        }
    }

    val sum = fun Int.(x: Int, y: Int): Int = this + x + y


    fun testRunblocking() = runBlocking {

    }
}

fun main() {
//    val startTime = System.currentTimeMillis()
//    val job = launch(Dispatchers.Default) {
//        var nextPrintTime = startTime
//        var i = 0
//        repeat (10) {
//            // 一个执行计算的循环，只是为了占用 CPU
//            // 每秒打印消息两次
//            val currentTimeMillis = System.currentTimeMillis()
//            println("$nextPrintTime  $currentTimeMillis")
//            if (currentTimeMillis >= nextPrintTime) {
//                println("job: I'm sleeping ${i++} ... $nextPrintTime  $currentTimeMillis")
//                nextPrintTime += 50L
//            }
//        }
//    }
//    delay(1300L) // 等待一段时间
//    println("main: I'm tired of waiting!")
//    job.cancelAndJoin() // 取消一个作业并且等待它结束
//    println("main: Now I can quit.")


    val s = "http://106.55.13.150:29080/open-platform/sso?redirect_uri=wemeet://auth/sso?sso_auth_code=61990499f20c019699154421f7d55634&corp_id=1400321069"


    java.net.URL(s)



}