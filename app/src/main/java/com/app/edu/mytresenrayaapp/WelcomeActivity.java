package com.app.edu.mytresenrayaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    MediaPlayer mp;
    SharedPreferences sp;
    boolean sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        //Recuperamos si en las opciones hemos quitado el sonido
        sp = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
        sonido = sp.getBoolean("sonido", true);

        if (sonido) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.bienvenida);
            mp.setLooping(true);
            mp.start();
        }
    }

    public void start_app(View vi){
        SharedPreferences sp = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
        String name = sp.getString("nombre","");

        //Paramos el sonido
        if (sonido) {
            mp.stop();
        }

        if (name==""){
            General.setActivity(this, LoginActivity.class);
        } else {General.setActivity(this, GameActivity.class);}
    }


}
