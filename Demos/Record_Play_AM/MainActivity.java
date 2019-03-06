import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaRecorder;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.Manifest;

public class MainActivity extends AppCompatActivity {

    Button StartBtn;
    Button StopBtn;
    private final int fs = 16000;
    int track_and_rec = 0;
    int Gain=5;
    private int B_Length;
    private AudioRecord record;
    private AudioTrack track;
    private AudioManager manager;
    boolean isRecording=false;
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    // Requesting permission to RECORD_AUDIO
    private boolean permissionToRecordAccepted = false;
    private String [] permissions = {Manifest.permission.RECORD_AUDIO};
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_RECORD_AUDIO_PERMISSION:
                permissionToRecordAccepted  = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                break;
        }
        if (!permissionToRecordAccepted ) finish();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartBtn = (Button) findViewById(R.id.StartBtn);
        StartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!isRecording && track_and_rec == 0) {
                    (new Thread() {
                        @Override
                        public void run() {
                            initRecordAndTrack();
                            startRecordAndPlay();
                            playback();
                        }
                    }).start();
                }
            }
        });

        StopBtn = (Button) findViewById(R.id.StopBtn);
        StopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRecording ) {
                    stopRecordAndPlay();
                }

            }

        });

        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION);
    }


    private void initRecordAndTrack() {
        if (track_and_rec==0){
            int min = AudioRecord.getMinBufferSize(fs, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
            record = new AudioRecord(MediaRecorder.AudioSource.MIC, fs, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT,
                    min);
            int mJ = AudioTrack.getMinBufferSize(fs, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);
            track = new AudioTrack(AudioManager.MODE_NORMAL, fs, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT, mJ,
                    AudioTrack.MODE_STREAM);
            track_and_rec=1;
            B_Length = Math.max(min,mJ);
        }
    }

    private void startRecordAndPlay() {
        record.startRecording();
        track.play();
        isRecording = true;
    }

    private void stopRecordAndPlay() {

        if (track_and_rec==1) {
            isRecording = false;
            track_and_rec=0;
            record.stop();
            track.stop();
            record.release();
            track.release();

        }
    }

    private void playback(){

        setVolumeControlStream(AudioManager.MODE_NORMAL);
        manager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
        manager.setSpeakerphoneOn(false);

        short[] frame = new short[B_Length];
        float[] data = new float[B_Length];
        int num ;

        int frequency = 1000;
        double twopi = 8. * Math.atan(1.);
        double phase = 0.0;

        manager.setMode(AudioManager.MODE_NORMAL);

        short[] frame_out= new short[B_Length];


        while (isRecording) {
            num = record.read(frame, 0, B_Length);
            for (int i = 0; i < B_Length; i++) {
                data[i] = frame[i];
            }

            //Do your signal processing on data[i]

            for (int i = 0; i < B_Length; i++) {
                frame_out[i] = (short) (data[i]*Gain*Math.sin(phase));
                phase += twopi * frequency / fs;
                if (phase>twopi){
                    phase -= twopi;
                }
            }
            track.write(frame_out, 0, num);
        }
    }
}
