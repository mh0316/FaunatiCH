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

                animales.add(new Animal(data[0], data[1], data[2],data[3],data[4],data[5]));
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible");
        }
    }

    public static void main(String[] args) {
        var animalesDelJuego = new ArrayList<Animal>();
        var animalesDelJugador = new ArrayList<Animal>();
        DatosAnimales.leerArchivoAnimales(animalesDelJuego, "./src/main/resources/animales.txt");
        for (int i = 0; i < animalesDelJuego.size(); i++) {
            System.out.println(animalesDelJuego.get(i).getNombre() +" "+ animalesDelJuego.get(i).getVida());
        }
        
        var id_animales = new ArrayList<String>();
        id_animales.add("1");id_animales.add("2");id_animales.add("4");


        for (int i = 0; i < id_animales.size(); i++) {
            for (int j = 0; j < animalesDelJuego.size(); j++) {
                if ((Integer.parseInt(id_animales.get(i))) == (Integer.parseInt(animalesDelJuego.get(j).getId()))){
                    animalesDelJugador.add(animalesDelJuego.get(j));
                    System.out.println("Se agregó: "+animalesDelJuego.get(j).getNombre()+ " Id: "+animalesDelJuego.get(j).getId());
                }
            }
        }

        System.out.println("AHORA LA LISTA EFECTIVA DE ANIMALES DEL JUGADOR");
        for (Animal animal: animalesDelJugador) {
            System.out.println(animal);
        }
    }


}
