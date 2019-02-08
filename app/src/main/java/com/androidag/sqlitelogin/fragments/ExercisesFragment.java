package com.androidag.sqlitelogin.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.exercises.ExerciseOne;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExercisesFragment extends Fragment implements View.OnClickListener {

    private ImageButton btn1;
    private ImageButton btn2;
    private ImageButton btn3;
    private ImageButton btn4;
    private ImageButton btn5;
    private ImageButton btn6;

    public ExercisesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_exercises, container, false);

        btn1 = (ImageButton) view.findViewById(R.id.button1);
        btn2 = (ImageButton) view.findViewById(R.id.button2);
        btn3 = (ImageButton) view.findViewById(R.id.button3);
        btn4 = (ImageButton) view.findViewById(R.id.button4);
        btn5 = (ImageButton) view.findViewById(R.id.button5);
        btn6 = (ImageButton) view.findViewById(R.id.button6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button1) {
            Toast.makeText(getActivity(), "Button 1", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.button2) {
            Toast.makeText(getActivity(), "Button 2", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.button3) {
            Toast.makeText(getActivity(), "Button 3", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.button4) {
            Toast.makeText(getActivity(), "Button 4", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.button5) {
            Toast.makeText(getActivity(), "Button 5", Toast.LENGTH_LONG).show();
        } else if (view.getId() == R.id.button6) {
            Toast.makeText(getActivity(), "Button 6", Toast.LENGTH_LONG).show();
        }
    }
}
