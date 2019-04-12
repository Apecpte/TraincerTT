package com.androidag.sqlitelogin.exercises;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashScrabbleLanguageFragment extends Fragment {

    private Button btnStartMemoSc;

    public SplashScrabbleLanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_scrabble_language, container, false);

        btnStartMemoSc = (Button) view.findViewById(R.id.buttonStartMemoSc);

        btnStartMemoSc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageFragment lF = new LanguageFragment();
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
