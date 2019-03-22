package com.androidag.sqlitelogin.exercises;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashAtentionFragment extends Fragment {


    public SplashAtentionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_atention, container, false);

      /*  AtentionFragment aF = new AtentionFragment();
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, aF)
                .addToBackStack(null)
                .commit(); */

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //Second fragment after 5 seconds appears
                AtentionFragment aF = new AtentionFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, aF)
                        .addToBackStack(null)
                        .commit();

            }
        };

        handler.postDelayed(runnable, 5000);

        // Inflate the layout for this fragment
        return view;
    }
}
