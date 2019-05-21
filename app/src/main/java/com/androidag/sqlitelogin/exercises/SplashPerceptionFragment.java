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
public class SplashPerceptionFragment extends Fragment {

    private Button btnStartPerception;
    private ImageButton audioInstPerception;

    public SplashPerceptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_perception, container, false);

        final MediaPlayer perceptionMP = MediaPlayer.create(getContext(), R.raw.relaciona_imagen1);

        btnStartPerception = (Button) view.findViewById(R.id.buttonStartPerception);
        audioInstPerception = (ImageButton) view.findViewById(R.id.perceptionButtonInst);

        audioInstPerception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perceptionMP.start();
            }
        });

        btnStartPerception.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerceptionFragment per1F = new PerceptionFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, per1F)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
