import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    EditText TextInput;
    TextView TextOutput;
    Button writebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextInput = (EditText) findViewById(R.id.etText);
        TextOutput = (TextView) findViewById(R.id.PrintText);
        writebtn = (Button) findViewById(R.id.write_btn);
        writebtn.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        // TODO Auto-generated method stub
        TextOutput.setText(TextInput.getText());
    }
}
