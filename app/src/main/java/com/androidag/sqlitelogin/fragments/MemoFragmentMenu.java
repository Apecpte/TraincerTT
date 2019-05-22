package com.androidag.sqlitelogin.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.exercises.MemoFragment;
import com.androidag.sqlitelogin.exercises.MemorFragment;
import com.androidag.sqlitelogin.exercises.SplashInsMemoFragment;
import com.androidag.sqlitelogin.exercises.SplashMemoFragment;
import com.androidag.sqlitelogin.exercises.SplashMemorFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemoFragmentMenu extends Fragment implements View.OnClickListener {

    private ImageButton btnMemorama;
    private ImageButton btnRemember;

    public MemoFragmentMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memo_fragment_menu, container, false);

        btnMemorama = (ImageButton) view.findViewById(R.id.buttonMemorama);
        btnRemember = (ImageButton) view.findViewById(R.id.buttonRemember);

        btnMemorama.setOnClickListener(this);
        btnRemember.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {

            case R.id.buttonMemorama:
                //Lenguaje
                fragment = new SplashMemorFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonRemember:
                //Atención
                fragment = new SplashInsMemoFragment();
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
