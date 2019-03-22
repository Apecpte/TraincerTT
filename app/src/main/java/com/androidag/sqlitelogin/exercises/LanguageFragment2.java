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

public class LanguageFragment2 extends Fragment {

    TextView questionLabel, questionLabel2, questionLabel3, questionCountLabel, scoreLabel;
    EditText answerEdt, answerEdt2;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<LanguageQuestionModel2> questionModelArraylist;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    public LanguageFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_language_fragment2, container, false);

        questionCountLabel = view.findViewById(R.id.noQuestionLeng2);
        questionLabel = view.findViewById(R.id.textViewLeng1Q2);
        questionLabel2 = view.findViewById(R.id.textViewLeng2Q2);
        questionLabel3 = view.findViewById(R.id.textViewLeng3Q2);
        scoreLabel = view.findViewById(R.id.scoreLeng2);

        answerEdt = view.findViewById(R.id.editTextLeng1A2);
        answerEdt2 = view.findViewById(R.id.editTextLeng2A2);
        submitButton = view.findViewById(R.id.btnLeng2);
        progressBar = view.findViewById(R.id.progressLeng2);

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

        if(!answerEdt.getText().toString().isEmpty() && !answerEdt2.getText().toString().isEmpty()){
            if(answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswer()) && answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswer2())){
                numberOfCorrectAnswer ++;

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
                        currentPosition ++;
                        setData();
                        answerEdt.setText("");
                        answerEdt2.setText("");
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
                builder.setMessage("Las respuesta correcta son: " + questionModelArraylist.get(currentPosition).getAnswer() + " y " + questionModelArraylist.get(currentPosition).getAnswer2());
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        currentPosition ++;
                        setData();
                        answerEdt.setText("");
                        answerEdt2.setText("");
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

            int x = ((currentPosition+1) * 100) / questionModelArraylist.size();

            progressBar.setProgress(x);
        }else
        {
            if(answerEdt.getText().toString().isEmpty() ){
                answerEdt.setError("¡El campo esta vacío!");
            } else if (answerEdt2.getText().toString().isEmpty()){
                answerEdt2.setError("¡El campo esta vacío!");
            }
          //  submitButton.setError("¡El campo esta vacío!");
        }


    }

    public void setUpQuestion(){
        questionModelArraylist.add(new LanguageQuestionModel2("Hoy estu", "e con mi ", "ermana en la feria.","v", "h"));
        questionModelArraylist.add(new LanguageQuestionModel2("El arroz pesa","a un kilo en la ", "alanza.","b", "b"));
        questionModelArraylist.add(new LanguageQuestionModel2("No me ", "usta tomar ", "arabe.","g", "j"));
        questionModelArraylist.add(new LanguageQuestionModel2("Hoy ", "e comido crema de cala","aza.","h", "b"));
        questionModelArraylist.add(new LanguageQuestionModel2("Las ", "elas del ", "arco eran blancas.","v", "b"));
        questionModelArraylist.add(new LanguageQuestionModel2("El pá", "aro se escapó de la ", "aula.","j","j"));
        questionModelArraylist.add(new LanguageQuestionModel2("Los domin"," os no ", "ay colegio.", "g", "h"));
        questionModelArraylist.add(new LanguageQuestionModel2("Estu","e jugando al ", "alón.", "v", "b"));
        questionModelArraylist.add(new LanguageQuestionModel2("" ,"eneralmente voy al ","imnasio los martes.", "g", "g"));
        questionModelArraylist.add(new LanguageQuestionModel2("A mi ", "ermana Candy le dio ","ripa.", "h" , "g"));
    }

    public void setData(){

        if(questionModelArraylist.size()>currentPosition) {

            questionLabel.setText(questionModelArraylist.get(currentPosition).getQuestionString());
            questionLabel2.setText(questionModelArraylist.get(currentPosition).getQuestionString2());
            questionLabel3.setText(questionModelArraylist.get(currentPosition).getQuestionString3());

            scoreLabel.setText("Score :" + numberOfCorrectAnswer + "/" + questionModelArraylist.size());
            questionCountLabel.setText("Pregunta No : " + (currentPosition + 1));

        }else{

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            TextView title = new TextView(getContext());
            title.setText("!Felicidades¡");
            title.setPadding(10, 10, 10, 10);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(40);
            builder.setMessage("Tu score es: " + numberOfCorrectAnswer + "/" + questionModelArraylist.size() + "\n¿Deseas continuar con el siguiente nivel?");
            builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //getActivity().finish();
                    LanguageFragment3 lF3 = new LanguageFragment3();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, lF3)
                            .addToBackStack(null)
                            .commit();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
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
            TextView textView = (TextView) dialog.findViewById(android.R.id.message);
            textView.setTextSize(30);
            dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(25);
            dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(25);
        }
    }
}
