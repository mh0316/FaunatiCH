package guis;

import modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaEstadisticas extends JFrame implements ActionListener {
    FondoVentanaEstadisticas fondo = new FondoVentanaEstadisticas();
    Jugador jugador;
    private JPanel panel;
    private JButton botonVolver;

    public VentanaEstadisticas(Jugador jugador){
        this.jugador = jugador;
        this.setTitle("Estadísticas");
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.fondo.setLayout(null);
        this.getContentPane().add(fondo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        agregarPartes();
    }

    private void agregarPartes(){
        agregarBotones(fondo);
        añadirPanel();
    }

    private void añadirPanel(){
        panel = new JPanel();
        panel.setLayout(null);
    }

    public void agregarBotones(FondoVentanaEstadisticas fondo) {
        botonVolver = new JButton();
        botonVolver.setText("Volver");
        botonVolver.setBounds(20,420,100,30);
        botonVolver.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonVolver);
        botonVolver.setOpaque(true);
        botonVolver.setBackground(Color.ORANGE);
        botonVolver.setForeground(Color.BLACK);
        botonVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonVolver){
            try {
                new VentanaMenuPrincipal(jugador).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        }
    }
}