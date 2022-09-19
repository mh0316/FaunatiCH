import java.util.Scanner;

public class FaunatiCH {
    public static void main(String[] args) {
        iniciarJuego();
    }

    public static void iniciarJuego() {
        mostrarTextoDeBienvenida();
        mostrarMenu();
        opcionesMenu(ingresar());
    }

    private static void opcionesMenu(int opcionIngresada) {
        switch (opcionIngresada) {
            case 1 -> comenzarJuego();
            case 2 -> mostrarEstadisticas();
            case 3 -> salirDelJuego();
            default -> {
                System.out.println("Por favor ingrese un número válido:");
                opcionesMenu(ingresar());
            }
        }
    }

    private static void comenzarJuego() {
        mostrarMapaGeografico();
        int zona = elegirZona(ingresar());
        mostrarAnimalesZonaElegida(zona);

        String[][] animalEnemigo = elegirAnimalPorZona(zona);
        String[][] animalJugador = generarAnimalUsuario();

        mostrarCombate(animalEnemigo, animalJugador);
        combatir(animalEnemigo, animalJugador);
    }

    private static void mostrarAnimalesZonaElegida(int zona) {
        switch (zona) {
            case 1 -> mostrarAnimalesZonaNorte();
            case 2 -> mostrarAnimalesZonaCentral();
            case 3 -> mostrarAnimalesZonaSur();
        }
    }

    public static void combatir(String[][] animalEnemigo, String[][] animalJugador) {
        int vidaAnimalEnemigo = Integer.parseInt(animalEnemigo[1][0]);
        int vidaAnimalJugador = Integer.parseInt(animalJugador[1][0]);

        while (vidaAnimalJugador >= 0 && vidaAnimalEnemigo >= 0) {
            mostrarNivelDeVidaAnimales(animalEnemigo, animalJugador, vidaAnimalJugador, vidaAnimalEnemigo);

            int ataqueJugador = jugadaDeUsuario(animalJugador);
            vidaAnimalEnemigo -= ataqueJugador;

            if (!(vidaAnimalEnemigo >= 0)) {
                break;
            } else {
                int ataqueAnimalEnemigo = jugadaDeCPU(animalEnemigo);
                vidaAnimalJugador -= ataqueAnimalEnemigo;
            }
        }
    }

    public static int jugadaDeCPU(String[][] animalEnemigo) {
        int ataqueAleatorio = (int) ((Math.random() * animalEnemigo[2].length));
        mostrarAtaque(animalEnemigo, ataqueAleatorio);
        return Integer.parseInt(animalEnemigo[3][ataqueAleatorio]);
    }

    public static int jugadaDeUsuario(String[][] animalJugador) {
        mostrarOpcionesDeAtaque(animalJugador);
        int opcionDeAtaque = pedirOpcionDeAtaque(ingresar(), animalJugador);
        mostrarAtaque(animalJugador, opcionDeAtaque - 1);
        return Integer.parseInt(animalJugador[3][opcionDeAtaque - 1]);
    }

    private static void mostrarAtaque(String[][] animal, int opcionDeAtaque) {
        String nombreAnimal = animal[0][0];
        String ataque = animal[2][opcionDeAtaque];
        String puntosDeVida = animal[3][opcionDeAtaque];

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println(nombreAnimal + " ha usado " + ataque + ", y ha quitado " + puntosDeVida + " puntos de vida!");
        System.out.println("---------------------------------------------------------------------------------------------");
    }

    private static int pedirOpcionDeAtaque(int opcionIngresada, String[][] animalJugador) {
        if (opcionIngresada < 1 || opcionIngresada > animalJugador[2].length) {
            System.out.println("Por favor ingrese un número válido:");
            return pedirOpcionDeAtaque(ingresar(), animalJugador);
        }
        return opcionIngresada;
    }

    private static String[][] generarAnimalUsuario() {
        return new String[][]{{"Condor"}, {"50"}, {"Picoton", "Intimidacion", "Mordida"}, {"5", "3", "4"}};
    }

    private static String[][] elegirAnimalPorZona(int zona) {
        switch (zona) {
            case 1:
                return elegirAnimalZonaNorte(ingresar());
            case 2:
                return elegirAnimalZonaCentral(ingresar());
            case 3:
                return elegirAnimalZonaSur(ingresar());
            default:
                System.out.println("Elija una opción válida");
                return elegirAnimalPorZona(ingresar());
        }
    }

    private static int elegirZona(int opcionIngresada) {
        if (opcionIngresada < 1 || opcionIngresada > 3) {
            System.out.println("Por favor ingrese una opción válida");
            return elegirZona(ingresar());
        }
        return opcionIngresada;
    }

