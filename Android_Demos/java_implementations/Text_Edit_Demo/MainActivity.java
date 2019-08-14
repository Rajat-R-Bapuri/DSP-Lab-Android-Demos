/* change the package name to the package name of you project
* errors will be thrown if package name does not match your project name
* If you had created an empty project, the default project name will be 'My Application'
* therefore, in that case the package name would be com.example.myapplication
**/
package com.example.textedit;

/*import necessary packages */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    /**
     * create variable of class EditText, TextView and Button these variables will
     * later assigned to views in OnCreate Method
     */
    EditText TextInput;
    TextView TextOutput;
    Button writebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* assign views to the variables created previously */
        TextInput = (EditText) findViewById(R.id.etText);
        TextOutput = (TextView) findViewById(R.id.PrintText);
        writebtn = (Button) findViewById(R.id.write_btn);

        /* set OnClick listener to the button */
        writebtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        /**
         * TextInput.getText() is a function call which extracts the text from the
         * EditText View The text obtained from the EditText is set to the Text View by
         * calling
         */
        TextOutput.setText(TextInput.getText());
    }
}
