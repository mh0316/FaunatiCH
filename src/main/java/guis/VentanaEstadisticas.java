package guis;

import modelo.Animal;
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

    private JLabel parcheCuritas;
    private JLabel animales;

    private JComboBox comboBoxAnimales;

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
        agregarEtiquetas();
        mostrarInformacion();
        agregarComboBox();
    }

    private void agregarComboBox() {
        comboBoxAnimales = new JComboBox<>();
        JComboBox <String> comboBox = new JComboBox<String>();
        comboBox.setBounds(400,300,250,30);
        fondo.add(comboBox);

        for (Animal a: this.jugador.getAnimales()) {
            comboBox.addItem(a.getNombre());
        }
    }

    private void agregarEtiquetas() {
        parcheCuritas = new JLabel("");
        parcheCuritas.setBounds(400,100,670,30);
        parcheCuritas.setFont(new Font("arial",Font.BOLD,20));
        fondo.add(parcheCuritas);

        animales = new JLabel("");
        animales.setBounds(400,130,150,300);
        animales.setFont(new Font("arial",Font.BOLD,20));
        fondo.add(animales);
    }

    public void mostrarInformacion() {
        parcheCuritas.setText("<html>"+"Parche curitas: "+jugador.getParcheCuritas()+"<html>");
        animales.setText("<html>"+"----Animales----"+"<html>");
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