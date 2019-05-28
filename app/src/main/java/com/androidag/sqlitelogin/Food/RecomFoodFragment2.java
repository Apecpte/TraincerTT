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
import com.androidag.sqlitelogin.fragments.RecomFoodFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecomFoodFragment2 extends Fragment implements View.OnClickListener {

    private Button btnLeftFood;
    private Button btnRightFood;
    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private Button btnYT;
    private ViewFlipper viewFlipper2;
    private ImageButton audioAli_2;
    private MediaPlayer ali_2_MP;

    public RecomFoodFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom_food_fragment2, container, false);

        ali_2_MP = MediaPlayer.create(getContext(), R.raw.ali_frutas);

        btnLeftFood = (Button) view.findViewById(R.id.btnLeftFood2);
        btnRightFood = (Button) view.findViewById(R.id.btnRightFood2);
        btnGoOut = (Button) view.findViewById(R.id.buttonGoOut);
        btnBack = (Button) view.findViewById(R.id.buttonBack);
        btnNext = (Button) view.findViewById(R.id.buttonNext);
        btnYT = (Button) view.findViewById(R.id.btnYT);
        viewFlipper2 = (ViewFlipper) view.findViewById(R.id.viewFlipperFood2);

        audioAli_2 = (ImageButton) view.findViewById(R.id.imBtnRecomAliAudio2);

        audioAli_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ali_2_MP.start();
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
            case R.id.btnLeftFood2:
                viewFlipper2.showPrevious();
                break;

            case R.id.btnRightFood2:
                viewFlipper2.showNext();
                break;

            case R.id.buttonGoOut:
                ali_2_MP.stop();
                fragment = new HomeFragment();
                fragmentTransaction = true;
                break;

            case R.id.buttonBack:
                ali_2_MP.stop();
                fragment = new RecomFoodFragment();
                fragmentTransaction = true;
                break;

            case R.id.buttonNext:
                ali_2_MP.stop();
                fragment = new RecomFoodFragment3();
                fragmentTransaction = true;
                break;

            case R.id.btnYT:
                ali_2_MP.stop();
                youtubeFyV("qbXoxyIcxug");
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

    public void youtubeFyV(String id) {
        //id = "uD_2jTSb4aY";
        Intent youtubeFishIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        startActivity(youtubeFishIntent);
    }
}
