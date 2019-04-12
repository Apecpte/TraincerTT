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
public class SplashPerceFragment extends Fragment {

    private Button btnStartPerce;

    public SplashPerceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_perce, container, false);

        btnStartPerce = (Button) view.findViewById(R.id.buttonStartPerce);

        btnStartPerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerceFragment p1F = new PerceFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, p1F)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
