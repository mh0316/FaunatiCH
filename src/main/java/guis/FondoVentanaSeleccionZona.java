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
        File archivo1 = new File("./src/main/resources/FondoSeleccionZona.jpeg");
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