package com.androidag.sqlitelogin.exercises;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class AtentionFragment extends Fragment {

    TextView questionLabel, questionCountLabel, scoreLabel;
    EditText answerEdt;
    Button submitButton;
    ProgressBar progressBar;
    ArrayList<MathQuestionModel> questionModelArraylist;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    public AtentionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_atention, container, false);

        questionCountLabel = view.findViewById(R.id.noQuestionAte);
        questionLabel = view.findViewById(R.id.textViewAteQ);
        scoreLabel = view.findViewById(R.id.scoreAte);

        answerEdt = view.findViewById(R.id.editTextAteA);
        submitButton = view.findViewById(R.id.btnAte);
        progressBar = view.findViewById(R.id.progressAte);

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

        questionModelArraylist.add(new MathQuestionModel("625 el inverso es :","526"));
        questionModelArraylist.add(new MathQuestionModel("47682  el inverso es :","28674"));
        questionModelArraylist.add(new MathQuestionModel("69173  el inverso es :","37196"));
        questionModelArraylist.add(new MathQuestionModel("7265637  el inverso es :","7365627"));
        questionModelArraylist.add(new MathQuestionModel("497846465  el inverso es :","564648794"));
        questionModelArraylist.add(new MathQuestionModel("674942536  el inverso es :","635249476"));
        questionModelArraylist.add(new MathQuestionModel("541368267  el inverso es :","762863145"));
        questionModelArraylist.add(new MathQuestionModel("648662513  el inverso es :","315266846"));
        questionModelArraylist.add(new MathQuestionModel("564788225  el inverso es :","522887465"));
        questionModelArraylist.add(new MathQuestionModel("456356157 el inverso es :","751653654"));

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
