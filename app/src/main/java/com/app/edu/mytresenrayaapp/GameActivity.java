package com.app.edu.mytresenrayaapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Executors;

public class GameActivity extends AppCompatActivity {

    TextView tvMensajes;
    Button bt1;
    Button bt2;
    Button bt3;
    Button bt4;
    Button bt5;
    Button bt6;
    Button bt7;
    Button bt8;
    Button bt9;
    Button btReStart;
    String signo = "X";
    ArrayList<Button> tablero;
    String test ="-";
    Boolean endGame = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tvMensajes = (TextView) findViewById(R.id.tvMensajes);
        bt1 = (Button) findViewById(R.id.bt1);
        bt2 = (Button) findViewById(R.id.bt2);
        bt3 = (Button) findViewById(R.id.bt3);
        bt4 = (Button) findViewById(R.id.bt4);
        bt5 = (Button) findViewById(R.id.bt5);
        bt6 = (Button) findViewById(R.id.bt6);
        bt7 = (Button) findViewById(R.id.bt7);
        bt8 = (Button) findViewById(R.id.bt8);
        bt9 = (Button) findViewById(R.id.bt9);
        btReStart = (Button) findViewById(R.id.btReStart);

        final Handler handler = new Handler();

        tablero = new ArrayList<Button>() {{add(bt1); add(bt2); add(bt3);
            add(bt4); add(bt5); add(bt6);add(bt7); add(bt8); add(bt9);}};

