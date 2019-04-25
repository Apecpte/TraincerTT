package com.androidag.sqlitelogin.exercises;

public class LanguageQuestionModel2 {

    public String languageQuestions[] = {
            "Hoy estu",
            "El arroz pesa",
            "No me ",
            "Hoy ",
            "Las ",
            "El pá",
            "Los domin",
            "Estu",
            "",
            "A mi "
    };

    public String languageQuestions2[] = {
            "e con mi ",
            "a un kilo en la ",
            "usta tomar ",
            "e comido crema de cala",
            "elas del ",
            "aro se escapó de la ",
            "os no ",
            "e jugando al ",
            "eneralmente voy al ",
            "ermana Candy le dio "
    };

    public String languageQuestions3[] = {
            "ermana en la feria.",
            "alanza.",
            "arabe.",
            "aza.",
            "arco eran blancas.",
            "aula.",
            "ay colegio.",
            "alón.",
            "imnasio los martes.",
            "ripa."
    };

    public String languageChoice[][] = {
            {"v & h", "b & j", "b & h"},
            {"b & v", "v & b", "b & b"},
            {"j & g", "g & j", "g & j"},
            {"l & b", "h & b", "h & v"},
            {"v & b", "b & v", "b & b"},
            {"g & j", "j & j", "j & g"},
            {"j & d", "g & h", "j & h"},
            {"v & v", "b & b", "v & b"},
            {"g & g", "g & j", "j & g"},
            {"h & g", "h & j", "h & b"}
    };

    public String answers[] = {
            "v & h",
            "b & b",
            "g & j",
            "h & b",
            "v & b",
            "j & j",
            "g & h",
            "v & b",
            "g & g",
            "h & g"
    };

    public String getlanguageQuestions(int a) {
        String questions1 = languageQuestions[a];
        return questions1;
    }

    public String getlanguageQuestions2(int b) {
        String questions2 = languageQuestions2[b];
        return questions2;
    }

    public String getlanguageQuestions3(int c) {
        String questions3 = languageQuestions3[c];
        return questions3;
    }

    public String getChoice1 (int a){
        String choice = languageChoice[a] [0];
        return choice;
    }

    public String getChoice2 (int a){
        String choice = languageChoice[a] [1];
        return choice;
    }

    public String getChoice3 (int a){
        String choice = languageChoice[a] [2];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answersss = answers[a];
        return answersss;
    }
}