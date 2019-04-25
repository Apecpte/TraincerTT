package com.androidag.sqlitelogin.test;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.activity.Home;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment1 extends Fragment {

    public Button test_button1, test_button2, test_button3, test_button4;
    public ImageView imageViewTest;
    public TextView scoreTest, questionT;

    private QuizDatabase testQuestions = new QuizDatabase();

    private String tAnswers;
    private int tScore = 0;
    private int list = testQuestions.testQuestions.length -1 ;

    Random r;

    int turn = 0;

    public TestFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test1, container, false);

        r = new Random();

        imageViewTest = (ImageView) view.findViewById(R.id.imageViewTest);

        test_button1 = (Button) view.findViewById(R.id.test_button1);
        test_button2 = (Button) view.findViewById(R.id.test_button2);
        test_button3 = (Button) view.findViewById(R.id.test_button3);
        test_button4 = (Button) view.findViewById(R.id.test_button4);

        scoreTest = (TextView) view.findViewById(R.id.textViewScore);
        questionT = (TextView) view.findViewById(R.id.textViewTest);

        scoreTest.setText("Puntuación: " + tScore);

        updateQuestions(turn);

        //updateQuestions(r.nextInt(turn));

        test_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (test_button1.getText() == tAnswers){
                    tScore++;
                    scoreTest.setText("Puntuación: " + tScore);
                    //updateQuestions(r.nextInt(tQuestionsLenght));
                    //Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_LONG).show();

                    if (turn < list){
                        turn++;
                        updateQuestions(turn);
                        //updateQuestions(r.nextInt(turn));
                    } else {
                        //Toast.makeText(getActivity(), "You finished the game!", Toast.LENGTH_LONG).show();
                        gameOver();
                    }
                } else {
                    //Toast.makeText(getActivity(), "Wrong!", Toast.LENGTH_LONG).show();

                    if (turn < list){
                        turn++;
                        updateQuestions(turn);
                        //updateQuestions(r.nextInt(turn));
                    } else {
                        //Toast.makeText(getActivity(), "You finished the game!", Toast.LENGTH_LONG).show();
                        gameOver();
                    }
                    //updateQuestions(r.nextInt(tQuestionsLenght));
                    //gameOver();
                }
            }
        });

        test_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (test_button2.getText() == tAnswers){
                    tScore++;
                    scoreTest.setText("Puntuación: " + tScore);
                    //updateQuestions(r.nextInt(tQuestionsLenght));
                   // Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_LONG).show();
                    if (turn < list){
                        turn++;
                        updateQuestions(turn);
                        //updateQuestions(r.nextInt(turn));
                    } else {
                       // Toast.makeText(getActivity(), "You finished the game!", Toast.LENGTH_LONG).show();
                        gameOver();
                    }
                } else {
                   // Toast.makeText(getActivity(), "Wrong!", Toast.LENGTH_LONG).show();

                    if (turn < list){
                        turn++;
                        updateQuestions(turn);
                        //updateQuestions(r.nextInt(turn));
                    } else {
                       // Toast.makeText(getActivity(), "You finished the game!", Toast.LENGTH_LONG).show();
                        gameOver();
                    }
                    //updateQuestions(r.nextInt(tQuestionsLenght));
                    //gameOver();
                }
            }
        });

        test_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (test_button3.getText() == tAnswers){
                    tScore++;
                    scoreTest.setText("Puntuación: " + tScore);
                    //updateQuestions(r.nextInt(tQuestionsLenght));
                    //Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_LONG).show();
                    if (turn < list){
                        turn++;
                        updateQuestions(turn);
                        //updateQuestions(r.nextInt(turn));
                    } else {
                       // Toast.makeText(getActivity(), "You finished the game!", Toast.LENGTH_LONG).show();
                        gameOver();
                    }
                } else {
                   // Toast.makeText(getActivity(), "Wrong!", Toast.LENGTH_LONG).show();

                    if (turn < list){
                        turn++;
                        updateQuestions(turn);
                        //updateQuestions(r.nextInt(turn));
                    } else {
                       // Toast.makeText(getActivity(), "You finished the game!", Toast.LENGTH_LONG).show();
                        gameOver();
                    }
                    //updateQuestions(r.nextInt(tQuestionsLenght));
                    //gameOver();
                }
            }
        });

        test_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (test_button4.getText() == tAnswers){
                    tScore++;
                    scoreTest.setText("Puntuación: " + tScore);
                    //updateQuestions(r.nextInt(tQuestionsLenght));
                    //Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_LONG).show();

                    if (turn < list){
                        turn++;
                        updateQuestions(turn);
                        //updateQuestions(r.nextInt(turn));
                    } else {
                        //Toast.makeText(getActivity(), "You finished the game!", Toast.LENGTH_LONG).show();
                        gameOver();
                    }
                } else {
                   // Toast.makeText(getActivity(), "Wrong!", Toast.LENGTH_LONG).show();

                    if (turn < list){
                        turn++;
                        updateQuestions(turn);
                        //updateQuestions(r.nextInt(turn));
                    } else {
                       // Toast.makeText(getActivity(), "You finished the game!", Toast.LENGTH_LONG).show();
                        gameOver();
                    }
                    //gameOver();
                }
                /*
                if (test_button4.getText().toString().equalsIgnoreCase(list.get(turn -1).getNameTest())){
                    Toast.makeText(getActivity(), "Correct!", Toast.LENGTH_LONG).show();

                    if (turn < list.size()){
                        turn++;
                        newQuestions(turn);
                    } else {
                        Toast.makeText(getActivity(), "You finished the game!", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "Wrong!", Toast.LENGTH_LONG).show();
                } */
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
    private void updateQuestions(int num) {
        questionT.setText(testQuestions.getQuestions(num));
        imageViewTest.setImageResource(testQuestions.getTestImage(num));
        test_button1.setText(testQuestions.getChoice1(num));
        test_button2.setText(testQuestions.getChoice2(num));
        test_button3.setText(testQuestions.getChoice3(num));
        test_button4.setText(testQuestions.getChoice4(num));

        tAnswers = testQuestions.getCorrectAnswer(num);
    }


    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder
                .setMessage("Tu puntuación es: " + tScore + " puntos.")
                .setCancelable(false)
                .setNeutralButton("MENU", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getActivity(), Home.class));
                        getActivity().finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        TextView textView = (TextView) alertDialog.findViewById(android.R.id.message);
        textView.setTextSize(50);
        alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
    }

}
