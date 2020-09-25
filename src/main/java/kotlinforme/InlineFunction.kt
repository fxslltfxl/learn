package kotlinforme

fun sum(a: Int, b: Int, lambda: (result: Int) -> Unit): Int {
    val r = a + b
    lambda.invoke(r)
    return r
}

val obj = Object()

fun main(args: Array<String>) {

    Thread {
        synchronized(obj) {
            Thread.sleep(2000)
            obj.notifyAll()
        }
    }.run()


    Thread {
        synchronized(obj) {
            obj.wait()
            print("111")
        }
    }.run()
}

class Demo(private val title: String) {

    // 编译错误: Public-Api inline function cannot access non-Public-Api
    // prive final val title
//    inline fun test(l: () -> Unit) {
//        println("Title: $title") // 编译错误: Public-Api inline function cannot access non-Public-Api prive final val title
//    }

    // 私有的没问题
    private inline fun test(l: () -> Unit) {
        println("Title: $title")
    }
}
