package com.androidag.sqlitelogin.exercises;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashLanguageFragment extends Fragment {

    private Button btnStartMemo;

    public SplashLanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_language, container, false);

        btnStartMemo = (Button) view.findViewById(R.id.buttonStartMemo);

        btnStartMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageFragment2 l2F = new LanguageFragment2();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, l2F)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
