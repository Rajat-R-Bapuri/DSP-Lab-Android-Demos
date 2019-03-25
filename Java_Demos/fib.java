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
