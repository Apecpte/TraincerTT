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
public class SplashMemoFragment extends Fragment {

    private Chronometer chronometer1;
    private ImageButton audioInstMemo;
    private MediaPlayer memoMP;

    public SplashMemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_memo, container, false);

        memoMP = MediaPlayer.create(getContext(), R.raw.de_15segundos);

        chronometer1 = view.findViewById(R.id.chronometerMemo1);
        audioInstMemo = (ImageButton) view.findViewById(R.id.memoButtonInst);

        audioInstMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memoMP.start();
            }
        });


        chronometer1.start();
        chronometer1.setBase(SystemClock.elapsedRealtime());

        chronometer1.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if ((SystemClock.elapsedRealtime() - chronometer1.getBase()) >= 15000) {
                    chronometer1.setBase(SystemClock.elapsedRealtime());
                    memoMP.stop();
                    MemoFragment m1F = new MemoFragment();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, m1F)
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
                MemoFragment m1F = new MemoFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m1F)
                        .addToBackStack(null)
                        .commit();

            }
        };

        handler.postDelayed(runnable, 15000);
        */
        // Inflate the layout for this fragment
        return view;
    }

}
