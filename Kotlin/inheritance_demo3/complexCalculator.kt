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