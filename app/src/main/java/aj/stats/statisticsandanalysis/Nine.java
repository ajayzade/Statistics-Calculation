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

public class Nine extends AppCompatActivity {

    private EditText e1,e2;
    private TextView t;
    double c,p;
    int n,r;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);

        getSupportActionBar().setTitle(R.string.permutation_and_combination);

        e1 = (EditText) findViewById(R.id.el1);
        e2 = (EditText) findViewById(R.id.el2);
        t = (TextView) findViewById(R.id.ttv);

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

    @SuppressLint("SetTextI18n")
    public void btn(View view) {
        e1.setText("");
        e2.setText("");
        t.setText("");
    }

    @SuppressLint("SetTextI18n")
    public void cal(View view) {
        try{
            if (TextUtils.isEmpty(e1.getText()) || TextUtils.isEmpty(e2.getText())){
                Toast.makeText(this, "Please fill up the boxes", Toast.LENGTH_SHORT).show();
            }else {
                n = Integer.parseInt(e1.getText().toString());
                r = Integer.parseInt(e2.getText().toString());
                c = fact(n) / (fact(r) * fact(n - r));
                p = fact(n) / fact(n - r);
                t.setText(t.getText()
                        + "Permutation :\n" + "\t\tP(" + n + "," + r + ") = " + p + "\n");
                t.setText(t.getText() +
                        "Combination : \n\t\t" + "C(" + n + "," + r + ") = " + c + "\n");
            }
        }catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
