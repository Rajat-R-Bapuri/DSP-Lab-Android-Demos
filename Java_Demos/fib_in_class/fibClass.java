public class fibClass {
    // We want to generate following fibonacci series
    // 1 1 2 3 5 8 13 21 34 55 89 144 ...

    // write a method to generate the Nth Fibonacci number
    static long nFib(int N) // needs to be public in order to access the method from outside the class
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