package com.androidag.sqlitelogin.RecomExer;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class Recom3ExerFragment7 extends Fragment implements View.OnClickListener {

    private Button btnGoOut;
    private Button btnNext;
    private Button btnBack;
    private ImageButton audioEjerF3_7;
    private MediaPlayer ejerF3_7_MP;

    public Recom3ExerFragment7() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom3_exer_fragment7, container, false);

        ejerF3_7_MP = MediaPlayer.create(getContext(), R.raw.ejer_f3_flex_ext_tronco);

        ImageView imageView = (ImageView) view.findViewById (R.id.imageView3GifExer);

        Glide.with(getContext()).load(R.drawable.re3_flexiontronco).into(imageView);

        btnGoOut = (Button) view.findViewById(R.id.button3GoOut);
        btnNext = (Button) view.findViewById(R.id.button3Next);
        btnBack = (Button) view.findViewById(R.id.button3Back);
        audioEjerF3_7 = (ImageButton) view.findViewById(R.id.imBtnRecomExer3Audio7);

        audioEjerF3_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ejerF3_7_MP.start();
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
                ejerF3_7_MP.stop();
                fragment = new NivelExerFragment();
                fragmentTransaction = true;
                break;

            case R.id.button3Back:
                ejerF3_7_MP.stop();
                fragment = new Recom3ExerFragment6();
                fragmentTransaction = true;
                break;

            case R.id.button3Next:
                ejerF3_7_MP.stop();
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
        builder.setMessage("¿Deseas regresar a la fase 1?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //getActivity().finish();
                RecomExerFragment ref = new RecomExerFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, ref)
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
