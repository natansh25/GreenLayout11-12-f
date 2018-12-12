package infinity1087.android.com.examplehr.splashScreen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import infinity1087.android.com.examplehr.MainActivity;
import infinity1087.android.com.examplehr.R;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_Screen = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                //finish();
            }
        }, SPLASH_Screen);
    }
}

