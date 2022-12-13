package modelo;

import java.util.ArrayList;


public class PortalDeInicio {

    public static Jugador crearCuentaParaVentana(String nombre, String rut, String contrasena) {

        var animalinicial = Animal.crearAnimalInicial();
        var animales = new ArrayList<Animal>();
        animales.add(animalinicial);
        var parcheCurita = "0";
        return new Jugador(nombre, rut, contrasena, parcheCurita, animales);
    }

    public static boolean validarContrasenaCorrecta(ConjuntoJugadores conjuntoJugadores, String rut, String contrasenia) { //borré el throw considerar para futuros errores
        try {
            var jugadorRegistrado = conjuntoJugadores.buscarJugadorPorRut(rut);
            return jugadorRegistrado.getContrasenia().equals(contrasenia);
        } catch (Exception JugadorNoEncontradoException) {
            System.out.println("No existe un usuario registrado con este rut, intente nuevamente");
        }
        return false;
    }
}