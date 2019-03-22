package com.androidag.sqlitelogin.fragments;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.RecomExer.Recom2ExerFragment;
import com.androidag.sqlitelogin.RecomExer.Recom3ExerFragment;
import com.androidag.sqlitelogin.RecomExer.RecomExerFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class NivelExerFragment extends Fragment implements View.OnClickListener{

    private Button exerN1;
    private Button exerN2;
    private Button exerN3;

    public NivelExerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nivel_exer, container, false);

        alertRecomRelax();

        exerN1 = (Button) view.findViewById(R.id.buttonExerN1);
        exerN2 = (Button) view.findViewById(R.id.buttonExerN2);
        exerN3 = (Button) view.findViewById(R.id.buttonExerN3);

        exerN1.setOnClickListener(this);
        exerN2.setOnClickListener(this);
        exerN3.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {

            case R.id.buttonExerN1:
                fragment = new RecomExerFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonExerN2:
                fragment = new Recom2ExerFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonExerN3:
                fragment = new Recom3ExerFragment();
                fragmentTransaction = true;
                break;
        }
        if (fragmentTransaction) {
            changeFragment(fragment);
        }

    }

    private void changeFragment(Fragment fragment) {
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
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
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(40);
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
    }
}
