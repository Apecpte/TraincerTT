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

    TextView questionLabel, questionLabel2, questionLabel3, questionLabel4, questionCountLabel, scoreLabel;
    EditText answerEdt, answerEdt2, answerEdt3;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<LanguageQuestionModel3> questionModelArraylist;

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
        scoreLabel = view.findViewById(R.id.scoreLeng2);

        answerEdt = view.findViewById(R.id.editTextLeng1A2);
        answerEdt2 = view.findViewById(R.id.editTextLeng2A2);
        answerEdt3 = view.findViewById(R.id.editTextLeng2A3);
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

    public void checkAnswer() {
        String answerString = answerEdt.getText().toString().trim();

        if (!answerEdt.getText().toString().isEmpty() && !answerEdt2.getText().toString().isEmpty() && !answerEdt3.getText().toString().isEmpty()) {
            if (answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswer())
                    && answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswer2())
                    && answerString.equalsIgnoreCase(questionModelArraylist.get(currentPosition).getAnswer3())) {
                numberOfCorrectAnswer++;

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
                        currentPosition++;
                        setData();
                        answerEdt.setText("");
                        answerEdt2.setText("");
                        answerEdt3.setText("");
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCustomTitle(titleG);
                dialog.show();
                TextView textView = (TextView) dialog.findViewById(android.R.id.message);
                textView.setTextSize(30);
                dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);

            } else {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                TextView titleB = new TextView(getContext());
                titleB.setText("¡Respuesta incorrecta!");
                titleB.setPadding(10, 10, 10, 10);
                titleB.setGravity(Gravity.CENTER);
                titleB.setTextSize(40);
                builder.setMessage("Las respuesta correcta son: " + questionModelArraylist.get(currentPosition).getAnswer()
                        + " , " + questionModelArraylist.get(currentPosition).getAnswer2()
                        + " y " + questionModelArraylist.get(currentPosition).getAnswer3());
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        currentPosition++;
                        setData();
                        answerEdt.setText("");
                        answerEdt2.setText("");
                        answerEdt3.setText("");
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

            int x = ((currentPosition + 1) * 100) / questionModelArraylist.size();

            progressBar.setProgress(x);
        } else {
            if (answerEdt.getText().toString().isEmpty()) {
                answerEdt.setError("¡El campo esta vacío!");
            } else if (answerEdt2.getText().toString().isEmpty()) {
                answerEdt2.setError("¡El campo esta vacío!");
            } else if (answerEdt3.getText().toString().isEmpty()) {
                answerEdt2.setError("¡El campo esta vacío!");
                //  submitButton.setError("¡El campo esta vacío!");
            }
        }


    }

    public void setUpQuestion () {
        questionModelArraylist.add(new LanguageQuestionModel3(" oy he jugado al ", "alón con ", "mi ", "ecino.", "h", "b", "v"));
        questionModelArraylist.add(new LanguageQuestionModel3("El a", "ión ", "iaja a gran ", "elocidad.", "v", "v", "v"));
        questionModelArraylist.add(new LanguageQuestionModel3("El ", "avilán es un a", "e de rap", "ña.", "g", "v", "i"));
        questionModelArraylist.add(new LanguageQuestionModel3("", "e dormido ", "asta las nue", "e.", "h", "h", "v"));
        questionModelArraylist.add(new LanguageQuestionModel3("Mi ", "ecino es ", "ailarín profe", "ional.", "v", "b", "s"));
        questionModelArraylist.add(new LanguageQuestionModel3("El ", "ueves fu", "mo", " al cine.", "j", "i", "s"));
        questionModelArraylist.add(new LanguageQuestionModel3("", "oy ", "a sido un día muy ", "onito.", "h", "h", "b"));
        questionModelArraylist.add(new LanguageQuestionModel3("M", " deporte fa", "orito es el ", "aloncesto.", "i", "v", "b"));
        questionModelArraylist.add(new LanguageQuestionModel3("El ", "ugo de naran", "a es rico en ", "itamina C.", "j", "j", "v"));
        questionModelArraylist.add(new LanguageQuestionModel3("El caballo ne", "ro era el que me", "or ", "alopaba.", "g", "j", "g"));
    }

    public void setData () {

        if (questionModelArraylist.size() > currentPosition) {

            questionLabel.setText(questionModelArraylist.get(currentPosition).getQuestionString());
            questionLabel2.setText(questionModelArraylist.get(currentPosition).getQuestionString2());
            questionLabel3.setText(questionModelArraylist.get(currentPosition).getQuestionString3());
            questionLabel4.setText(questionModelArraylist.get(currentPosition).getQuestionString4());

            scoreLabel.setText("Score :" + numberOfCorrectAnswer + "/" + questionModelArraylist.size());
            questionCountLabel.setText("Pregunta No : " + (currentPosition + 1));

        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            TextView title = new TextView(getContext());
            title.setText("!Felicidades, haz concluido con los tres niveles del ejercicio¡");
            title.setPadding(10, 10, 10, 10);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(40);
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
            dialog.setCanceledOnTouchOutside(false);
            dialog.setCustomTitle(title);
            dialog.show();
            TextView textView = (TextView) dialog.findViewById(android.R.id.message);
            textView.setTextSize(30);
            dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
        }
    }
}
