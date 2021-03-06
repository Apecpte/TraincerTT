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
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.ExercisesFragment;
import com.androidag.sqlitelogin.fragments.HomeFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AteFragment3 extends Fragment {

    TextView questionLabel;
    EditText answerEdt;
    Button submitButton;
    ArrayList<MathQuestionModel> questionModelArraylist;

    int currentPosition = 0;

    public AteFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ate_fragment3, container, false);

        questionLabel = view.findViewById(R.id.textView3Ate);
        answerEdt = view.findViewById(R.id.editText3Ate);
        submitButton = view.findViewById(R.id.btn3Ate);

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

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                TextView titleG = new TextView(getContext());
                titleG.setText("¡Felicidades!");
                titleG.setPadding(10, 10, 10, 10);
                titleG.setGravity(Gravity.CENTER);
                titleG.setTextSize(40);
                builder.setMessage("Respuesta correcta");
                builder.setNeutralButton("OK", new DialogInterface.OnClickListener(){
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
                builder.setMessage("La respuesta correcta es: " + questionModelArraylist.get(currentPosition).getAnswer() + "\n\nTú puedes");
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

    }

    public void setUpQuestion(){
        questionModelArraylist.add(new MathQuestionModel("¿Cuántos tomates hay en la imagen?","7"));
    }

    public void setData(){

        if(questionModelArraylist.size()>currentPosition) {

            questionLabel.setText(questionModelArraylist.get(currentPosition).getQuestionString());

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            TextView title = new TextView(getContext());
            title.setText("¡Has concluido con el ejercicio!");
            title.setPadding(10, 10, 10, 10);
            title.setGravity(Gravity.CENTER);
            title.setTextSize(40);
            builder.setMessage("¿Deseas continuar con el siguiente nivel?");
            builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //getActivity().finish();
                    AteFragment2 aF2 = new AteFragment2();
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.content_frame, aF2)
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
