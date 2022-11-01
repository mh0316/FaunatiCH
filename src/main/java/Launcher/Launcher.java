package Launcher;

import dato.DatosJugadores;
import modelo.*;

import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) throws JugadorNoEncontradoException {
        ConjuntoJugadores conjuntoJugadores = new ConjuntoJugadores();
        DatosJugadores.leerArchivoJugador(conjuntoJugadores, "C:\\Users\\npach\\IdeaProjects\\JuegoFaunatich\\conjuntoJugadores.txt");
        PortalDeInicio.mostrarTextoDeBienvenida();
        PortalDeInicio.mostrarOpcionesPortalInicio(conjuntoJugadores);



    }



}