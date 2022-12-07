package guis;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FondoVentanaCombate extends JPanel {
    @Override
    public void paint (Graphics g){
        File archivo = new File("./src/main/resources/FondoVentanaCombate.jpeg");
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read((archivo));
        }catch (IOException e){
            e.printStackTrace();
        }

        assert bufferedImage != null;
        ImageIcon imagen = new ImageIcon(bufferedImage);
        g.drawImage(imagen.getImage(),0,0,getWidth(),getHeight(),this);
        setOpaque(false);
        super.paint(g);
    }
}