package aj.stats.statisticsandanalysis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6494979048790657/2038225113");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void twelve(View view) {
        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            startActivity(new Intent(MainActivity.this,Twelve.class));
        }
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startActivity(new Intent(MainActivity.this,Twelve.class));
            }
        });
    }

    public void eleven(View view) {
        startActivity(new Intent(MainActivity.this,Eleven.class));
    }

    public void ten(View view) {
        startActivity(new Intent(MainActivity.this,Ten.class));
    }

    public void nine(View view) {
        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            startActivity(new Intent(MainActivity.this,Nine.class));
        }
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startActivity(new Intent(MainActivity.this,Nine.class));
            }
        });
    }

    public void eight(View view) {
        startActivity(new Intent(MainActivity.this,Eight.class));
    }

    public void seven(View view) {
        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            startActivity(new Intent(MainActivity.this,Seven.class));
        }
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startActivity(new Intent(MainActivity.this,Seven.class));
            }
        });
    }

    public void six(View view) {
        startActivity(new Intent(MainActivity.this,Six.class));
    }

    public void five(View view) {
        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            startActivity(new Intent(MainActivity.this,Five.class));
        }
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startActivity(new Intent(MainActivity.this,Five.class));
            }
        });
    }

    public void four(View view) {
        startActivity(new Intent(MainActivity.this,Four.class));
    }

    public void three(View view) {
        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            startActivity(new Intent(MainActivity.this,Three.class));
        }
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startActivity(new Intent(MainActivity.this,Three.class));
            }
        });
    }

    public void two(View view) {
        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            startActivity(new Intent(MainActivity.this,Two.class));
        }
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                startActivity(new Intent(MainActivity.this,Two.class));
            }
        });
    }

    public void one(View view) {
        startActivity(new Intent(MainActivity.this,One.class));
    }
}
