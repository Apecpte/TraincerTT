package com.androidag.sqlitelogin.test;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.activity.Home;
import com.androidag.sqlitelogin.fragments.HomeFragment;
import com.androidag.sqlitelogin.fragments.TestFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreTestFragment extends Fragment {

    private Button btnBackToMenu;
    private int scoreLast;

    public ScoreTestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_score_test, container, false);

        TextView txtScoreLast = (TextView) view.findViewById(R.id.tVTestScoreLast);
        TextView txtScoreHigh = (TextView) view.findViewById(R.id.tVTestScoreHigh);
        btnBackToMenu = (Button) view.findViewById(R.id.buttonTableScoreTest);

        scoreLast = getArguments().getInt("score", 0);

        txtScoreLast.setText("Última puntuación: " + scoreLast);

        SharedPreferences mypref = this.getActivity().getPreferences(Context.MODE_PRIVATE);
        int highscore = mypref.getInt("highscore", 0);
        if (highscore>=scoreLast)
            txtScoreHigh.setText("Puntuación más alta: " + highscore);
        else {
            txtScoreHigh.setText("Nueva puntuación más alta: " + scoreLast);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", scoreLast);
            editor.commit();
        }

        btnBackToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeFragment hoFr = new HomeFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, hoFr)
                        .addToBackStack(null)
                        .commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

}
