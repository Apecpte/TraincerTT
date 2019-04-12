package com.androidag.sqlitelogin.exercises;

public class LanguQuestionModel2 {

    public String languQuestions[] = {
            "Lugar al que van los niños para aprender: ",
            "Trozo cuadrado de tela que se usa para secarse: ",
            "Objeto de cocina que fríe alimentos, de metal con un mango alargado: ",
            "Recipiente parecido a un vaso, más pequeño, con asa que se usa para tomar café: ",
            "Ensuciar algo: ",
            "Prenda de vestir larga que se ata a la cintura y se usa en casa: ",
            "Pelos que están por encima de los ojos: ",
            "Palo de metal o de madera para apoyarse al caminar: ",
            "Reparar un objeto que está estropeado: ",
            "Pieza blanca y dura que tenemos en la boca y sirve para morder: "
    };

    public String languChoice[][] = {
            {"Cordón", "Colegio", "Castor"},
            {"Toalla", "Dátil", "Carmín"},
            {"Puente", "Jaula", "Sartén"},
            {"Trasto", "Pila", "Taza"},
            {"Oler", "Manchar", "Subir"},
            {"Zapato", "Bata", "Tapa"},
            {"Cena", "Ceja", "Piel"},
            {"Pistón", "Rueda", "Bastón"},
            {"Comprar", "Arreglar", "Repasar"},
            {"Lengua", "Diente", "Garganta"}
    };

    public String answers[] = {
            "Colegio",
            "Toalla",
            "Sartén",
            "Taza",
            "Manchar",
            "Bata",
            "Ceja",
            "Bastón",
            "Arreglar",
            "Diente"
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

    public String getCorrectAnswer(int a){
        String answersss = answers[a];
        return answersss;
    }
}
