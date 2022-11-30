package guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaGanarVida extends JFrame implements ActionListener {
    FondoVentanaGanarVida fondo = new FondoVentanaGanarVida();
    private JPanel panel;
    private JButton botonVolver;
    private JLabel pregunta;
    private JLabel respuestaCorrecta;
    private JLabel respuestaIncorrecta1;
    private JLabel respuestaIncorrecta2;
    private JButton botonAlternativaCorrecta;
    private JButton botonAlternativaIncorrecta1;
    private JButton botonAlternativaIncorrecta2;

    public VentanaGanarVida(){
        this.setTitle("Preguntas para Ganar Vidas");
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
        añadirPanel();
        añadirEtiquetas();
    }

    private void añadirPanel(){
        panel = new JPanel();
        panel.setLayout(null);
    }

    public void agregarBotones(FondoVentanaGanarVida fondo) {
        botonVolver = new JButton("Volver");
        botonVolver.setBounds(20, 420, 100, 30);
        botonVolver.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonVolver);
        botonVolver.setOpaque(true);
        botonVolver.setBackground(Color.ORANGE);
        botonVolver.setForeground(Color.BLACK);
        botonVolver.addActionListener(this);

        botonAlternativaCorrecta = new JButton();
        botonAlternativaCorrecta.setBounds(100,270,20,20);
        fondo.add(botonAlternativaCorrecta);
        botonAlternativaCorrecta.addActionListener(this);

        botonAlternativaIncorrecta1 = new JButton();
        botonAlternativaIncorrecta1.setBounds(100,310,20,20);
        fondo.add(botonAlternativaIncorrecta1);
        botonAlternativaIncorrecta1.addActionListener(this);

        botonAlternativaIncorrecta2 = new JButton();
        botonAlternativaIncorrecta2.setBounds(100,350,20,20);
        fondo.add(botonAlternativaIncorrecta2);
        botonAlternativaIncorrecta2.addActionListener(this);
    }

    public void añadirEtiquetas(){
        pregunta = new JLabel("¿Qué hace una llama para defenderse?");
        pregunta.setBounds(70,30,480,180);
        pregunta.setFont(new Font("arial",Font.BOLD,25));
        fondo.add(pregunta);

        respuestaCorrecta = new JLabel("Lanza un escupo");
        respuestaCorrecta.setBounds(130,230,180,100);
        respuestaCorrecta.setForeground(Color.WHITE);
        respuestaCorrecta.setFont(new Font("arial",Font.BOLD,15));
        fondo.add(respuestaCorrecta);

        respuestaIncorrecta1 = new JLabel("Patea");
        respuestaIncorrecta1.setBounds(130,270,180,100);
        respuestaIncorrecta1.setForeground(Color.WHITE);
        respuestaIncorrecta1.setFont(new Font("arial",Font.BOLD,15));
        fondo.add(respuestaIncorrecta1);

        respuestaIncorrecta2 = new JLabel("Gruñe");
        respuestaIncorrecta2.setBounds(130,310,180,100);
        respuestaIncorrecta2.setForeground(Color.WHITE);
        respuestaIncorrecta2.setFont(new Font("arial",Font.BOLD,15));
        fondo.add(respuestaIncorrecta2);
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
        } else if(e.getSource() == botonAlternativaCorrecta) {
            JOptionPane.showMessageDialog(this, "¡RESPUESTA CORRECTA! Ganaste 3 vidas!!",
                    "", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            try {
                new VentanaMenuPrincipal().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if(e.getSource() == botonAlternativaIncorrecta1) {
            JOptionPane.showMessageDialog(this, "RESPUESTA INCORRECTA",
                    "", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            try {
                new VentanaMenuPrincipal().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if(e.getSource() == botonAlternativaIncorrecta2) {
            JOptionPane.showMessageDialog(this, "RESPUESTA INCORRECTA",
                    "", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            try {
                new VentanaMenuPrincipal().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}