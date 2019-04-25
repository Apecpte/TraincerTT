package com.androidag.sqlitelogin.exercises;

public class LanguageQuestionModel {

    public String languageQuestions[] = {
            "C a m p ",
            "C o r a ",
            "P a l ",
            "C ",
            "P a r ",
            "V e r a ",
            "L ",
            "F r a ",
            "C o ",
            "E s t "
    };

    public String languageQuestions2[] = {
            " n a",
            " ó n",
            " m a",
            " g u e ñ a",
            " g u a y a",
            " r u z",
            " c t u r a",
            " c i ó n",
            " i m a",
            " d i a n t e"
    };

    public String languageChoice[][] = {
            {"e", "a"},
            {"s", "z"},
            {"o", "i"},
            {"i", "y"},
            {"e", "a"},
            {"c", "g"},
            {"e", "i"},
            {"s", "c"},
            {"r", "l"},
            {"a", "u"}
    };

    public String answers[] = {
            "a",
            "z",
            "o",
            "i",
            "a",
            "c",
            "e",
            "c",
            "l",
            "u"
    };

    public String getlanguageQuestions(int a) {
        String questions1 = languageQuestions[a];
        return questions1;
    }

    public String getlanguageQuestions2(int b) {
        String questions2 = languageQuestions2[b];
        return questions2;
    }

    public String getChoice1 (int a){
        String choice = languageChoice[a] [0];
        return choice;
    }

    public String getChoice2 (int a){
        String choice = languageChoice[a] [1];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answersss = answers[a];
        return answersss;
    }
}
