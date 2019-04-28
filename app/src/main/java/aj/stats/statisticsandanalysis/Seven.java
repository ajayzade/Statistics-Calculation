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

public class Seven extends AppCompatActivity {

    private TextView t1,t2,t3;
    private ArrayList<Double> xValues;
    private ArrayList<Double> yValues;
    int count = 0;
    double sumY = 0,sumX2 = 0,sumX = 0,sumXY = 0,r,sumY2 = 0;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seven);

        getSupportActionBar().setTitle(R.string.correlation_coefficient);

        t1 = (TextView) findViewById(R.id.a1);
        t2 = (TextView) findViewById(R.id.a2);
        t3 = (TextView) findViewById(R.id.a3);

        xValues = new ArrayList<>();
        yValues = new ArrayList<>();

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void clear(View view) {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        xValues.clear();
        yValues.clear();
    }

    @SuppressLint("SetTextI18n")
    public void cal(View view) {
        try{
            for(int i = 0;i < xValues.size();i++){
                sumY = sumY + yValues.get(i);
                sumX2 = sumX2 + (xValues.get(i)*xValues.get(i));
                sumX = sumX + xValues.get(i);
                sumXY = sumXY + (xValues.get(i)*yValues.get(i));
                sumY2 = sumY2 + (yValues.get(i)*yValues.get(i));
            }
            r = (count*sumXY - sumX*sumY) / (Math.sqrt((count*sumX2 - sumX*sumX)*(count*sumY2 - sumY*sumY)));
            t3.setText(t3.getText() + "Coefficient of Correletion : \n\t\t" + "r = " + r + "\n");
        }catch(Exception e){
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btn4(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Seven.this);
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
                    Toast.makeText(Seven.this, "Enter the Number Please", Toast.LENGTH_SHORT).show();
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

    public void btn1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Seven.this);
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
                    Toast.makeText(Seven.this, "Enter the Number Please", Toast.LENGTH_SHORT).show();
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
}
