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
public class MeditaFragment4 extends Fragment {

    private ImageButton audioFase3;
    private Button goOut;
    private Button goBack;
    private Button goNext;

    public MeditaFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medita_fragment4, container, false);

        final MediaPlayer fase3MP = MediaPlayer.create(getContext(), R.raw.medi_relaxmental);

        audioFase3 = (ImageButton) view.findViewById(R.id.imBtnMedita4AudioFase3);

        goOut = (Button) view.findViewById(R.id.buttonGoOutMedita4);
        goBack = (Button) view.findViewById(R.id.buttonBackMedita4);
        goNext = (Button) view.findViewById(R.id.buttonNextMedita4);

        audioFase3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fase3MP.start();
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
                MeditaFragment3 m3f = new MeditaFragment3();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m3f)
                        .addToBackStack(null)
                        .commit();
            }
        });

        goNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MeditaFragment1 m1F = new MeditaFragment1();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m1F)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
