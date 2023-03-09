package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerificadorCorreo {

    public static boolean verificarCorreo(String correoElectronico){
        //Patrón para validar el email
        Pattern patron = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = patron.matcher(correoElectronico);

        return mather.find();
    }

    /*private static boolean verificarCorreo(Matcher mather){

        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
        } else {
            System.out.println("El email ingresado es inválido.");
        }
        return mather.find();
    }*/

}