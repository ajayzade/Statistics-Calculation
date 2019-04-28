package aj.stats.statisticsandanalysis;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.w3c.dom.Text;

public class Four extends AppCompatActivity {

    private EditText e1,e2,e3,e4;
    int n,x;
    double p,q,P;
    private TextView t;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        getSupportActionBar().setTitle(R.string.binomial_distribution);

        e1 = (EditText) findViewById(R.id.edit4);
        e2 = (EditText) findViewById(R.id.edit5);
        e3 = (EditText) findViewById(R.id.edit6);
        e4 = (EditText) findViewById(R.id.edit7);
        t = (TextView) findViewById(R.id.tv6);

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public int fact(int n){
        int f = 1;
        for(int i = 1;i <= n;i++){
            f = f * i;
        }
        return f;
    }

    public void btn(View view) {
        e1.setText("");
        e2.setText("");
        e3.setText("");
        e4.setText("");
        t.setText("");
    }

    @SuppressLint("SetTextI18n")
    public void cal(View view) {
        try {
            if (TextUtils.isEmpty(e1.getText()) || TextUtils.isEmpty(e2.getText()) ||
                    TextUtils.isEmpty(e3.getText()) || TextUtils.isEmpty(e4.getText())) {
                Toast.makeText(Four.this, "Please fill up the empty space first", Toast.LENGTH_SHORT).show();
            } else {
                n = Integer.parseInt(e1.getText().toString());
                x = Integer.parseInt(e4.getText().toString());
                p = Double.parseDouble(e2.getText().toString());
                q = Double.parseDouble(e3.getText().toString());
                P = ((fact(n)) / ((fact(n - x)) * fact(x))) * (Math.pow(p, x) * Math.pow(q, n - x));
                t.setText(t.getText() + "P(X = " + x + ") = " + P);
            }
        }catch (Exception e){
            Toast.makeText(Four.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
