package apitest

fun main() {
    hello {
        println("111")
        return@hello
    }
    println("1111")
}

object TTTT {
    val test:String = ""
}

inline fun hello(crossinline test:()->Unit) {
    println("111")
    return test()
}