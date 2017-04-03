package com.app.edu.mytresenrayaapp.servicios;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by telefonica on 29/03/2017.
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
        Toast.makeText(this, "destruyendo servicio", Toast.LENGTH_LONG).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "se ha iniciado el servicio", Toast.LENGTH_LONG).show();
        new CalculoTask().execute(new Void[]{null});
        return Service.START_STICKY;
    }

    private class CalculoTask extends AsyncTask<Void,Integer,Long> {
        @Override
        protected Long doInBackground(Void... arg0) {
            //simula una tarea de larga duración en donde
            //se tarda mucho en realizar la suma de los números
            //de 1 a 100
            long result = 0;
            for (int i = 1; i <= 100; i++) {
                result += i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //con cada suma, se hace la llamada a este método
                //que provocará la ejecución de onProgressUpdate
                publishProgress(i);
            }
            return result;
        }

        @Override
        protected void onPostExecute(Long result) {
            Toast.makeText(getBaseContext(), "calculo finalizado "+	result, Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            System.out.println(values[0]+" % calculado");
            //enviamos un mensaje al Handler con el porcentaje
            //de calculo realizado. Se lo pasamos en el segundo
            //parámetro
            //MainActivity.manejador.obtainMessage(0,values[0],1,new Clase(values[0])).sendToTarget();
        }

    }



}
