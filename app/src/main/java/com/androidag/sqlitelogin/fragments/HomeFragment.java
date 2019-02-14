package com.androidag.sqlitelogin.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private ImageButton btnTest;
    private ImageButton btnFood;
    private ImageButton btnExer;
    private ImageButton btnRelax;

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

        btnTest.setOnClickListener(this);
        btnFood.setOnClickListener(this);
        btnExer.setOnClickListener(this);
        btnRelax.setOnClickListener(this);

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
                alertRecomFood();
                fragment = new RecomFoodFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonExercise:
                fragment = new ExercisesFragment();
                fragmentTransaction = true;
                break;
            case R.id.buttonRelax:
                alertRecomRelax();
                fragment = new RecomExerFragment();
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
                //.addToBackStack(null)
                .commit();
    }

    public void alertRecomFood() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setTitle("Cerrar Sesión");
        builder.setMessage(R.string.FoodSlogan);
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
