package com.androidag.sqlitelogin.exercises;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import com.androidag.sqlitelogin.fragments.ExercisesFragment;
import com.androidag.sqlitelogin.fragments.HomeFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AtentionFragment2 extends Fragment {

    TextView questionLabel, questionCountLabel, scoreLabel;
    EditText answerEdt;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<MathQuestionModel> questionModelArraylist;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    public AtentionFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_atention_fragment2, container, false);

        questionCountLabel = view.findViewById(R.id.noQuestionAte2);
        questionLabel = view.findViewById(R.id.textViewAteQ2);
        scoreLabel = view.findViewById(R.id.scoreAte2);

        answerEdt = view.findViewById(R.id.editTextAteA2);
        submitButton = view.findViewById(R.id.btnAte2);
        progressBar = view.findViewById(R.id.progressAte2);

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

        if(!answerEdt.getText().toString().isEmpty()){
            if(answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswer())){
                numberOfCorrectAnswer ++;

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
                        currentPosition ++;
                        setData();
                        answerEdt.setText("");
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCustomTitle(titleG);
                dialog.show();
                TextView textView = (TextView) dialog.findViewById(android.R.id.message);
                textView.setTextSize(30);
                dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);

            }else {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                TextView titleB = new TextView(getContext());
                titleB.setText("¡Respuesta incorrecta!");
                titleB.setPadding(10, 10, 10, 10);
                titleB.setGravity(Gravity.CENTER);
                titleB.setTextSize(40);
                builder.setMessage("La respuesta correcta es: " + questionModelArraylist.get(currentPosition).getAnswer()  + "\n\nIntenta de nuevo");
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        currentPosition ++;
                        setData();
                        answerEdt.setText("");
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
        }else
        {
            answerEdt.setError("¡El campo esta vacío!");
        }


        int x = ((currentPosition+1) * 100) / questionModelArraylist.size();

        progressBar.setProgress(x);

    }

    public void setUpQuestion(){
        questionModelArraylist.add(new MathQuestionModel("5771 el inverso es :","1775"));
        questionModelArraylist.add(new MathQuestionModel("6562 el inverso es :","2656"));
        questionModelArraylist.add(new MathQuestionModel("9782 el inverso es :","2879"));
        questionModelArraylist.add(new MathQuestionModel("84212 el inverso es :","21248"));
        questionModelArraylist.add(new MathQuestionModel("75081 el inverso es :","18057"));
        questionModelArraylist.add(new MathQuestionModel("29712 el inverso es :","21792"));
        questionModelArraylist.add(new MathQuestionModel("935206 el inverso es :","602539"));
        questionModelArraylist.add(new MathQuestionModel("780187 el inverso es :","781087"));
        questionModelArraylist.add(new MathQuestionModel("498377 el inverso es :","773894"));
        questionModelArraylist.add(new MathQuestionModel("6938069 el inverso es :","9608396"));
    }

    public void setData(){

        if(questionModelArraylist.size()>currentPosition) {

            questionLabel.setText(questionModelArraylist.get(currentPosition).getQuestionString());

            scoreLabel.setText("Puntuación :" + numberOfCorrectAnswer + "/" + questionModelArraylist.size());
            questionCountLabel.setText("Pregunta No : " + (currentPosition + 1));

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            TextView title = new TextView(getContext());
            title.setText("¡Has concluido con el ejercicio!");
            title.setPadding(10, 10, 10, 10);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(40);
            builder.setMessage("Tu puntuación es: " + numberOfCorrectAnswer + "/" + questionModelArraylist.size() + "\n\n¿Deseas continuar con el siguiente nivel?");
            builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //getActivity().finish();
                    AtentionFragment3 aF3 = new AtentionFragment3();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, aF3)
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
            TextView textView = (TextView) dialog.findViewById(android.R.id.message);
            textView.setTextSize(30);
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(25);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(25);
        }
    }
}
