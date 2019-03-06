import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.media.AudioTrack;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button PlayBtn;
    Button StopBtn;
    Button UpBtn;
    Button DownBtn;
    TextView FreqDisp;
    AudioTrack Track;
    int frequency = 440;
    boolean isplaying = false;
    int Fs = 44100;
    int  buffLength = AudioTrack.getMinBufferSize(Fs, AudioFormat.CHANNEL_OUT_MONO, AudioFormat.ENCODING_PCM_16BIT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FreqDisp = (TextView) findViewById(R.id.FreqDisp);

        PlayBtn = (Button) findViewById(R.id.PlayBtn);
        PlayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isplaying){
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

        UpBtn = (Button) findViewById(R.id.FreqUpBtn);
        UpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display_msg = "Frequency: ";
                frequency = frequency+10;
                display_msg = display_msg+frequency+" Hz";
                FreqDisp.setText(display_msg);
            }
        });

        DownBtn = (Button) findViewById(R.id.FreqDownBtn);
        DownBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String display_msg = "Frequency: ";
                frequency = frequency-10;
                display_msg = display_msg+frequency+" Hz";
                FreqDisp.setText(display_msg);
            }
        });
    }

    private void initTrack(){

        Track = new AudioTrack(AudioManager.MODE_NORMAL,
                Fs,
                AudioFormat.CHANNEL_OUT_MONO,
                AudioFormat.ENCODING_PCM_16BIT,
                buffLength,
                AudioTrack.MODE_STREAM);
    }

    private void startPlaying(){
        Track.play();
        isplaying=true;
    }

    private void playback(){
        short[] frame_out= new short[buffLength];
        int amplitude = (int) (32767) ;
        double twopi = 8. * Math.atan(1.);
        double phase = 0.0;
        while (isplaying){
            for (int i = 0; i < buffLength; i++) {
                frame_out[i] = (short) (amplitude * Math.sin(phase));
                phase += twopi * frequency / Fs;
                if (phase>twopi){
                    phase -= twopi;
                }
            }
            Track.write(frame_out, 0, buffLength);
        }
    }

    private void stopPlaying(){
        if (isplaying){
            isplaying=false;
            Track.stop();
            Track.release();
        }
    }
}
