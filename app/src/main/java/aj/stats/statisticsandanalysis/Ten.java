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

public class Ten extends AppCompatActivity {

    private TextView t1,t2,t3,t4,t5;
    private EditText e1,e2;
    private ArrayList<Double> ax1,ax2,af1,af2,ad1,ad2;
    double m1,m2;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ten);

        getSupportActionBar().setTitle(R.string.f_test);

        t1 = (TextView) findViewById(R.id.q1);
        t2 = (TextView) findViewById(R.id.q2);
        t3 = (TextView) findViewById(R.id.q4);
        t4 = (TextView) findViewById(R.id.q5);
        t5 = (TextView) findViewById(R.id.q);
        e1 = (EditText) findViewById(R.id.q3);
        e2 = (EditText) findViewById(R.id.q6);

        ax1 = new ArrayList<>();
        ax2 = new ArrayList<>();
        af1 = new ArrayList<>();
        af2 = new ArrayList<>();
        ad1 = new ArrayList<>();
        ad2 = new ArrayList<>();

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    public void btn1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Ten.this);
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
                    Toast.makeText(Ten.this, "Please fill up the empty space", Toast.LENGTH_SHORT).show();
                }else{
                    ax1.add(Double.parseDouble(e.getText().toString()));
                    t1.setText(t1.getText() + e.getText().toString() + ",");
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

    public void btn2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Ten.this);
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
                    Toast.makeText(Ten.this, "Please fill up the empty space", Toast.LENGTH_SHORT).show();
                }else{
                    af1.add(Double.parseDouble(e.getText().toString()));
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

    public void btn3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Ten.this);
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
                    Toast.makeText(Ten.this, "Please fill up the empty space", Toast.LENGTH_SHORT).show();
                }else{
                    ax2.add(Double.parseDouble(e.getText().toString()));
                    t3.setText(t3.getText() + e.getText().toString() + ",");
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

    public void btn4(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Ten.this);
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
                    Toast.makeText(Ten.this, "Please fill up the empty space", Toast.LENGTH_SHORT).show();
                }else{
                    af2.add(Double.parseDouble(e.getText().toString()));
                    t4.setText(t4.getText() + e.getText().toString() + ",");
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
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        e1.setText("");
        e2.setText("");
        ax1.clear();
        ax2.clear();
        af2.clear();
        af1.clear();
        ad1.clear();
        ad2.clear();
    }

    @SuppressLint("SetTextI18n")
    public void cal(View view) {
        try {
            if (TextUtils.isEmpty(e1.getText().toString()) || TextUtils.isEmpty(e2.getText().toString())) {
                Toast.makeText(this, "Please fill up the empty spaces", Toast.LENGTH_SHORT).show();
            } else {
                int i;
                double s1 = 0, s2 = 0, n1 = 0, n2 = 0, v1, v2, F;
                m1 = Double.parseDouble(e1.getText().toString());
                m2 = Double.parseDouble(e2.getText().toString());
                for (i = 0; i < ax1.size(); i++) {
                    s1 = s1 + (Math.pow(ax1.get(i) - m1, 2));
                    s2 = s2 + (Math.pow(ax2.get(i) - m2, 2));
                    n1 = n1 + af1.get(i);
                    n2 = n2 + af2.get(i);
                }
                v1 = s1 / n1;
                v2 = s2 / n2;
                F = v1 / v2;
                t5.setText(t5.getText() + "F-Value = " + F + "\n");
            }
        }catch (Exception e){
            Toast.makeText(Ten.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
