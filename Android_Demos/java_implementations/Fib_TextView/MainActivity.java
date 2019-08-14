package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int N = 15; /* N value */

        TextView fibText = findViewById(R.id.text_view);

        /**
         * if you are compiling the application with API 25 and below
         * then you need to cast it as below
         * fib = (TextView) findViewById(R.id.text_view);
         *  */ 

        /* call the function nFib */
        String result = nFib(N);

        /* set the result string to the TextView */
        fibText.setText(result);
    }

    /* a method to generate the Nth Fibonacci number*/
    static String nFib(int N)
    {
        if (N > 0) {

            /* long is used to avoid overflow for bigger N */
            long result[] = new long[N];

            /* first two Fibonacci numbers */
            result[0] = result[1] = 1;

            /* generate the fibonacci sequence and store in the array */
            for (int i = 2; i <= N - 1; i++) {
                result[i] = result[i - 1] + result[i - 2];
            }

            for (long res : result) { /* simple way to traverse arrays */

                /* print the generated fibonacci series */
                Log.d(TAG, String.valueOf(res));

            }

            /* print last Fibonacci number to logcat with a message */
            Log.d(TAG, "The 15th Fibonacci number is " + result[N-1]);

            /* convert the array to string and return it */
            return Arrays.toString(result);
        }

        /* return a message if N < 0 */
        return "Not a valid value of N";
    }
}
