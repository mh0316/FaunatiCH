package guis;

import modelo.Animal;
import modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class VentanaAnimalesZonaSur extends JFrame implements ActionListener {
    FondoVentanaAnimalesZonaSur fondo = new FondoVentanaAnimalesZonaSur();
    private Jugador jugador;
    private ArrayList<Animal> animales;
    private JPanel panel;
    private JButton botonPinguino;
    private JButton botonNiandu;
    private JButton botonZorroPatagonico;
    private JButton botonVolver;

    public VentanaAnimalesZonaSur(Jugador jugador, ArrayList<Animal> animales) throws IOException {
        this.jugador = jugador;
        this.animales = animales;
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
        botonPinguino = new JButton("Pingüino");
        botonPinguino.setBounds(160,120,110,30);
        botonPinguino.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonPinguino);
        botonPinguino.setOpaque(true);
        botonPinguino.setBackground(Color.white);
        botonPinguino.setForeground(Color.black);
        botonPinguino.addActionListener(this);

        botonNiandu = new JButton("Ñandú");
        botonNiandu.setBounds(140,330,110,30);
        botonNiandu.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonNiandu);
        botonNiandu.setOpaque(true);
        botonNiandu.setBackground(Color.white);
        botonNiandu.setForeground(Color.black);
        botonNiandu.addActionListener(this);

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
                new VentanaSeleccionDeZona(jugador, animales).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        } else if(e.getSource() == botonPinguino) {
            new VentanaSeleccionAnimalAmigo(this.jugador,animales.get(8));
            this.dispose();
        }
        else if(e.getSource() == botonNiandu) {
            new VentanaSeleccionAnimalAmigo(this.jugador, animales.get(10));
            this.dispose();
        }else if(e.getSource() == botonZorroPatagonico) {
            new VentanaSeleccionAnimalAmigo(this.jugador, animales.get(9));
            this.dispose();
        }
    }
}