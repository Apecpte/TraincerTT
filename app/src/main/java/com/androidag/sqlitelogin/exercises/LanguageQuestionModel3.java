package com.androidag.sqlitelogin.exercises;

public class LanguageQuestionModel3 {

    public String languageQuestions[] = {
            "",
            "El a",
            "El ",
            "",
            "Mi ",
            "El ",
            "",
            "M",
            "El ",
            "El caballo ne"
    };

    public String languageQuestions2[] = {
            "oy he jugado al ",
            "ión ",
            "avilán es un a",
            "e dormido ",
            "ecino es ",
            "ueves fu",
            "oy ",
            " deporte fa",
            "ugo de naran",
            "ro era el que me"
    };

    public String languageQuestions3[] = {
            "alón con mi ",
            "iaja a gran ",
            "e de rap",
            "asta las nue",
            "ailarín profe",
            "mo",
            "a sido un día muy ",
            "orito es el ",
            "a es rico en ",
            "or "
    };

    public String languageQuestions4[] = {
            "ecino.",
            "elocidad.",
            "ña.",
            "e.",
            "ional.",
            " al cine.",
            "onito.",
            "aloncesto.",
            "itamina C.",
            "alopaba."
    };


    public String languageChoice[][] = {
            {"h & b & b", "h & v & b", "d & v & v", "h & b & v"},
            {"v & b & v", "b & v & v", "v & v & v", "v & b & b"},
            {"j & v & i", "j & b & i", "g & v & i", "g & b & i"},
            {"h & h & b", "j & h & v", "h & p & v", "h & h & v"},
            {"v & b & s", "b & v & s", "v & b & z", "v & v & z"},
            {"j & i & z", "g & i & z", "j & i & s", "g & i & s"},
            {"d & h & v", "d & h & b", "h & h & v", "h & h & b"},
            {"i & v & b", "i & b & b", "i & b & v", "y & v & b"},
            {"g & j & v", "j & j & b", "j & j & v", "j & g & v"},
            {"j & j & g", "g & j & g", "g & j & j", "g & g & g"}
    };

    public String answers[] = {
            "h & b & v",
            "v & v & v",
            "g & v & i",
            "h & h & v",
            "v & b & s",
            "j & i & s",
            "h & h & b",
            "i & v & b",
            "j & j & v",
            "g & j & g"
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

    public String getlanguageQuestions4(int d) {
        String questions4 = languageQuestions4[d];
        return questions4;
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

    public String getChoice4 (int a){
        String choice = languageChoice[a] [3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answersss = answers[a];
        return answersss;
    }
}
