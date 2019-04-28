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

public class One extends AppCompatActivity {

    private TextView tv1,tv2;
    private Button calculate;
    private double mean;
    private double sum = 0.0,index;
    private int count = 0;
    private ArrayList<Double> arrayList;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        getSupportActionBar().setTitle(R.string.mean_median_mode);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        calculate = (Button) findViewById(R.id.cal);

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        arrayList = new ArrayList<>();

        calculate.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try {
                    tv2.setText("");
                    mean = (double) (sum / count);
                    tv2.setText(tv2.getText() + "Mean = " + mean + "\n");
                    if (arrayList.size() % 2 == 0) {
                        index = (arrayList.get(((arrayList.size() / 2) + 1) - 1) + arrayList.get((arrayList.size() / 2) - 1)) / 2;
                        tv2.setText(tv2.getText() + "Median = " + index + "\n");
                    } else {
                        index = (arrayList.get((arrayList.size() / 2)) - 1);
                        tv2.setText(tv2.getText() + "Median = " + index + "\n");
                    }
                }catch (Exception e){
                    Toast.makeText(One.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void btn1(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(One.this);
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
                    Toast.makeText(One.this, "Enter the Number Please", Toast.LENGTH_SHORT).show();
                }else{
                    tv1.setText(tv1.getText() + edit.getText().toString() + ",");
                    count++;
                    sum = sum + Double.parseDouble(edit.getText().toString());
                    arrayList.add(Double.parseDouble(edit.getText().toString()));
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

    public void clear(View view) {
        tv1.setText("");
        tv2.setText("");
        arrayList.clear();
    }
}
