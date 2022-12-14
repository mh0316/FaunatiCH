package modelo;

import java.util.ArrayList;

public class Cuestionario {
    private ArrayList<Pregunta> preguntas;

    public Cuestionario() {
        this.preguntas = new ArrayList<>();
    }

    public ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }




    /*public Pregunta getCuestionario() {
        int nPregunta = (int) (Math.random() * this.cuestionario.size() + 1);
        return cuestionario.get(nPregunta);
    }*/




}
