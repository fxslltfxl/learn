package apitest

fun main() {
    hello {
        println("111")
        return@hello
    }
    println("1111")
}


inline fun hello(crossinline test:()->Unit) {
    println("111")
    return test()
}