    private static String[][] elegirAnimalZonaNorte(int opcionIngresada) {
        String[][] caracteristicasAlpaca = {{"Alpaca"}, {"30"}, {"Escupitajo", "Patada", "Mordida"}, {"5", "3", "4"}};
        String[][] caracteristicasVicuña = {{"Vicuña"}, {"30"}, {"Mordizco", "Patada", "Embestida"}, {"5", "3", "4"}};
        String[][] caracteristicasGuanaco = {{"Guanaco"}, {"30"}, {"Escupo", "Patada", "Embestida"}, {"5", "3", "4"}};
        String[][] caracteristicasLlama = {{"Llama"}, {"30"}, {"Escupo", "Silbar", "Embestida"}, {"5", "3", "4"}};

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
                return elegirAnimalZonaNorte(ingresar());
        }
    }

    private static String[][] elegirAnimalZonaCentral(int opcionIngresada) {
        String[][] caracteristicasZorroCulpeo = {{"Zorro Culpeo"}, {"30"}, {"Mordedura", "Patada", "Ataque random"}, {"5", "3", "4"}};
        String[][] caracteristicasPuma = {{"Puma"}, {"30"}, {"Mordizco", "Embestida", "Arañazo"}, {"5", "3", "4"}};
        String[][] caracteristicasAguilaMora = {{"Águila Mora"}, {"30"}, {"Garras", "En Picada", "Picotazo"}, {"5", "3", "4"}};

        switch (opcionIngresada) {
            case 1:
                return caracteristicasZorroCulpeo;
            case 2:
                return caracteristicasPuma;
            case 3:
                return caracteristicasAguilaMora;
            default:
                System.out.println("Por favor ingrese un número válido:");
                return elegirAnimalZonaCentral(ingresar());
        }
    }

    private static String[][] elegirAnimalZonaSur(int opcionIngresada) {
        String[][] caracteristicasPinguino = {{"Pinguino"}, {"30"}, {"Picar", "Aletazo", "Ataque random"}, {"4", "5", "3"}};
        String[][] caracteristicasZorroPatagonico = {{"Zorro Patagonico"}, {"30"}, {"Mordizco", "Garras", "Ataque random 2"}, {"3", "5", "6"}};
        String[][] caracteristicasÑandu = {{"Ñandu"}, {"31"}, {"Aleteo", "Patada", "ataque random"}, {"7", "4", "4"}};

        switch (opcionIngresada) {
            case 1:
                return caracteristicasPinguino;
            case 2:
                return caracteristicasZorroPatagonico;
            case 3:
                return caracteristicasÑandu;
            default:
                System.out.println("Por favor ingrese un número válido:");
                return elegirAnimalZonaSur(ingresar());
        }
    }

    private static String[][] caracteristicasAnimalesZonaNorte() {
        String[][] caracteristicasAlpaca = {{"Vida", "Espupitazo"}, {"30", "5", "3"}};

        String[][] caracteristicasVicuña = {{"Vida", "Mortizco", "Patada"}, {"30", "5", "3"}};

        String[][] caracteristicasGuanaco = {{"Vida", "Escupo", "Patada"}, {"30", "4", "4"}};

        String[][] caracteristicasLlama = {{"Vida", "Escupo", "Silbar"}, {"30", "5", "5"}};

        return caracteristicasLlama;
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

    private static void mostrarOpcionesDeAtaque(String[][] animalJugador) {
        System.out.println("¿Que ataque deberia hacer " + animalJugador[0][0] + "?:");

        for (int i = 0; i < animalJugador[2].length; i++) {
            System.out.println((i + 1) + ". " + animalJugador[2][i]);
        }
    }


    private static void mostrarNivelDeVidaAnimales(String[][] animalElegidoEnZonaJugando, String[][] animalUsuarioJugando, int vidaAnimalJugador, int vidaAnimalEnemigo) {
        System.out.println("Vida de " + animalElegidoEnZonaJugando[0][0] + ": " + vidaAnimalEnemigo);
        System.out.println("Vida de " + animalUsuarioJugando[0][0] + ": " + vidaAnimalJugador);
        System.out.println();
    }

    private static void mostrarCombate(String[][] animalDelUsuario, String[][] animalElegidoEnZona) {
        System.out.println("El combate será " + animalDelUsuario[0][0] + " vs " + animalElegidoEnZona[0][0]);
    }

    private static void salirDelJuego() {
        System.out.println("Juego terminado.");
    }

    private static void mostrarAnimalesZonaNorte() {
        System.out.println("""
                Estos son los animales que puede usar en esta zona.
                Elija alguno:
                1. Alpaca
                2. Vicuña
                3. Guanaco.
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

    private static void mostrarMapaGeografico() {
        System.out.println("""
                A continuación elija la zona geográfica con la que desea empezar:
                1. Zona norte.
                2. Zona central.
                3. Zona sur.""");
    }

    private static void mostrarEstadisticas() {
        System.out.println("""
                Sus estadísticas de juego son las siguientes:
                Nivel 1: .....
                Nivel 2: .....
                Nivel 3: .....""");
    }

    private static void mostrarMenu() {
        System.out.println("""
                Ingrese una opción:
                1. Empezar.
                2. Mostrar estadísticas.
                3. Salir del juego.""");
    }

    private static void mostrarTextoDeBienvenida() {
        System.out.println("BIENVENIDO A FAUNATICH!");
        System.out.println("Este juego te ayudará a aprender sobre la fauna Chilena de una manera muy entretenida.");
    }
}