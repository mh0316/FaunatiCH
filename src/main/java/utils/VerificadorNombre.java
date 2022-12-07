package utils;

public class VerificadorNombre {
    public static boolean validarNombre(String nombre){
        return nombre.length() < 11;
    }

}
