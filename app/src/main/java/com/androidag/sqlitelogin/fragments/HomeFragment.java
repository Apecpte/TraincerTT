package com.androidag.sqlitelogin.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.meditation.MeditaFragment1;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private ImageButton btnTest;
    private ImageButton btnFood;
    private ImageButton btnExer;
    private ImageButton btnRelax;
    private ImageButton btnRecomExer;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnTest = (ImageButton) view.findViewById(R.id.buttonTest);
        btnFood = (ImageButton) view.findViewById(R.id.buttonFood);
        btnExer = (ImageButton) view.findViewById(R.id.buttonExercise);
        btnRelax = (ImageButton) view.findViewById(R.id.buttonRelax);
        btnRecomExer = (ImageButton) view.findViewById(R.id.buttonRecommExercise);

        btnTest.setOnClickListener(this);
        btnFood.setOnClickListener(this);
        btnExer.setOnClickListener(this);
        btnRelax.setOnClickListener(this);
        btnRecomExer.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (view.getId()) {

            case R.id.buttonTest:
                fragment = new TestFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonFood:
                fragment = new RecomFoodFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonExercise:
                fragment = new ExercisesFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonRelax:
                fragment = new MeditaFragment1();
                fragmentTransaction = true;
                break;
            case R.id.buttonRecommExercise:
                fragment = new NivelExerFragment();
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

}
