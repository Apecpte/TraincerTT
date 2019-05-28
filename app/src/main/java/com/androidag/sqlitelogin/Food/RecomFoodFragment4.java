package com.androidag.sqlitelogin.Food;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecomFoodFragment4 extends Fragment implements View.OnClickListener {

    private Button btnLeftFood;
    private Button btnRightFood;
    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private Button btnYT;
    private ViewFlipper viewFlipper4;
    private ImageButton audioAli_4;
    private MediaPlayer ali_4_MP;

    public RecomFoodFragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recom_food_fragment4, container, false);

        ali_4_MP = MediaPlayer.create(getContext(), R.raw.ali_frutos_secos);

        btnLeftFood = (Button) view.findViewById(R.id.btnLeftFood4);
        btnRightFood = (Button) view.findViewById(R.id.btnRightFood4);
        btnGoOut = (Button) view.findViewById(R.id.buttonGoOut);
        btnNext = (Button) view.findViewById(R.id.buttonNext);
        btnBack = (Button) view.findViewById(R.id.buttonBack);
        btnYT = (Button) view.findViewById(R.id.btnYT);
        viewFlipper4 = (ViewFlipper) view.findViewById(R.id.viewFlipperFood4);

        audioAli_4 = (ImageButton) view.findViewById(R.id.imBtnRecomAliAudio4);

        audioAli_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ali_4_MP.start();
            }
        });

        btnLeftFood.setOnClickListener(this);
        btnRightFood.setOnClickListener(this);
        btnGoOut.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnYT.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.btnLeftFood4:
                viewFlipper4.showPrevious();
                break;

            case R.id.btnRightFood4:
                viewFlipper4.showNext();
                break;

            case R.id.buttonGoOut:
                ali_4_MP.stop();
                fragment = new HomeFragment();
                fragmentTransaction = true;
                break;

            case R.id.buttonBack:
                ali_4_MP.stop();
                fragment = new RecomFoodFragment3();
                fragmentTransaction = true;
                break;

            case R.id.buttonNext:
                ali_4_MP.stop();
                fragment = new RecomFoodFragment5();
                fragmentTransaction = true;
                break;

            case R.id.btnYT:
                ali_4_MP.stop();
                youtubeFish("eG4MK8dm3uk");
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

    public void youtubeFish(String id) {
        //id = "uD_2jTSb4aY";
        Intent youtubeFishIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        startActivity(youtubeFishIntent);
    }
}
