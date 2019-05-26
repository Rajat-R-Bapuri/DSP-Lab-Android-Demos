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
// there are other methods available to write derived class headers
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