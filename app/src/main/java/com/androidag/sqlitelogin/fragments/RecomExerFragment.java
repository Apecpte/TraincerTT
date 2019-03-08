package com.androidag.sqlitelogin.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.RecomExer.RecomExerFragment2;
import com.bumptech.glide.Glide;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecomExerFragment extends Fragment implements View.OnClickListener {

    private Button btnGoOut;
    private Button btnNext;

    public RecomExerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recom_exer, container, false);

        ImageView imageView = (ImageView) view.findViewById (R.id.imageViewGifExer);

        Glide.with(getContext()).load(R.drawable.re_rodillas).into(imageView);


        alertRecomRelax();

        btnGoOut = (Button) view.findViewById(R.id.buttonGoOut);
        btnNext = (Button) view.findViewById(R.id.buttonNext);

        btnGoOut.setOnClickListener(this);
        btnNext.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {

        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {
            case R.id.buttonGoOut:
                fragment = new HomeFragment();
                fragmentTransaction = true;
                break;

            case R.id.buttonNext:
                fragment = new RecomExerFragment2();
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

    public void alertRecomRelax() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setTitle("Cerrar Sesión");
        builder.setMessage(R.string.Exerlogan);
        //builder.setIcon(R.drawable.ic_logout);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(30);
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
    }
}
