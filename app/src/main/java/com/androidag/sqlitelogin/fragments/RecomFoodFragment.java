package com.androidag.sqlitelogin.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.androidag.sqlitelogin.Food.RecomFoodFragment2;
import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecomFoodFragment extends Fragment implements View.OnClickListener {

    private Button btnGoOut;
    private Button btnNext;
    private Button btnYT;


    public RecomFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recom_food, container, false);

        btnGoOut = (Button) view.findViewById(R.id.buttonGoOut);
        btnNext = (Button) view.findViewById(R.id.buttonNext);
        btnYT = (Button) view.findViewById(R.id.btnYT);

        btnGoOut.setOnClickListener(this);
        btnNext.setOnClickListener(this);
        btnYT.setOnClickListener(this);

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
                fragment = new RecomFoodFragment2();
                fragmentTransaction = true;
                break;

            case R.id.btnYT:
                youtubeFish("uD_2jTSb4aY");
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

    public void youtubeFish(String id) {
        //id = "uD_2jTSb4aY";
        Intent youtubeFishIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        startActivity(youtubeFishIntent);
    }

}

