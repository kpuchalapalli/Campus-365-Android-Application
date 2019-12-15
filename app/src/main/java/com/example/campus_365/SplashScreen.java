package com.example.campus_365;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();
        LogoLauncher logo= new LogoLauncher();
        logo.start();
    }
    private class LogoLauncher extends Thread{
        public void run()
        {
            try{
                sleep(800);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            Intent intent = new Intent(SplashScreen.this,MainActivity.class);
            startActivity(intent);
            SplashScreen.this.finish();
        }
    }
}
