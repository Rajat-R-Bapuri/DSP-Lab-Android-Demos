package com.example.fibonacciusingedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    /* Define a TAG string which is used as TAG in log statements */
    private static final String TAG = "MyActivity";

    private EditText getN;
    private TextView fibText;

    private int N;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Get the views from the layout by using the ids defined in XML */
        fibText = findViewById(R.id.text_view);
        Button genFib = findViewById(R.id.genFib);
        getN = findViewById(R.id.getN);

        /*
         * set onClickListener to the button and write the logic for what happens when
         * the button is clicked
         */
        genFib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!getN.getText().toString().equals("")) {

                    /* There are multiple ways to convert text to integer, this is one way */
                    N = Integer.parseInt(getN.getText().toString());

                    result = nFib(N);

                    /* Log the result */
                    Log.d(TAG, result);
                } else {
                    result = "Not a valid value";
                }

                // set the result string to the TextView
                fibText.setText(result);
            }
        });
    }

    /* a method to generate the Nth Fibonacci number */
    static String nFib(int N) {
        if (N > 0) {

            /* return 1 if N is 1 */
            if (N == 1) {
                return "1";
            }

            /* perform calculations only if N > 1 */

            /* long is used to avoid overflow for bigger N */

            long[] result = new long[N];

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
            Log.d(TAG, "The " + N + " Fibonacci number is " + result[N - 1]);

            /* convert the array to string and return it */
            return Arrays.toString(result);
        }

        /* return a message if N < 0 */
        return "Not a valid value";
    }
}
