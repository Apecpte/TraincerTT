package com.androidag.sqlitelogin.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.exercises.SplashAteFragment;
import com.androidag.sqlitelogin.exercises.SplashAtentionFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AtentionFragmentMenu extends Fragment implements View.OnClickListener {

    private ImageButton btntAte;
    private ImageButton btnAtention;

    public AtentionFragmentMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atention_fragment_menu, container, false);

        btntAte = (ImageButton) view.findViewById(R.id.buttonAte);
        btnAtention = (ImageButton) view.findViewById(R.id.buttonAtention);

        btntAte.setOnClickListener(this);
        btnAtention.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {

            case R.id.buttonAte:
                //Lenguaje
                fragment = new SplashAteFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonAtention:
                //Atención
                fragment = new SplashAtentionFragment();
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
