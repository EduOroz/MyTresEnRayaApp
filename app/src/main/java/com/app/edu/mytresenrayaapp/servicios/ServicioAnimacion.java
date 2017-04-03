package com.app.edu.mytresenrayaapp.servicios;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Button;
import android.widget.Toast;

import com.app.edu.mytresenrayaapp.layout.FragmentVerPartida;

import java.util.ArrayList;

/**
 * Created by Edu on 03/04/2017.
 */

public class ServicioAnimacion extends Service {

    public ServicioAnimacion() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Destruyendo servicio", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("ACTIVITY Servicio Animación Arrancando");
        //Toast.makeText(this, "se ha iniciado el servicio", Toast.LENGTH_LONG).show();
        new CalculoTask().execute(new Void[]{null});
        return Service.START_STICKY;
    }

    private class CalculoTask extends AsyncTask<Void,Integer,Long> {
        @Override
        protected Long doInBackground(Void... arg0) {

            int posicion;
            String signo;
            long result = 0;

            for (int contador=0; contador<9; contador++){

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(contador);
            }

            return result;
        }

        @Override
        protected void onPostExecute(Long result) {
            Toast.makeText(getBaseContext(), "Partida finalizada ", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            System.out.println("Movimiento " +values[0]);
            //enviamos un mensaje al Handler con el porcentaje
            //de calculo realizado. Se lo pasamos en el segundo
            //parámetro
            FragmentVerPartida.manejador.obtainMessage(0, values[0], 9).sendToTarget();
        }

    }



}
