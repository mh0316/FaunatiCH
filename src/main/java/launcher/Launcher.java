package launcher;

import dato.DatosJugadores;
import modelo.ConjuntoJugadores;
import modelo.JugadorNoEncontradoException;
import modelo.PortalDeInicio;

public class Launcher {
    public static void main(String[] args) throws JugadorNoEncontradoException {
        ConjuntoJugadores conjuntoJugadores = new ConjuntoJugadores();
        DatosJugadores.leerArchivoJugador(conjuntoJugadores, "./src/main/resources/conjuntoJugadores.txt");
        PortalDeInicio.mostrarTextoDeBienvenida();
        PortalDeInicio.mostrarOpcionesPortalInicio(conjuntoJugadores);
    }
}