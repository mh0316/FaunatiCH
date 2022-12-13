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

                convetirIdAAnimal(data, animalesDelJugador, animalesDelJuego);

                conjuntoJugadores.getJugadores().add(new Jugador(data[0], data[1], data[2], data[3], animalesDelJugador));
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible");
        }
    }

    private static ArrayList<Animal> convetirIdAAnimal(String[] data, ArrayList<Animal> animalesDelJugador, ArrayList<Animal> animalesDelJuego) {
        System.out.println("................................................");
        for (int i = 4; i < data.length; i++) {
            for (Animal delJuego : animalesDelJuego) {
                if (Integer.parseInt(data[i]) == Integer.parseInt(delJuego.getId())) {
                    animalesDelJugador.add(delJuego);
                    System.out.println("Se agregó: " + delJuego.getNombre() + " Id: " + delJuego.getId());
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


            var conjuntoJugadores = new ConjuntoJugadores();
            DatosJugadores.leerArchivoJugador(conjuntoJugadores, "./src/main/resources/conjuntoJugadores.txt");

            if (conjuntoJugadores.jugadorExiste(jugador.getRut())){
                FileWriter fw = new FileWriter(file); // true permite anxar contenido al archivo en vez de borrar lo que existe
                BufferedWriter bw = new BufferedWriter(fw);
                conjuntoJugadores.actualizarDatosJugador(jugador); //actualizar datos jugador debe borrar el jugador del arraylist y agregar el nuevo con los datos modificados
                file.delete();
                file.createNewFile();

                for (int i = 0; i < conjuntoJugadores.getJugadores().size(); i++) {
                    bw.write(conjuntoJugadores.getJugadores().get(i).toString());
                    if (i != conjuntoJugadores.getJugadores().size()-1){
                        bw.newLine();
                    }
                }
                bw.close();

            }else {
                FileWriter fw = new FileWriter(file, true); // true permite anxar contenido al archivo en vez de borrar lo que existe
                BufferedWriter bw = new BufferedWriter(fw);
                bw.newLine();
                bw.write(jugador.toString());
                bw.close();
            }

            return true;

        } catch (Exception e) {
            System.out.println("Error al ingresar datos del jugador");
            return false;
        }
    }

}