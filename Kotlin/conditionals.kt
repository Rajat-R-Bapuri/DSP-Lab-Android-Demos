fun main() {
    var a: Int = 10
    var b: Int = 20
    var c: Int = 33
    var d: Int = 10

    if (a > b) {
        println("a > b")
    } else {
        println("a < b")
    }

    if (a == c) {
        println("a = c")
    } else if (a == d) {
        println("a == d")
    } else {
        println("Kotlin")
    }

    when (a % 2) {
        0 -> println("a is even") // case 1
        1 -> println("a is odd") // case 2
        else -> println("default statement") // default statement
    }

    when (c % 2) {
        0 -> println("c is even") // case 1
        1 -> println("c is odd") // case 2
        // default statement can be omitted
    }
}