        //Creamos listeners para hacer click en los botones
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endGame){
                    if (bt1.getText().toString().equals("-")) {
                        signo = cambiarSigno(bt1, signo);
                        tvMensajes.setText("");
                        System.out.println("GANADOR: " +bt1.getText().toString());
                        test=comprobarGanador(bt1.getText().toString());
                        if (test.equals("X")){
                            tvMensajes.setText("Enhorabuena ganan las X");
                            endGame = true;
                        } else if (test.equals("O")) {
                            tvMensajes.setText("Enhorabuena ganan las O");
                            endGame = true;
                        } else {
                            if (comprobarEmpate()){
                                tvMensajes.setText("La partida termina en empate");
                                endGame = true;
                            };
                        }
                        //Después de mover el jugador y comprobar si el juego termina, mueve la IA tras 1 segundo
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 100ms
                                if(!endGame){signo = moveIA(signo);}
                            }
                        }, 500);


                    } else {
                        tvMensajes.setText("Esa casilla ya esta usada");
                    }
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endGame) {
                    if (bt2.getText().toString().equals("-")) {
                        signo = cambiarSigno(bt2, signo);
                        tvMensajes.setText("");
                        test = comprobarGanador(bt2.getText().toString());
                        if (test.equals("X")) {
                            tvMensajes.setText("Enhorabuena ganan las X");
                            endGame = true;
                        } else if (test.equals("O")) {
                            tvMensajes.setText("Enhorabuena ganan las O");
                            endGame = true;
                        } else {
                            if (comprobarEmpate()) {
                                tvMensajes.setText("La partida termina en empate");
                                endGame = true;
                            };
                        }

                        //Después de mover el jugador y comprobar si el juego termina, mueve la IA tras 1 segundo
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 100ms
                                if(!endGame){signo = moveIA(signo);}
                            }
                        }, 500);


                    } else {
                        tvMensajes.setText("Esa casilla ya esta usada");
                    }
                }
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endGame) {
                    if (bt3.getText().toString().equals("-")) {
                        signo = cambiarSigno(bt3, signo);
                        tvMensajes.setText("");
                        test = comprobarGanador(bt3.getText().toString());
                        if (test.equals("X")) {
                            tvMensajes.setText("Enhorabuena ganan las X");
                            endGame = true;
                        } else if (test.equals("O")) {
                            tvMensajes.setText("Enhorabuena ganan las O");
                            endGame = true;
                        } else {
                            if (comprobarEmpate()) {
                                tvMensajes.setText("La partida termina en empate");
                                endGame = true;
                            };
                        }

                        //Después de mover el jugador y comprobar si el juego termina, mueve la IA tras 1 segundo
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 100ms
                                if(!endGame){signo = moveIA(signo);}
                            }
                        }, 500);


                    } else {
                        tvMensajes.setText("Esa casilla ya esta usada");
                    }
                }
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endGame) {
                    if (bt4.getText().toString().equals("-")) {
                        signo = cambiarSigno(bt4, signo);
                        tvMensajes.setText("");
                        test = comprobarGanador(bt4.getText().toString());
                        if (test.equals("X")) {
                            tvMensajes.setText("Enhorabuena ganan las X");
                            endGame = true;
                        } else if (test.equals("O")) {
                            tvMensajes.setText("Enhorabuena ganan las O");
                            endGame = true;
                        } else {
                            if (comprobarEmpate()) {
                                tvMensajes.setText("La partida termina en empate");
                                endGame = true;
                            };
                        }

                        //Después de mover el jugador y comprobar si el juego termina, mueve la IA tras 1 segundo
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 500ms
                                if(!endGame){signo = moveIA(signo);}
                            }
                        }, 500);

                    } else {
                        tvMensajes.setText("Esa casilla ya esta usada");
                    }
                }
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endGame) {
                    if (bt5.getText().toString().equals("-")) {
                        signo = cambiarSigno(bt5, signo);
                        tvMensajes.setText("");
                        test=comprobarGanador(bt5.getText().toString());
                        if (test.equals("X")){
                            tvMensajes.setText("Enhorabuena ganan las X");
                            endGame = true;
                        } else if (test.equals("O")) {
                            tvMensajes.setText("Enhorabuena ganan las O");
                            endGame = true;
                        } else {
                            if (comprobarEmpate()){
                                tvMensajes.setText("La partida termina en empate");
                                endGame = true;
                            };
                        }

                        //Después de mover el jugador y comprobar si el juego termina, mueve la IA tras 1 segundo
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 500ms
                                if(!endGame){signo = moveIA(signo);}
                            }
                        }, 500);

                    } else {
                        tvMensajes.setText("Esa casilla ya esta usada");
                    }
                }
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endGame) {
                    if (bt6.getText().toString().equals("-")) {
                        signo = cambiarSigno(bt6, signo);
                        tvMensajes.setText("");
                        test = comprobarGanador(bt6.getText().toString());
                        if (test.equals("X")) {
                            tvMensajes.setText("Enhorabuena ganan las X");
                            endGame = true;
                        } else if (test.equals("O")) {
                            tvMensajes.setText("Enhorabuena ganan las O");
                            endGame = true;
                        } else {
                            if (comprobarEmpate()) {
                                tvMensajes.setText("La partida termina en empate");
                                endGame = true;
                            };
                        }

                        //Después de mover el jugador y comprobar si el juego termina, mueve la IA tras 1 segundo
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 500ms
                                if(!endGame){signo = moveIA(signo);}
                            }
                        }, 500);

                    } else {
                        tvMensajes.setText("Esa casilla ya esta usada");
                    }
                }
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endGame) {
                    if (bt7.getText().toString().equals("-")) {
                        signo = cambiarSigno(bt7, signo);
                        tvMensajes.setText("");
                        test = comprobarGanador(bt7.getText().toString());
                        if (test.equals("X")) {
                            tvMensajes.setText("Enhorabuena ganan las X");
                            endGame = true;
                        } else if (test.equals("O")) {
                            tvMensajes.setText("Enhorabuena ganan las O");
                            endGame = true;
                        } else {
                            if (comprobarEmpate()) {
                                tvMensajes.setText("La partida termina en empate");
                                endGame = true;
                            };
                        }

                        //Después de mover el jugador y comprobar si el juego termina, mueve la IA tras 1 segundo
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 500ms
                                if(!endGame){signo = moveIA(signo);}
                            }
                        }, 500);

                    } else {
                        tvMensajes.setText("Esa casilla ya esta usada");
                    }
                }
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endGame) {
                    if (bt8.getText().toString().equals("-")) {
                        signo = cambiarSigno(bt8, signo);
                        tvMensajes.setText("");
                        test = comprobarGanador(bt8.getText().toString());
                        if (test.equals("X")) {
                            tvMensajes.setText("Enhorabuena ganan las X");
                            endGame = true;
                        } else if (test.equals("O")) {
                            tvMensajes.setText("Enhorabuena ganan las O");
                            endGame = true;
                        } else {
                            if (comprobarEmpate()) {
                                tvMensajes.setText("La partida termina en empate");
                                endGame = true;
                            };
                        }

                        //Después de mover el jugador y comprobar si el juego termina, mueve la IA tras 1 segundo
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 500ms
                                if(!endGame){signo = moveIA(signo);}
                            }
                        }, 500);

                    } else {
                        tvMensajes.setText("Esa casilla ya esta usada");
                    }
                }
            }
        });

        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!endGame) {
                    if (bt9.getText().toString().equals("-")) {
                        signo = cambiarSigno(bt9, signo);
                        tvMensajes.setText("");
                        test = comprobarGanador(bt9.getText().toString());
                        if (test.equals("X")) {
                            tvMensajes.setText("Enhorabuena ganan las X");
                            endGame = true;
                        } else if (test.equals("O")) {
                            tvMensajes.setText("Enhorabuena ganan las O");
                            endGame = true;
                        } else {
                            if (comprobarEmpate()) {
                                tvMensajes.setText("La partida termina en empate");
                                endGame = true;
                            };
                        }

                        //Después de mover el jugador y comprobar si el juego termina, mueve la IA tras 1 segundo
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //Do something after 500ms
                                if(!endGame){signo = moveIA(signo);}
                            }
                        }, 500);

                    } else {
                        tvMensajes.setText("Esa casilla ya esta usada");
                    }
                }
            }
        });

        btReStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvMensajes.setText("¿Juegas?");
                bt1.setText("-");
                bt2.setText("-");
                bt3.setText("-");
                bt4.setText("-");
                bt5.setText("-");
                bt6.setText("-");
                bt7.setText("-");
                bt8.setText("-");
                bt9.setText("-");
                endGame=false;
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

    private String cambiarSigno(Button bt, String signo){
        //Cambiamos el texto del botón y reseteamos signo
        System.out.println("ACTIVITY JUGAR-cambiar Signo de: " +signo);
        bt.setText(signo);
        if (signo.equals("X")){
            signo = "O";
        } else signo="X";
        System.out.println("ACTIVITY JUGAR-cambiar Signo a: " +signo);
        return signo;
    }

    private String comprobarGanador(String signo){

        if (comprobarFila(1, signo)){
            return signo;
        }
        if (comprobarFila(2, signo)){
            return signo;
        }
        if (comprobarFila(3, signo)){
            return signo;
        }
        if (comprobarColumna(1, signo)){
            return signo;
        }
        if (comprobarColumna(2, signo)){
            return signo;
        }
        if (comprobarColumna(3, signo)){
            return signo;
        }
        if (comprobarDiagonal(1, signo)){
            return signo;
        }
        if (comprobarDiagonal(2, signo)){
            return signo;
        }

        System.out.println("ACTIVITY GAME: Comprobando Ganador "+signo);

        return "-";
    }

    private boolean comprobarFila(int fila, String signo){

        int pos=0;
        boolean fin = false;
        if (fila == 1){
            pos=0;
        } else if (fila == 2) {
            pos=3;
        } else if (fila == 3) {
            pos=6;
        }

        if (tablero.get(pos).getText().equals(signo)){
            if (tablero.get(pos+1).getText().equals(signo)){
                if (tablero.get(pos+2).getText().equals(signo)){
                    fin = true;
                }
            }
        }

        System.out.println("ACTIVITY GAME: Comprobando Fila "+fila +" termina " +fin);
        return fin;
    }

    private boolean comprobarColumna(int columna, String signo){

        boolean fin = false;

        if (tablero.get(columna-1).getText().equals(signo)){
            if (tablero.get(columna+2).getText().equals(signo)){
                if (tablero.get(columna+5).getText().equals(signo)){
                    fin = true;
                }
            }
        }
        System.out.println("ACTIVITY GAME: Comprobando Columna "+columna +" termina " +fin);

        return fin;
    }

    private boolean comprobarDiagonal(int diag, String signo){

        boolean fin = false;
        int diagonal[] = {0, 4, 8};
        if (diag==2){
            diagonal[0]=2;
            diagonal[2]=6;
        }

        if (tablero.get(diagonal[0]).getText().equals(signo)){
            if (tablero.get(diagonal[1]).getText().equals(signo)){
                if (tablero.get(diagonal[2]).getText().equals(signo)){
                    fin = true;
                }
            }
        }
        System.out.println("ACTIVITY GAME: Comprobando Diagonal "+diag +" termina " +fin);

        return fin;
    }

    private boolean comprobarEmpate(){
        boolean empate=true;
        for (int j=0; j<tablero.size();j++){
            if (tablero.get(j).getText().toString().equals("-")){
                empate = false;
            }
        }
        return empate;
    }

    private String moveIA(String signo){
        System.out.println("ACTIVITY JUGAR-IA: Moviendo la IA con signo " +signo);
        String signo_persona;
        Boolean movimiento=false;

        if (signo.equals("X")){
            signo_persona = "O";
        } else signo_persona="X";

        //Simularemos un movimiento en el tablero y veremos si puede ganar
        for (int j=0; j<tablero.size();j++){
            if (tablero.get(j).getText().toString().equals("-")){
                tablero.get(j).setText(signo);
                if (comprobarGanador(signo).equals(signo)&&!movimiento){
                    tvMensajes.setText("Lo siento has perdido");
                    endGame=true;
                    movimiento=true;
                } else {tablero.get(j).setText("-");};
            }
        }
        //Revisaremos si con algún movimiento en el tablero el jugador puede ganar
        if(!movimiento){
            for (int j=0; j<tablero.size();j++){
                if (tablero.get(j).getText().toString().equals("-")){
                    tablero.get(j).setText(signo_persona);
                    if (comprobarGanador(signo_persona).equals(signo_persona)&&!movimiento){
                        tablero.get(j).setText(signo);
                        movimiento=true;
                        tvMensajes.setText("Lo siento te he cortado");
                    } else {tablero.get(j).setText("-");};
                }
            }
        }
        //Si está libre nos pondremos en la casilla central o en una esquina
        if(!movimiento){
            if (tablero.get(4).getText().toString().equals("-")){
                tablero.get(4).setText(signo);
                System.out.println("ACTIVITY IA: Coloco en el centro no puedo ganar");
            } else {
                if (tablero.get(0).getText().toString().equals("-")) {
                    tablero.get(0).setText(signo);
                    System.out.println("ACTIVITY IA: Coloco en esquina 0 no puedo ganar");
                } else {
                    if (tablero.get(6).getText().toString().equals("-")) {
                        tablero.get(6).setText(signo);
                        System.out.println("ACTIVITY IA: Coloco en esquina 6 no puedo ganar");
                    } else {
                        if (tablero.get(2).getText().toString().equals("-")) {
                            tablero.get(2).setText(signo);
                            System.out.println("ACTIVITY IA: Coloco en esquina 2 no puedo ganar");
                        } else {
                            if (tablero.get(8).getText().toString().equals("-")) {
                                tablero.get(8).setText(signo);
                                System.out.println("ACTIVITY IA: Coloco en esquina 8 no puedo ganar");
                            }
                        }
                    }
                }
            }
        }

        //Cambiamos el signo para que este disponible para el jugador persona
        if (signo.equals("X")){
            signo = "O";
        } else signo="X";

        System.out.println("ACTIVITY JUGAR-IA: Terminando de mover la IA devuelve el signo " +signo);
        return signo;
    }


}
