package com.androidag.sqlitelogin.exercises;

import com.androidag.sqlitelogin.R;

public class PerceptionQuestionModel2 {

    public Integer perceptionQuestion[] = {
            R.mipmap.perce_soda
    };

    public Integer perceptionChoice[][] = {
            {R.mipmap.perce_soda,
                    R.mipmap.perce_soda,
                    R.mipmap.perce_soda,
                    R.mipmap.perce_soda,
                    R.mipmap.perce_soda,
                    R.mipmap.perce_soda}
    };


    public Integer answers[] = {
            R.mipmap.perce_soda
    };

    public Integer getPerceptionQuestion(int a) {
        Integer imagePerception = perceptionQuestion[a];
        return imagePerception;
    }

    public Integer getChoice1 (int a){
        Integer choice = perceptionChoice[a] [0];
        return choice;
    }

    public Integer getChoice2 (int a){
        Integer choice = perceptionChoice[a] [1];
        return choice;
    }

    public Integer getChoice3 (int a){
        Integer choice = perceptionChoice[a] [2];
        return choice;
    }

    public Integer getChoice4 (int a){
        Integer choice = perceptionChoice[a] [3];
        return choice;
    }

    public Integer getChoice5 (int a){
        Integer choice = perceptionChoice[a] [4];
        return choice;
    }

    public Integer getChoice6 (int a){
        Integer choice = perceptionChoice[a] [5];
        return choice;
    }

    public Integer getCorrectAnswer(int a){
        Integer answersss = answers[a];
        return answersss;
    }
}
