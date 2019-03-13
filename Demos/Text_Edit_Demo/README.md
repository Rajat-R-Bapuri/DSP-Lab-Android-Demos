# Simple Text Edit demo

Use the code provided in the TextEditDemo. Following snippets explain what the `java` and `XML` codes are doing.

**activity_main.XML**

Each component of the UI can be assigned attributes such as the layout_width, layout_height etc. using the `XML` code instead of using the drag and drop feature. This method provides more flexibility and control over how the components are placed in the UI as compared to the drag and drop.

```XML
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    android:gravity="center_horizontal">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:text="Enter Text and \nPress the button!"
        android:textSize="30dp" />
    <EditText
        android:id="@+id/etText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:ems="10"
        android:hint="enter text" >
    </EditText>

    <Button
        android:id="@+id/write_btn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="Print"
        />
    <TextView
        android:id="@+id/PrintText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:text="Text will appear here!"
        android:textSize="20dp"
        />
</LinearLayout>
```

**MainActivity.java**

```java
// import all necessary packages and libraries
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

  // create an object of EditText class --  object used to get the user input
  EditText TextInput;

  // create an object of TextView class -- object  used to display the output
  // text in the screen
  TextView TextOutput;

  // create an object of Button class -- object  used to define actions to take
  // place when user interacts with the button
  Button writebtn;

  // annotation which indicates that a method declaration is intended to
  // override a method declaration in a supertype
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    // this is the first function that is called when the activity is initialized.
    // Usually setContentView(int) is called here followed by other initializations.
    super.onCreate(savedInstanceState);

    // set the layout resource defining your UI
    setContentView(R.layout.activity_main);

    // Use findViewById to retrieve the widgets in that UI that you need to
    // interact with programmatically.
    // The ids are assigned in the XML code
    // IDs for components can be any names which you prefer
    // Each component needs to have unique ID
    // https://developer.android.com/guide/topics/resources/layout-resource#idvalue
    TextInput = (EditText) findViewById(R.id.etText);
    TextOutput = (TextView) findViewById(R.id.PrintText);
    writebtn = (Button) findViewById(R.id.write_btn);

    // use setOnClickListener method to listen to user interaction
    // with the button
    writebtn.setOnClickListener(this);
  }

  @Override
  public void onClick(View v){
    // TODO Auto-generated method stub

    // use setText(String) method to display text on the screen
    TextOutput.setText(TextInput.getText());
  }
}
```
