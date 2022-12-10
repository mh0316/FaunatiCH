package guis;

import modelo.ConjuntoJugadores;
import modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaMenuPrincipal extends JFrame implements ActionListener {
    FondoVentanaPrincipal fondo = new FondoVentanaPrincipal();
    Jugador jugador;
    private JPanel panel;
    public JButton botonStart;
    public JButton botonEstadisticas;
    public JButton botonGanarVidas;
    public JButton botonSalir;
    private JLabel etiquetaJugador;

    public VentanaMenuPrincipal(Jugador jugador) throws IOException {
        this.jugador = jugador;
        this.setTitle("Menú Principal");
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
        //panel.setBackground(Color.BLUE);
        //this.getContentPane().add(panel);
    }

    public void añadirBotones(FondoVentanaPrincipal fondo){
        botonStart = new JButton();
        botonStart.setText("START");
        botonStart.setBounds(290,220,130,50);
        botonStart.setHorizontalAlignment(SwingConstants.CENTER);
        botonStart.setFont(new Font("arial",Font.BOLD,20));
        fondo.add(botonStart);
        botonStart.setOpaque(true);
        botonStart.setBackground(Color.green);
        botonStart.setForeground(Color.WHITE);
        botonStart.addActionListener(this);

        botonEstadisticas = new JButton();
        botonEstadisticas.setText("Estadísticas");
        botonEstadisticas.setBounds(125,230,130,30);
        botonEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonEstadisticas);
        botonEstadisticas.setOpaque(true);
        botonEstadisticas.setBackground(Color.GREEN);
        botonEstadisticas.setForeground(Color.WHITE);
        botonEstadisticas.addActionListener(this);

        botonGanarVidas = new JButton();
        botonGanarVidas.setText("Ganar Vidas");
        botonGanarVidas.setBounds(466,230,130,30);
        botonGanarVidas.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonGanarVidas);
        botonGanarVidas.setOpaque(true);
        botonGanarVidas.setBackground(Color.GREEN);
        botonGanarVidas.setForeground(Color.WHITE);
        botonGanarVidas.addActionListener(this);

        botonSalir = new JButton();
        botonSalir.setText("Salir");
        botonSalir.setBounds(580,10,100,23);
        botonSalir.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonSalir);
        botonSalir.setOpaque(true);
        botonSalir.setBackground(Color.RED);
        botonSalir.setForeground(Color.WHITE);
        botonSalir.addActionListener(this);
    }

    public void agregarEtiqueta(){
        etiquetaJugador = new JLabel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonStart){
            try {
                new VentanaSeleccionDeZona(jugador).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        } else if (e.getSource() == botonEstadisticas) {
            new VentanaEstadisticas(jugador).setVisible(true);
            this.dispose();
        } else if (e.getSource() == botonGanarVidas) {
            new VentanaGanarVida(jugador).setVisible(true);
            this.dispose();
        }else if(e.getSource() == botonSalir) {
            if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro/a que desea salir del juego?", "Confirmación de cierre", JOptionPane.YES_NO_OPTION) == JOptionPane.ERROR_MESSAGE) {
                System.exit(0);
            }
        }
    }
}