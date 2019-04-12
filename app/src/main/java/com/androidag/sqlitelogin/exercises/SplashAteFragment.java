package com.androidag.sqlitelogin.exercises;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashAteFragment extends Fragment {

    private Button btnStartAte;

    public SplashAteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_ate, container, false);

        btnStartAte = (Button) view.findViewById(R.id.buttonStartAte);

        btnStartAte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AteFragment aF = new AteFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, aF)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
