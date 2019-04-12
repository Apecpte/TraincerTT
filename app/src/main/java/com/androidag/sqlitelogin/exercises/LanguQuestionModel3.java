package com.androidag.sqlitelogin.exercises;

public class LanguQuestionModel3 {

    public String languQuestions[] = {
            "Herramienta de metal que se usa para apalancar y abrir: ",
            "Hijo de mi tío: ",
            "Medio de transporte con trenes que van bajo tierra: ",
            "Cicatriz redonda y pequeña en el vientre, resultado de cortar el cordón umbilical: ",
            "Persona que vende y representa productos: ",
            "Piel que cubre y protege el ojo, puede subir y bajar: ",
            "Sentimiento de terror hacia algo peligroso: ",
            "Dar un consejo sobre algo a una persona: ",
            "Entrometerse en un asunto sin tener permiso ni autoridad: ",
            "Formarse una idea a partir de pocos datos y sin tener seguridad sobre ello: "
    };

    public String languChoice[][] = {
            {"Pinza", "Palanca", "Palo", "Plomo"},
            {"Nieto", "Yerno", "Primo", "Hermano"},
            {"Submarino", "Puerto", "Metro", "Automóvil"},
            {"Ombligo", "Herida", "Tripa", "Uña"},
            {"Camarera", "Director", "Comerciante", "Cómico"},
            {"Paraguas", "Párpado", "Cortina", "Ceja"},
            {"Miedo", "Amor", "Dolor", "Asco"},
            {"Presionar", "Recomendar", "Admirar", "Olvidar"},
            {"Imitar", "Pecar", "Inmiscuir", "Roer"},
            {"Saber", "Suponer", "Admirar", "Aprender"}
    };

    public String answers[] = {
            "Palanca",
            "Primo",
            "Metro",
            "Ombligo",
            "Comerciante",
            "Párpado",
            "Miedo",
            "Recomendar",
            "Inmiscuir",
            "Suponer"
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

    public String getChoice3 (int a){
        String choice = languChoice[a] [2];
        return choice;
    }

    public String getChoice4 (int a){
        String choice = languChoice[a] [3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answersss = answers[a];
        return answersss;
    }
}
