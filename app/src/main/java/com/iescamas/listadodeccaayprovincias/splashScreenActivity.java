package com.iescamas.listadodeccaayprovincias;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class splashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Obligamos a que el splashScreen a bloquearse verticalmente
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Método para lanzar el MainActivity desde el splashScreen
        new Handler().postDelayed(()->{
            Intent intent  = new Intent(splashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finishAffinity();
        },3000);

    }
}