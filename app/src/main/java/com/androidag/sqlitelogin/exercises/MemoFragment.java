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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class MemoFragment extends Fragment implements View.OnClickListener {

    private ImageView questionImage;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            // {"Image Name", "Right Answer", "Choice1", "Choice2", "Choice3"}
            {"memo1", "Aretes, anillo, lentes y un cierre", "Collar, reloj, pulsera y una bolsa", "Collar, aretes, anillos y lentes", "Aretes, reloj, lentes y un cierre"},
    };

    public MemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_memo, container, false);

        questionImage = view.findViewById(R.id.questionImageMemo);
        answerBtn1 = view.findViewById(R.id.answerBtnMemo1);
        answerBtn2 = view.findViewById(R.id.answerBtnMemo2);
        answerBtn3 = view.findViewById(R.id.answerBtnMemo3);
        answerBtn4 = view.findViewById(R.id.answerBtnMemo4);

        answerBtn1.setOnClickListener(this);
        answerBtn2.setOnClickListener(this);
        answerBtn3.setOnClickListener(this);
        answerBtn4.setOnClickListener(this);

        // Create quizArray from quizData.
        for (int i = 0; i < quizData.length; i++) {
            // Prepare array.
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // Image Name
            tmpArray.add(quizData[i][1]); // Right Answer
            tmpArray.add(quizData[i][2]); // Choice1
            tmpArray.add(quizData[i][3]); // Choice2
            tmpArray.add(quizData[i][4]); // Choice3

            // Add tmpArray to quizArray.
            quizArray.add(tmpArray);
        }

        showNextQuiz();
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.answerBtnMemo1:
                checkAnswer(view);
                break;
            case R.id.answerBtnMemo2:
                checkAnswer(view);
                break;
            case R.id.answerBtnMemo3:
                checkAnswer(view);
                break;
            case R.id.answerBtnMemo4:
                checkAnswer(view);
                break;
        }
    }

    public void showNextQuiz() {

        // Generate random number between 0 and 4 (quizArray's size -1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        // Pick one quiz set.
        ArrayList<String> quiz = quizArray.get(randomNum);

        // Set Image and Right Answer.
        // Array format: {"Image Name", "Right Answer", "Choice1", "Choice2", "Choice3"}
        questionImage.setImageResource(
                getResources().getIdentifier(quiz.get(0), "drawable", getActivity().getPackageName()));
        rightAnswer = quiz.get(1);

        // Remove "Image Name" from quiz and shuffle choices.
        quiz.remove(0);
        Collections.shuffle(quiz);

        // Set choices.
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        // Remove this quiz from quizArray.
        quizArray.remove(randomNum);

    }

    public void checkAnswer(View view) {

        // Get pushed button.
        Button answerBtn = view.findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        if (btnText.equals(rightAnswer)) {
            // Correct!!
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
                    if (quizArray.size() < 1) {
                        // quizArray is empty.
                        showResult();
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

        } else {
            // Wrong
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            TextView titleB = new TextView(getContext());
            titleB.setText("¡Respuesta incorrecta!");
            titleB.setPadding(10, 10, 10, 10);
            titleB.setGravity(Gravity.CENTER);
            titleB.setTextSize(40);
            builder.setMessage("La respuesta correcta es: " + rightAnswer);
            builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (quizArray.size() < 1) {
                        // quizArray is empty.
                        showResult();
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
    }
    public void showResult() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView title = new TextView(getContext());
        title.setText("¡Haz concluido con el ejercicio!");
        title.setPadding(10, 10, 10, 10);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(40);
        builder.setMessage("¿Deseas continuar con el siguiente nivel?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
              getActivity().recreate();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                getActivity().finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCustomTitle(title);
        dialog.show();
        TextView textView = (TextView) dialog.findViewById(android.R.id.message);
        textView.setTextSize(30);
        dialog.getButton(android.app.AlertDialog.BUTTON_NEGATIVE).setTextSize(25);
        dialog.getButton(android.app.AlertDialog.BUTTON_POSITIVE).setTextSize(25);
    }
}
