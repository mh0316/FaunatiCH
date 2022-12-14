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
        for (int i = 3; i < data.length; i++) {
            for (Animal delJuego : animalesDelJuego) {
                if (Integer.parseInt(data[i]) == Integer.parseInt(delJuego.getId())) {
                    animalesDelJugador.add(delJuego);
                    System.out.println("Se agregó: " + delJuego.getNombre() + " Id: " + delJuego.getId());
                }
            }
        }
        return animalesDelJugador;
    }

    /*public static boolean registrarDatos(Jugador jugador, String direccionArchivo) {
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
            bw.close(); //sino cierro jamás será escrito en el txt
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar datos del jugador");
            return false;
        }
    }*/

    public static boolean registrarDatos(Jugador jugador, String direccionArchivo) {
        boolean lineaVacia = false;
        try {
            File file = new File(direccionArchivo);
            if (!file.exists()) {
                file.createNewFile();
                lineaVacia = true;
            }


            var conjuntoJugadores = new ConjuntoJugadores();
            DatosJugadores.leerArchivoJugador(conjuntoJugadores, "src/main/resources/conjuntoJugadores.txt");

            if (conjuntoJugadores.jugadorExiste(jugador.getRut())){
                FileWriter fw = new FileWriter(file); // true permite anxar contenido al archivo en vez de borrar lo que existe
                BufferedWriter bw = new BufferedWriter(fw);
                conjuntoJugadores.actualizarDatosJugador(jugador); //actualizar datos jugador debe borrar el jugador del arraylist y agregar el nuevo con los datos modificados
                file.delete();
                file.createNewFile();
                /*for (Jugador j: conjuntoJugadores.getJugadores()) {
                    bw.write(j.toString());
                    bw.newLine(); //TODO REPARAR

                }*/
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
                bw.newLine(); //TODO
                bw.write(jugador.toString());
                bw.close();

            }



             //sino cierro jamás será escrito en el txt
            //S
            return true;
        } catch (Exception e) {
            System.out.println("Error al ingresar datos del jugador");
            return false;
        }
    }




  /*  public static void main(String[] args) {
        ConjuntoJugadores conjuntoJugadores = new ConjuntoJugadores();
        DatosJugadores.leerArchivoJugador(conjuntoJugadores, "./src/main/resources/conjuntoJugadores.txt");
        //System.out.println(conjuntoJugadores.getJugadores().toString());
        ArrayList<Animal> animales = new ArrayList<>();
        DatosAnimales.leerArchivoAnimales(animales,"./src/main/resources/animales.txt" );
        var j = conjuntoJugadores.getJugadores().get(1);
        j.agregarAnimal(animales.get(0));
        DatosJugadores.registrarDatos(j, "src/main/resources/conjuntoJugadores.txt");

    }
*/
/*
  public static void main(String[] args) {
      ArrayList<Animal> animales = new ArrayList<>();
      DatosAnimales.leerArchivoAnimales(animales,"./src/main/resources/animales.txt" );
      registrarDatos(new Jugador("jaime", "237659457","jaipass1", animales),"./src/main/resources/conjuntoJugadores.txt");
      registrarDatos(new Jugador("jaime", "127128994","jaipass1", animales),"./src/main/resources/conjuntoJugadores.txt");
      registrarDatos(new Jugador("jaime", "247477608","jaipass1", animales),"./src/main/resources/conjuntoJugadores.txt");
      registrarDatos(new Jugador("jaime", "157126458","jaipass1", animales),"./src/main/resources/conjuntoJugadores.txt");
      registrarDatos(new Jugador("jaime", "157126458","jaipass1", animales),"./src/main/resources/conjuntoJugadores.txt");
      //registrarDatos(new Jugador("jaime", "177454168","jaipass1", animales),"./src/main/resources/conjuntoJugadores.txt");
      //registrarDatos(new Jugador("stalin", "71894665","jaimepass1", animales),"./src/main/resources/conjuntoJugadores.txt");
      var conjuntoJugadores = new ConjuntoJugadores();
      DatosJugadores.leerArchivoJugador(conjuntoJugadores,"./src/main/resources/conjuntoJugadores.txt" );
      conjuntoJugadores.getJugadores().get(1).agregarAnimal(animales.get(1));
      DatosJugadores.registrarDatos(conjuntoJugadores.getJugadores().get(1), "./src/main/resources/conjuntoJugadores.txt");



      */
/*ConjuntoJugadores conjuntoJugadores = new ConjuntoJugadores();
      leerArchivoJugador(conjuntoJugadores,"./src/main/resources/conjuntoJugadores.txt" );
      for (Jugador j: conjuntoJugadores.getJugadores()) {
          System.out.println(j);
      }*//*

  }
*/

    public static void main(String[] args) {
        ConjuntoJugadores conjuntoJugadores = new ConjuntoJugadores();
        DatosJugadores.leerArchivoJugador(conjuntoJugadores, "C:\\Users\\npach\\IdeaProjects\\FaunatiCH\\src\\main\\resources\\conjuntoJugadores.txt");
        conjuntoJugadores.getJugadores().get(1).setParcheCuritas("3");
        DatosJugadores.registrarDatos(conjuntoJugadores.getJugadores().get(1), "./src/main/resources/conjuntoJugadores.txt");
    }



}
