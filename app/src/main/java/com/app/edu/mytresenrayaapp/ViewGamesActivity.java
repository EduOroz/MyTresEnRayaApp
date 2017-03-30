package com.app.edu.mytresenrayaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ViewGamesActivity extends AppCompatActivity {

    SharedPreferences sp;

    MediaPlayer mp;
    boolean sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_games);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sp = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
        sonido = sp.getBoolean("sonido", false);

        if (sonido){
            mp = MediaPlayer.create(getApplicationContext(), R.raw.bienvenida);
            mp.setLooping(true);
            mp.start();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (sonido){
            mp.stop();
        }
    }
    //Sobreescribimos estas 2 funciones para la navegación en el menu hamburguesa
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        General.menu(this, id);

        return super.onOptionsItemSelected(item);
    }

}
