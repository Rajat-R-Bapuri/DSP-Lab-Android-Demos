package com.example.textedit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create variables of the view elements from the layout
        val TextInput: EditText = findViewById(R.id.etText)
        val TextOutput: TextView = findViewById(R.id.PrintText)
        val writebtn: Button = findViewById(R.id.write_btn)

        // set on click listener to the button
        writebtn.setOnClickListener {
            // obtain the text from the edit text and set it to the text view

            // following syntax os called property access syntax
            TextOutput.text = TextInput.text
        }
    }
}
