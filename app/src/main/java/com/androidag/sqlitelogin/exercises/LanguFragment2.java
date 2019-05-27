package com.androidag.sqlitelogin.exercises;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.ExercisesFragment;
import com.androidag.sqlitelogin.fragments.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LanguFragment2 extends Fragment {

    private TextView questionLabel, questionCountLabel, scoreLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private String languageAnswers;
    private ProgressBar progressBar;

    private LanguQuestionModel2 languQuestions = new LanguQuestionModel2();

    private int list = languQuestions.languQuestions.length -1 ;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;


    public LanguFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_langu_fragment2, container, false);

        questionCountLabel = view.findViewById(R.id.noQuestionLangu2);
        questionLabel = view.findViewById(R.id.textViewLangu2);
        scoreLabel = view.findViewById(R.id.scoreLangu2);
        answerBtn1 = view.findViewById(R.id.answerBtn2Langu1);
        answerBtn2 = view.findViewById(R.id.answerBtn2Langu2);
        answerBtn3 = view.findViewById(R.id.answerBtn2Langu3);
        progressBar = view.findViewById(R.id.progressLangu2);

        scoreLabel.setText("Puntuación: " + numberOfCorrectAnswer  + "/" + languQuestions.languQuestions.length);

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
        // Inflate the layout for this fragment
        return view;
    }

    private void updateQuestions(int num) {
        questionLabel.setText(languQuestions.getlanguQuestions(num));
        answerBtn1.setText(languQuestions.getChoice1(num));
        answerBtn2.setText(languQuestions.getChoice2(num));
        answerBtn3.setText(languQuestions.getChoice3(num));

        languageAnswers = languQuestions.getCorrectAnswer(num);

        questionCountLabel.setText("Pregunta No : " + (currentPosition + 1));
        int x = ((currentPosition) * 100) / languQuestions.languQuestions.length;

        progressBar.setProgress(x);
    }

    private void GoodAnswer(){
        scoreLabel.setText("Puntuación: " + numberOfCorrectAnswer + "/" + languQuestions.languQuestions.length);
        //updateQuestions(r.nextInt(tQuestionsLenght));
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView titleG = new TextView(getContext());
        titleG.setText("¡Correcto!");
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
        scoreLabel.setText("Puntuación: " + numberOfCorrectAnswer + "/" + languQuestions.languQuestions.length);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView titleB = new TextView(getContext());
        titleB.setText("¡Respuesta incorrecta!");
        titleB.setPadding(10, 10, 10, 10);
        titleB.setGravity(Gravity.CENTER);
        titleB.setTextSize(40);
        builder.setMessage("La respuesta correcta es: " + languQuestions.getCorrectAnswer(currentPosition) + "\nIntenta de nuevo");
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
        title.setText("¡Has concluido con el ejercicio!");
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(40);
        builder.setMessage("Tu puntuación es: " + numberOfCorrectAnswer + "/" + languQuestions.languQuestions.length + "\n¿Deseas continuar con el siguiente nivel?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //getActivity().finish();
                LanguFragment3 lf3 = new LanguFragment3();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, lf3)
                        .addToBackStack(null)
                        .commit();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //getActivity().finish();
                ExercisesFragment hf = new ExercisesFragment();
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
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(25);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(25);
    }
}
