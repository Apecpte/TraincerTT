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
public class RecomFoodFragment3 extends Fragment implements View.OnClickListener {

    private Button btnLeftFood;
    private Button btnRightFood;
    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private Button btnYT;
    private ViewFlipper viewFlipper3;
    private ImageButton audioAli_3;
    private MediaPlayer ali_3_MP;

    public RecomFoodFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom_food_fragment3, container, false);

        ali_3_MP = MediaPlayer.create(getContext(), R.raw.ali_legumbres);

        btnLeftFood = (Button) view.findViewById(R.id.btnLeftFood3);
        btnRightFood = (Button) view.findViewById(R.id.btnRightFood3);
        btnGoOut = (Button) view.findViewById(R.id.buttonGoOut);
        btnNext = (Button) view.findViewById(R.id.buttonNext);
        btnBack = (Button) view.findViewById(R.id.buttonBack);
        btnYT = (Button) view.findViewById(R.id.btnYT);
        viewFlipper3 = (ViewFlipper) view.findViewById(R.id.viewFlipperFood3);

        audioAli_3 = (ImageButton) view.findViewById(R.id.imBtnRecomAliAudio3);

        audioAli_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ali_3_MP.start();
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
            case R.id.btnLeftFood3:
                viewFlipper3.showPrevious();
                break;

            case R.id.btnRightFood3:
                viewFlipper3.showNext();
                break;

            case R.id.buttonGoOut:
                ali_3_MP.stop();
                fragment = new HomeFragment();
                fragmentTransaction = true;
                break;

            case R.id.buttonBack:
                ali_3_MP.stop();
                fragment = new RecomFoodFragment2();
                fragmentTransaction = true;
                break;

            case R.id.buttonNext:
                ali_3_MP.stop();
                fragment = new RecomFoodFragment4();
                fragmentTransaction = true;
                break;

            case R.id.btnYT:
                ali_3_MP.stop();
                youtubeFish("cPfZU_iKmaI");
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
