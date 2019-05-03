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
public class SplashAtentionFragment extends Fragment {

    private Button btnStartAtention;
    private ImageButton audioInstAtention;

    public SplashAtentionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_splash_atention, container, false);

        final MediaPlayer atentionMP = MediaPlayer.create(getContext(), R.raw.invierte_numeros);

        btnStartAtention = (Button) view.findViewById(R.id.buttonStartAtention);
        audioInstAtention = (ImageButton) view.findViewById(R.id.atentionButtonInst);

        audioInstAtention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atentionMP.start();
            }
        });

        btnStartAtention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AtentionFragment aF = new AtentionFragment();
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
