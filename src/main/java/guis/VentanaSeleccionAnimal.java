package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaSeleccionAnimal extends JFrame implements ActionListener {
    FondoVentanaSeleccionAnimal fondo = new FondoVentanaSeleccionAnimal();
    private JComboBox botonListaAnimales;
    private JButton botonVolver;
    private JButton botonAceptar;
    //private ImageIcon imagen;
    private JPanel panel;

    public VentanaSeleccionAnimal(){
        this.setTitle("Selección de Animal");
        setSize(700,500);
        setLocationRelativeTo(null);
        this.setLayout(null);
        //this.getContentPane().add(fondo);
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

    public void añadirBotones(FondoVentanaSeleccionAnimal fondo){
        String[] animales = {};
        botonListaAnimales = new JComboBox<>(animales);
        botonListaAnimales.setBounds(270,100,150,30);
        fondo.add(botonListaAnimales);

        botonVolver = new JButton("Volver");
        botonVolver.setBounds(100,350,120,50);
        botonVolver.setFont(new Font("arial",Font.BOLD,20));
        //imagen = new ImageIcon("C:\\Users\\marce\\Downloads\\datos\\chi.png");
        //botonVolver.setIcon(imagen);
        this.add(botonVolver);
        botonVolver.addActionListener(this);

        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(480,350,120,50);
        botonAceptar.setFont(new Font("arial",Font.BOLD,20));
        //fondo.add(botonAceptar);
        this.add(botonAceptar);
        botonAceptar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonVolver){
            this.dispose();
            try {
                new VentanaSeleccionDeZona().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if(e.getSource() == botonAceptar) {
            this.dispose();
            try {
                new VentanaSeleccionDeZona().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}