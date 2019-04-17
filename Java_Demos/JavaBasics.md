# Java basics

## Contents

1. [Introduction](#introduction)

2. [Hello world!](#hello-world!)

3. [Print Nth Fibonacci number using Java](#print-nth-fibonacci-number-using-java)

4. [Rewriting Nth Fibonacci number program using class in Java](#rewriting-above-nth-fibonacci-number-using-class-in-java)

5. [Using constructors to create objects of a class in Java](#using-constructors-to-create-objects-of-a-class-in-java)

6. [Inheritance and interfaces in Java](#inheritance-and-interfaces-in-java)

   a. [Interfaces Demo](#interfaces-demo)

   b. [Inheritance Demo 1](#inheritance-demo-1)

   c. [Inheritance Demo 2](#inheritance-demo-2)

   d. [Inheritance Demo 3](#inheritance-demo-3)

7. [Summary of Java Tutorial](#summary-of-java-tutorial)

## Introduction

This section provides basics of Java so that you can understand how to write logic for the Android applications.

\* If you do not have Java installed on your machine you can download it from this [link](https://www.java.com/en/download/help/download_options.xml) and install.

\* To check is Java is already installed on your system, go to command terminal/command prompt in your system and type `java -version`. You must be able to see Java version. Or you can follow this [official link](https://www.java.com/en/download/installed.jsp) to verify Java online.

[Java](https://en.wikipedia.org/wiki/Java_(programming_language)) is a general-purpose computer-programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers "write once, run anywhere" (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.

Have a look at primitive data types in Java [here.](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

[Official Java tutorial by Oracle.](https://docs.oracle.com/javase/tutorial/java/index.html)

## Hello world!

```java
public class Hello // create a class called as Hello
// In Java every line of code has to be inside a class
{

    public static void main(String[] args) // entry point to program
    // just like main() in C
    {
        System.out.println("Hello world!"); // print hello world to console
    }
}
```

\* Even though the above code seems to be pretty straight forward at first look, you might want to learn meaning of each of the keywords used in the code above at this [link](https://www.learnjavaonline.org/en/Hello%2C_World%21).

To execute above code,

1. Create a java file named `Hello.java`. The class name and the file name should match. You could also download this repository and use the files provided.
2. Open terminal/command prompt and navigate to the directory which has the java program file. (You can also use any online IDEs or download one).
3. Execute `javac Hello.java` to compile the program.
4. Execute `java Hello` to run the program.

So to summarize, use `javac ClassName.java` to compile a java file, the run the program using `java ClassName`.

---

## Print Nth Fibonacci number using Java

This code demonstrates usage of loops and functions in Java.
This demo takes user input.

```java
import java.util.Scanner; // import packages

public class fib {
    // We want to generate following fibonacci series
    // 1 1 2 3 5 8 13 21 34 55 89 144 ...

    // write a method to generate the Nth Fibonacci number
    private static long nFib(int N) // note the private keyword which says
                            // only the members of the class 'fib'
                            // can access this function
    {
        if (N < 0) {
            return -1; // return -1 if N is negative
        } else if (N == 0 || N == 1 || N == 2) {
            return 1;
        } else {
            long result[] = new long[N]; // long is used to avoid overflow for bigger N
            result[0] = result[1] = 1; // first two Fibonacci numbers

            // generate the fibonacci sequence and store in the array
            for (int i = 2; i <= N - 1; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }

            for (long res : result) // simple way to traverse arrays
                System.out.print(res + "\t"); // print the generated fibonacci series

            return result[N - 1]; // return the nth Fibonacci number
        }
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in); // create a scanner object
        System.out.print("Enter the the value of N: ");
        String input = scanner.nextLine(); // input can be read and string form command line
        // reading input as string just to demonstrate conversion of string to int
        // and exception handling in Java
        // following line can be used to get int input from command line
        // int input = scanner.nextInt();
        int N = 0;
        try {
            N = Integer.valueOf(input); // type casting string to int
            System.out.printf("\nThe Fibonacci number at N=%d is %d%n", N, nFib(N));
        } catch (Exception e) { // handle the errors here
            // may be ask for user input again here
            e.printStackTrace(); // print the error that occured
        } finally { // this section is always executed whether exception occurs or not
            scanner.close();
        }

    }
}
```

The syntax of Java is similar to C or C++.

(With some changes to above Java codes, they can be used in Android!
But in case of Android App, it is not preferred to use `System.out.print` statements.
Instead we use Log to generate logs in Android App.
Log statements are used while debugging Android Applications. We will deal with Logs in android later.)

## Rewriting above Nth Fibonacci number using class in Java

This demo will help you knowing creating user defined classes in one file and use them in another file.
Informally, you have to create two separate Java files for this demo.
You can find these files in the folder [fib_in_class](https://github.com/Rajat-R-Bapuri/DSP-Lab-Android-Demos/tree/master/Java_Demos/fib_in_class). To keep the demo simple and within the scope of this tutorial, we will create both files in the same directory which avoids us from worrying about creating user defined packages, interfaces etc... If you are interested you may look into Java documentation or other websites for more complex examples.

First create a **fibClass.java** file. You may use the following code or use the files from [here](https://github.com/Rajat-R-Bapuri/DSP-Lab-Android-Demos/tree/master/Java_Demos/fib_in_class)

```java
public class fibClass {
    // We want to generate following fibonacci series
    // 1 1 2 3 5 8 13 21 34 55 89 144 ...

    // write a method to generate the Nth Fibonacci number
    static long nFib(int N) // note the private keyword which says
                            // only the members of the class 'fib'
                            // can access this function
    {
        if (N < 0) {
            return -1; // return -1 if N is negative
        } else if (N == 0 || N == 1 || N == 2) {
            return 1;
        } else {
            long result[] = new long[N]; // long is used to avoid overflow for bigger N
            result[0] = result[1] = 1; // first two Fibonacci numbers

            // generate the fibonacci sequence and store in the array
            for (int i = 2; i <= N - 1; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }

            for (long res : result) // simple way to traverse arrays
                System.out.print(res + "\t"); // print the generated fibonacci series

            return result[N - 1]; // return the nth Fibonacci number
        }
    }
}
```

Then create the **mainClass.java** file as follows in which you will try to access the `fib` method from the `fibClass`.

```java
import java.util.Scanner; // import packages

public class mainClass {
    public static void main(String args[]) {
        // fibClass fib = fibClass();
        Scanner scanner = new Scanner(System.in); // create a scanner object
        System.out.print("Enter the the value of N: ");
        String input = scanner.nextLine(); // input can be read and string form command line
        // reading input as string just to demonstrate conversion of string to int
        // and exception handling in Java
        // following line can be used to get int input from command line
        // int input = scanner.nextInt();
        int N = 0;
        try {
            N = Integer.valueOf(input); // type casting string to int
            System.out.printf("\nThe Fibonacci number at N=%d is %d%n", N, fibClass.nFib(N)); // access the method like this
            // you may try to experiment by making the nFib method private
        } catch (Exception e) { // handle the errors here
            // may be ask for user input again here
            e.printStackTrace(); // print the error that occured
        } finally { // this section is always executed whether exception occurs or not
            scanner.close();
        }
    }
}
```

## Using constructors to create objects of a class in Java

In the previous demo it was only a method in a class. This demo will help you to get to know about creating objects of a class.
Detailed information about classes and objects [here](https://docs.oracle.com/javase/tutorial/java/javaOO/index.html)

For this demo we will implement student records using classes.
Files for this demo are available [here]().
Create a file called as **Student.java**, use the following code for the class or you may try to write your own.

```java
public class Student{

    // class attributes
    // it is good practice to keep the class attributes as private
    // and use constructors, getter and setter methods to initialize and update values

    private int student_id;
    private String student_name;

    //  there can be multiple constructors in a class
    // if no constructor is written, the compiler automatically provides a no argument default constructor
    // which initializes the attributes to default values
    // but it is good practice to have your own constructor

    // constructor is called when the Student class object is created
    public Student(){
        this.student_id = 0;
        this.student_name = null;
    }

    // constructor with arguments
    public Student(int id, String name){
        this.student_id = id;
        this.student_name = name;
    }

    // constructor with single argument
    public Student(int id){
        this.student_id = id;
    }

    // setter methods
    public void set_student_id(int id){
        this.student_id = id;
    }

    public void set_student_name(String name){
        this.student_name = name;
    }

    // getter methods
    public int get_student_id(){
        return this.student_id;
    }

    public String get_student_name(){
        return this.student_name;
    }
}
```

Create a file named as mainClass.java and use the following code.
Comments have been provided in the code, which makes it self-explanatory.

```java
public class mainClass{
    public static void main(String[] args){
        Student s1 = new Student(); // use new keyword to create an object of class Student
        // using different types of construtors available in the 
        // student class to create objects
        Student s2 = new Student(10, "Some Name");
        Student s3 = new Student(11);

        // manipulate the default values using the setter methods of the class
        s1.set_student_id(12);
        s1.set_student_name("Some Name 2");

        // access the attributes using the getter methods
        System.out.println("Student 1 details --> Id: " + s1.get_student_id() + 
        "\t Name: " + s1.get_student_name());

        // play around with this code by writing more lines and adding more methods
    }
}
```

## Inheritance and interfaces in Java

This section deals with demos which show how inheritance and interfaces work in Java. These are widely used concepts while dealing with Android app development using Java.

### Interfaces Demo

This demo is to show usage of interfaces.
In the Java programming language, an interface is a reference type, similar to a class, that can contain only constants, method signatures, default methods, static methods, and nested types.
Read more [here.](https://docs.oracle.com/javase/tutorial/java/IandI/createinterface.html)

In this demo we will implement a simple complex number calculator.
Create a file called `complex_number_interface.java` and use the following code in it or write your own.

Files for this demo are available [here]().

```java
class complex implements ComplexCalculator{ // notice the use of implements keyword

    // attributes of class complex
    private int real, imaginary;

    // constructor of the class complex
    public complex(int r, int i){
        real = r;
        imaginary = i;
    }

    // implementing the interface ComplexCalculator 
    public complex add(complex a){
        complex c = new complex(0, 0);
        c.real = this.real + a.real;
        c.imaginary = this.imaginary + a.imaginary;
        return c;
    }

    public complex subtract(complex a){
        complex c = new complex(0, 0);
        c.real = this.real - a.real;
        c.imaginary = this.imaginary - a.imaginary;
        return c;
    }

    public String complex_number_string(){
        return this.real + " + " + this.imaginary + "i";
    }
}

interface ComplexCalculator{

    // method signatures to perform operations on complex numbers
    complex add(complex a);

    complex subtract(complex a);

    // interfaces can contain constants
    float pi = 3.14f;
}

public class complex_number_interface {

    public static void main(String[] args) {
        // create two complex numbers
        complex x = new complex(1, 2);
        complex y = new complex(3, 4);

        // perform operations on complex numbers
        complex z = x.add(y);

        System.out.println("Addition of "+ x.complex_number_string() + " and " + 
        y.complex_number_string() + " is " + z.complex_number_string());

        // similarly subtraction can be performed
    }
}
```

### Inheritance Demo 1

Inheritance is one of the most important mechanisms in Java just like in any other OOP language.
In this demo we will use the Student records example to demonstrate inheritance.

Use `extends` keyword in the `mainClass` to inherit all the attributes and methods from Student class. 
In short, `Sudent` class is `Superclass` and `mainClass` is the `Subclass`.

Files for this demo are available [here]().
Create a file called as **Student.java**, use the following code for the class or you may try to write your own.

```java
public class Student{

    private int student_id;
    private String student_name;

    // constructor without arguments
    public Student(){
        this.student_id = 10;
        this.student_name = "Newton";
    }

    // setter methods
    public void set_student_id(int id){
        this.student_id = id;
    }

    public void set_student_name(String name){
        this.student_name = name;
    }

    // getter methods
    public int get_student_id(){
        return this.student_id;
    }

    public String get_student_name(){
        return this.student_name;
    }

    public void printSudentDetails(){
        System.out.println("Student details --> Id: " + this.get_student_id() + 
        "\t Name: " + this.get_student_name());
    }
}
```

Create a file named as **mainClass.java** and use the following code.
Comments have been provided in the code, which makes it self-explanatory.
You need to have both these Java files in the same directory.

```java
public class mainClass extends Student{ // use extends keyword to inherit from a class
    public static void main(String[] args){

        // create a object of mainClass 
        mainClass sc = new mainClass();

        // all the methods are inherited to the subclass which can be called using the subclass object
        sc.printSudentDetails();

        // call the superclass methods using subclass object
        sc.set_student_name("Issac");

        sc.printSudentDetails();

        int id = sc.get_student_id();

        // play around with this code by writing more lines and adding more methods
    }
}
```

Detailed explanation about Inheritance is available [here.](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
Many other examples are available in the official documentation of Java as well as on other websites

### Inheritance demo 2

This demo is taken from the [official Java documentation of inheritance.](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
Here we create a single file named `MountainBike.java` to demonstrate another method to write the code.

Read more about Abstract methods and classes [here.](https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html)

Files for this demo are available [here]().

```java
public class MountainBike extends Bicycle {

    // the MountainBike subclass adds one field
    public int seatHeight;

    // the MountainBike subclass has one constructor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // the MountainBike subclass adds one method
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }

    // Method to print bike attributes
    public void PrintBikeAttributes(){
        System.out.println("Height: " + this.seatHeight);
        System.out.println("Cadence: " + this.cadence);
        System.out.println("Speed: " + this.speed);
        System.out.println("Gear: " + this.gear);
    }

    public static void main(String args[]) {
        MountainBike mBike = new MountainBike(2, 10, 2, 1);
        System.out.println("Initial bike attributes");
        mBike.PrintBikeAttributes();
        mBike.setCadence(30);
        mBike.setGear(2);
        mBike.speedUp(10);
        System.out.println("Bike attributes after gearing up");
        mBike.PrintBikeAttributes();

    }
}

class Bicycle {

    // the Bicycle class has three fields
    public int cadence;
    public int gear;
    public int speed;

    // the Bicycle class has one constructor
    public Bicycle(int startCadence, int startSpeed, int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }

    // the Bicycle class has four methods
    public void setCadence(int newValue) {
        cadence = newValue;
    }

    public void setGear(int newValue) {
        gear = newValue;
    }

    public void applyBrake(int decrement) {
        speed -= decrement;
    }

    public void speedUp(int increment) {
        speed += increment;
    }
}
```

### Inheritance Demo 3

This demo is intended to show how Abstract classes are used and these are widely used in Android app development using Java.

Abstract classes are the classes which may or may not have methods which are `abstract`.
Abstract methods are the methods which are declared but the definitions are not implemented. These methods are supposed to be implemented in the subclass which extend the superclass.
Abstract classes are declared using `abstract` keyword and subclass uses `extends` keyword to inherit from superclass.

In this demo we will reimplement the complex number calculator.

Files for this demo are available [here]().

```java
class complex extends ComplexNumberOperations{ // notice the use of implements keyword

    // attributes of class complex
    private int real, imaginary;

    // constructor of the class complex
    public complex(int r, int i){
        real = r;
        imaginary = i;
    }

    // getter methods
    public int get_real(){
        return this.real;
    }

    public int get_imaginary(){
        return this.imaginary;
    }

    // setter methods
    public void set_real(int r){
        this.real = r;
    }

    public void set_imaginary(int i){
        this.imaginary = i;
    }

    // methods to return complex number in form of string
    public String complex_number_string(){
        return this.real + " + " + this.imaginary + "i";
    }

    // implement the subtract method which was abstract in ComplexNumberOperations
    public complex subtract(complex a, complex b){
        complex c = new complex(0, 0);
        c.set_real(a.get_real() - b.get_real());
        c.set_imaginary(a.get_imaginary() - b.get_imaginary());
        return c;
    }
}

abstract class ComplexNumberOperations implements ComplexCalculator{
        // implementing the interface ComplexCalculator 
        public complex add(complex a, complex b){
            complex c = new complex(0, 0);
            c.set_real(a.get_real() + b.get_real());
            c.set_imaginary(a.get_imaginary() + b.get_imaginary());
            return c;
        }

        abstract public complex subtract(complex a, complex b);
}

interface ComplexCalculator{

    // method signatures to perform operations on complex numbers
    complex add(complex a, complex b);

    complex subtract(complex a, complex b);

    // interfaces can contain constants
    float pi = 3.14f;
}

public class complex_number_calculator {

    public static void main(String[] args) {
        // create two complex numbers
        complex x = new complex(1, 2);
        complex y = new complex(3, 4);

        // perform operations on complex numbers
        complex z = new complex(0, 0);
        z = z.subtract(x, y);

        System.out.println("Subtraction of "+ x.complex_number_string() + " and " + 
        y.complex_number_string() + " is " + z.complex_number_string());

        // similarly addition can be performed
    }
}
```

## Summary of Java Tutorial

|Keyword|Functionality|
|-------|-------------|
|`import` |To import packages|
|`abstract`|    Declare a class as abstract|
|`implements`|  Implement methods of an interface|
|`extends`|     Inherit all the members from a superclass|

Now that you know some basics of `Java`, you can continue with Android app development using `Java` from [here](../Android_Demos/README.md).