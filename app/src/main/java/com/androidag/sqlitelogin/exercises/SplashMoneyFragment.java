package com.androidag.sqlitelogin.exercises;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.androidag.sqlitelogin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SplashMoneyFragment extends Fragment {

    private Button btnStartMoney;
    private ImageButton audioInstMoney;
    private MediaPlayer moneyMP;

    public SplashMoneyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_money, container, false);

        moneyMP = MediaPlayer.create(getContext(), R.raw.cuanto_dinero1);

        btnStartMoney = (Button) view.findViewById(R.id.buttonStartMoney);
        audioInstMoney = (ImageButton) view.findViewById(R.id.moneyButtonInst);

        audioInstMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moneyMP.start();
            }
        });

        btnStartMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moneyMP.stop();
                MoneyFragment mo1F = new MoneyFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, mo1F)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
