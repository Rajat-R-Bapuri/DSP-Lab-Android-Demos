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