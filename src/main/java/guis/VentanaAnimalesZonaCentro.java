package guis;

import modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaAnimalesZonaCentro extends JFrame implements ActionListener {
    FondoVentanaAnimalesZonaCentro fondo = new FondoVentanaAnimalesZonaCentro();
    Jugador jugador;
    private JPanel panel;
    private JButton botonZorroCulpeo;
    private JButton botonAguilaMora;
    private JButton botonPuma;
    private JButton botonVolver;

    public VentanaAnimalesZonaCentro(Jugador jugador){
        this.jugador = jugador;
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.fondo.setLayout(null);
        this.getContentPane().add(fondo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        agregarPartes();
    }

    private void agregarPartes(){
        agregarBotones(fondo);
        agregarPanel();
    }

    private void agregarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
    }

    public void agregarBotones(FondoVentanaAnimalesZonaCentro fondo){
        botonZorroCulpeo = new JButton("Zorro Culpeo");
        botonZorroCulpeo.setBounds(150,140,110,30);
        botonZorroCulpeo.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonZorroCulpeo);
        botonZorroCulpeo.setOpaque(true);
        botonZorroCulpeo.setBackground(Color.white);
        botonZorroCulpeo.setForeground(Color.black);
        botonZorroCulpeo.addActionListener(this);

        botonAguilaMora = new JButton("Águila Mora");
        botonAguilaMora.setBounds(130,330,110,30);
        botonAguilaMora.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonAguilaMora);
        botonAguilaMora.setOpaque(true);
        botonAguilaMora.setBackground(Color.white);
        botonAguilaMora.setForeground(Color.black);
        botonAguilaMora.addActionListener(this);

        botonPuma = new JButton("Puma");
        botonPuma.setBounds(460,100,110,30);
        botonPuma.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonPuma);
        botonPuma.setOpaque(true);
        botonPuma.setBackground(Color.white);
        botonPuma.setForeground(Color.black);
        botonPuma.addActionListener(this);

        botonVolver = new JButton("Volver");
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
                new VentanaSeleccionDeZona(jugador).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        } else if(e.getSource() == botonZorroCulpeo) {
            new VentanaSeleccionAnimalAmigo(this.jugador);
            this.dispose();
        }
        else if(e.getSource() == botonAguilaMora) {
            new VentanaSeleccionAnimalAmigo(this.jugador);
            this.dispose();
        }else if(e.getSource() == botonPuma) {
            new VentanaSeleccionAnimalAmigo(this.jugador);
            this.dispose();
        }
    }
}