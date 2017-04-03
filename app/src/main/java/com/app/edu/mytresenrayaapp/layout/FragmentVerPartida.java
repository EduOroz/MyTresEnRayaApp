package com.app.edu.mytresenrayaapp.layout;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.app.edu.mytresenrayaapp.General;
import com.app.edu.mytresenrayaapp.R;
import com.app.edu.mytresenrayaapp.ViewGamesActivity;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentVerPartida.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentVerPartida#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentVerPartida extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    Button bt1ViewGames;
    Button bt2ViewGames;
    Button bt3ViewGames;
    Button bt4ViewGames;
    Button bt5ViewGames;
    Button bt6ViewGames;
    Button bt7ViewGames;
    Button bt8ViewGames;
    Button bt9ViewGames;
    Button btCloseViewGame;
    String[] movimientos;
    int contador;
    int posicion;
    String signo;
    boolean done = true;
    ArrayList<Button> tablero;

    View myView = null;


    public FragmentVerPartida() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentVerPartida.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentVerPartida newInstance(String param1, String param2) {
        FragmentVerPartida fragment = new FragmentVerPartida();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        System.out.println("ACTIVITY FRAGMENT: Estamos en OnCreate");
        System.out.println("ACTIVITY FRAGMENT parametro entrada: " +mParam1.toString());

        String[] parametros = mParam1.replace(" ","").replace("en","").split(">");
        System.out.println("ACTIVITY FRAGMENT parametro 1 " +parametros[1]);
        movimientos = parametros[1].split("\\|");
        System.out.println("ACTIVITY FRAGMENT parametro 1 " +movimientos[0]);


        /*final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 1000);*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("ACTIVITY FRAGMENT: Estamos en OnCreateView");
        myView = inflater.inflate(R.layout.fragment_ver_partida, container, false);

        bt1ViewGames = (Button) myView.findViewById(R.id.bt1ViewGames);
        bt2ViewGames = (Button) myView.findViewById(R.id.bt2ViewGames);
        bt3ViewGames = (Button) myView.findViewById(R.id.bt3ViewGames);
        bt4ViewGames = (Button) myView.findViewById(R.id.bt4ViewGames);
        bt5ViewGames = (Button) myView.findViewById(R.id.bt5ViewGames);
        bt6ViewGames = (Button) myView.findViewById(R.id.bt6ViewGames);
        bt7ViewGames = (Button) myView.findViewById(R.id.bt7ViewGames);
        bt8ViewGames = (Button) myView.findViewById(R.id.bt8ViewGames);
        bt9ViewGames = (Button) myView.findViewById(R.id.bt9ViewGames);
        btCloseViewGame = (Button) myView.findViewById(R.id.btCloseViewGame);

        tablero = new ArrayList<Button>() {{add(bt1ViewGames); add(bt2ViewGames); add(bt3ViewGames);
            add(bt4ViewGames); add(bt5ViewGames); add(bt6ViewGames);add(bt7ViewGames); add(bt8ViewGames); add(bt9ViewGames);}};

        btCloseViewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();

            }
        });

        return myView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        for (contador=0;contador<=(movimientos.length-1);contador++){

            System.out.println("ACTIVITY FRAGMENT Ver movimientos: " + movimientos[contador]);
            //Restamos 48 al convertir a entero por la diferencia de 48 posiciones en la tabla ASCII
            posicion = movimientos[contador].charAt(1) - 48;
            signo = Character.toString(movimientos[contador].charAt(0));
            System.out.println("ACTIVITY FRAGMENT Ver posicion: " + posicion);
            System.out.println("ACTIVITY FRAGMENT Ver signo: " + signo);
            try {
                tablero.get(posicion).setText(signo);
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
