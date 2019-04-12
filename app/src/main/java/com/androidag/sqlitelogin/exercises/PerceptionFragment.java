package com.androidag.sqlitelogin.exercises;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidag.sqlitelogin.R;
import com.androidag.sqlitelogin.fragments.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerceptionFragment extends Fragment {

    private ImageView imageViewPerception;
    private ImageButton imbCarta1, imbCarta2, imbCarta3, imbCarta4;

    private PerceptionQuestionModel perceptionChoices = new PerceptionQuestionModel();

    private int list = perceptionChoices.perceptionChoice.length -1;

    int currentPosition = 0;
    int numberOfCorrectAnswer = 0;

    public PerceptionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perception, container, false);

        imageViewPerception = (ImageView) view.findViewById(R.id.imageViewPerception1);
        imbCarta1 = view.findViewById(R.id.cartaPerce1);
        imbCarta2 = view.findViewById(R.id.cartaPerce2);
        imbCarta3 = view.findViewById(R.id.cartaPerce3);
        imbCarta4 = view.findViewById(R.id.cartaPerce4);

        updateQuestions(currentPosition);

        imbCarta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WrongAnswer();
            }
        });

        imbCarta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoodAnswer();
            }
        });

        imbCarta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WrongAnswer();
            }
        });

        imbCarta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WrongAnswer();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void updateQuestions(int num) {
        imageViewPerception.setImageResource(perceptionChoices.getPerceptionQuestion(num));
        imbCarta1.setImageResource(perceptionChoices.getChoice1(num));
        imbCarta2.setImageResource(perceptionChoices.getChoice2(num));
        imbCarta3.setImageResource(perceptionChoices.getChoice3(num));
        imbCarta4.setImageResource(perceptionChoices.getChoice4(num));
    }

    private void GoodAnswer(){
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
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        TextView titleB = new TextView(getContext());
        titleB.setText("¡Respuesta incorrecta!");
        titleB.setPadding(10, 10, 10, 10);
        titleB.setGravity(Gravity.CENTER);
        titleB.setTextSize(40);
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
        dialog.getButton(AlertDialog.BUTTON_NEUTRAL).setTextSize(25);
    }


    private void gameOver(){
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
                //getActivity().finish();
                PerceptionFragment2 pe2F = new PerceptionFragment2();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.content_frame, pe2F)
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
        TextView textViewAlert = (TextView) dialog.findViewById(android.R.id.message);
        textViewAlert.setTextSize(30);
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextSize(25);
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextSize(25);
    }
}
