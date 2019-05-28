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
public class Recom3ExerFragment2 extends Fragment implements View.OnClickListener {

    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private ImageButton audioEjerF3_2;
    private MediaPlayer ejerF3_2_MP;

    public Recom3ExerFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom3_exer_fragment2, container, false);

        ejerF3_2_MP = MediaPlayer.create(getContext(), R.raw.ejer_f3_circ_hombros);

        ImageView imageView = (ImageView) view.findViewById (R.id.imageView3GifExer);
        imageView.setImageResource(R.drawable.re3_circhombros);

        btnGoOut = (Button) view.findViewById(R.id.button3GoOut);
        btnNext = (Button) view.findViewById(R.id.button3Next);
        btnBack = (Button) view.findViewById(R.id.button3Back);
        audioEjerF3_2 = (ImageButton) view.findViewById(R.id.imBtnRecomExer3Audio2);

        audioEjerF3_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejerF3_2_MP.start();
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
                ejerF3_2_MP.stop();
                fragment = new NivelExerFragment();
                fragmentTransaction = true;
                break;

            case R.id.button3Back:
                ejerF3_2_MP.stop();
                fragment = new Recom3ExerFragment();
                fragmentTransaction = true;
                break;

            case R.id.button3Next:
                ejerF3_2_MP.stop();
                fragment = new Recom3ExerFragment3();
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
