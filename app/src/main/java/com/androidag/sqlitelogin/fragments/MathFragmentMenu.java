package com.androidag.sqlitelogin.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.exercises.SplashMathsFragment;
import com.androidag.sqlitelogin.exercises.SplashMoneyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MathFragmentMenu extends Fragment implements View.OnClickListener {

    private ImageButton btnMaths;
    private ImageButton btnMoney;

    public MathFragmentMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_math_fragment_menu, container, false);

        btnMaths = (ImageButton) view.findViewById(R.id.buttonMaths);
        btnMoney = (ImageButton) view.findViewById(R.id.buttonMoney);

        btnMaths.setOnClickListener(this);
        btnMoney.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {

            case R.id.buttonMaths:
                //Lenguaje
                fragment = new SplashMathsFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonMoney:
                //Atención
                fragment = new SplashMoneyFragment();
                fragmentTransaction = true;
                break;
        }
        if (fragmentTransaction) {
            changeFragment(fragment);
        }
    }

    private void changeFragment (Fragment fragment){
        getActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}
