package com.app.edu.mytresenrayaapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Salir")
                    .setMessage("¿Estás seguro?")
                    .setNegativeButton(android.R.string.cancel, null)// sin listener
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        // un listener que al pulsar, cierre la aplicacion
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Salir
                            WelcomeActivity.this.finish();
                        }
                    })
                    .show();

            // Si el listener devuelve true, significa que el evento esta procesado, y nadie debe hacer nada mas
            return true;
        }
        // para las demas cosas, se reenvia el evento al listener habitual
        return super.onKeyDown(keyCode, event);
    }

    public void start_app(View vi){
        SharedPreferences sp = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
        String name = sp.getString("nombre","");

        if (sonido) {
            mp.stop();
        }

        if (name==""){
            General.setActivity(this, LoginActivity.class);
        } else {General.setActivity(this, GameActivity.class);}
    }


}


