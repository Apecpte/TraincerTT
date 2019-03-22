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
public class LanguageFragment extends Fragment {

    TextView questionLabel, questionLabel2, questionCountLabel, scoreLabel;
    EditText answerEdt;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<LanguageQuestionModel> questionModelArraylist;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    public LanguageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_language, container, false);

        questionCountLabel = view.findViewById(R.id.noQuestionLeng);
        questionLabel = view.findViewById(R.id.textViewLengQ1);
        questionLabel2 = view.findViewById(R.id.textViewLengQ2);
        scoreLabel = view.findViewById(R.id.scoreLeng);

        answerEdt = view.findViewById(R.id.editTextLengA);
        submitButton = view.findViewById(R.id.btnLeng);
        progressBar = view.findViewById(R.id.progressLeng);

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
            answerEdt.setError("¡El campo esta vacío!");
        }


    }

    public void setUpQuestion(){
        questionModelArraylist.add(new LanguageQuestionModel("C a m p "," n a","a"));
        questionModelArraylist.add(new LanguageQuestionModel("C o r a "," ó n","z"));
        questionModelArraylist.add(new LanguageQuestionModel("P a l "," m a","o"));
        questionModelArraylist.add(new LanguageQuestionModel("C "," g u e ñ a","i"));
        questionModelArraylist.add(new LanguageQuestionModel("P a r "," g u a y a","a"));
        questionModelArraylist.add(new LanguageQuestionModel("V e r a "," r u z","c"));
        questionModelArraylist.add(new LanguageQuestionModel("L "," c t u r a","e"));
        questionModelArraylist.add(new LanguageQuestionModel("F r a "," c i ó n","c"));
        questionModelArraylist.add(new LanguageQuestionModel("C o "," i m a","l"));
        questionModelArraylist.add(new LanguageQuestionModel("E s t "," d i a n t e","u"));
    }

    public void setData(){

        if(questionModelArraylist.size()>currentPosition) {

            questionLabel.setText(questionModelArraylist.get(currentPosition).getQuestionString());
            questionLabel2.setText(questionModelArraylist.get(currentPosition).getQuestionString2());

            scoreLabel.setText("Score :" + numberOfCorrectAnswer + "/" + questionModelArraylist.size());
            questionCountLabel.setText("Pregunta No : " + (currentPosition + 1));

        }else{

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            TextView title = new TextView(getContext());
            title.setText("¡Haz concluido con el ejercicio!");
            title.setPadding(10, 10, 10, 10);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(40);
            builder.setMessage("Tu score es: " + numberOfCorrectAnswer + "/" + questionModelArraylist.size() + "\n¿Deseas continuar con el siguiente nivel?");
            builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //getActivity().finish();
                    LanguageFragment2 lF2 = new LanguageFragment2();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, lF2)
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
