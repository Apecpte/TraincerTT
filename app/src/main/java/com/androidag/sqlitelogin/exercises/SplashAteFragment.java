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
public class SplashAteFragment extends Fragment {

    private Button btnStartAte;
    private ImageButton audioInstAte;

    public SplashAteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_ate, container, false);

        final MediaPlayer ateMP = MediaPlayer.create(getContext(), R.raw.cuantos_objetos1);

        btnStartAte = (Button) view.findViewById(R.id.buttonStartAte);
        audioInstAte = (ImageButton) view.findViewById(R.id.ateButtonInst);

        audioInstAte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ateMP.start();
            }
        });

        btnStartAte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AteFragment aF = new AteFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, aF)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
