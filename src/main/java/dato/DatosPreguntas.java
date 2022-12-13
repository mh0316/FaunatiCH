package dato;

import modelo.Cuestionario;
import modelo.Pregunta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DatosPreguntas {
    public static void leerArchivoCuestionario(Cuestionario cuestionario, String direccionArchivo) {
        String textoArchivo = "";

        try {
            var archivo = new File(direccionArchivo);
            var lector = new FileReader(archivo);
            var memoria = new BufferedReader(lector);

            while ((textoArchivo = memoria.readLine()) != null) {
                String[] data = textoArchivo.split(";");

                cuestionario.getPreguntas().add(new Pregunta(data[0],data[1],data[2],data[3],data[4]));
            }
        } catch (Exception e) {
            System.out.println("Documento no disponible");
        }
    }

}