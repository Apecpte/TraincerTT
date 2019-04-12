package com.androidag.sqlitelogin.meditation;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeditaFragment1 extends Fragment {

    private ImageButton audioPosInicial;
    private ImageButton audioFrente;
    private ImageButton audioOjos;
    private ImageButton audioNariz;
    private ImageButton audioBoca;
    private ImageButton audioLengua;
    private ImageButton audioMandi;
    private ImageButton audioLabios;
    private Button goOut;
    private Button goNext;

    public MeditaFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medita_fragment1, container, false);

        final MediaPlayer posIniMP = MediaPlayer.create(getContext(), R.raw.posicion_inicial);
        final MediaPlayer frenteMP = MediaPlayer.create(getContext(), R.raw.frente);
        final MediaPlayer ojosMP = MediaPlayer.create(getContext(), R.raw.ojos);
        final MediaPlayer narizMP = MediaPlayer.create(getContext(), R.raw.nariz);
        final MediaPlayer bocaMP = MediaPlayer.create(getContext(), R.raw.boca);
        final MediaPlayer lenguaMP = MediaPlayer.create(getContext(), R.raw.lengua);
        final MediaPlayer mandiMP = MediaPlayer.create(getContext(), R.raw.mandibula);
        final MediaPlayer labiosMP = MediaPlayer.create(getContext(), R.raw.labios);

        audioPosInicial = (ImageButton) view.findViewById(R.id.imBtnMeditaAudioPosIni);
        audioFrente = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioFrente);
        audioOjos = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioOjos);
        audioNariz = (ImageButton) view.findViewById(R.id.imBtnMedita1Audionariz);
        audioBoca = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioBoca);
        audioLengua = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioLengua);
        audioMandi = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioMandi);
        audioLabios = (ImageButton) view.findViewById(R.id.imBtnMedita1AudioLabios);

        goOut = (Button) view.findViewById(R.id.buttonGoOutMedita1);
        goNext = (Button) view.findViewById(R.id.buttonNextMedita1);

        audioPosInicial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                posIniMP.start();
            }
        });

        audioFrente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frenteMP.start();
            }
        });

        audioOjos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ojosMP.start();
            }
        });

        audioNariz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                narizMP.start();
            }
        });

        audioBoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bocaMP.start();
            }
        });

        audioLengua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lenguaMP.start();
            }
        });

        audioMandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mandiMP.start();
            }
        });

        audioLabios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                labiosMP.start();
            }
        });

        goOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment hf = new HomeFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, hf)
                        .addToBackStack(null)
                        .commit();
            }
        });

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeditaFragment2 m2f = new MeditaFragment2();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m2f)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}
