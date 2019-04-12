package com.androidag.sqlitelogin.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.exercises.SplashPerceFragment;
import com.androidag.sqlitelogin.exercises.SplashPerceptionFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerceptionFragmentMenu extends Fragment implements View.OnClickListener {

    private ImageButton btntPerce;
    private ImageButton btnPerception;

    public PerceptionFragmentMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perception_fragment_menu, container, false);

        btntPerce = (ImageButton) view.findViewById(R.id.buttonPerce);
        btnPerception = (ImageButton) view.findViewById(R.id.buttonPerception);

        btntPerce.setOnClickListener(this);
        btnPerception.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {

            case R.id.buttonPerce:
                //Lenguaje
                fragment = new SplashPerceFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonPerception:
                //Atención
                fragment = new SplashPerceptionFragment();
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
