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

public class Six extends AppCompatActivity {

    private TextView t1,t2,t3;
    private ArrayList<Double> xValues;
    private ArrayList<Double> yValues;
    int count = 0;
    double sumY = 0,sumX2 = 0,sumX = 0,sumXY = 0,a,b;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);

        getSupportActionBar().setTitle(R.string.linear_regression);

        t1 = (TextView) findViewById(R.id.ans2);
        t2 = (TextView) findViewById(R.id.ans3);
        t3 = (TextView) findViewById(R.id.ans4);

        xValues = new ArrayList<>();
        yValues = new ArrayList<>();

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void btn1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Six.this);
        @SuppressLint("InflateParams") View v = getLayoutInflater().inflate(R.layout.new_input,null);
        final EditText edit = (EditText) v.findViewById(R.id.edit);
        Button b1 = (Button) v.findViewById(R.id.enter);
        Button b2 = (Button) v.findViewById(R.id.cancel);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edit.getText())){
                    Toast.makeText(Six.this, "Enter the Number Please", Toast.LENGTH_SHORT).show();
                }else{
                    t1.setText(t1.getText() + edit.getText().toString() + ",");
                    xValues.add(Double.parseDouble(edit.getText().toString()));
                    count++;
                }
                edit.setText("");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void cal(View view) {
        try{
            for(int i = 0;i < xValues.size();i++){
                sumY = sumY + yValues.get(i);
                sumX2 = sumX2 + (xValues.get(i)*xValues.get(i));
                sumX = sumX + xValues.get(i);
                sumXY = sumXY + (xValues.get(i)*yValues.get(i));
            }
            a = (sumY*sumX2 - sumX*sumXY) / (count*sumX2 - sumX*sumX);
            b = (count*sumXY - sumX*sumY) / (count*sumX2 - sumX*sumX);
            t3.setText(t3.getText() + "Linear Regression : \n"
            + "\t\t" + "Y = " + a + " + " + b + "X\n\t where,\n" +
                    "a = " + a + "\n" + "b = " + b + "\n");
        }catch(Exception e){
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void clear(View view) {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        xValues.clear();
        yValues.clear();
    }

    public void btn4(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Six.this);
        @SuppressLint("InflateParams") View v = getLayoutInflater().inflate(R.layout.new_input,null);
        final EditText edit = (EditText) v.findViewById(R.id.edit);
        Button b1 = (Button) v.findViewById(R.id.enter);
        Button b2 = (Button) v.findViewById(R.id.cancel);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(edit.getText())){
                    Toast.makeText(Six.this, "Enter the Number Please", Toast.LENGTH_SHORT).show();
                }else{
                    t2.setText(t2.getText() + edit.getText().toString() + ",");
                    yValues.add(Double.parseDouble(edit.getText().toString()));
                }
                edit.setText("");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}
