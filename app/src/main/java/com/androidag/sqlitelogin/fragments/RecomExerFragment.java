package com.androidag.sqlitelogin.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidag.sqlitelogin.Food.RecomFoodFragment2;
import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.Relax.RecomExerFragment2;

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
}
