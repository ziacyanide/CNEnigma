package cyanide.cnenigma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
ProgressBar load;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MobileAds.initialize(this, new OnInitializationCompleteListener() {
//            @Override
//            public void onInitializationComplete(InitializationStatus initializationStatus) {
//            }
//        });

        load = (ProgressBar) findViewById(R.id.progressBar);
        load.incrementProgressBy(10);
        Timer check = new Timer();
        intent = new Intent(this,DashBoard.class);
        //startActivity(intent);

        TimerTask test = new TimerTask() {
            @Override
            public void run() {
                startActivity(intent);
            }

        };
        check.schedule(test,6000);



    }

    /**
     *
     */
    @Override
    protected void onPause() {
        this.finish();
        super.onPause();
    }
}
