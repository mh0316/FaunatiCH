package modelo;

import dato.DatosJugadores;
import dato.VerificadorContraseña;
import dato.VerificadorNombre;
import dato.VerificadorRut;

import java.util.Scanner;

public class PortalDeInicio {
    public static void mostrarTextoDeBienvenida() {
        System.out.println("BIENVENIDO/A A FAUNATICH!");
        System.out.println("Este juego te ayudará a aprender sobre la fauna Chilena de una manera muy entretenida.\n");
    }


    public static void mostrarOpcionesPortalInicio(ConjuntoJugadores conjuntoJugadores) throws JugadorNoEncontradoException {
        System.out.println("""
                FAUNATICH.
                Elija alguna opcion:
                1. Iniciar Sesión.
                2. Crear Cuenta.""");
        opcionesPortalInicio(conjuntoJugadores, ingresar());
    }

    private static void opcionesPortalInicio(ConjuntoJugadores conjuntoJugadores, int opcionIngresada) throws JugadorNoEncontradoException {
        switch (opcionIngresada) {
            case 1 -> iniciarSesion(conjuntoJugadores);
            case 2 -> crearCuenta(conjuntoJugadores);
            default -> {
                System.out.println("Por favor ingrese una opcion válida:");
                mostrarOpcionesPortalInicio(conjuntoJugadores);
            }
        }
    }

    public static void crearCuenta(ConjuntoJugadores conjuntoJugadores){
        String nombre = pedirNombre();
        String rut = pedirRut();
        String contrasena = pedirContraseña();
        Jugador jugador = new Jugador(nombre, rut, contrasena);
        if(conjuntoJugadores.agregarJugador(jugador)){
            DatosJugadores.registrarDatos(jugador, "C:\\Users\\npach\\IdeaProjects\\JuegoFaunatich\\conjuntoJugadores.txt");
        }else {
            System.out.println("Esta cuenta ya existe");

        }

    }

    //TODO reparar logica, nunca llegará al ultimo return eso es bueno pero hay HORROR de logica
    private static String pedirNombre() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Ingrese un nombre de jugador: ");
        String nombre = teclado.nextLine();
        if(VerificadorNombre.validarNombre(nombre)){
            return nombre;
        }else {
            nombre = pedirNombre();
        }
        return nombre;
    }

    private static String pedirRut(){
        System.out.println("A continuación deberá ingresar su rut, sin puntos ni guión y con dígito verificador.");
        System.out.print("Ingrese su rut: ");
        String rut = ingresarDatos();
        if(VerificadorRut.validarRut(rut) == true){
            return rut;
        }else{
            System.out.print("Error, el rut no es válido, ingréselo nuavamente. \n");
            rut = pedirRut();
        }

        return rut;
    }

    private static String pedirContraseña(){
        System.out.println("A continuación deberá ingresar una contraseña, la cual deberá tener letras y números y debe tener por lo menos 5 caracteres y máximo 10.");
        System.out.print("Ingrese una contraseña: ");
        String contrasena = ingresarDatos();
        VerificadorContraseña.verificarContraseña(contrasena);
        if(VerificadorContraseña.verificarContraseña(contrasena) == true){
            return contrasena;
        }else{
            System.out.println("Error, la contraseña no es válida, inténtelo nuevamente. ");
            contrasena = pedirContraseña();
        }

        return contrasena;
    }

    private static String ingresarDatos(){
        Scanner teclado = new Scanner(System.in);
        String ingreso = teclado.nextLine();
        return ingreso;
    }

    private static void iniciarSesion(ConjuntoJugadores conjuntoJugadores) { //borré el throw considerar para futuros errores
        String rut = pedirRut();
        String contraseña = pedirContraseña();
        try{
            var jugadorRegistrado = conjuntoJugadores.buscarJugadorPorRut(rut);
            if (jugadorRegistrado.getContraseña().equals(contraseña)){
                System.out.println("\nHola "+jugadorRegistrado.getNombre());
                MenuJuego.mostrarMenu(jugadorRegistrado);
                //TODO agregar metodo que lleve al juego
            }else {
                System.out.println("Contraseña incorrecta intente iniciar sesion nuevamente");
                iniciarSesion(conjuntoJugadores);
            }
        }catch (Exception JugadorNoEncontradoException){
            System.out.println("No existe un usuario registrado con este rut, intente nuevamente");
            iniciarSesion(conjuntoJugadores);
        }

        //rut esta registrado
            //contraseña correcta
            //contraseña incorrecta
        //rut no esta registrado
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
