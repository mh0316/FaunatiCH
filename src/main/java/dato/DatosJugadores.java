package dato;

import modelo.ConjuntoJugadores;
import modelo.Jugador;

import java.io.*;

public class DatosJugadores {
    public static void leerArchivoJugador(ConjuntoJugadores conjuntoJugadores, String direccionArchivo) {
        String textoArchivo = "";

        try {
            var archivo = new File(direccionArchivo);
            var lector = new FileReader(archivo);
            var memoria = new BufferedReader(lector);

            while ((textoArchivo = memoria.readLine()) != null) {
                String[] data = textoArchivo.split(";");
                //TODO incluir agregar animales a la lista de animales del usuario
                conjuntoJugadores.getJugadores().add(new Jugador(data[0], data[1], data[2]));
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible");
        }
    }

    public static boolean registrarDatos(Jugador objeto, String direccionArchivo) {
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
            bw.write(objeto.toString());
            bw.close();
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar datos del jugador");
            return false;
        }
    }


}
