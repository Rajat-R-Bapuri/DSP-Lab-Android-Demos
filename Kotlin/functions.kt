// add function to add two numbers
fun add(a: Int, b: Int): Int {
    return a + b
}

// function with default arguments
fun another_add_fn(a: Int, b: Int = 1): Int {
    return a + b
}

// single line functions
fun mul(a: Int, b: Int) = a * b

fun main() {

    println(add(1, 2))
    println(another_add_fn(1))
    println(mul(3, 2))

    // call function by explicitly specifying argument names and values
    println(add(a=1, b=2))
    println(another_add_fn(a=1))
    println(mul(a=3, b=2))
}