package dato;

public class VerificadorContraseña {

    public static boolean verificarContraseña(String contrasena){
        if(esAlfaNumerico(contrasena)){
            return true;
        }else {
            return false;
        }
    }

    //TODO reparar que valide correctamente que sea alfanumerico, actualmente acepta todo
    public static boolean esAlfaNumerico(String s) {
        return s.matches("^\\w{8,12}$");
    }
}
