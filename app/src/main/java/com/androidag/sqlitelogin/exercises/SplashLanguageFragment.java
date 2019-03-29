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
public class SplashLanguageFragment extends Fragment {


    public SplashLanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_language, container, false);

        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //Second fragment after 5 seconds appears
                LanguageFragment l1F = new LanguageFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, l1F)
                        .addToBackStack(null)
                        .commit();

            }
        };

        handler.postDelayed(runnable, 10000);
        // Inflate the layout for this fragment
        return view;
    }

}
