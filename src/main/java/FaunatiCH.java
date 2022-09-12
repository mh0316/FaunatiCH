import java.util.Scanner;

public class FaunatiCH {
    public static void main(String[] args) {
        iniciarJuego();
    }

    public static void iniciarJuego(){
        System.out.println("BIENVENIDO A FAUNATICH");
        System.out.println("Este juego te ayudará a aprender sobre la fauna Chilena de una manera muy entretenida.");
        mostrarMenu();
    }

    private static void mostrarMenu(){
        System.out.println("""
                Ingrese una opción:
                1. Empezar.
                2. Mostrar estadísticas.
                3. Salir del juego.""");
        opcionesMenu(ingresar());
    }

    private static void opcionesMenu(int opcionIngresada){
        switch (opcionIngresada) {
            case 1 -> empezar();
            case 2 -> mostrarEstadisticas();
            case 3 -> salirDelJuego();
            default -> {
                System.out.println("Por favor ingrese un número válido:");
                opcionesMenu(ingresar());
            }
        }
    }

    private static void empezar(){
        System.out.println("\nA continuación elija la zona geográfica con la que desea empezar:");
        mostrarMapaGeografico();
        opcionesMapa(ingresar());
        opcionesPorZonaElegida(ingresar());
    }

    private static void opcionesPorZonaElegida(int opcionIngresada){
        switch (opcionIngresada){
            case 1:
                opcionesAnimalesZonaNorte(opcionIngresada);
                break;
            case 2:
                opcionesAnimalesZonaCentral(opcionIngresada);
                break;
            case 3:
                opcionesAnimalesZonaSur(opcionIngresada);
                break;
        }
    }

    private static void mostrarMapaGeografico(){
        System.out.println("""
                1. Zona norte.
                2. Zona central.
                3. Zona sur.""");
    }

    private static void opcionesMapa(int opcionIngresada){
        switch (opcionIngresada) {
            case 1 -> mostrarAnimalesZonaNorte();
            case 2 -> mostrarAnimalesZonaCentral();
            case 3 -> mostrarAnimalesZonaSur();
            default -> {
                System.out.println("Por favor ingrese un número válido:");
                opcionesMapa(ingresar());
            }
        }
    }

    private static String[][] opcionesAnimalesZonaNorte(int opcionIngresada){
        String[][] caracteristicasAlpaca = {{"Vida","Espupitazo"},{"30","5","3"}};
        String[][] caracteristicasVicuña = {{"Vida","Mortizco","Patada"},{"30","5","3"}};
        String[][] caracteristicasGuanaco = {{"Vida", "Escupo", "Patada"},{"30","4","4"}};
        String[][] caracteristicasLlama = {{"Vida","Escupo","Silbar"},{"30","5","5"}};

        switch (opcionIngresada) {
            case 1:
                return caracteristicasAlpaca;
            case 2:
                return caracteristicasVicuña;
            case 3:
                return caracteristicasGuanaco;
            case 4:
                return caracteristicasLlama;
            default:
                System.out.println("Por favor ingrese un número válido:");
                opcionesAnimalesZonaNorte(ingresar());
        }

        // retorno momentáneo, nunca se debería llegar hasta aquí
        return caracteristicasLlama;
    }

    private static String[][] opcionesAnimalesZonaCentral(int opcionIngresada){
        String[][] caracteristicasZorroCulpeo = {{"Vida","Mordedura"},{"30","5","3"}};
        String[][] caracteristicasPuma = {{"Vida","Mortizco","Embestida"},{"30","5","3"}};
        String[][] caracteristicasAguilaMora = {{"Vida", "Garras", "En Picada"},{"30","4","4"}};

        switch (opcionIngresada) {
            case 1:
                return caracteristicasZorroCulpeo;
            case 2:
                return caracteristicasPuma;
            case 3:
                return caracteristicasAguilaMora;
            default:
                System.out.println("Por favor ingrese un número válido:");
                opcionesAnimalesZonaCentral(ingresar());
        }

        // retorno momentáneo, nunca se debería llegar hasta aquí
        return caracteristicasZorroCulpeo;
    }

    private static String[][] opcionesAnimalesZonaSur(int opcionIngresada){
        String[][] caracteristicasPinguino = {{"Vida","Picar","Aletazo"},{"30","5","3"}};
        String[][] caracteristicasZorroPatagonico = {{"Vida","Mortizco"},{"30","5","3"}};
        String[][] caracteristicasÑandu = {{"Vida", "Aleteo", "Patada"},{"30","4","4"}};

        switch (opcionIngresada) {
            case 1:
                return caracteristicasPinguino;
            case 2:
                return caracteristicasZorroPatagonico;
            case 3:
                return caracteristicasÑandu;
            default:
                System.out.println("Por favor ingrese un número válido:");
                opcionesAnimalesZonaSur(ingresar());
        }

        // retorno momentáneo, nunca se debería llegar hasta aquí
        return caracteristicasPinguino;
    }

    private static void mostrarAnimalesZonaNorte() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona.
                Elija alguno:
                1. Guanaco
                2. Vicuña
                3. Alpaca.
                4. Llama.""");
    }

    private static void mostrarAnimalesZonaCentral() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona.
                Elija alguno:
                1. Zorro Culpeo.
                2. Puma.
                3. Águila Mora.""");
    }

    private static void mostrarAnimalesZonaSur() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona.
                Elija alguno:
                1. Pingüino.
                2. Zorro de la Patagonia.
                3. Ñandú.""");
    }

    private static void mostrarEstadisticas(){
        System.out.println("""
                Sus estadísticas de juego son las siguientes:
                Nivel 1: .....
                Nivel 2: .....
                Nivel 3: .....""");
    }

    private static String[][] caracteristicasAnimalesZonaNorte(){
        String[][] caracteristicasAlpaca = {{"Vida","Espupitazo"},{"30","5","3"}};

        String[][] caracteristicasVicuña = {{"Vida","Mortizco","Patada"},{"30","5","3"}};

        String[][] caracteristicasGuanaco = {{"Vida", "Escupo", "Patada"},{"30","4","4"}};

        String[][] caracteristicasLlama = {{"Vida","Escupo","Silbar"},{"30","5","5"}};

        return caracteristicasLlama;
    }

    private static String[][] caracteristicasAnimalInicial(){
        String[][] caractteristicasQuiltro = {{"Vida","Mordizco","Ladrido"},{"30","6","2"}};
        return caractteristicasQuiltro;
    }

    private static void salirDelJuego(){
        System.out.println("Juego terminado.");
    }

    private static int ingresar() {
        Scanner teclado = new Scanner(System.in);
        int entrada;
        do {
            try {
                entrada = teclado.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Por favor ingrese una opción válida:");
                teclado.nextLine();
            }
        } while (true);
        return entrada;
    }
}
