package guis;

import modelo.ConjuntoJugadores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaSeleccionDeZona extends JFrame implements ActionListener {
    FondoVentanaSeleccionZona fondo = new FondoVentanaSeleccionZona();
    public JPanel panel;
    private JButton botonZonaNorte;
    private JButton botonZonaCentro;
    private JButton botonZonaSur;
    private JButton botonVolver;
    private ConjuntoJugadores jugador;

    public VentanaSeleccionDeZona() throws IOException {
        this.setTitle("Selección de Zonas");
        setSize(700,500);
        setLocationRelativeTo(null);
        fondo.setLayout(null);
        this.getContentPane().add(fondo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        agregarPartes();
    }

    private void agregarPartes(){
        añadirBotones(fondo);
        añadirPanel();
    }

    private void añadirPanel(){
        panel = new JPanel();
        panel.setLayout(null);
    }

    public void añadirBotones(FondoVentanaSeleccionZona fondo){
        botonZonaNorte = new JButton();
        botonZonaNorte.setText("ZONA NORTE");
        botonZonaNorte.setBounds(115,65,130,50);
        botonZonaNorte.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonZonaNorte);
        botonZonaNorte.setOpaque(true);
        botonZonaNorte.setBackground(Color.white);
        botonZonaNorte.setForeground(Color.black);
        botonZonaNorte.addActionListener(this);

        botonZonaCentro = new JButton();
        botonZonaCentro.setText("ZONA CENTRO");
        botonZonaCentro.setBounds(392,215,130,50);
        botonZonaCentro.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonZonaCentro);
        botonZonaCentro.setOpaque(true);
        botonZonaCentro.setBackground(Color.white);
        botonZonaCentro.setForeground(Color.black);
        botonZonaCentro.addActionListener(this);

        botonZonaSur = new JButton();
        botonZonaSur.setText("ZONA SUR");
        botonZonaSur.setBounds(115,355,130,50);
        botonZonaSur.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonZonaSur);
        botonZonaSur.setOpaque(true);
        botonZonaSur.setBackground(Color.white);
        botonZonaSur.setForeground(Color.black);
        botonZonaSur.addActionListener(this);

        botonVolver = new JButton();
        botonVolver.setText("Volver");
        botonVolver.setBounds(560,400,100,30);
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
                new VentanaMenuPrincipal().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        } else if (e.getSource() == botonZonaNorte) {
            try {
                new VentanaAnimalesZonaNorte().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        } else if (e.getSource() == botonZonaCentro){
            new VentanaAnimalesZonaCentro().setVisible(true);
            this.dispose();
        } else if (e.getSource() == botonZonaSur) {
            try {
                new VentanaAnimalesZonaSur().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        }
    }
}