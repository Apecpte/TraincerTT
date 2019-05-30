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
public class SplashMathsFragment extends Fragment {

    private Button btnStartMaths;
    private ImageButton audioInstMaths;
    private MediaPlayer mathsMP;

    public SplashMathsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_maths, container, false);

        mathsMP = MediaPlayer.create(getContext(), R.raw.op_arimeticas1);

        btnStartMaths = (Button) view.findViewById(R.id.buttonStartMaths);
        audioInstMaths = (ImageButton) view.findViewById(R.id.mathsButtonInst);

        audioInstMaths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathsMP.start();
            }
        });

        btnStartMaths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathsMP.stop();
                MathsFragment m1F = new MathsFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m1F)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
