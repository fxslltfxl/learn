package kotlinTest


fun String.notEmpty(): Boolean {
    return !this.isNullOrBlank()
}

open class Point {
    var a: String
    var b: Int

    constructor(a: String, b: Int) {
        this.a = a
        this.b = b
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (a != other.a) return false
        if (b != other.b) return false

        return true
    }

}

infix fun Point.graw(other: Point): Point {
    return Point(this.a + other.a, b + other.b)
}

operator fun Point.plus(other: Point): Point {
    return Point(a + other.a, b + other.b)
}

val point = fun String.(point: Point?) {
    println(point?.a + this)
}

fun main(args: Array<String>) {
//    val first = Point("00", 2)
//    val first1 = Point("00", 2)
//    val second = Point("11", 2)
//
//    var point = Point("1", 1)
    "qqq".point(null)
//    println(first === first1)
//    println(first == first1)
//    val total = first + second
//    println(total)

    println("".notEmpty())
    null?.notEmpty()
    "11".notEmpty()


}



