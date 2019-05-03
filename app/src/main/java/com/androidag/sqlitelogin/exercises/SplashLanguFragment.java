package com.androidag.sqlitelogin.exercises;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashLanguFragment extends Fragment {

    private Button btnStartLangu;
    private ImageButton audioInstLangu;

    public SplashLanguFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_splash_langu, container, false);

        final MediaPlayer languMP = MediaPlayer.create(getContext(), R.raw.resp_preguntas);

        btnStartLangu = (Button) view.findViewById(R.id.buttonStartLangu);
        audioInstLangu = (ImageButton) view.findViewById(R.id.languButtonInst);

        audioInstLangu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                languMP.start();
            }
        });

        btnStartLangu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguFragment lF = new LanguFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, lF)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
