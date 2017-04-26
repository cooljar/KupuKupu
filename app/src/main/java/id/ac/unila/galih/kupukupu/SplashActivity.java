package id.ac.unila.galih.kupukupu;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {

    ProgressBar pBar;
    CountDownTimer ctdn;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        pBar = (ProgressBar) findViewById(R.id.pBar);
        ctdn = new CountDownTimer(5*1000, 1000) {
            public void onTick(long millisUntilFinished) {
                i++;
                pBar.setProgress(i);
            }
            public void onFinish() {
                i++;
                pBar.setProgress(0);
                pBar.setVisibility(View.GONE);
                Intent intent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        };
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(ctdn != null) ctdn.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(ctdn != null) ctdn.cancel();
        if(pBar != null) pBar.setProgress(0);
    }
}
