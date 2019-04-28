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

public class Eleven extends AppCompatActivity {

    private EditText e1,e2,e3,e4;
    private TextView t;
    double sm,pm,sd,ts;
    int n;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleven);

        getSupportActionBar().setTitle(R.string.t_score);

        e1 = (EditText) findViewById(R.id.k1);
        e2 = (EditText) findViewById(R.id.k2);
        e3 = (EditText) findViewById(R.id.k3);
        e4 = (EditText) findViewById(R.id.k4);
        t = (TextView) findViewById(R.id.k);

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @SuppressLint("SetTextI18n")
    public void cal(View view) {
        try {
            if (TextUtils.isEmpty(e1.getText()) || TextUtils.isEmpty(e2.getText()) ||
                    TextUtils.isEmpty(e3.getText()) || TextUtils.isEmpty(e4.getText())) {
                Toast.makeText(this, "Please enter the empty spaces", Toast.LENGTH_SHORT).show();
            } else {
                sm = Double.parseDouble(e1.getText().toString());
                pm = Double.parseDouble(e2.getText().toString());
                sd = Double.parseDouble(e3.getText().toString());
                n = Integer.parseInt(e4.getText().toString());
                ts = (sm - pm) / (sd / Math.sqrt(n));
                t.setText(t.getText() + "T-Score = " + ts + "\n");
            }
        }catch (Exception e){
            Toast.makeText(Eleven.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void clear(View view) {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
    }
}
