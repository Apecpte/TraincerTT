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
public class Recom2ExerFragment6 extends Fragment implements View.OnClickListener{

    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private ImageButton audioEjerF2_6;
    private MediaPlayer ejerF2_6_MP;

    public Recom2ExerFragment6() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom2_exer_fragment6, container, false);

        ejerF2_6_MP = MediaPlayer.create(getContext(), R.raw.ejer_f2_ejer_rodillas_2);

        ImageView imageView = (ImageView) view.findViewById (R.id.imageView2GifExer);

        Glide.with(getContext()).load(R.drawable.re2_silla2).into(imageView);

        btnGoOut = (Button) view.findViewById(R.id.button2GoOut);
        btnNext = (Button) view.findViewById(R.id.button2Next);
        btnBack = (Button) view.findViewById(R.id.button2Back);
        audioEjerF2_6 = (ImageButton) view.findViewById(R.id.imBtnRecomExer2Audio6);

        audioEjerF2_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejerF2_6_MP.start();
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
            case R.id.button2GoOut:
                ejerF2_6_MP.stop();
                fragment = new NivelExerFragment();
                fragmentTransaction = true;
                break;

            case R.id.button2Back:
                ejerF2_6_MP.stop();
                fragment = new Recom2ExerFragment5();
                fragmentTransaction = true;
                break;

            case R.id.button2Next:
                ejerF2_6_MP.stop();
                fragment = new Recom2ExerFragment7();
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
