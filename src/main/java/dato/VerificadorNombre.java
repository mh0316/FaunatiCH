package dato;

public class VerificadorNombre {
    public static boolean validarNombre(String nombre){
        if(nombre.length() > 10){
            return false;
        }else {
            return true;
        }
    }
}
