fun main() {
// create a mutable list with integers
    val a: MutableList<Int> = mutableListOf(1, 2, 3)

// create immutable list elements using mutable list
    val b: List<Int> = a

    println("a " + a)
    println("b " + b)

// iterate through a list using for loop
    println("--------")
    for (i in a) {
        println(i)
    }

// create a list with heterogenous data types using listOf method
    println("--------")
    val x = listOf("Hello", 1, true)
    println(x)

// access elements of a list using indices
    println("--------")
    println(x[0])
    println(x[1])
    println(x[2])

// another way to iterate lists
    println("--------")
    x.forEach {
        // use variable i as temp to perform operations on it
        i ->
        println(i)
    }

// print size of x using size attribute
    println("Size of x: " + x.size)
}