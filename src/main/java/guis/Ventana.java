package guis;


import modelo.Animal;
import modelo.Animal;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Ventana extends JFrame {


    public Ventana() {
        this.setLayout(null);
        this.setSize(700,500);
        /*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(true); //poner en false
    }

    protected JTextField generarCampoDeTexto(int x, int y, int ancho, int largo) {
        JTextField campoDeTexto = new JTextField();
        this.add(campoDeTexto);
        campoDeTexto.setBounds(x, y, ancho, largo);
        return campoDeTexto;
    }
    protected JPasswordField generarCampoDeTextoContraseña(int x, int y, int ancho, int largo) {
        JPasswordField campoDeTexto = new JPasswordField();
        campoDeTexto.setBounds(x, y, ancho, largo);
        campoDeTexto.setVisible(true);
        this.add(campoDeTexto);
        return campoDeTexto;
    }

    protected JButton generarBoton(String texto, int x, int y, int ancho, int largo) {
        JButton boton = new JButton(texto);
        boton.setBounds(x, y, ancho, largo);
        this.add(boton);

        return boton;
    }

    protected JButton generarBotonIcono(String direccionIcono, int x, int y, int ancho, int largo) {
        JButton boton = new JButton();
        boton.setBounds(x, y, ancho, largo);
        this.add(boton);
        ImageIcon imagen = new ImageIcon(direccionIcono);
        boton.setIcon(imagen);

        return boton;
    }


    protected JButton generarBoton(int x, int y, int ancho, int largo) {
        JButton boton = new JButton();
        boton.setBounds(x, y, ancho, largo);
        this.add(boton);

        return boton;
    }

    protected JLabel generarEtiquetaBlanca (String texto, int x, int y, int ancho, int largo, String fuente, int tamaño) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        Font myFont1 = new Font(fuente, Font.BOLD, tamaño);
        etiqueta.setFont(myFont1);
        etiqueta.setForeground(Color.WHITE);
        this.add(etiqueta);
        return etiqueta;
    }


    protected JLabel generarEtiqueta (String texto, int x, int y, int ancho, int largo, String fuente, int tamaño) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        Font myFont1 = new Font(fuente, Font.BOLD, tamaño);
        etiqueta.setFont(myFont1);
        this.add(etiqueta);
        return etiqueta;
    }

    protected JLabel generarEtiqueta (String texto, int x, int y, int ancho, int largo) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        this.add(etiqueta);
        return etiqueta;
    }

    protected JLabel generarEtiquetaBandera (String texto, int x, int y, int ancho, int largo) {
        JLabel etiqueta = new JLabel(texto);
        etiqueta.setBounds(x, y, ancho, largo);
        var imagen =  new ImageIcon("./src/main/resources/"+texto);
        etiqueta.setIcon(imagen);
        this.add(etiqueta);
        return etiqueta;
    }



    /*protected JComboBox generarComboBoxSelecciones(ArrayList<Seleccion> selecciones, int x, int y, int ancho, int largo) {
        *//*JComboBox <String> comboBox = new JComboBox<String>();
        this.add(comboBox);
        comboBox.setBounds(x,y,ancho,largo);

        for (Seleccion s: selecciones) {
            comboBox.addItem(s.getNombre());
        }

        return comboBox;*//*
    }*/

    protected JComboBox generarComboBoxAnimales(ArrayList<Animal> animales, int x, int y, int ancho, int largo) {
        JComboBox <String> comboBox = new JComboBox<String>();
        this.add(comboBox);
        comboBox.setBounds(x,y,ancho,largo);


        for (Animal a : animales) {
            comboBox.addItem(a.getNombre());
        }

        return comboBox;
    }
}
