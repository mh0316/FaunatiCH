import java.util.Scanner;

public class FaunatiCH {
    public static void main(String[] args) {
        iniciarJuego();
    }

    public static void iniciarJuego(){
        System.out.println("BIENVENIDO A FAUNATICH ");
        System.out.println("Linea agregada para probar el pull");
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
        mostrarMapaGeografico();
        opcionesMapa(ingresar());

        String[][] animalElegidoEnZona = opcionesPorZonaElegida(ingresar());
        String[][] animalUsuario = generarAnimalUsuario();

        mostrarCombate(animalElegidoEnZona, animalUsuario); //muestra entre quieres es el combate
        iniciarCombate(animalElegidoEnZona, animalUsuario);

        //combate(animalUsuario, );
    }

    private static void iniciarCombate(String[][] animalElegidoEnZona,String[][] animalUsuario) {
        String[][] animalElegidoEnZonaJugando = animalElegidoEnZona;
        String[][] animalUsuarioJugando = animalUsuario;

        int vidaAnimalElegidoEnZonaJugando =  Integer.parseInt(animalElegidoEnZonaJugando[1][0]);
        System.out.println("vidaAnimalElegidoEnZonaJugando = " + vidaAnimalElegidoEnZonaJugando); //borrar
        int vidaAnimalUsuarioJugando =  Integer.parseInt(animalUsuarioJugando[1][0]);
        System.out.println("vidaAnimalUsuarioJugando =  " + vidaAnimalUsuarioJugando); //borrar

        while (vidaAnimalUsuarioJugando >=0 || vidaAnimalElegidoEnZonaJugando >= 0){ //probablemente sea un &&
            mostrarNivelDeVidaAnimales(animalElegidoEnZonaJugando, animalUsuarioJugando);
            jugadaDeUsuario(animalUsuarioJugando, vidaAnimalElegidoEnZonaJugando);
            if (!(vidaAnimalElegidoEnZonaJugando >= 0)){
                break;
            }else {
                jugadaDeCPU(animalElegidoEnZonaJugando, vidaAnimalUsuarioJugando);
            }
        }
    }

    public static void jugadaDeCPU(String[][] animalElegidoEnZonaJugando, int vidaAnimalUsuarioJugando) {
        int numeroRandom = (int) ((Math.random()*3));
        int ataqueAnimalElegidoEnZonaJugando = Integer.parseInt(animalElegidoEnZonaJugando[3][numeroRandom]);

        vidaAnimalUsuarioJugando = vidaAnimalUsuarioJugando - ataqueAnimalElegidoEnZonaJugando;
    }


    public static void jugadaDeUsuario(String[][] animalUsuarioJugando, int vidaAnimalElegidoEnZonaJugando) {
        mostrarOpcionesDeAtaque(animalUsuarioJugando);
        int opcionDeAtaqueIngresada = pedirOpcionDeAtaque(ingresar()); //recibe la opcion de ataque seleccionada por el usuario
        int ataqueAnimalUsuarioJugando = Integer.parseInt(animalUsuarioJugando[3][opcionDeAtaqueIngresada]);

        vidaAnimalElegidoEnZonaJugando = vidaAnimalElegidoEnZonaJugando - ataqueAnimalUsuarioJugando;
    }

    private static int pedirOpcionDeAtaque(int opcionIngresada) {
        switch (opcionIngresada){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                System.out.println("Por favor ingrese un número válido:");
                pedirOpcionDeAtaque(ingresar());

        }
        return 4; //retorno temporal BORRAR CUANDO ENCUENTRE SOLUCION pide un retorno entero incluso teniendo un default
    }

    private static void mostrarOpcionesDeAtaque(String[][] animalUsuarioJugando) {
        System.out.println("¿Que ataque deberia hacer " + animalUsuarioJugando[0][0] + "?:");
        System.out.println("1. " + animalUsuarioJugando[2][0]);
        System.out.println("2. " + animalUsuarioJugando[2][1]);
        System.out.println("3. " + animalUsuarioJugando[2][2]);
    }


    private static void mostrarNivelDeVidaAnimales(String[][] animalElegidoEnZonaJugando, String[][] animalUsuarioJugando) {
        System.out.println("Vida de " + animalElegidoEnZonaJugando[0][0] + ": " + animalElegidoEnZonaJugando[1][0]);
        System.out.println("Vida de " + animalUsuarioJugando[0][0] + ": " + animalUsuarioJugando[1][0]);
        System.out.println();
    }

    private static String[][] generarAnimalUsuario() {
        String[][] caracteristicasCondor = {{"Condor"},{"50"},{"Picoton","Intimidacion","Mordida"},{"5","3","4"}};
        return caracteristicasCondor;
    }

    private static void mostrarCombate(String[][] animalDelUsuario, String[][] animalElegidoEnZona) {
        System.out.println("El combate será de "+ animalDelUsuario[0][0] + " vs " + animalElegidoEnZona[0][0]);
    }

    private static String[][] opcionesPorZonaElegida(int opcionIngresada){
        switch (opcionIngresada){
            case 1:
                return opcionesAnimalesZonaNorte(opcionIngresada);
            case 2:
                return opcionesAnimalesZonaCentral(opcionIngresada);

            case 3:
                return  opcionesAnimalesZonaSur(opcionIngresada);
            default:
                return opcionesPorZonaElegida(ingresar());
        }

    }

    private static void mostrarMapaGeografico(){
        System.out.println("""
                A continuación elija la zona geográfica con la que desea empezar:
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
        String[][] caracteristicasAlpaca = {{"Alpaca"},{"30"},{"Escupitazo","Patada","Mordida"},{"5","3","4"}};
        String[][] caracteristicasVicuña = {{"Vicuña"},{"30"},{"Mordizco","Patada","Ataque random"},{"5","3","4"}};
        String[][] caracteristicasGuanaco = {{"Guanaco"},{"30"},{"Escupo","Patada","Ataque random"},{"5","3","4"}};
        String[][] caracteristicasLlama = {{"Llama"},{"30"},{"Escupo","Silbar","Ataque random"},{"5","3","4"}};

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
        return caracteristicasAlpaca;
    }

    private static String[][] opcionesAnimalesZonaCentral(int opcionIngresada){
        String[][] caracteristicasZorroCulpeo = {{"Zorro Culpeo"},{"30"},{"Mordedura","Patada","Ataque random"},{"5","3","4"}};
        String[][] caracteristicasPuma = {{"Puma"},{"30"},{"Mordizco","Embestida","Ataque random"},{"5","3","4"}};
        String[][] caracteristicasAguilaMora = {{"Águila Mora"},{"30"},{"Garras","En Picada","Ataque random"},{"5","3","4"}};

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
        String[][] caracteristicasPinguino = {{"Pinguino"},{"30"},{"Picar","Aletazo", "Ataque random", "Ataque random"},{"4","5","3"}};
        String[][] caracteristicasZorroPatagonico = {{"ZorroPatagonico"},{"30"},{"Mordizo", "Ataque random", "Ataque random 2"},{"3","5","6"}};
        String[][] caracteristicasÑandu = {{"Ñandu"},{"31"},{"Aleteo","Patada", "ataque random"},{"7","4","4"}};


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