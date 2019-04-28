package aj.stats.statisticsandanalysis;

import android.annotation.SuppressLint;
import android.support.v7.app.AlertDialog;
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

import java.util.ArrayList;

public class Twelve extends AppCompatActivity {

    private TextView t1,t2;
    private ArrayList<Double> arrayList;
    double exp,sum;
    int count = 0;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_twelve);

        getSupportActionBar().setTitle(R.string.chi_square_test);

        arrayList = new ArrayList<>();

        t1 = (TextView) findViewById(R.id.v1);
        t2 = (TextView) findViewById(R.id.v2);

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void btn1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Twelve.this);
        @SuppressLint("InflateParams") View v = getLayoutInflater().inflate(R.layout.new_input,null);
        final EditText e = (EditText) v.findViewById(R.id.edit);
        Button b1 = (Button) v.findViewById(R.id.enter);
        Button b2 = (Button) v.findViewById(R.id.cancel);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(e.getText())){
                    Toast.makeText(Twelve.this, "Please fill up the empty space", Toast.LENGTH_SHORT).show();
                }else{
                    arrayList.add(Double.parseDouble(e.getText().toString()));
                    t1.setText(t1.getText() + e.getText().toString() + ",");
                    count++;
                }
                e.setText("");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    public void clear(View view) {
        arrayList.clear();
        t1.setText("");
        t2.setText("");
    }

    @SuppressLint("SetTextI18n")
    public void cal(View view) {
        try {
            int i;
            double x = 0;
            for (i = 0; i < arrayList.size(); i++) {
                sum = sum + arrayList.get(i);
            }
            exp = sum / count;
            for (i = 0; i < arrayList.size(); i++) {
                x = x + Math.pow((arrayList.get(i) - exp), 2) / exp;
            }
            t2.setText(t2.getText() + "X^2 = " + x + "\n");
        }catch (Exception e){
            Toast.makeText(Twelve.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
