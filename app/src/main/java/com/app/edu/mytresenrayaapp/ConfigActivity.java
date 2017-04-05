package com.app.edu.mytresenrayaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

/**
 * Created by Eduardo on 29/03/2017.
 *  Actividad para gestionar la configuración de nuestra App
 */

public class ConfigActivity extends AppCompatActivity {

    RadioButton rbStartsIA;
    RadioButton rbStartsPerson;
    RadioGroup rgWhoStarts;
    Switch swSonido;
    Switch swSaveGames;

    SharedPreferences sp;

    MediaPlayer mp;
    boolean sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rbStartsIA = (RadioButton) findViewById(R.id.rbStartsIA);
        rbStartsPerson = (RadioButton) findViewById(R.id.rbStartsPerson);;
        rgWhoStarts = (RadioGroup) findViewById(R.id.rgWhoStart);
        swSonido = (Switch) findViewById(R.id.swSonido);
        swSaveGames = (Switch) findViewById(R.id.swSaveGames);

        sp = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
        sonido = sp.getBoolean("sonido", true);

        if (sonido){
            mp = MediaPlayer.create(getApplicationContext(), R.raw.bienvenida);
            mp.setLooping(true);
            mp.start();

            swSonido.setChecked(true);
        }

        if(sp.getBoolean("saveGames",false)){
            swSaveGames.setChecked(true);
        }

        if(sp.getString("empieza","").equals("IA")){
            rbStartsIA.setChecked(true);
        } else {rbStartsPerson.setChecked(true);}

        rgWhoStarts.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId==R.id.rbStartsIA){
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("empieza","IA");
                    editor.commit();
                    System.out.println("ACTIVITY CONFIG: Cambiamos para que empiece la " +sp.getString("empieza",""));
                } else {
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putString("empieza","Person");
                    editor.commit();
                    System.out.println("ACTIVITY CONFIG: Cambiamos para que empiece la " +sp.getString("empieza",""));
                }
            }
        });

        swSonido.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putBoolean("sonido",true);
                    editor.commit();
                    sonido = true;
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.bienvenida);
                    mp.start();
                    System.out.println("ACTIVITY CONFIG: Sonido " +sp.getBoolean("sonido", false));
                } else {
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putBoolean("sonido",false);
                    editor.commit();

                    if (sonido){
                        mp.stop();
                    }

                    sonido = false;
                    System.out.println("ACTIVITY CONFIG: Sonido " +sp.getBoolean("sonido", false));
                }
            }
        });

        swSaveGames.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putBoolean("saveGames",true);
                    editor.commit();
                    System.out.println("ACTIVITY CONFIG: Guardar partidas " +sp.getBoolean("saveGames",false));
                } else {
                    SharedPreferences.Editor editor=sp.edit();
                    editor.putBoolean("saveGames",false);
                    editor.commit();
                    System.out.println("ACTIVITY CONFIG: Guardar partidas " +sp.getBoolean("saveGames",false));
                }
            }
        });
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
        General.menu(this, id);

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (sonido){
            mp.stop();
        }
    }
}
