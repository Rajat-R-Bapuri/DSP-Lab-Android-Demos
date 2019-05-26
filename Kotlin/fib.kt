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

