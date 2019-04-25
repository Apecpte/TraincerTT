package com.androidag.sqlitelogin.exercises;


import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashMemo3Fragment extends Fragment {

    private Chronometer chronometer3;

    public SplashMemo3Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_memo3, container, false);

        chronometer3 = view.findViewById(R.id.chronometerMemo3);

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
