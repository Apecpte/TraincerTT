package com.androidag.sqlitelogin.exercises;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
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
public class SplashLanguageFragment extends Fragment {

    private Button btnStartMemo;
    //private ImageButton audioInstLanguage;

    public SplashLanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_language, container, false);

//        final MediaPlayer languageMP = MediaPlayer.create(getContext(), R.raw.completaPalabra);

        btnStartMemo = (Button) view.findViewById(R.id.buttonStartMemo);
  /*      audioInstLanguage = (ImageButton) view.findViewById(R.id.languageButtonInst);

        audioInstLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                languageMP.start();
            }
        });
*/
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
