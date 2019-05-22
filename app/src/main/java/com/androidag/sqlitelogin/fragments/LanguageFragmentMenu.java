package com.androidag.sqlitelogin.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.exercises.SplashLanguFragment;
import com.androidag.sqlitelogin.exercises.SplashScrabbleLanguageFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguageFragmentMenu extends Fragment implements View.OnClickListener {

    private ImageButton btnLangu;
    private ImageButton btnLanguage;

    public LanguageFragmentMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language_fragment_menu, container, false);

        btnLangu = (ImageButton) view.findViewById(R.id.buttonLangu);
        btnLanguage = (ImageButton) view.findViewById(R.id.buttonLanguage);

        btnLangu.setOnClickListener(this);
        btnLanguage.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {

            case R.id.buttonLangu:
                //Lenguaje
                fragment = new SplashLanguFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonLanguage:
                //Atención
                fragment = new SplashScrabbleLanguageFragment();
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
