package com.androidag.sqlitelogin.exercises;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashMemo2Fragment extends Fragment {

    private Chronometer chronometer2;
    private ImageButton audioInstMemo2;

    public SplashMemo2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_memo2, container, false);

        final MediaPlayer memo2MP = MediaPlayer.create(getContext(), R.raw.de_10segundos);

        chronometer2 = view.findViewById(R.id.chronometerMemo2);
        audioInstMemo2 = (ImageButton) view.findViewById(R.id.memo2ButtonInst);

        audioInstMemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memo2MP.start();
            }
        });


        chronometer2.start();
        chronometer2.setBase(SystemClock.elapsedRealtime());

        chronometer2.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer2.getBase()) >= 10000) {
                    chronometer2.setBase(SystemClock.elapsedRealtime());
                    MemoFragment2 m2F = new MemoFragment2();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, m2F)
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
        /*
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //Second fragment after 15 seconds appears
                MemoFragment2 m2F = new MemoFragment2();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m2F)
                        .addToBackStack(null)
                        .commit();

            }
        };

        handler.postDelayed(runnable, 10000);
        */
        // Inflate the layout for this fragment
        return view;
    }

}
