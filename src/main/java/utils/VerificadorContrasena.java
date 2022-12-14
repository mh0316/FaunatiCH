package utils;

public class VerificadorContrasena {
    public static boolean verificarContrasena(String contrasena){
        return esAlfaNumerico(contrasena) && !esEspacioVacio(contrasena) && esLongitudCorrecta(contrasena);
    }

    public static boolean esAlfaNumerico(String s) {
        return s != null && s.matches("^[a-zA-Z0-9]*$");
    }

    private static boolean esEspacioVacio(String contrasena){
        return contrasena.isEmpty();
    }

    private static boolean esLongitudCorrecta(String contrasena){
        return contrasena.length() <= 10 && contrasena.length() >= 5;
    }
}