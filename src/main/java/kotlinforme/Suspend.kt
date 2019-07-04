package kotlinforme

import io.netty.util.concurrent.Promise
import kotlinx.coroutines.*

class Suspend {
    suspend fun suspendTest(x: Any) {
        withContext(Dispatchers.IO) {

        }
    }
    companion object {
        @JvmStatic
        fun fuck(){

        }
    }
}

fun main(args: Array<String>) {
    val deferred = (1..1_000).map {
        GlobalScope.async {
            delay(1000)
            it
        }
    }

    runBlocking {
        val sumBy = deferred.sumBy {
            println(it.await())
            it.await()
        }
        println(sumBy)
    }
}

fun workload(n: Int): Promise<Int>? {
    return null
}
