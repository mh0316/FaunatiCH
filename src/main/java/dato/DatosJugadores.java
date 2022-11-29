package dato;

import modelo.Animal;
import modelo.ConjuntoJugadores;
import modelo.Jugador;

import java.io.*;
import java.util.ArrayList;

public class DatosJugadores {
    public static void leerArchivoJugador(ConjuntoJugadores conjuntoJugadores, String direccionArchivo) {
        String textoArchivo = "";

        try {
            var archivo = new File(direccionArchivo);
            var lector = new FileReader(archivo);
            var memoria = new BufferedReader(lector);

            while ((textoArchivo = memoria.readLine()) != null) {
                String[] data = textoArchivo.split(";");
                ArrayList<Animal> animalesDelJugador = new ArrayList<>();
                ArrayList<Animal> animalesDelJuego = new ArrayList<>();

                DatosAnimales.leerArchivoAnimales(animalesDelJuego, "./src/main/resources/animales.txt");

                convetirNombreAAnimal(data, animalesDelJugador, animalesDelJuego);

                conjuntoJugadores.getJugadores().add(new Jugador(data[0], data[1], data[2], animalesDelJugador));
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible");
        }
    }

    private static ArrayList<Animal> convetirNombreAAnimal(String[] data, ArrayList<Animal> animalesDelJugador, ArrayList<Animal> animalesDelJuego) {
        System.out.println("................................................");
        for (int i = 3; i < data.length; i++) {
            for (int j = 0; j < animalesDelJuego.size(); j++) {
                if (Integer.parseInt(data[i]) == Integer.parseInt(animalesDelJuego.get(j).getId())){
                    animalesDelJugador.add(animalesDelJuego.get(j));
                    System.out.println("Se agregó: "+animalesDelJuego.get(j).getNombre()+ " Id: "+animalesDelJuego.get(j).getId());
                }
            }
        }
        return animalesDelJugador;
    }

    public static boolean registrarDatos(Jugador jugador, String direccionArchivo) {
        boolean lineaVacia = false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }
            FileWriter fw = new FileWriter(file, true); // true permite anxar contenido al archivo en vez de borrar lo que existe
            BufferedWriter bw = new BufferedWriter(fw);

            if (!lineaVacia) {
                bw.newLine();
            }
            bw.write(jugador.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar datos del jugador");
            return false;
        }
    }

    public static void main(String[] args) {
        ConjuntoJugadores conjuntoJugadores = new ConjuntoJugadores();
        DatosJugadores.leerArchivoJugador(conjuntoJugadores, "./src/main/resources/conjuntoJugadores.txt");
        System.out.println(conjuntoJugadores.getJugadores().toString());
        /*var animalesDelJuego = new ArrayList<Animal>();
        DatosAnimales.leerArchivoAnimales(animalesDelJuego, "src/main/resources/conjuntoJugadores.txt");*/
        System.out.println(conjuntoJugadores.getJugadores().get(2).toString());

    }





}
