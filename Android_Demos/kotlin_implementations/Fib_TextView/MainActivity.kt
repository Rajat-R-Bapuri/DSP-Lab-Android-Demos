package com.example.fibonaccitextview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    // Define a TAG string which is used as TAG in log statements
    private val TAG: String = "MyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val N = 15

        // create an instance of TextView
        val fibText: TextView = findViewById(R.id.text_view)

        fibText.text = nFib(N)

    }

    private fun nFib(N: Int): String {
        if (N > 0) {
            val result = LongArray(N) // long is used to avoid overflow for bigger N
            result[1] = 1
            result[0] = result[1] // first two Fibonacci numbers

            // generate the fibonacci sequence and store in the array
            for (i in 2 until N) {
                // the for statement can also be written as
                // for (i in 2 until N)
                result[i] = result[i - 1] + result[i - 2]
            }

            for (res in result) { // simple way to traverse arrays

                // print the generated fibonacci series
                Log.d(TAG, res.toString())

            }

            // print last Fibonacci number to logcat with a message
            Log.d(TAG, "The 15th Fibonacci number is " + result[N - 1])

            return Arrays.toString(result) // convert the array to string and return it
        } else {
            return "Not a valid value of N" // return a message if N < 0
        }
    }
}
