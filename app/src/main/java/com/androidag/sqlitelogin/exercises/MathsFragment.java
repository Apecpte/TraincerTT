package com.androidag.sqlitelogin.exercises;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.HomeFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MathsFragment extends Fragment {

    TextView questionLabel, questionCountLabel, scoreLabel;
    EditText answerEdt;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<MathQuestionModel> questionModelArraylist;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    public MathsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_maths, container, false);

        questionCountLabel = view.findViewById(R.id.noQuestionMath);
        questionLabel = view.findViewById(R.id.textViewMathQ);
        scoreLabel = view.findViewById(R.id.scoreMath);

        answerEdt = view.findViewById(R.id.editTextMathA);
        submitButton = view.findViewById(R.id.btnMath);
        progressBar = view.findViewById(R.id.progressMath);

        questionModelArraylist = new ArrayList<>();

        setUpQuestion();

        setData();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer();
            }
        });

        answerEdt.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                Log.e("event.getAction()",event.getAction()+"");
                Log.e("event.keyCode()",keyCode+"");
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {

                    checkAnswer();
                    return true;
                }
                return false;
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public void checkAnswer(){
        String answerString  = answerEdt.getText().toString().trim();

        if(answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswer())){
            numberOfCorrectAnswer ++;

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("¡Bien hecho!");
            builder.setMessage("Respuesta correcta");
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    currentPosition ++;
                    setData();
                    answerEdt.setText("");
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
            TextView textView = (TextView) dialog.findViewById(android.R.id.message);
            textView.setTextSize(40);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);

        }else {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("¡Respuesta incorrecta!");
            builder.setMessage("La respuesta correcta es: " + questionModelArraylist.get(currentPosition).getAnswer());
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    currentPosition ++;
                    setData();
                    answerEdt.setText("");
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
            TextView textView = (TextView) dialog.findViewById(android.R.id.message);
            textView.setTextSize(40);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
        }

        int x = ((currentPosition+1) * 100) / questionModelArraylist.size();

        progressBar.setProgress(x);

    }

    public void setUpQuestion(){

        questionModelArraylist.add(new MathQuestionModel(" 5892\n+4371","10263"));
        questionModelArraylist.add(new MathQuestionModel(" 3750\n+1983","5733"));
        questionModelArraylist.add(new MathQuestionModel(" 762 * 18","13716"));
        questionModelArraylist.add(new MathQuestionModel(" 5892\n-4371","1521"));
        questionModelArraylist.add(new MathQuestionModel(" 558\n-327","231"));
        questionModelArraylist.add(new MathQuestionModel(" 138 " +"\u00F7" +" 6","23"));

    }

    public void setData(){

        if(questionModelArraylist.size()>currentPosition) {

            questionLabel.setText(questionModelArraylist.get(currentPosition).getQuestionString());

            scoreLabel.setText("Score :" + numberOfCorrectAnswer + "/" + questionModelArraylist.size());
            questionCountLabel.setText("Pregunta No : " + (currentPosition + 1));

        }else{

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Haz concluido con el ejercicio");
            builder.setMessage("Tu score es: " + numberOfCorrectAnswer + "/" + questionModelArraylist.size());
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //getActivity().finish();
                    HomeFragment hf = new HomeFragment();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, hf)
                            .addToBackStack(null)
                            .commit();
                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
            TextView textView = (TextView) dialog.findViewById(android.R.id.message);
            textView.setTextSize(40);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
        }
    }
}
