package com.example.slider;

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

    private void initializeView() {
        slider_value = (TextView) findViewById(R.id.number_viewer);
        slider = (SeekBar) findViewById(R.id.DemoSlider);
        // set the max value of the slider using setMax function
        slider.setMax(1000);
        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            // override the onProgressChanged method to perform operations
            // whenever the there a change in SeekBar
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                String label = "";
                label += progress;
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
