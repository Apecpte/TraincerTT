package com.androidag.sqlitelogin.exercises;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
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
public class LanguageFragment3 extends Fragment {

    private TextView questionLabel, questionLabel2, questionLabel3, questionLabel4, questionCountLabel, scoreLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;
    private String languageAnswers;
    private ProgressBar progressBar;

    private LanguageQuestionModel3 languageQuestions = new LanguageQuestionModel3();

    private int list = languageQuestions.languageQuestions.length -1 ;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;


    public LanguageFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language_fragment3, container, false);

        questionCountLabel = view.findViewById(R.id.noQuestionLeng3);
        questionLabel = view.findViewById(R.id.textViewLeng1Q3);
        questionLabel2 = view.findViewById(R.id.textViewLeng2Q3);
        questionLabel3 = view.findViewById(R.id.textViewLeng3Q3);
        questionLabel4 = view.findViewById(R.id.textViewLeng4Q3);
        scoreLabel = view.findViewById(R.id.scoreLeng3);
        answerBtn1 = view.findViewById(R.id.btn3LengO1);
        answerBtn2 = view.findViewById(R.id.btn3LengO2);
        answerBtn3 = view.findViewById(R.id.btn3LengO3);
        answerBtn4 = view.findViewById(R.id.btn3LengO4);
        progressBar = view.findViewById(R.id.progressLeng3);

        scoreLabel.setText("Puntuación: " + numberOfCorrectAnswer  + "/" + languageQuestions.languageQuestions.length);

        updateQuestions(currentPosition);

        answerBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerBtn1.getText() == languageAnswers){
                    numberOfCorrectAnswer++;
                    GoodAnswer();
                } else {
                    WrongAnswer();
                }
            }
        });

        answerBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerBtn2.getText() == languageAnswers){
                    numberOfCorrectAnswer++;
                    GoodAnswer();
                } else {
                    WrongAnswer();
                }
            }
        });

        answerBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerBtn3.getText() == languageAnswers){
                    numberOfCorrectAnswer++;
                    GoodAnswer();
                } else {
                    WrongAnswer();
                }
            }
        });

        answerBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerBtn4.getText() == languageAnswers){
                    numberOfCorrectAnswer++;
                    GoodAnswer();
                } else {
                    WrongAnswer();
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void updateQuestions(int num) {
        questionLabel.setText(languageQuestions.getlanguageQuestions(num));
        questionLabel2.setText(languageQuestions.getlanguageQuestions2(num));
        questionLabel3.setText(languageQuestions.getlanguageQuestions3(num));
        questionLabel4.setText(languageQuestions.getlanguageQuestions4(num));
        answerBtn1.setText(languageQuestions.getChoice1(num));
        answerBtn2.setText(languageQuestions.getChoice2(num));
        answerBtn3.setText(languageQuestions.getChoice3(num));
        answerBtn4.setText(languageQuestions.getChoice4(num));

        languageAnswers = languageQuestions.getCorrectAnswer(num);

        questionCountLabel.setText("Pregunta No : " + (currentPosition + 1));
        int x = ((currentPosition) * 100) / languageQuestions.languageQuestions.length;

        progressBar.setProgress(x);
    }

    private void GoodAnswer(){
        scoreLabel.setText("Puntuación: " + numberOfCorrectAnswer + "/" + languageQuestions.languageQuestions.length);
        //updateQuestions(r.nextInt(tQuestionsLenght));
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView titleG = new TextView(getContext());
        titleG.setText("¡Bien hecho!");
        titleG.setPadding(10, 10, 10, 10);
        titleG.setGravity(Gravity.CENTER);
        titleG.setTextSize(40);
        builder.setMessage("Respuesta correcta");
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (currentPosition < list){
                    currentPosition++;
                    updateQuestions(currentPosition);
                    //updateQuestions(r.nextInt(turn));
                } else {
                    gameOver();
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCustomTitle(titleG);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(30);
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
    }

    private void WrongAnswer(){
        scoreLabel.setText("Puntuación: " + numberOfCorrectAnswer + "/" + languageQuestions.languageQuestions.length);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView titleB = new TextView(getContext());
        titleB.setText("¡Respuesta incorrecta!");
        titleB.setPadding(10, 10, 10, 10);
        titleB.setGravity(Gravity.CENTER);
        titleB.setTextSize(40);
        builder.setMessage("La respuesta correcta es: " + languageQuestions.getCorrectAnswer(currentPosition));
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (currentPosition < list){
                    currentPosition++;
                    updateQuestions(currentPosition);
                    //updateQuestions(r.nextInt(turn));
                } else {
                    gameOver();
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCustomTitle(titleB);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(30);
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
    }

    private void gameOver(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView title = new TextView(getContext());
        title.setText("!Felicidades, haz concluido con los tres niveles del ejercicio¡");
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(40);
        builder.setMessage("Tu puntuación es: " + numberOfCorrectAnswer + "/" + languageQuestions.languageQuestions.length);
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
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCustomTitle(title);
        dialog.show();
        TextView textViewAlert = (TextView) dialog.findViewById(android.R.id.message);
        textViewAlert.setTextSize(30);
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
    }
}
