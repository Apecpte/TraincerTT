package com.androidag.sqlitelogin.exercises;

public class LanguQuestionModel {

    public String languQuestions[] = {
            "Objeto de metal que con el que abrimos y cerramos puertas, que se mete y se gira en la cerradura: ",
            "Órgano del cuerpo que mueve la sangre: ",
            "Objeto que usamos para peinarnos: ",
            "Objeto que nos protege de la lluvia. Se abre y se cierra: ",
            "Cubren los pies, sirven para caminar: ",
            "Parte del cuerpo que nos permite oír: ",
            "Objeto con cristal y patillas para ver mejor: ",
            "Líquido que nos ponemos para oler mejor: ",
            "Parte del cuerpo con la que olemos y respiramos: ",
            "Fruta de color verde por fuera, blanca por dentro y con mucha agua: "
    };

    public String languChoice[][] = {
            {"Llaves", "Libro"},
            {"Corazón", "León"},
            {"Leña", "Peine"},
            {"Paraguas", "Toro"},
            {"Globo", "Zapatos"},
            {"Oreja", "Chicle"},
            {"Zurno", "Lentes"},
            {"Tila", "Colonia"},
            {"Nariz", "Lomo"},
            {"Pera", "Pluma"}
    };

    public String answers[] = {
            "Llaves",
            "Corazón",
            "Peine",
            "Paraguas",
            "Zapatos",
            "Oreja",
            "Lentes",
            "Colonia",
            "Nariz",
            "Pera"
    };

    public String getlanguQuestions(int a) {
        String questions1 = languQuestions[a];
        return questions1;
    }

    public String getChoice1 (int a){
        String choice = languChoice[a] [0];
        return choice;
    }

    public String getChoice2 (int a){
        String choice = languChoice[a] [1];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answersss = answers[a];
        return answersss;
    }
}
