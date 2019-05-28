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
public class RecomExerFragment4 extends Fragment implements View.OnClickListener {

    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private ImageButton audioEjerF1_4;
    private MediaPlayer ejerF1_4_MP;

    public RecomExerFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recom_exer_fragment4, container, false);

        ejerF1_4_MP = MediaPlayer.create(getContext(), R.raw.ejer_f1_flex_tronco);

        ImageView imageView = (ImageView) view.findViewById (R.id.imageViewGifExer);

        Glide.with(getContext()).load(R.drawable.re1_caderalado).into(imageView);

        btnGoOut = (Button) view.findViewById(R.id.buttonGoOut);
        btnNext = (Button) view.findViewById(R.id.buttonNext);
        btnBack = (Button) view.findViewById(R.id.buttonBack);
        audioEjerF1_4 = (ImageButton) view.findViewById(R.id.imBtnRecomExer1Audio4);

        audioEjerF1_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejerF1_4_MP.start();
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
            case R.id.buttonGoOut:
                ejerF1_4_MP.stop();
                fragment = new NivelExerFragment();
                fragmentTransaction = true;
                break;

            case R.id.buttonBack:
                ejerF1_4_MP.stop();
                fragment = new RecomExerFragment3();
                fragmentTransaction = true;
                break;

            case R.id.buttonNext:
                ejerF1_4_MP.stop();
                fragment = new RecomExerFragment5();
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
