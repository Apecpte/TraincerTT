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
public class Recom2ExerFragment3 extends Fragment implements View.OnClickListener {

    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private ImageButton audioEjerF2_3;

    public Recom2ExerFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom2_exer_fragment3, container, false);

        final MediaPlayer ejerF2_3_MP = MediaPlayer.create(getContext(), R.raw.ejer_f2_ejer_hombros);

        ImageView imageView = (ImageView) view.findViewById (R.id.imageView2GifExer);

        Glide.with(getContext()).load(R.drawable.re2_brazogiro).into(imageView);

        btnGoOut = (Button) view.findViewById(R.id.button2GoOut);
        btnNext = (Button) view.findViewById(R.id.button2Next);
        btnBack = (Button) view.findViewById(R.id.button2Back);
        audioEjerF2_3 = (ImageButton) view.findViewById(R.id.imBtnRecomExer2Audio3);

        audioEjerF2_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejerF2_3_MP.start();
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
                fragment = new NivelExerFragment();
                fragmentTransaction = true;
                break;

            case R.id.button2Back:
                fragment = new Recom2ExerFragment2();
                fragmentTransaction = true;
                break;

            case R.id.button2Next:
                fragment = new Recom2ExerFragment4();
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
