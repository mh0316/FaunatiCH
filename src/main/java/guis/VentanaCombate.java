package guis;

import modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaCombate extends JFrame implements ActionListener {
    FondoVentanaCombate fondo = new FondoVentanaCombate();
    Jugador jugador;
    private JPanel panel;
    private JButton botonPicotazo;
    private JButton botonExtenderAlas;
    private JButton botonMasPuntosDeVida;
    private JButton botonHuirVolando;
    private JButton botonVolver;

    public VentanaCombate(Jugador jugador){
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

    public void agregarBotones(FondoVentanaCombate fondo){
        botonPicotazo = new JButton("Picotazo");
        botonPicotazo.setBounds(370,315,120,30);
        botonPicotazo.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonPicotazo);
        botonPicotazo.setOpaque(true);
        botonPicotazo.setBackground(Color.white);
        botonPicotazo.setForeground(Color.black);
        botonPicotazo.addActionListener(this);

        botonExtenderAlas = new JButton("Extender Alas");
        botonExtenderAlas.setBounds(370,400,120,30);
        botonExtenderAlas.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonExtenderAlas);
        botonExtenderAlas.setOpaque(true);
        botonExtenderAlas.setBackground(Color.white);
        botonExtenderAlas.setForeground(Color.black);
        botonExtenderAlas.addActionListener(this);

        botonMasPuntosDeVida = new JButton("Más puntos de vida");
        botonMasPuntosDeVida.setBounds(520,315,150,30);
        botonMasPuntosDeVida.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonMasPuntosDeVida);
        botonMasPuntosDeVida.setOpaque(true);
        botonMasPuntosDeVida.setBackground(Color.white);
        botonMasPuntosDeVida.setForeground(Color.black);
        botonMasPuntosDeVida.addActionListener(this);

        botonHuirVolando = new JButton("Huir Volando");
        botonHuirVolando.setBounds(540,400,120,30);
        botonHuirVolando.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonHuirVolando);
        botonHuirVolando.setOpaque(true);
        botonHuirVolando.setBackground(Color.white);
        botonHuirVolando.setForeground(Color.black);
        botonHuirVolando.addActionListener(this);

        botonVolver = new JButton("Volver");
        botonVolver.setBounds(20,20,100,30);
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
            /*try {
                new VentanaSeleccionDeZona(jugador, animales).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }*/
            this.dispose();
        } else if (e.getSource() == botonPicotazo) {
            this.dispose();
            new VentanaAtaque().setVisible(true);
            this.dispose();
            new VentanaCombate(jugador).setVisible(true);
        }
    }
}