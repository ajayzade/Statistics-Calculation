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

public class Three extends AppCompatActivity {

    private TextView t1,t2,t3;
    private ArrayList<Double> arrayList1;
    private ArrayList<Double> arrayList2;
    private ArrayList<Double> arrayList3;
    private ArrayList<Double> arrayList4;
    private ArrayList<Double> arrayList5;
    private ArrayList<Double> arrayList6;
    private ArrayList<Double> arrayList7;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        getSupportActionBar().setTitle(R.string.deviations_and_variance);

        t1 = (TextView) findViewById(R.id.o1);
        t2 = (TextView) findViewById(R.id.o2);
        t3 = (TextView) findViewById(R.id.o3);

        arrayList1 = new ArrayList<>();
        arrayList2 = new ArrayList<>();
        arrayList3 = new ArrayList<>();
        arrayList4 = new ArrayList<>();
        arrayList5 = new ArrayList<>();
        arrayList6 = new ArrayList<>();
        arrayList7 = new ArrayList<>();

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void clear(View view) {
        flash();
    }

    @SuppressLint("SetTextI18n")
    public void cal(View view) {
        try{
            int i;
            double s = 0, N = 0, fd = 0,fx = 0,mean,stD,fm = 0,mD;
            for (i = 0;i < arrayList1.size();i++){
                arrayList4.add(((arrayList1.get(i) + arrayList2.get(i)) / 2));
                s = s + arrayList3.get(i);
                arrayList5.add(s);
                arrayList6.add((arrayList4.get(i) * arrayList3.get(i)));
                N = N + arrayList3.get(i);
                fx = fx + arrayList6.get(i);
            }
            mean = (double) (fx / N);
            for (i = 0;i < arrayList1.size();i++){
                arrayList7.add(arrayList4.get(i) - mean);
                fd = fd + (Math.pow(arrayList7.get(i),2));
                fm = fm + arrayList7.get(i);
            }
            stD = Math.sqrt(fd / N);
            mD = fm / N;
            t3.setText("Class Interval\t\t\t\t\t\t\t" + "F\t\t\t\t\t\t\t" + "x\t\t\t\t\t\t\t" + "Fx\t\t\t\t\t\t\t" + "d\n");
            for (i = 0; i < arrayList1.size(); i++) {
                t3.setText(t3.getText() + arrayList1.get(i).toString()
                        + " - " + arrayList2.get(i).toString() + "\t\t\t\t\t\t\t" + arrayList3.get(i).toString()
                        + "\t\t\t\t\t" + arrayList4.get(i).toString() + "\t\t\t\t\t" + arrayList6.get(i).toString()
                        + "\t\t\t\t\t" + arrayList7.get(i).toString() + "\n");
            }
            t3.setText(t3.getText() + "\n" + "Standard Deviation = " + stD + "\n");
            t3.setText(t3.getText() + "\n" + "Mean Deviation = " + mD + "\n");
        }catch (Exception e){
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void flash(){
        arrayList1.clear();
        arrayList2.clear();
        arrayList3.clear();
        arrayList4.clear();
        arrayList5.clear();
        arrayList6.clear();
        t1.setText("");
        t2.setText("");
        t3.setText("");
    }

    public void btn2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Three.this);
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
                    Toast.makeText(Three.this, "Please fill up the empty space", Toast.LENGTH_SHORT).show();
                }else{
                    arrayList3.add(Double.parseDouble(e.getText().toString()));
                    t2.setText(t2.getText() + e.getText().toString() + ",");
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

    public void btn1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Three.this);
        @SuppressLint("InflateParams") View v = getLayoutInflater().inflate(R.layout.input_two,null);
        final EditText e1 = (EditText) v.findViewById(R.id.edit1);
        final EditText e2 = (EditText) v.findViewById(R.id.edit2);
        Button b1 = (Button) v.findViewById(R.id.enter1);
        Button b2 = (Button) v.findViewById(R.id.cancel1);
        builder.setView(v);
        final AlertDialog dialog = builder.create();
        dialog.show();
        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(e1.getText()) || TextUtils.isEmpty(e2.getText())){
                    Toast.makeText(Three.this, "Please fill up the empty space", Toast.LENGTH_SHORT).show();
                }else{
                    arrayList1.add(Double.parseDouble(e1.getText().toString()));
                    arrayList2.add(Double.parseDouble(e2.getText().toString()));
                    t1.setText(t1.getText() + e1.getText().toString() + " - " + e2.getText().toString() + ",");
                }
                e1.setText("");
                e2.setText("");
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
