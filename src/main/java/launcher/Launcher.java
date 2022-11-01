package launcher;

import dato.DatosJugadores;
import modelo.ConjuntoJugadores;
import modelo.JugadorNoEncontradoException;
import modelo.PortalDeInicio;

public class Launcher {
    public static void main(String[] args) throws JugadorNoEncontradoException {
        ConjuntoJugadores conjuntoJugadores = new ConjuntoJugadores();
        DatosJugadores.leerArchivoJugador(conjuntoJugadores, "C:\\Users\\npach\\IdeaProjects\\JuegoFaunatich\\conjuntoJugadores.txt");
        PortalDeInicio.mostrarTextoDeBienvenida();
        PortalDeInicio.mostrarOpcionesPortalInicio(conjuntoJugadores);



    }



}
