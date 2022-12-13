package dato;

import modelo.Animal;


import java.io.*;
import java.util.ArrayList;

public class DatosAnimales {
    public static void leerArchivoAnimales(ArrayList<Animal> animales, String direccionArchivo) {
        String textoArchivo = "";

        try {
            var archivo = new File(direccionArchivo);
            var lector = new FileReader(archivo);
            var memoria = new BufferedReader(lector);

            while ((textoArchivo = memoria.readLine()) != null) {
                String[] data = textoArchivo.split(";");
                animales.add(new Animal(data[0], data[1],data[2],data[3],data[4],data[5],data[6],data[7],data[8], data[9]));

                /*animales.add(new Animal(data[0], data[1], data[2],data[3],data[4],data[5],
                                        data[6], data[7], data[8], data[9]));*/
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible");
        }
    }

    public static void main(String[] args) {
        var animalesDelJuego = new ArrayList<Animal>();

        DatosAnimales.leerArchivoAnimales(animalesDelJuego, "./src/main/resources/animales.txt");
        for (Animal delJuego : animalesDelJuego) {
            System.out.println(delJuego.getId()+"  "+delJuego.getNombre() + " " + delJuego.getVida());
        }


}}
