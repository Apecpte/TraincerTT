package com.androidag.sqlitelogin.exercises;

import android.print.PageRange;

public class LanguageQuestionModel2 {

    public LanguageQuestionModel2(String questionString, String questionString2, String questionString3, String answer, String answer2) {
        QuestionString = questionString;
        QuestionString2 = questionString2;
        QuestionString3 = questionString3;
        Answer = answer;
        Answer2 = answer2;
    }

    public String getQuestionString() {
        return QuestionString;
    }

    public void setQuestionString(String questionString) {
        QuestionString = questionString;
    }

    public String getQuestionString2() {
        return QuestionString2;
    }

    public void setQuestionString2(String questionString2) {
        QuestionString2 = questionString2;
    }

    public String getQuestionString3() {
        return QuestionString3;
    }

    public void setQuestionString3(String questionString3) {
        QuestionString3 = questionString3;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getAnswer2() {
        return Answer2;
    }

    public void setAnswer2 (String answer2) {
        Answer2 = answer2;
    }

    private String QuestionString;
    private String QuestionString2;
    private String QuestionString3;
    private String Answer;
    private String Answer2;
}
