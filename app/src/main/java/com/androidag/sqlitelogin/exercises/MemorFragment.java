package com.androidag.sqlitelogin.exercises;


import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemorFragment extends Fragment implements View.OnClickListener{

    ImageButton imbCarta1, imbCarta2, imbCarta3, imbCarta4, imbCarta5, imbCarta6, imbCarta7, imbCarta8;
    int[] imagenes = {R.mipmap.apple_memory,R.mipmap.banana_memory,R.mipmap.orange_memory,R.mipmap.uva_memory};
    int[] juego = new int[8];
    int[] cartas_selecionadas = new int[2];
    int[] imagenes_selecionadas = new int[2];
    int[] juego_terminado = new int[8];
    int turno=0, ganador=0;

    public MemorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_memor, container, false);

        imbCarta1 = (ImageButton) view.findViewById(R.id.imbCarta1);
        imbCarta1.setOnClickListener(this);
        imbCarta2 = (ImageButton) view.findViewById(R.id.imbCarta2);
        imbCarta2.setOnClickListener(this);
        imbCarta3 = (ImageButton) view.findViewById(R.id.imbCarta3);
        imbCarta3.setOnClickListener(this);
        imbCarta4 = (ImageButton) view.findViewById(R.id.imbCarta4);
        imbCarta4.setOnClickListener(this);
        imbCarta5 = (ImageButton) view.findViewById(R.id.imbCarta5);
        imbCarta5.setOnClickListener(this);
        imbCarta6 = (ImageButton) view.findViewById(R.id.imbCarta6);
        imbCarta6.setOnClickListener(this);
        imbCarta7 = (ImageButton) view.findViewById(R.id.imbCarta7);
        imbCarta7.setOnClickListener(this);
        imbCarta8 = (ImageButton) view.findViewById(R.id.imbCarta8);
        imbCarta8.setOnClickListener(this);

        if (savedInstanceState == null)
        {
            asignarImagenes();
            for (int i=0;i<8;i++)
                juego_terminado[i]=0;

            cartas_selecionadas[0]=8;
        }


        // Inflate the layout for this fragment
        return view;
    }

    private void asignarImagenes()
    {
        int posicion, contador = 0;

        for (int i=0;i<4;)
        {
            posicion = (int)(Math.random()*8);

            if(juego[posicion]==0) {
                juego[posicion] = imagenes[i];
                contador++;

                if(contador == 2)
                {
                    i++;
                    contador=0;
                }

            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imbCarta1:
                imbCarta1.setImageResource(juego[0]);
                imagenes_selecionadas[turno]=juego[0];
                cartas_selecionadas[turno]=0;
                imbCarta1.setEnabled(false);
                break;
            case R.id.imbCarta2:
                imbCarta2.setImageResource(juego[1]);
                imagenes_selecionadas[turno]=juego[1];
                cartas_selecionadas[turno]=1;
                imbCarta2.setEnabled(false);
                break;
            case R.id.imbCarta3:
                imbCarta3.setImageResource(juego[2]);
                imagenes_selecionadas[turno]=juego[2];
                cartas_selecionadas[turno]=2;
                imbCarta3.setEnabled(false);
                break;
            case R.id.imbCarta4:
                imbCarta4.setImageResource(juego[3]);
                imagenes_selecionadas[turno]=juego[3];
                cartas_selecionadas[turno]=3;
                imbCarta4.setEnabled(false);
                break;
            case R.id.imbCarta5:
                imbCarta5.setImageResource(juego[4]);
                imagenes_selecionadas[turno]=juego[4];
                cartas_selecionadas[turno]=4;
                imbCarta5.setEnabled(false);
                break;
            case R.id.imbCarta6:
                imbCarta6.setImageResource(juego[5]);
                imagenes_selecionadas[turno]=juego[5];
                cartas_selecionadas[turno]=5;
                imbCarta6.setEnabled(false);
                break;
            case R.id.imbCarta7:
                imbCarta7.setImageResource(juego[6]);
                imagenes_selecionadas[turno]=juego[6];
                cartas_selecionadas[turno]=6;
                imbCarta7.setEnabled(false);
                break;
            case R.id.imbCarta8:
                imbCarta8.setImageResource(juego[7]);
                imagenes_selecionadas[turno]=juego[7];
                cartas_selecionadas[turno]=7;
                imbCarta8.setEnabled(false);
                break;
        }

        if(turno==0) {
            turno = 1;
        }else{
            new MemorFragment.Hilo().execute();
            turno=0;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle estado) {
        super.onSaveInstanceState(estado);
        estado.putInt("TURNO", turno);
        estado.putInt("GANADOR", ganador);
        estado.putIntArray("ARREGLO_JUEGO", juego);
        estado.putIntArray("ARREGLO_JUEGO_TERMINADO", juego_terminado);
        estado.putIntArray("ARREGLO_CARTAS_SELECCIONADAS", cartas_selecionadas);
        estado.putIntArray("ARREGLO_IMAGENES_SELECCIONADAS", imagenes_selecionadas);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null){
            turno = savedInstanceState.getInt("TURNO");
            ganador = savedInstanceState.getInt("GANADOR");
            juego = savedInstanceState.getIntArray("ARREGLO_JUEGO");
            juego_terminado = savedInstanceState.getIntArray("ARREGLO_JUEGO_TERMINADO");
            cartas_selecionadas = savedInstanceState.getIntArray("ARREGLO_CARTAS_SELECCIONADAS");
            imagenes_selecionadas = savedInstanceState.getIntArray("ARREGLO_IMAGENES_SELECCIONADAS");

            if (juego_terminado[0] == 1 || cartas_selecionadas[0]==0)
            {
                imbCarta1.setImageResource(juego[0]);
                imbCarta1.setEnabled(false);
            }

            if (juego_terminado[1] == 1 || cartas_selecionadas[0]==1)
            {
                imbCarta2.setImageResource(juego[1]);
                imbCarta2.setEnabled(false);
            }

            if (juego_terminado[2] == 1 || cartas_selecionadas[0]==2)
            {
                imbCarta3.setImageResource(juego[2]);
                imbCarta3.setEnabled(false);
            }

            if (juego_terminado[3] == 1 || cartas_selecionadas[0]==3)
            {
                imbCarta4.setImageResource(juego[3]);
                imbCarta4.setEnabled(false);
            }

            if (juego_terminado[4] == 1 || cartas_selecionadas[0]==4)
            {
                imbCarta5.setImageResource(juego[4]);
                imbCarta5.setEnabled(false);
            }

            if (juego_terminado[5] == 1 || cartas_selecionadas[0]==5)
            {
                imbCarta6.setImageResource(juego[5]);
                imbCarta6.setEnabled(false);
            }

            if (juego_terminado[6] == 1 || cartas_selecionadas[0]==6)
            {
                imbCarta7.setImageResource(juego[6]);
                imbCarta7.setEnabled(false);
            }

            if (juego_terminado[7] == 1 || cartas_selecionadas[0]==7)
            {
                imbCarta8.setImageResource(juego[7]);
                imbCarta8.setEnabled(false);
            }
        }
    }


    class Hilo extends AsyncTask<Void,Integer,Void>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            imbCarta1.setEnabled(false);
            imbCarta2.setEnabled(false);
            imbCarta3.setEnabled(false);
            imbCarta4.setEnabled(false);
            imbCarta5.setEnabled(false);
            imbCarta6.setEnabled(false);
            imbCarta7.setEnabled(false);
            imbCarta8.setEnabled(false);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                Thread.sleep(300);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if(imagenes_selecionadas[0]==imagenes_selecionadas[1])
            {
                juego_terminado[cartas_selecionadas[0]]=1;
                juego_terminado[cartas_selecionadas[1]]=1;

                ganador++;

                if(ganador==4){
                    //Toast.makeText(getApplicationContext(),"!Felicidades has ganado¡",Toast.LENGTH_SHORT).show();
                    alertScoreMemo();
                }

            }

            if (juego_terminado[0] == 0)
            {
                imbCarta1.setImageResource(R.mipmap.brain_memory);
                imbCarta1.setEnabled(true);
            }

            if (juego_terminado[1] == 0)
            {
                imbCarta2.setImageResource(R.mipmap.brain_memory);
                imbCarta2.setEnabled(true);
            }

            if (juego_terminado[2] == 0)
            {
                imbCarta3.setImageResource(R.mipmap.brain_memory);
                imbCarta3.setEnabled(true);
            }

            if (juego_terminado[3] == 0)
            {
                imbCarta4.setImageResource(R.mipmap.brain_memory);
                imbCarta4.setEnabled(true);
            }

            if (juego_terminado[4] == 0)
            {
                imbCarta5.setImageResource(R.mipmap.brain_memory);
                imbCarta5.setEnabled(true);
            }

            if (juego_terminado[5] == 0)
            {
                imbCarta6.setImageResource(R.mipmap.brain_memory);
                imbCarta6.setEnabled(true);
            }

            if (juego_terminado[6] == 0)
            {
                imbCarta7.setImageResource(R.mipmap.brain_memory);
                imbCarta7.setEnabled(true);
            }

            if (juego_terminado[7] == 0)
            {
                imbCarta8.setImageResource(R.mipmap.brain_memory);
                imbCarta8.setEnabled(true);
            }

            cartas_selecionadas[0]=8;

        }
    }

    public void alertScoreMemo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView title = new TextView(getContext());
        title.setText("!Felicidades, has ganado¡");
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(40);
        builder.setMessage("¿Deseas continuar con el siguiente nivel?");
        //builder.setIcon(R.drawable.ic_logout);
        builder.setPositiveButton("SÍ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //getActivity().finish();
                MemorFragment2 mF2 = new MemorFragment2();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, mF2)
                        .addToBackStack(null)
                        .commit();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //getActivity().finish();
                HomeFragment hf = new HomeFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, hf)
                        .addToBackStack(null)
                        .commit();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCustomTitle(title);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(30);
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(25);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(25);
    }
}
