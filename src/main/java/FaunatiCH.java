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
                System.out.println("Por favor ingrese una número válido:");
                opcionesMenu(ingresar());
            }
        }
    }

    private static void empezar(){
        System.out.println("\nA continuación elija la zona geográfica con la que desea empezar:");
        mostrarMapaGeografico();
        opcionesMapa(ingresar());
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
                System.out.println("Por favor ingrese una número válido:");
                opcionesMapa(ingresar());
            }
        }
    }

    private static void mostrarAnimalesZonaNorte() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona:
                1. Guanaco
                2. Vicuña
                3. Alpaca.
                4. Llama.""");
    }

    private static int[] puntajeGuanaco(int[] puntaje){
        int[] guanaco = new int[0];
        return guanaco;
    }

    private static void mostrarAnimalesZonaCentral() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona:
                1. Zorro Culpeo.
                2. Puma.
                3. Águila Mora.
                4. Codorniz.""");
    }

    private static void mostrarAnimalesZonaSur() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona:
                1. Pingüino.
                2. Zorro de la Patagonia.
                3. Ñandú.
                4. Huemul.""");
    }

    private static void mostrarEstadisticas(){
        System.out.println("""
                        Sus estadísticas de juego son las siguientes:
                        Nivel 1: .....
                        Nivel 2: .....
                        Nivel 3: .....""");
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