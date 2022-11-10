package dato;

public class VerificadorContrasenia {

    public static boolean verificarContrasenia(String contrasena){
        return esAlfaNumericoYTamanioCorrecto(contrasena);
    }

    //se eliminó el validador de tamaño ahora con expresiones regulares validamos tamaño correcto tambien
    //no se deja ante la posibilidad de futuras extra validaciones
    public static boolean esAlfaNumericoYTamanioCorrecto(String s) {
        return s.matches("^\\w{8,12}$");
    }
}
