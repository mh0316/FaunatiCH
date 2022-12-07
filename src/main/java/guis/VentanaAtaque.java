package guis;

import javax.swing.*;

public class VentanaAtaque extends JFrame {
    FondoVentanaAtaque fondoAtaque = new FondoVentanaAtaque();
    private JPanel panel;

    public VentanaAtaque(){
        setSize(700,500);
        setLocationRelativeTo(null);
        fondoAtaque.setLayout(null);
        this.getContentPane().add(fondoAtaque);
        this.setResizable(false);
        agregarPanelDeAtaque();
    }

    private void agregarPanelDeAtaque(){
        panel = new JPanel();
        panel.setLayout(null);
    }
}