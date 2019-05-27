package com.androidag.sqlitelogin.RecomExer;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.HomeFragment;
import com.androidag.sqlitelogin.fragments.NivelExerFragment;
import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recom3ExerFragment5 extends Fragment implements View.OnClickListener {

    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private ImageButton audioEjerF3_5;

    public Recom3ExerFragment5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom3_exer_fragment5, container, false);

        final MediaPlayer ejerF3_5_MP = MediaPlayer.create(getContext(), R.raw.ejer_f3_flex_ext_rodilla);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView3GifExer);
        imageView.setImageResource(R.drawable.re3_flexionrodilla);

        btnGoOut = (Button) view.findViewById(R.id.button3GoOut);
        btnNext = (Button) view.findViewById(R.id.button3Next);
        btnBack = (Button) view.findViewById(R.id.button3Back);
        audioEjerF3_5 = (ImageButton) view.findViewById(R.id.imBtnRecomExer3Audio5);

        audioEjerF3_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejerF3_5_MP.start();
            }
        });

        btnGoOut.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.button3GoOut:
                fragment = new NivelExerFragment();
                fragmentTransaction = true;
                break;

            case R.id.button3Back:
                fragment = new Recom3ExerFragment4();
                fragmentTransaction = true;
                break;

            case R.id.button3Next:
                fragment = new Recom3ExerFragment6();
                fragmentTransaction = true;
                break;
        }
        if (fragmentTransaction) {
            changeFragment(fragment);
        }
    }

    private void changeFragment(Fragment fragment) {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
    }
}
