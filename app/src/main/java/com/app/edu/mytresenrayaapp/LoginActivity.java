package com.app.edu.mytresenrayaapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

public class LoginActivity extends AppCompatActivity {

    Button login;
    SharedPreferences sp;
    String name;
    AutoCompleteTextView actvNombre;

    MediaPlayer mp;
    boolean sonido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = this.getSharedPreferences("settings", Context.MODE_PRIVATE);

        sonido = sp.getBoolean("sonido",false);
        if (sonido) {
            mp = MediaPlayer.create(getApplicationContext(), R.raw.bienvenida);
            mp.start();
        }

        actvNombre = (AutoCompleteTextView) findViewById(R.id.actvNombre);
        login = (Button) findViewById(R.id.sign_in_button);

        login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                name = actvNombre.getText().toString();
                System.out.println("ACTIVITY LOGIN nombre escrito: " +name);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("nombre", name);
                editor.commit();
                General.setActivity(LoginActivity.this, GameActivity.class);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (sonido){
            mp.stop();
        }
    }


}

