package com.app.edu.mytresenrayaapp;


import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.app.edu.mytresenrayaapp.layout.FragmentVerPartida;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ViewGamesActivity extends AppCompatActivity {

    SharedPreferences sp;

    MediaPlayer mp;
    boolean sonido;

    //FragmentManager manager;
    FragmentVerPartida fragVerpartida;

    ListView lvViewPartidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_games);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sp = this.getSharedPreferences("settings", Context.MODE_PRIVATE);
        sonido = sp.getBoolean("sonido", false);

        lvViewPartidas = (ListView) findViewById(R.id.lvViewPartidas);

        if (sonido){
            mp = MediaPlayer.create(getApplicationContext(), R.raw.bienvenida);
            mp.setLooping(true);
            mp.start();
        }

        //iniciar la comunicación con el servidor remoto para obtener las partidas jugadas
        ComunicacionTask com = new ComunicacionTask();
        com.execute("http://minionsdesapps.esy.es/apps/verPartidas.php");

        //Creamos un listener para cuando hagamos click en una partida nos abra un fragment
        lvViewPartidas.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            View view, int position, long id) {
                        Toast.makeText(ViewGamesActivity.this,
                                "Partida " +position,
                                Toast.LENGTH_SHORT).show();

                        //Abrimos el Fragment creado
                        System.out.println("ACTIVITY VALL - Item señalado: " +lvViewPartidas.getItemAtPosition(position).toString());
                        FragmentManager manager = getSupportFragmentManager();
                        fragVerpartida = FragmentVerPartida.newInstance(lvViewPartidas.getItemAtPosition(position).toString(), "fragVerpartida");
                        manager.beginTransaction().replace(R.id.activity_view_games, fragVerpartida).addToBackStack(null).commit();
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
    //Sobreescribimos estas 2 funciones para la navegación en el menu hamburguesa
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        General.menu(this, id);
        return super.onOptionsItemSelected(item);
    }

    private class ComunicacionTask extends AsyncTask<String, Void, String> {

        //@RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(String... params) {

            String cadenaJson="";
            try{
                //monta la url con la dirección del servidor remoto
                URL url=new URL(params[0]);
                URLConnection con=url.openConnection();
                //recuperacion de la respuesta JSON
                String s;
                InputStream is=con.getInputStream();
                //utilizamos UTF-8 para que interprete correctamente las ñ y acentos
                BufferedReader bf=new BufferedReader(
                        new InputStreamReader(is, Charset.forName("UTF-8")));
                while((s=bf.readLine())!=null){
                    cadenaJson+=s;
                }

            }
            catch(IOException ex){
                ex.printStackTrace();
            }
            return cadenaJson;
        }

        @Override
        protected void onPostExecute(String result) {

            ArrayList<String> json_list = new ArrayList<>();

            try{
                //creamos un array JSON a partir de la cadena recibida
                JSONArray jarray=new JSONArray(""+result);

                //recorremos el jarray y cada objeto del mismo lo metemos en un array list
                for(int i=0;i<jarray.length();i++){
                    JSONObject job=jarray.getJSONObject(i);
                    System.out.println("ACTIVITY VIEW GAMES Fila Recibida: "+job.toString());
                    if (job.get("ganador").equals("Empate")){
                        json_list.add(job.getString("id")+". " +job.getString("nombre") +"   > " +job.getString("movimientos") +"   > " +job.getString("ganador"));
                    } else {
                        json_list.add(job.getString("id")+". " +job.getString("nombre") +"   > " +job.getString("movimientos") +"   > win by: " +job.getString("ganador"));
                    }
                }

            }
            catch(JSONException ex){
                ex.printStackTrace();
            }

            //System.out.println("ACTIVITY VIEW GAMES Primer elemento json_list: " +json_list.get(0));
            ArrayAdapter<String> adapter= new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, json_list);
            lvViewPartidas.setAdapter(adapter);
            //tvSalida.setText(""+result);
        }

    }

}
