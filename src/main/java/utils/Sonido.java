package utils;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonido {
    public static void reproducirSonido(){
        File archivo = new File("./src/main/resources/HomeroDOU.wav");
        AudioInputStream audioInputStream = null;
        try {
            audioInputStream = AudioSystem.getAudioInputStream(archivo);
        } catch (UnsupportedAudioFileException | IOException ex) {
            throw new RuntimeException(ex);
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }
        try {
            clip.open(audioInputStream);
        } catch (LineUnavailableException | IOException ex) {
            throw new RuntimeException(ex);
        }
        clip.start();
    }
}