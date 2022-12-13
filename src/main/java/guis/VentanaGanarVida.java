package guis;

import modelo.Jugador;
import modelo.Pregunta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaGanarVida extends JFrame implements ActionListener {
    FondoVentanaGanarVida fondo = new FondoVentanaGanarVida();
    private Jugador jugador;
    private Pregunta pregunta;
    private JPanel panel;
    private JButton botonVolver;
    private JLabel enunciado;
    private JLabel alternativaA;
    private JLabel alternativaB;
    private JLabel alternativaC;
    private JButton botonAlternativaA;
    private JButton botonAlternativaB;
    private JButton botonAlternativaC;

    public VentanaGanarVida(Jugador jugador, Pregunta pregunta){
        this.pregunta = pregunta;
        this.jugador = jugador;
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
        aniadirPanel();
        aniadirEtiquetas();
        mostrarInformacion();
    }

    private void aniadirPanel(){
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

        botonAlternativaA = new JButton();
        botonAlternativaA.setBounds(100,270,20,20);
        fondo.add(botonAlternativaA);
        botonAlternativaA.addActionListener(this);

        botonAlternativaB = new JButton();
        botonAlternativaB.setBounds(100,310,20,20);
        fondo.add(botonAlternativaB);
        botonAlternativaB.addActionListener(this);

        botonAlternativaC = new JButton();
        botonAlternativaC.setBounds(100,350,20,20);
        fondo.add(botonAlternativaC);
        botonAlternativaC.addActionListener(this);
    }

    public void aniadirEtiquetas(){
        enunciado = new JLabel("");
        enunciado.setBounds(70,30,480,180);
        enunciado.setFont(new Font("arial",Font.BOLD,25));
        fondo.add(enunciado);

        alternativaA = new JLabel("");
        alternativaA.setBounds(130,230,350,100);
        alternativaA.setForeground(Color.WHITE);
        alternativaA.setFont(new Font("arial",Font.BOLD,15));
        fondo.add(alternativaA);

        alternativaB = new JLabel("");
        alternativaB.setBounds(130,270,350,100);
        alternativaB.setForeground(Color.WHITE);
        alternativaB.setFont(new Font("arial",Font.BOLD,15));
        fondo.add(alternativaB);

        alternativaC = new JLabel("");
        alternativaC.setBounds(130,310,350,100);
        alternativaC.setForeground(Color.WHITE);
        alternativaC.setFont(new Font("arial",Font.BOLD,15));
        fondo.add(alternativaC);
    }

    public void mostrarInformacion() {
        enunciado.setText("<html>"+pregunta.getEnunciado()+"<html>");
        alternativaA.setText(pregunta.getAlternativaA());
        alternativaB.setText(pregunta.getAlternativaB());
        alternativaC.setText(pregunta.getAlternativaC());
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
        } else if(e.getSource() == botonAlternativaA && "A".equals(pregunta.getAlternativaCorrecta())) {
            JOptionPane.showMessageDialog(this, "RESPUESTA CORRECTA : \n Ganaste un parchecurita)",
                    "", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

            jugador.agregarUnParcheCuritas();
            System.out.println(jugador.getParcheCuritas()); //para ver por consola no mas

            try {
                new VentanaMenuPrincipal(jugador).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if(e.getSource() == botonAlternativaB && "B".equals(pregunta.getAlternativaCorrecta())) {
            JOptionPane.showMessageDialog(this, "RESPUESTA CORRECTA :) \n Ganaste un parchecurita",
                    "", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

            jugador.agregarUnParcheCuritas();
            System.out.println(jugador.getParcheCuritas()); //para ver por consola no mas

            try {
                new VentanaMenuPrincipal(jugador).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        } else if(e.getSource() == botonAlternativaC && "C".equals(pregunta.getAlternativaCorrecta())) {
            JOptionPane.showMessageDialog(this, "RESPUESTA CORRECTA : \n Ganaste un parchecurita)",
                    "", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

            jugador.agregarUnParcheCuritas();
            System.out.println(jugador.getParcheCuritas()); //para ver por consola no mas

            try {
                new VentanaMenuPrincipal(jugador).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Lo siento :( RESPUESTA INCORRECTA",
                    "", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
            try {
                new VentanaMenuPrincipal(jugador).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }



        //opcion 1: crear un metodo que actualice las vidas que ganó el jugador y llamar ese metodo en el evento
        //opcion 2: no guardar los datos y modificar solo el objeto, luego guarda los
        //TODO Dar instrucciones al niño sobre como ganar las vidas... debes responder blablabla
    }
}