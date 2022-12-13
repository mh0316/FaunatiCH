package guis;

import dato.DatosAnimales;
import dato.DatosJugadores;
import dato.DatosPreguntas;
import modelo.Animal;
import modelo.Cuestionario;
import modelo.Jugador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class VentanaMenuPrincipal extends JFrame implements ActionListener {
    FondoVentanaPrincipal fondo = new FondoVentanaPrincipal();
    Jugador jugador;
    private JPanel panel;
    public JButton botonStart;
    public JButton botonEstadisticas;
    public JButton botonGanarParcheCuritas;
    public JButton botonSalir;
    private JLabel etiquetaJugador;

    public VentanaMenuPrincipal(Jugador jugador) throws IOException {
        this.jugador = jugador;
        this.setTitle("Menú Principal");
        setSize(700,500);
        setLocationRelativeTo(null);
        fondo.setLayout(null);
        this.getContentPane().add(fondo);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        agregarPartes();
    }

    private void agregarPartes(){
        agregarBotones(fondo);
        agregarPanel();
        agregarEtiqueta();

    }

    private void agregarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        //panel.setBackground(Color.BLUE);
        //this.getContentPane().add(panel);
    }

    public void agregarBotones(FondoVentanaPrincipal fondo){
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

        botonGanarParcheCuritas = new JButton();
        botonGanarParcheCuritas.setText("Ganar Parche Curitas");
        botonGanarParcheCuritas.setBounds(466,230,170,30);
        botonGanarParcheCuritas.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonGanarParcheCuritas);
        botonGanarParcheCuritas.setOpaque(true);
        botonGanarParcheCuritas.setBackground(Color.GREEN);
        botonGanarParcheCuritas.setForeground(Color.WHITE);
        botonGanarParcheCuritas.addActionListener(this);

        botonSalir = new JButton();
        botonSalir.setText("Cerrar sesión");
        botonSalir.setBounds(560,10,120,23);
        botonSalir.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonSalir);
        botonSalir.setOpaque(true);
        botonSalir.setBackground(Color.RED);
        botonSalir.setForeground(Color.WHITE);
        botonSalir.addActionListener(this);
    }

    public void agregarEtiqueta(){
        etiquetaJugador = new JLabel();
        etiquetaJugador.setText(jugador.getNombre());
        etiquetaJugador.setBounds(30,30,100,30);
        etiquetaJugador.setFont(new Font("arial",Font.BOLD,20));
        etiquetaJugador.setForeground(Color.WHITE);
        fondo.add(etiquetaJugador);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonStart){
            try {
                var animales = new ArrayList<Animal>();
                DatosAnimales.leerArchivoAnimales(animales,"./src/main/resources/animales.txt");
                new VentanaSeleccionDeZona(jugador,animales).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        } else if (e.getSource() == botonEstadisticas) {
            new VentanaEstadisticas(jugador).setVisible(true);
            this.dispose();
        } else if (e.getSource() == botonGanarParcheCuritas) {
            Cuestionario cuestionario = new Cuestionario();
            DatosPreguntas.leerArchivoCuestionario(cuestionario, "./src/main/resources/cuestionario.txt");
            new VentanaGanarVida(jugador, cuestionario.obtenerPregunta()).setVisible(true);
            this.dispose();
        }else if(e.getSource() == botonSalir) {
            if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro/a que desea cerrar sesión?",
                    "Confirmación de cierre", JOptionPane.YES_NO_OPTION) == JOptionPane.ERROR_MESSAGE) {
                DatosJugadores.registrarDatos(jugador, "./src/main/resources/conjuntoJugadores.txt");
                this.dispose();
                new VentanaInicioDeSesion().setVisible(true);

            }

        }
    }
}