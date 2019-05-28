package com.androidag.sqlitelogin.RecomExer;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.HomeFragment;
import com.androidag.sqlitelogin.fragments.NivelExerFragment;
import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recom2ExerFragment7 extends Fragment implements View.OnClickListener {

    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private ImageButton audioEjerF2_7;
    private MediaPlayer ejerF2_7_MP;

    public Recom2ExerFragment7() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_recom2_exer_fragment7, container, false);

        ejerF2_7_MP = MediaPlayer.create(getContext(), R.raw.ejer_f2_botar_balon);

        ImageView imageView = (ImageView) view.findViewById (R.id.imageView2GifExer);

        Glide.with(getContext()).load(R.drawable.re2_bote).into(imageView);

        btnGoOut = (Button) view.findViewById(R.id.button2GoOut);
        btnNext = (Button) view.findViewById(R.id.button2Next);
        btnBack = (Button) view.findViewById(R.id.button2Back);
        audioEjerF2_7 = (ImageButton) view.findViewById(R.id.imBtnRecomExer2Audio7);

        audioEjerF2_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejerF2_7_MP.start();
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
                ejerF2_7_MP.stop();
                fragment = new HomeFragment();
                fragmentTransaction = true;
                break;

            case R.id.button2Back:
                ejerF2_7_MP.stop();
                fragment = new Recom2ExerFragment6();
                fragmentTransaction = true;
                break;

            case R.id.button2Next:
                ejerF2_7_MP.stop();
                gameOver();
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

    private void gameOver(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView title = new TextView(getContext());
        builder.setMessage("¿Deseas continuar con la fase 3?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //getActivity().finish();
                Recom3ExerFragment r3ef = new Recom3ExerFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, r3ef)
                        .addToBackStack(null)
                        .commit();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //getActivity().finish();
                NivelExerFragment hf = new NivelExerFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, hf)
                        .addToBackStack(null)
                        .commit();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textViewAlert = (TextView) dialog.findViewById(android.R.id.message);
        textViewAlert.setTextSize(40);
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(25);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(25);
    }
}
