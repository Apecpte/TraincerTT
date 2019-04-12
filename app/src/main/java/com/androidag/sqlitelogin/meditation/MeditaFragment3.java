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
public class MeditaFragment3 extends Fragment {

    private ImageButton audioFase2;
    private Button goOut;
    private Button goBack;
    private Button goNext;

    public MeditaFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medita_fragment3, container, false);

        final MediaPlayer fase2MP = MediaPlayer.create(getContext(), R.raw.repaso);

        audioFase2 = (ImageButton) view.findViewById(R.id.imBtnMedita3AudioFase2);

        goOut = (Button) view.findViewById(R.id.buttonGoOutMedita3);
        goBack = (Button) view.findViewById(R.id.buttonBackMedita3);
        goNext = (Button) view.findViewById(R.id.buttonNextMedita3);

        audioFase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fase2MP.start();
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
                MeditaFragment2 m2f = new MeditaFragment2();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m2f)
                        .addToBackStack(null)
                        .commit();
            }
        });

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeditaFragment4 m4f = new MeditaFragment4();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m4f)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
