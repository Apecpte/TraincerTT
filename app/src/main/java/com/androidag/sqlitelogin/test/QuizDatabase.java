package com.androidag.sqlitelogin.test;

import com.androidag.sqlitelogin.R;

public class QuizDatabase {


    public String testQuestions[] = {
            "¿Cuál es la secuencia correcta?",
            "¿Qué figura es?",
            "¿Qué hora es en la imagen?",
            "¿Qué animales hay?",
            //"Memoriza las siguientes cinco palabras. Se le pedirá que los nombre de nuevo en unos minutos \nROSTRO \nSEDA \nIGLESIA \nCLAVEL \nROJO",
            "Lea la serie de letras. ¿Cuántas letras “A” hay en la serie?\nFBACMNAAJKLBAFAKDEAAAJAMOFAAB",
            "Réstale 7 al 100. Basándote en ese resultado, réstale otra vez 7. \nSigue restando 7 al resultado tres veces más. \nIdentifica la serie correcta de números de las siguientes opciones.",
            "Si la banana y la naranja son frutas, ¿qué son el tren y la bicicleta?",
            "Escriba la siguiente palabra al revés: \nAMOR",
            "¿Cuál es el año actual?",
            "¿En que país vive?"

    };

    Integer testImage[] = {
            R.drawable.test_image1,
            R.drawable.cubo,
            R.drawable.test_image3,
            R.drawable.test_image4,
            0,
            0,
            0,
            0,
            0,
            0
    };

    public String testChoice[][] = {
            {"1-A-2-3-4-5-B-C-D-E","1-A-2-3-B-C-4-5-D-E", "1-A-2-B-3-C-4-D-5-E", "1-A-2-B-C-3-4-D-E-5"},
            {"Cuadrado", "Rombo", "Prisma rectangular", "Cubo"},
            {"Once minutos pasada las diez","Once y diez", "Diez y diez", "Once y dos"},
            {"León, rinoceronte y camello","Tigre, rinoceronte y camello", "León, vacuno y camello", "León, rinoceronte y jirafa"},
            {"12","9", "10", "11"},
            {"93, 86, 78, 71, 64","93, 86, 79, 72, 65", "92, 97, 80, 73, 66", "93, 85, 79, 72, 65"},
            {"Deportes","Medios de transporte", "Carreteras", "Oficios"},
            {"ROMA", "RONA", "RANA", "MORA"},
            {"2020", "2018", "2019", "2017"},
            {"Estados Unidos","América", "Estado de México", "México"}
    };

    public String answers[] = {
            "1-A-2-B-3-C-4-D-5-E",
            "Trapezoide",
            "Once y diez",
            "León, rinoceronte y camello",
            "11",
            "93, 86, 79, 72, 65",
            "Medios de transporte",
            "ROMA",
            "2019",
            "México"
    };
/*
    public int scooreQ[] = {
            1,
            1,
            3,
            3,
            1,
            3,
            2,
            2,
            3,
            3
    };
    */

    public String getQuestions(int a) {
        String questions = testQuestions[a];
        return questions;
    }

    public int getTestImage(int a) {
        int imageTest = testImage[a];
        return imageTest;
    }

    public String getChoice1 (int a){
        String choice = testChoice[a] [0];
        return choice;
    }

    public String getChoice2 (int a){
        String choice = testChoice[a] [1];
        return choice;
    }

    public String getChoice3 (int a){
        String choice = testChoice[a] [2];
        return choice;
    }

    public String getChoice4 (int a){
        String choice = testChoice[a] [3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answersss = answers[a];
        return answersss;
    }
}
