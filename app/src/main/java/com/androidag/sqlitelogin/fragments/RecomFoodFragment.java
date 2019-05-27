package com.androidag.sqlitelogin.fragments;


import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.androidag.sqlitelogin.Food.RecomFoodFragment2;
import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecomFoodFragment extends Fragment implements View.OnClickListener {

    private Button btnLeftFood;
    private Button btnRightFood;
    private Button btnGoOut;
    private Button btnNext;
    private Button btnYT;
    private ViewFlipper viewFlipper1;
    private ImageButton audioAli_1;

    public RecomFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom_food, container, false);

        alertRecomFood();

        final MediaPlayer ali_1_MP = MediaPlayer.create(getContext(), R.raw.ali_pescado);

        btnLeftFood = (Button) view.findViewById(R.id.btnLeftFood1);
        btnRightFood = (Button) view.findViewById(R.id.btnRightFood1);
        btnGoOut = (Button) view.findViewById(R.id.buttonGoOut);
        btnNext = (Button) view.findViewById(R.id.buttonNext);
        btnYT = (Button) view.findViewById(R.id.btnYT);
        viewFlipper1 = (ViewFlipper) view.findViewById(R.id.viewFlipperFood1);

        audioAli_1 = (ImageButton) view.findViewById(R.id.imBtnRecomAliAudio1);

        audioAli_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ali_1_MP.start();
            }
        });

        btnLeftFood.setOnClickListener(this);
        btnRightFood.setOnClickListener(this);
        btnGoOut.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnYT.setOnClickListener(this);
        //img1.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.btnLeftFood1:
                viewFlipper1.showPrevious();
                break;

            case R.id.btnRightFood1:
                viewFlipper1.showNext();
                break;

            case R.id.buttonGoOut:
                fragment = new HomeFragment();
                fragmentTransaction = true;
                break;

            case R.id.buttonNext:
                fragment = new RecomFoodFragment2();
                fragmentTransaction = true;
                break;

            case R.id.btnYT:
                youtubeFish("uD_2jTSb4aY");
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

    public void alertRecomFood() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setTitle("Cerrar Sesión");
        builder.setMessage(R.string.FoodSlogan);
        //builder.setIcon(R.drawable.ic_logout);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(40);
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
    }

}

