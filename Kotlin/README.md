---
layout: default
title: Kotlin Basics
description: This section helps you with getting started with Kotlin.
---

# [Kotlin](https://kotlinlang.org) Basics

## Contents

1. Installation

2. Kotlin Architecture

## Installation

For this tutorial, please download and install the Kotlin standalone compiler from [here](https://kotlinlang.org/docs/tutorials/command-line.html) to compile code on Command Line or you can use IDE such as IntelliJ IDEA or VS Code.

For android application development, Kotlin comes bundled with recent Android Studio versions. So, there is no need to install it separately.
If you have older Android Studio versions then upgrade it to the latest versions.

Official tutorial is available [here](https://kotlinlang.org/docs/tutorials/).

## Kotlin and its architecture

Wikipedia: Kotlin is a cross-platform, statically typed, general-purpose programming language with type inference. Kotlin is designed to interoperate fully with Java, and the JVM version of its standard library depends on the Java Class Library, but type inference allows its syntax to be more concise.

Kotlin compiler builds the byte code which can be executed by the JVM.

![kotlin_architecture](https://www.tutorialspoint.com/kotlin/images/architecture.jpg)

Image Source: Tutorialspoint.com

## Hello world

Following is an example hello world program in Kotlin.
Copy the following code and save it to a file with extension `.kt`

> The main function is the entry point to the program. Main function takes single argument called as `args` which contains the command line arguments.

Few points to note:

- Semicolons at end of statements are discourages in Kotlin.

- Single line comments are written using `//`

- Multi line comments are enclosed within `/*` and `*/`

- Indentation is not significant in Kotlin.

```kotlin
fun main(args: Array<String>) {
    println("Hello World!")
}
```

## Compiling and running Kotlin programs

You can compile the Kotlin programs form the command line using the following command:

```bash
kotlinc file_name.kt -include-runtime -d file_name.jar
```

By default, Kotlin compiles down to Java.
Run the generated `.jar` file using the following command:

```bash
java -jar file_name.jar
```

Example:

If you saved the Hello World program to a file named `hello.kt`. The compile the program using:

```bash
kotlinc hello.kt -include-runtime -d hello.jar
```

Run the generated `hello.jar` file using the following command:

```bash
java -jar hello.jar
```

Read more about compiling and running [here](https://kotlinlang.org/docs/tutorials/kotlin-for-py/compiling-and-running.html).

## Creating Variables

Following snippet gives an idea about creating variables in Kotlin.

```kotlin
// general syntax to define variables is:
// val variableName: dataType = variableValue
// var variableName: dataType = variableValue

var str: String = "Hello world"  // Declare and initialize a mutable string variable
var i: Int = 10 // Declare and initialize a mutable integer variable
val j: Int = 20 // Declare and initialize a immutable integer variable
var k: Int // Declare an uninitialized mutable integer variable
val x = 10 // Int type is inferred automatically
var y = 3.3
```

|Keyword|Function|
|-|-|
|`val`|Used to declare an immutable/read-only local variable|
|`var`|Used to declare mutable variable|

Following program gives an idea about creating different types variables in Kotlin and printing them.
You can try to play around with this code.

```kotlin
fun main() {
    var a: String = "Hello world"
    val b: Int = 1
    var c: Float = 1.1f
    var d: Double = 100.1
    var e: Short = 11
    var f: Byte = 1
    var g: Char = 'A'
    var h: Boolean = true

    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)
    println(g)
    println(h)
}
```

## Operators and keywords

Most of the operators and keywords are same as Java and Python language. You may want to read about Kotlin operators and keywords [here](https://kotlinlang.org/docs/reference/keyword-reference.html).

## Conditionals

Just like C or Java, the conditionals have the same syntax. Following is the syntax for if-else statements.

```kotlin
fun main() {
    var a: Int = 10
    var b: Int = 20
    var c: Int = 30
    var d: Int = 10

    if (a > b){
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
}
```

Instead of switch statements, there is `When` keyword. The case statements use `->` to execute case statements. `When` is used as follows:

```kotlin
fun main() {
    var a: Int = 10
    var c: Int = 33

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
```

## Loops

Loops too have similar syntax to loops in other languages. In case of Kotlin we need to use `ranges` to increment the loop index, if loop index is needed. `Ranges` are written using start integer separated by `..` form the stop integer. Ex: `0..3` will generate numbers from 0 up to 3. Optionally we can provide step size to indicate increment size.

Following program shows the syntax to use different loops and ranges.

```kotlin
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
```

## Arrays

In Kotlin we can create arrays using the `arrayOf()` library function and passing the values to it. It is also possible to specify the type of elements explicitly, but in that case it is necessary to use specialized classes such as `IntArray`, `LongArray`, `ByteArray` etc. Following snippet gives an idea of creating arrays in Kotlin:

```kotlin
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
```

## Collections

### List

A `list` is an ordered collection of items. List can be mutable (uses `MutableList`) or immutable (uses `List`).
There are many other collection types such as set and map. Read more them [here](https://play.kotlinlang.org/byExample/05_Collections/02_Set)
For our purpose, Lists are sufficient.

```kotlin
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
        i ->
        println(i)
    }

    // print size of x using size attribute
    println("Size of x: " + x.size)
}
```

## Functions

`fun` keyword is used to declare and define functions. Following is the syntax for writing and using functions.

Following is the skeleton to write a function in Kotlin.

```kotlin
fun function_name(arg1: arg1_data_type, arg2: arg2_data_type, ...): return_data_type {
 // function definition
}
```

Following is an example program.

```kotlin
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
```

## Print Nth Fibonacci number using Kotlin

This the first demo in which we will use loops and functions. Also. this demo will take user input from command line. As the heading says, we are trying to generate Fibonacci number Nth fibonacci number for some N > 0.

(This program tends to generate negative numbers for bigger values of N as Fibonacci series exhibits exponential growth. You may want to use data type which can store bigger values.)

```kotlin
fun fib(N: Int): Long {
    if (N < 0) {
        return -1 // return -1 if N is negative
    } else if (N == 0 || N == 1 || N == 2) {
        return 1
    } else {
        val result = LongArray(N) // long is used to avoid overflow for bigger N
        result[1] = 1
        result[0] = result[1] // first two Fibonacci numbers

        // generate the fibonacci sequence and store in the array
        for (i in 2..N - 1) {
            result[i] = result[i - 1] + result[i - 2]
        }

        for (res in result) {
            // simple way to traverse arrays
            print(res.toString() + "\t") // print the generated fibonacci series
        }
        return result[N - 1] // return the nth Fibonacci number
    }
}

fun main() {
    print("Enter the the value of N: ")
    val enteredVal = readLine()

    try {
        // $ is used to reference a variable in string template
        println("\nThe Fibonacci number at N=$enteredVal is " + fib(Integer.valueOf(enteredVal)))
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
```

## Classes

Just like other languages, classes consists of class name, class header and class body. Class body can contain member attributes and methods, it is also possible to have an empty class.

Following program gives an example of using classes in Kotlin.

```kotlin
// Empty class with no poperties
class empty_student_class

// primary constructor is part of the header of the class declaration
class student(val id: Int, val name: String)

// class example with secondary constructor
// there can be one or more secondary constructors
class another_student_class {

    private val id: Int
    private val name: String
    // secondary constructor
    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
    }

    constructor(id: Int) {
        this.id = id
        this.name = "Kotlin"
    }

    // member attributes
    private val uid: Int = 0
    protected val pi: Float = 3.14f
    public val e: Float = 2.718f

    // member functions
    fun printStudentDetails() {
        println("Student id: " + this.id)
        println("Student name: " + this.name)
    }

}

fun main() {
    val a = student(1, "Student")

    // use . to access the attributes of a class
    println(a.id)
    println(a.name)

    println("--------")
    val b = another_student_class(2, "Another student")
    b.printStudentDetails()

    println("--------")
    val c = another_student_class(3)
    c.printStudentDetails()
}
```

## Inheritance

In this section we will deal with inheritance and we reimplement some of the Java demo programs using Kotlin.

### Inheritance Demo 1

This demo has two classes named `Student` and `Contact`. `Student` class inherits from the `Contact` class. As a result of inheritance all the public methods and attributes of the superclass are inherited to the subclass.

```kotlin
// to be able to inherit from contact class
// open keyword is necessary
open class Contact {

    // properties of Contact class
    private val number: Int

    // constructor
    constructor(number: Int) {
        this.number = number
    }

    fun printContact() {
        println("Contact number ${this.number}")
    }
}

// use colon to inherit from a superclass
// there are other methods available to write inherited class headers
// https://kotlinlang.org/docs/reference/classes.html
class Student : Contact {

    // properties of Student class
    private val id: Int
    private val name: String

    // constructor
    // call the superclass constructor using super method and passing required arguments
    constructor(id: Int, name: String, number: Int) : super(number) {
        this.id = id
        this.name = name
    }

    // method to print student details
    fun printStudentDetails() {
        println("Student id: ${this.id}")
        println("Student name: ${this.name}")
        // printContact method is inherited, so call it using this
        this.printContact()
    }
}

fun main(args: Array<String>) {
    // instantiate a student object and print the details
    var student1 = Student(1, "John", 123456)
    println("First Student details")
    student1.printStudentDetails()

    println("--------")

    var student2 = Student(2, "Elon", 65321)
    println("Second Student details")
    student2.printStudentDetails()
}
```

### Inheritance Demo 2

In this demo the superclass is `Bicycle` and the subclass is `MountainBike`.

```kotlin
open class Bicycle {
    // the Bicycle class has three fields
    private var cadence: Int
    private var gear: Int
    private var speed: Int

    // the Bicycle class has one constructor
    constructor(startCadence: Int, startSpeed: Int, startGear: Int) {
        this.gear = startGear
        this.cadence = startCadence
        this.speed = startSpeed
    }

    // the Bicycle class has four methods
    fun setCadence(newValue: Int) {
        this.cadence = newValue
    }

    fun setGear(newValue: Int) {
        this.gear = newValue
    }

    fun applyBrake(decrement: Int) {
        this.speed -= decrement
    }

    fun speedUp(increment: Int) {
        this.speed += increment
    }

    fun printBicyleAttributes() {
        println("Cadence: " + this.cadence);
        println("Speed: " + this.speed);
        println("Gear: " + this.gear);
    }
}

class MountainBike : Bicycle {
    // the MountainBike subclass adds one field
    private var seatHeight: Int;

    // the MountainBike subclass has one constructor
    constructor(startHeight: Int,
                startCadence: Int,
                startSpeed: Int,
                startGear: Int) : super(startCadence, startSpeed, startGear) {
        this.seatHeight = startHeight;
    }

    // the MountainBike subclass adds one method
    fun setHeight(newValue: Int) {
        this.seatHeight = newValue;
    }

    // Method to print bike attributes
    fun PrintBikeAttributes() {
        println("Height: " + this.seatHeight);
        this.printBicyleAttributes()
    }
}

fun main(args: Array<String>)
{
    val mBike = MountainBike(2, 10, 2, 1);
    println("Initial bike attributes");
    mBike.PrintBikeAttributes();
    mBike.setCadence(30);
    mBike.setGear(2);
    mBike.speedUp(10);
    println("Bike attributes after gearing up");
    mBike.PrintBikeAttributes();
}
```

### Inheritance Demo 3

In this demo we use the concept of `abstract` class. If the superclass has `abstract` methods then the subclass has to implement the method or the subclass has to be declared as `abstract`. Also, the `interfaces` are being introduced in this demo.

In this example, an `ComplexCalculator` is an `interface`. The `ComplexNumberOperations` class inherits the `ComplexCalculator` `interface`, but leaves `subtract` method unimplemented. This makes `ComplexNumberOperations` as `abstract`. So complex class needs to implement the subtract method.

```kotlin
class complex : ComplexNumberOperations {

    // attributes of class complex
    private var real: Int
    private var imaginary: Int

    // constructor of the class complex
    constructor(r: Int, i: Int) {
        this.real = r
        this.imaginary = i
    }

    // getter methods
    fun get_real(): Int {
        return this.real
    }

    fun get_imaginary(): Int {
        return this.imaginary
    }

    // setter methods
    fun set_real(r: Int) {
        this.real = r
    }

    fun set_imaginary(i: Int) {
        this.imaginary = i
    }

    // methods to return complex number in form of string
    fun complex_number_string(): String {
        return "${this.real} + ${this.imaginary} i"
    }

    // implement the subtract method which was abstract in ComplexNumberOperations
    override fun subtract(a: complex, b: complex): complex {
        var c = complex(0, 0)
        c.set_real(a.get_real() - b.get_real())
        c.set_imaginary(a.get_imaginary() - b.get_imaginary())
        return c
    }
}

abstract class ComplexNumberOperations : ComplexCalculator {
    // implementing the interface ComplexCalculator
    override fun add(a: complex, b: complex): complex {
        var c = complex(0, 0)
        c.set_real(a.get_real() + b.get_real())
        c.set_imaginary(a.get_imaginary() + b.get_imaginary())
        return c
    }

    override abstract fun subtract (a: complex, b: complex) :complex
}

interface ComplexCalculator {

    // method signatures to perform operations on complex numbers
    fun add(a: complex, b: complex):complex

    fun subtract(a: complex, b: complex):complex
}

fun main(args: Array<String>) {

    // create two complex numbers
    var x = complex(1, 2)
    var y = complex(3, 4)

    // perform operations on complex numbers
    var z = complex(0, 0)
    z = z.subtract(x, y)

    println("(${x.complex_number_string()}) - (${y.complex_number_string()}) = ${z.complex_number_string()}")

    // similarly addition can be performed
}
```
