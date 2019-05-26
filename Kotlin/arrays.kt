fun main() {

    // create an array of integer elements
    val a: IntArray = intArrayOf(0, 1, 2, -3)
    println("Array of integers")
    a.forEach {
        i ->
        println(i) // this is usage of lambda expression
        // use this link to read more about lambda functions in kotlin:
        // https://kotlinlang.org/docs/reference/lambdas.html
    }
    println("--------")

    /************************************************************/

    // instead of using lambda functions to traverse the arrays
    // we can user for loop as follows
    println("Array of integers")
    for (element in a) {
        println(element)
    }
    println("--------")

    /************************************************************/

    // create an array of long integers
    val b: LongArray = longArrayOf(10000000, 40000000, -5000000)
    println("Array of long ints")
    b.forEach {
        i->
        println(i)
    }
    println("--------")

    /************************************************************/

    // creating a array of boolean values
    val c: BooleanArray = booleanArrayOf(true, false, true, true)
    println("Array of booleans")
    c.forEach {
        i ->
        println(i)
    }
    println("--------")

    /************************************************************/

    // create an array of 5 zeros which can be populated later
    var d: IntArray = IntArray(5) {i -> i*0}
    // or var d: IntArray = IntArray(5) {0}
    // or var d: IntArray = IntArray(5, {i -> i*0})
    println("Array of zeros")
    d.forEach {
        i ->
        println(i)
    }

    // now assign values to array using loop or manually assign values at specific indices as per the need
    for (i in 0..d.size-1) {
        d[i] = i * i
    }
    // print the array after populating
    println("After populating")
    d.forEach {
        i ->
        println(i)
    }
    println("--------")

    /************************************************************/

    // create an array of heterogenous elements
    // this can also be achieved using Lists
    val x = arrayOf(1, 2, 3, "abcd", true)
    println("Array of heterogenous elements")
    x.forEach {
        i ->
        println(i)
    }
    println("--------")
}