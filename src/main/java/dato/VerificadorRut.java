package dato;

public class VerificadorRut {
    private static String limpiarRut(String input) {
        input = input.replaceAll("\\p{Punct}", "");
        return input;
    }

    public static String obtenerRutSinDigito(String rut) {
        return rut.substring(0, rut.length() - 1);
    }

    private static int verificarNumeroRut(String rutSinDigito) {
        try {
            return Integer.parseInt(rutSinDigito);
        } catch (NumberFormatException e) {
            return 1;
        }
    }

    private static String obtenerDigito(String rut) {
        return rut.substring(rut.length() - 1);
    }

    private static int convertirDigitoAInt(String digitoVerificador) {
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
        int numeroMultiplicador = 2;

        for (int i = 0; i < rutInvertido.length; i++) {
            if (numeroMultiplicador < 8) {
                cadenaParaMultiplicar[i] = numeroMultiplicador;
                numeroMultiplicador++;
            } else {
                numeroMultiplicador = 2;
                i--;
            }
        }

        return cadenaParaMultiplicar;
    }

    private static int multiplicarCadenas(int[] cadenaParaMultiplicar, char[] rutInvertido) {
        int multiplicacionCadenas = 0;

        for (int i = 0; i < rutInvertido.length; i++) {
            int digitoRutAMultiplicar = convertirCharAInt(rutInvertido[i]);
            int auxMultiplicacion = cadenaParaMultiplicar[i] * digitoRutAMultiplicar;
            multiplicacionCadenas += auxMultiplicacion;
        }

        return multiplicacionCadenas;
    }

    private static int calcularDigitoVerificador(int multiplicacionCadenas) {
        int division = multiplicacionCadenas / 11;
        int multiplicacionFinal = division * 11;

        return 11 - (multiplicacionCadenas - multiplicacionFinal);
    }

    private static int convertirCharAInt(char caracterRutInvertido) {
        String digitoString = String.valueOf(caracterRutInvertido);
        return Integer.parseInt(digitoString);
    }

    public static boolean validarRut(String input) {
        input = limpiarRut(input);
        String rutSinDigito = obtenerRutSinDigito(input);
        String digitoVerificador = obtenerDigito(input);
        int rut = verificarNumeroRut(rutSinDigito);
        char[] rutChar = convertirIntAArreglo(rut);
        char[] rutInvertido = invertirRut(rutChar);
        int[] cadenaParaMultiplicar = crearCadenaParaMultiplicar(rutInvertido);
        int multiplicacionCadenas = multiplicarCadenas(cadenaParaMultiplicar, rutInvertido);
        int resultadoDigitoVerificador = calcularDigitoVerificador(multiplicacionCadenas);
        int digitoVerificadorUsuario = convertirDigitoAInt(digitoVerificador);

        return digitoVerificadorUsuario == resultadoDigitoVerificador;
    }
}