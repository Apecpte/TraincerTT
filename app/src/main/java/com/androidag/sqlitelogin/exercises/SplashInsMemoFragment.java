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
public class SplashInsMemoFragment extends Fragment {

    private Button btnStartMemo;
    private ImageButton audioInstMemo;
    //private ImageButton audioInstLanguage;

    public SplashInsMemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_inst_memo, container, false);

        final MediaPlayer memoMP = MediaPlayer.create(getContext(), R.raw.donde_esta_inst);

        btnStartMemo = (Button) view.findViewById(R.id.buttonStartMemoSplash);
        audioInstMemo = (ImageButton) view.findViewById(R.id.memoSplashButtonInst);

        audioInstMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                memoMP.start();
            }
        });

        btnStartMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SplashMemoFragment smF1 = new SplashMemoFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, smF1)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
