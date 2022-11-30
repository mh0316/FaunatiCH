package guis;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FondoVentanaSeleccionZona extends JPanel {
    @Override
    public void paint(Graphics g) {
        File archivo1 = new File("D:\\Marcelo 2022\\UFRO\\Ingeniería civil informática\\Segundo Semestre 2022\\Asignaturas\\Programación\\Imágenes proyecto grupal\\Fondo Seleccion Zona.jpeg");
        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(archivo1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert bufferedImage != null;
        ImageIcon imagen = new ImageIcon(bufferedImage);
        g.drawImage(imagen.getImage(),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}