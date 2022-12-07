package launcher;

import dato.DatosJugadores;
import guis.VentanaInicioDeSesion;
import modelo.*;

import java.util.ArrayList;
import java.util.List;

public class Launcher {
    public static void main(String[] args) throws JugadorNoEncontradoException {
        /*ConjuntoJugadores conjuntoJugadores = new ConjuntoJugadores();
        DatosJugadores.leerArchivoJugador(conjuntoJugadores, "D:\\Marcelo 2022\\UFRO\\Ingeniería civil informática\\Segundo Semestre 2022\\Asignaturas\\Programación\\Programas IntelliJ\\FaunatiCH\\src\\conjuntoJugadores.txt");
        PortalDeInicio.mostrarTextoDeBienvenida();
        PortalDeInicio.mostrarOpcionesPortalInicio(conjuntoJugadores);*/

        VentanaInicioDeSesion ventanaInicioDeSesion = new VentanaInicioDeSesion();
        ventanaInicioDeSesion.setVisible(true);
    }
}