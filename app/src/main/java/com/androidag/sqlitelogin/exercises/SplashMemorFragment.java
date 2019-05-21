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
public class SplashMemorFragment extends Fragment {

    private Button btnStartMemor;
    private ImageButton audioInstMemor;

    public SplashMemorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_memor, container, false);

        final MediaPlayer memorMP = MediaPlayer.create(getContext(), R.raw.memorama1);

        btnStartMemor = (Button) view.findViewById(R.id.buttonStartMemor);
        audioInstMemor = (ImageButton) view.findViewById(R.id.memorButtonInst);

        audioInstMemor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memorMP.start();
            }
        });

        btnStartMemor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MemorFragment m2F = new MemorFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, m2F)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
