fun main() {
    // loop 0 through 3
    for (i in 0..3) {
        println(i)
    }
    println("--------")

    // loop 0 through 10 using step size of 3
    for (i in 0..10 step 3) {
        println(i)
    }
    println("--------")

    for (i in 3 downTo 0) {
        println(i)
    }
    println("--------")

    for (i in 10 downTo 0 step 3) {
        println(i)
    }
    println("--------")

    // writing the first for loop using while
    var i: Int = 0
    while (i <= 3) {
        println(i)
        i += 1
    }
    println("--------")

    // writing the first for loop using do while
    i = 0
    do {
        println(i)
        i++
    } while (i <= 3)
    println("--------")
}