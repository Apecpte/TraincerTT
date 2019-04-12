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
public class MeditaFragment2 extends Fragment {

    private ImageButton audioTorax;
    private ImageButton audioEspalda;
    private ImageButton audioEstomago;
    private ImageButton audioCintura;
    private Button goOut;
    private Button goBack;
    private Button goNext;

    public MeditaFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medita_fragment2, container, false);

        final MediaPlayer toraxMP = MediaPlayer.create(getContext(), R.raw.torax);
        final MediaPlayer espaldaMP = MediaPlayer.create(getContext(), R.raw.espalda);
        final MediaPlayer estoMP = MediaPlayer.create(getContext(), R.raw.estomago);
        final MediaPlayer cinturaMP = MediaPlayer.create(getContext(), R.raw.cintura);

        audioTorax = (ImageButton) view.findViewById(R.id.imBtnMedita2AudioTorax);
        audioEspalda = (ImageButton) view.findViewById(R.id.imBtnMedita2AudioEspalda);
        audioEstomago = (ImageButton) view.findViewById(R.id.imBtnMedita2AudioEsto);
        audioCintura = (ImageButton) view.findViewById(R.id.imBtnMedita2AudioCintura);

        goOut = (Button) view.findViewById(R.id.buttonGoOutMedita2);
        goBack = (Button) view.findViewById(R.id.buttonBackMedita2);
        goNext = (Button) view.findViewById(R.id.buttonNextMedita2);

        audioTorax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toraxMP.start();
            }
        });

        audioEspalda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                espaldaMP.start();
            }
        });

        audioEstomago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                estoMP.start();
            }
        });

        audioCintura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cinturaMP.start();
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

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeditaFragment1 m1f = new MeditaFragment1();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m1f)
                        .addToBackStack(null)
                        .commit();
            }
        });

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeditaFragment3 m3f = new MeditaFragment3();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m3f)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
