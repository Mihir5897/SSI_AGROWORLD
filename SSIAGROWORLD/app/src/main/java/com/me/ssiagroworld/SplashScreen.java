package com.me.ssiagroworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow() ;
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splace_screen);

        Thread splashTread = new Thread(){


            @Override

            public void run() {

                try {

                    sleep(3000);

                    startActivity(new Intent(getApplicationContext(),Register.class));

                    finish();

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }


                super.run();

            }

        };


        splashTread.start();

    }
}

