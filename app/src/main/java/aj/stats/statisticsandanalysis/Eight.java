package aj.stats.statisticsandanalysis;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Eight extends AppCompatActivity {

    private EditText e1,e2,e3;
    private TextView t;
    double zs,x,u,s;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eight);

        getSupportActionBar().setTitle(R.string.z_score_and_t_score);

        e1 = (EditText) findViewById(R.id.l1);
        e2 = (EditText) findViewById(R.id.l2);
        e3 = (EditText) findViewById(R.id.l3);
        t = (TextView) findViewById(R.id.l);

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void clear(View view) {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        t.setText("");
    }

    @SuppressLint("SetTextI18n")
    public void cal(View view) {
        try {
            if (TextUtils.isEmpty(e1.getText()) || TextUtils.isEmpty(e2.getText()) ||
                    TextUtils.isEmpty(e3.getText())) {
                Toast.makeText(this, "Please fill up the empty spaces", Toast.LENGTH_SHORT).show();
            } else {
                x = Double.parseDouble(e1.getText().toString());
                u = Double.parseDouble(e2.getText().toString());
                s = Double.parseDouble(e3.getText().toString());
                zs = (x - u) / s;
                t.setText(t.getText() + "Z-Score = " + zs + "\n");
            }
        }catch (Exception e){
            Toast.makeText(Eight.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
