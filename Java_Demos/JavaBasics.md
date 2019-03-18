# Java basics

This section provides basics of Java so that you can understand how to write logic for the Android applications.

\* If you do not have Java installed on your machine you can download it from this [link](https://www.java.com/en/download/help/download_options.xml).

\* To check is Java is already installed on your system, go to command terminal/command prompt in your system and type `java -version`. You must be able to see Java version. Or you can follow this [official link](https://www.java.com/en/download/installed.jsp) to verify Java online.

[Java](https://en.wikipedia.org/wiki/Java_(programming_language)) is a general-purpose computer-programming language that is concurrent, class-based, object-oriented, and specifically designed to have as few implementation dependencies as possible. It is intended to let application developers "write once, run anywhere" (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.

Have a look at primitive data types in Java [here](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)

[Offcial Java tutorial by Oracle.](https://docs.oracle.com/javase/tutorial/java/index.html)

## Hello world!

```Java
public class Hello // create a class called as Hello
// in Java every line of code has to be inside a class
{

    public static void main(String[] args) // entry point to program;
    // just like main() in C
    {
        System.out.println("Hello world!"); // print hello world to console
    }
}
```

\* Learn meaning of each of the keywords used in the code above at this [link](https://www.learnjavaonline.org/en/Hello%2C_World%21).

To execute above code,

1. Create a java file named `Hello.java`. The class name and the file name should match. You could also download this repository and use the files provided.
2. Open terminal/command prompt and navigate to the directory which has the java program file. (You can also use any online IDEs or download one).
3. Execute `javac Hello.java` to compile the program.
4. Execute `java Hello` to run the program.

So to summarize, use `javac ClassName.java` to compile a java file, the run the program using `java ClassName`.

---

## Print Nth Fibonacci number

This code demonstrates usage of loops and functions.

```java
import java.util.Scanner; // import packages

public class fib {
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

## Java for Android Development

With some changes to above Java codes, they can be used in Android!
But in case of Android App, it is not preferred to use `System.out.print` statements