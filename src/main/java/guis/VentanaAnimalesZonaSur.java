package guis;

import modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaAnimalesZonaSur extends JFrame implements ActionListener {
    FondoVentanaAnimalesZonaSur fondo = new FondoVentanaAnimalesZonaSur();
    Jugador jugador;
    private JPanel panel;
    private JButton botonPingüino;
    private JButton botonÑandu;
    private JButton botonZorroPatagonico;
    private JButton botonVolver;

    public VentanaAnimalesZonaSur(Jugador jugador) throws IOException {
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

    public void agregarBotones(FondoVentanaAnimalesZonaSur fondo){
        botonPingüino = new JButton("Pingüino");
        botonPingüino.setBounds(160,120,110,30);
        botonPingüino.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonPingüino);
        botonPingüino.setOpaque(true);
        botonPingüino.setBackground(Color.white);
        botonPingüino.setForeground(Color.black);
        botonPingüino.addActionListener(this);

        botonÑandu = new JButton("Ñandú");
        botonÑandu.setBounds(140,330,110,30);
        botonÑandu.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonÑandu);
        botonÑandu.setOpaque(true);
        botonÑandu.setBackground(Color.white);
        botonÑandu.setForeground(Color.black);
        botonÑandu.addActionListener(this);

        botonZorroPatagonico = new JButton("Zorro Patagónico");
        botonZorroPatagonico.setBounds(460,100,150,30);
        botonZorroPatagonico.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonZorroPatagonico);
        botonZorroPatagonico.setOpaque(true);
        botonZorroPatagonico.setBackground(Color.white);
        botonZorroPatagonico.setForeground(Color.black);
        botonZorroPatagonico.addActionListener(this);

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
        }
    }
}