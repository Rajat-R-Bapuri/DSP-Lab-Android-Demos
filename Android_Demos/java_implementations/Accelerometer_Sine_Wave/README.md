# Accelero-Sine Wave

This is a fun demo app, just to explore the sensors in the phone. This demo uses Accelerometer, but you can try to play around with other sensors. In this app, the frequency of the sine wave changes as x-axis accelerometer values changes.

(There are artifacts when the frequency changes with respect to changes in accelerometer values. You may want to work on this and fix the bug.)

**MainActivity.java**

```java
package com.example.accelarometeraudio;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.media.AudioTrack;
import android.media.AudioFormat;
import android.media.AudioManager;
import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Button PlayBtn;
    Button StopBtn;
    AudioTrack Track;
    boolean isplaying = false;
    int Fs = 44100;
    int buffLength = AudioTrack.getMinBufferSize(Fs, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
    private float lastX, lastY, lastZ;

    private SensorManager sensorManager;
    private Sensor accelerometer;

    private float[] gravity = new float[3];
    private float[] linear_acceleration = new float[3];

    private float frequency = 440;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            // success! we have an accelerometer

            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            // fai! we dont have an accelerometer!
        }

        PlayBtn = (Button) findViewById(R.id.PlayBtn);
        PlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isplaying) {
                    (new Thread() {
                        @Override
                        public void run() {
                            initTrack();
                            startPlaying();
                            playback();
                        }
                    }).start();
                }

            }
        });

        StopBtn = (Button) findViewById(R.id.StopBtn);
        StopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopPlaying();
            }
        });
    }

    private void initTrack() {

        Track = new AudioTrack(AudioManager.STREAM_MUSIC, Fs, AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT, buffLength, AudioTrack.MODE_STREAM);
        Track.setVolume(100);
    }

    private void startPlaying() {
        Track.play();
        isplaying = true;
    }

    private void playback() {
        short[] frame_out = new short[buffLength];
        int amplitude = (int) (32767);

        double twopi = 8. * Math.atan(1.);
        double phase = 0.0;
        while (isplaying) {
            for (int i = 0; i < buffLength; i++) {
                frame_out[i] = (short) (amplitude * Math.sin(phase));
                phase += twopi * frequency / Fs;
                if (phase > twopi) {
                    phase -= twopi;
                }
            }
            Track.write(frame_out, 0, buffLength);
        }
    }

    private void stopPlaying() {
        if (isplaying) {
            isplaying = false;
            Track.stop();
            Track.release();
        }
    }

    // Whenever there is a accelerometer sensor value change,
    // onSensorChanged is called. From this function we get the
    // accelerometer values and set it to frequency of the sine wave
    @Override
    public void onSensorChanged(SensorEvent event) {
        // alpha is calculated as t / (t + dT)
        // with t, the low-pass filter's time-constant
        // and dT, the event delivery rate

        final float alpha = 0.8f;

        gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
        gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
        gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

        linear_acceleration[0] = event.values[0] - gravity[0];
        linear_acceleration[1] = event.values[1] - gravity[1];
        linear_acceleration[2] = event.values[2] - gravity[2];

        Log.d("Accel", String.valueOf(linear_acceleration[0]) + " " + String.valueOf(linear_acceleration[1]) + " "
                + String.valueOf(linear_acceleration[2]));
        // As sensor values are small,
        // multiply sensor value of accelerometer along x axis with 100 to get bigger
        // values
        // you could try some other operations to amplify the sensor values
        frequency = abs(linear_acceleration[0] * 100);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
```

**activity_main.XML**

```xml
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
        android:layout_marginTop="20dp"
        android:text="Demo plays sine function!"
        android:textSize="30dp"
        />
    <Button
        android:id="@+id/PlayBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="30dp"
        android:text="play"
        android:textSize="20dp"/>
    <Button
        android:id="@+id/StopBtn"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Stop"
        android:textSize="20dp"/>


</LinearLayout>
```
