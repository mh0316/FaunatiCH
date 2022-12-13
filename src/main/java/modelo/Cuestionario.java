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

    public Pregunta obtenerPregunta(){
        int nPregunta = (int) (Math.random() * this.preguntas.size());
        return this.preguntas.get(nPregunta);
    }


    /*public Pregunta obtenerUnaPregunta() {
        int nPregunta = (int) (Math.random() * this.cuestionario.size() + 1);
        return cuestionario.get(nPregunta);
    }*/
}