package com.app.edu.mytresenrayaapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void start_app(View vi){
        SharedPreferences sp = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
        String name = sp.getString("nombre","");
        if (name==""){
            General.setActivity(this, LoginActivity.class);
        } else {General.setActivity(this, GameActivity.class);}
    }
}
