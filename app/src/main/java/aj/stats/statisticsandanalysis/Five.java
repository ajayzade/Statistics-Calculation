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

public class Five extends AppCompatActivity {

    private EditText e1,e2;
    private TextView t;
    int x;
    double m,P;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        getSupportActionBar().setTitle(R.string.poisson_distribution);

        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        t = (TextView) findViewById(R.id.ans1);

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void btncl(View view) {
        e1.setText("");
        e2.setText("");
        t.setText("");
    }

    @SuppressLint("SetTextI18n")
    public void btnc(View view) {
        try {
            if (TextUtils.isEmpty(e1.getText()) || TextUtils.isEmpty(e2.getText())) {
                Toast.makeText(this, "Please fill up the boxes", Toast.LENGTH_SHORT).show();
            } else {
                x = Integer.parseInt(e1.getText().toString());
                m = Double.parseDouble(e2.getText().toString());
                P = (((Math.pow(m, x)) * Math.pow(2.71828, -m)) / fact(x));
                t.setText(t.getText() + "P(X = " + x + ") = " + P + "\n");
            }
        }catch (Exception e){
            Toast.makeText(Five.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public int fact(int n){
        int f = 1;
        for(int i = 1;i <= n;i++){
            f = f * i;
        }
        return f;
    }
}
