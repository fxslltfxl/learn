package kotlinTest

class kotlinTest {

    companion object {
        val intArray = intArrayOf(2, 3, 4, 5, 6, 7)
        @JvmStatic
        fun main(args: Array<String>) {
        }

        @JvmStatic
        private fun test() {

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




}