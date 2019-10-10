package thread

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock


private val lock = ReentrantLock()

val newCondition:Condition = lock.newCondition()


fun main() {


    Thread {
        try {
            lock.lock()
            newCondition.await()
            println("执行GlobalScope.launch newCondition.await() ")
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            lock.unlock()
        }
    }.start()

    Thread.sleep(1000)
    lock.lock()
    newCondition.signal()
    lock.unlock()
    println("newCondition.signal()执行")

}

class LockAndRes {
    fun test()  {
        synchronized(this){

        }
    }
}