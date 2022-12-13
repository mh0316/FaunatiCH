package utils;

public class VerificadorRut {

    private static String obtenerDigitoVerificador(String rut) {
        return rut.substring(rut.length() - 1);
    }

    public static String obtenerRutSinDigitoVerificador(String rut) {
        return rut.substring(0, rut.length() - 1);
    }

    private static int verificarNumeroDeRut(String rutSinDigitoVerificador) {
        try {
            return Integer.parseInt(rutSinDigitoVerificador);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    private static String limpiarRut(String rut) {
        rut = rut.replaceAll("\\p{Punct}", "");
        return rut;
    }

    private static boolean contieneSimbolos(String rut){
        var rutLimpio = limpiarRut(rut);
        if (rut.equals(rutLimpio)){
            return false;
        }else {
            return true;
        }
    }






    private static int convertirDigitoVerificadorAInt(String digitoVerificador) {
        int digitoVerificadorUsuario;

        if (digitoVerificador.equalsIgnoreCase("k")) {
            digitoVerificadorUsuario = 10;
        } else if (digitoVerificador.equals("0")) {
            digitoVerificadorUsuario = 11;
        } else {
            try {
                digitoVerificadorUsuario = Integer.parseInt(digitoVerificador);
            } catch (NumberFormatException e) {
                digitoVerificadorUsuario = 12;
            }
        }
        return digitoVerificadorUsuario;
    }

    private static char[] convertirIntAArreglo(int rut) {
        return String.valueOf(rut).toCharArray();
    }

    private static char[] invertirRut(char[] rutChar) {
        char[] rutInvertido = new char[rutChar.length];

        for (int i = rutChar.length - 1, j = 0; i >= 0; i--, j++) {

            rutInvertido[j] = rutChar[i];
        }

        return rutInvertido;
    }

    private static int[] crearCadenaParaMultiplicar(char[] rutInvertido) {
        int[] cadenaParaMultiplicar = new int[rutInvertido.length];
        int numMultiplicador = 2;

        for (int i = 0; i < rutInvertido.length; i++) {
            if (numMultiplicador < 8) {
                cadenaParaMultiplicar[i] = numMultiplicador;
                numMultiplicador++;

            } else {
                numMultiplicador = 2;
                i--;

            }
        }

        return cadenaParaMultiplicar;
    }

    public static boolean validarRut(String input) {
        if (input.equals(limpiarRut(input))){
            input = limpiarRut(input);

            String rutSinDigito = obtenerRutSinDigitoVerificador(input);
            String digitoVerificador = obtenerDigitoVerificador(input);
            int rut = verificarNumeroDeRut(rutSinDigito);
            char[] rutChar = convertirIntAArreglo(rut);
            char[] rutInvertido = invertirRut(rutChar);
            int[] cadenaParaMultiplicar = crearCadenaParaMultiplicar(rutInvertido);
            int multiplicacionCadenas = multiplicarArreglos(cadenaParaMultiplicar, rutInvertido);
            int resultadoDigitoVerificador = calcularDigitoVerificador(multiplicacionCadenas);
            int digitoVerificadorUsuario = convertirDigitoVerificadorAInt(digitoVerificador);
            return (digitoVerificadorUsuario == resultadoDigitoVerificador);
        }else {
            return false;
        }
    }

    private static int multiplicarArreglos(int[] arregloParaMultiplicar, char[] rutInvertido) {
        int multiplicacionDeArreglos = 0;

        for (int i = 0; i < rutInvertido.length; i++) {
            int digitoRutAMultiplicar = convertirCharAInt(rutInvertido[i]);
            int auxMultiplicacion = arregloParaMultiplicar[i] * digitoRutAMultiplicar;
            multiplicacionDeArreglos += auxMultiplicacion;
        }

        return multiplicacionDeArreglos;
    }


    private static int convertirCharAInt(char caracterRutInvertido) {
        String digitoString = String.valueOf(caracterRutInvertido);
        return Integer.parseInt(digitoString);
    }


    private static int calcularDigitoVerificador(int multiplicacionCadenas) {
        int division = multiplicacionCadenas / 11;
        int multiplicacionFinal = division * 11;

        return 11 - (multiplicacionCadenas - multiplicacionFinal);
    }
}