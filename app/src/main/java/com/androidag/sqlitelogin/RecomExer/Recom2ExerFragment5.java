package com.androidag.sqlitelogin.RecomExer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.HomeFragment;
import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recom2ExerFragment5 extends Fragment implements View.OnClickListener {

    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;

    public Recom2ExerFragment5() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom2_exer_fragment5, container, false);

        ImageView imageView = (ImageView) view.findViewById (R.id.imageView2GifExer);

        Glide.with(getContext()).load(R.drawable.re2_silla1).into(imageView);

        btnGoOut = (Button) view.findViewById(R.id.button2GoOut);
        btnNext = (Button) view.findViewById(R.id.button2Next);
        btnBack = (Button) view.findViewById(R.id.button2Back);

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
                fragment = new HomeFragment();
                fragmentTransaction = true;
                break;

            case R.id.button2Back:
                fragment = new Recom2ExerFragment4();
                fragmentTransaction = true;
                break;

            case R.id.button2Next:
                fragment = new Recom2ExerFragment6();
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
