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
public class SplashMemo3Fragment extends Fragment {

    private Chronometer chronometer3;
    private ImageButton audioInstMemo3;

    public SplashMemo3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_memo3, container, false);

        final MediaPlayer memo3MP = MediaPlayer.create(getContext(), R.raw.de_5segundos);

        chronometer3 = view.findViewById(R.id.chronometerMemo3);
        audioInstMemo3 = (ImageButton) view.findViewById(R.id.memo3ButtonInst);

        audioInstMemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memo3MP.start();
            }
        });

        chronometer3.start();
        chronometer3.setBase(SystemClock.elapsedRealtime());

        chronometer3.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer3.getBase()) >= 5000) {
                    chronometer3.setBase(SystemClock.elapsedRealtime());
                    MemoFragment3 m3F = new MemoFragment3();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, m3F)
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
                MemoFragment3 m3F = new MemoFragment3();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m3F)
                        .addToBackStack(null)
                        .commit();

            }
        };

        handler.postDelayed(runnable, 5000);
        */
        // Inflate the layout for this fragment
        return view;
    }

}
