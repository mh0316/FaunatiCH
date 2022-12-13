package utils;

public class VerificadorNombre {
    public static boolean validarNombre(String nombre){
        if(nombre.length() > 10 || nombre.contains(" ")){
            return false;
        }else {
            return true;
        }
    }
}