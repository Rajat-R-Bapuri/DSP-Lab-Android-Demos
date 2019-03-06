# Slider Demo

**activity_main.XML**

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
    <!-- Inserting a text viewer object -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="40dp"
        android:text="Slider Demo 1"
        android:textSize="40dp"
        />
    <SeekBar
        android:id="@+id/DemoSlider"
        android:layout_width="300dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="60dp"
        android:max="1000"
        android:progress="500"
        />
    <TextView
        android:id="@+id/number_viewer"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="60dp"
        android:text="500"
        android:textSize="30dp"/>

</LinearLayout>
```

**MainActivity.java**

```java
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SeekBar slider;
    TextView slider_value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeView();
    }

    private void initializeView(){
        slider_value = (TextView)findViewById(R.id.number_viewer);
        slider = (SeekBar) findViewById(R.id.DemoSlider);
        slider.setMax(1000);
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                String label="";
                label +=progress;
                slider_value.setText(label);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}
```
