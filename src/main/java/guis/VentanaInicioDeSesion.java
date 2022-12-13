package guis;

import dato.DatosJugadores;
import modelo.ConjuntoJugadores;
import modelo.JugadorNoEncontradoException;
import modelo.PortalDeInicio;
import utils.Sonido;
import utils.VerificadorContrasena;
import utils.VerificadorRut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaInicioDeSesion extends JFrame implements ActionListener {
    FondoVentanaInicioSesion fondo = new FondoVentanaInicioSesion();
    private JPanel panel;
    private JTextField cajaDeTextoRut;
    private JPasswordField cajaDeTextoContrasena;
    private JButton botonAceptar;
    private JButton botonSalir;
    private JButton botonRegistrarse;

    public VentanaInicioDeSesion(){
        this.setTitle("Portal de inicio");
        this.setSize(700,500);
        this.setLocationRelativeTo(null);
        this.fondo.setLayout(null);
        this.getContentPane().add(fondo);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        agregarPartes();
    }

    private void agregarPartes(){
        agregarBotones(fondo);
        aniadirPanel();
    }

    private void aniadirPanel(){
        panel = new JPanel();
        panel.setLayout(null);
    }

    public void agregarBotones(FondoVentanaInicioSesion fondo) {
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(390, 340, 100, 30);
        botonAceptar.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonAceptar);
        botonAceptar.setOpaque(true);
        botonAceptar.setBackground(Color.white);
        botonAceptar.setForeground(Color.black);
        botonAceptar.addActionListener(this);

        botonSalir = new JButton("Salir");
        botonSalir.setBounds(500,340, 100, 30);
        botonSalir.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonSalir);
        botonSalir.setOpaque(true);
        botonSalir.setBackground(Color.white);
        botonSalir.setForeground(Color.black);
        botonSalir.addActionListener(this);

        botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setBounds(440,380, 110, 30);
        botonRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonRegistrarse);
        botonRegistrarse.setOpaque(true);
        botonRegistrarse.setBackground(Color.white);
        botonRegistrarse.setForeground(Color.black);
        botonRegistrarse.addActionListener(this);

        agregarCajasDeTexto();
    }

    public void agregarCajasDeTexto(){
        cajaDeTextoRut = new JTextField();
        cajaDeTextoRut.setBounds(430,210,130,30);
        fondo.add(cajaDeTextoRut);

        cajaDeTextoContrasena = new JPasswordField();
        cajaDeTextoContrasena.setBounds(430,280,130,30);
        fondo.add(cajaDeTextoContrasena);
    }

    public boolean cajasDeTextoVacias() {
        return cajaDeTextoRut.getText().equals("") || cajaDeTextoContrasena.getText().equals("");
    }


    public void limpiarCajasDeTexto() {
        cajaDeTextoRut.setText("");
        cajaDeTextoContrasena.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ConjuntoJugadores conjuntoJugadores = new ConjuntoJugadores();
        DatosJugadores.leerArchivoJugador(conjuntoJugadores,"./src/main/resources/conjuntoJugadores.txt");

        if(e.getSource() == botonSalir){
            if (JOptionPane.showConfirmDialog(rootPane, "¿Está seguro/a que desea salir del juego?",
                    "Confirmación de cierre", JOptionPane.YES_NO_OPTION) == JOptionPane.ERROR_MESSAGE) {System.exit(0);}
        }else if (e.getSource() == botonAceptar && cajasDeTextoVacias()){
            JOptionPane.showMessageDialog(this,"Por favor, no deje campos de texto vacíos");
            Sonido.reproducirSonido();
            limpiarCajasDeTexto();
        }else if(e.getSource() == botonAceptar && VerificadorRut.validarRut(cajaDeTextoRut.getText()) &&
                VerificadorContrasena.verificarContrasena(cajaDeTextoContrasena.getText()) &&
                PortalDeInicio.validarContrasenaCorrecta(conjuntoJugadores,cajaDeTextoRut.getText(),cajaDeTextoContrasena.getText())) {
            try {
                var jugador = conjuntoJugadores.buscarJugadorPorRut(cajaDeTextoRut.getText());
                JOptionPane.showMessageDialog(this,"USUARIO ACEPTADO"+"\nBienvenido "+jugador.getNombre());
                new VentanaMenuPrincipal(jugador).setVisible(true);
            } catch (JugadorNoEncontradoException | IOException ex) {
                throw new RuntimeException(ex);
            }

            this.dispose();
        } else if(e.getSource() == botonAceptar && (!VerificadorRut.validarRut(cajaDeTextoRut.getText()) || !VerificadorContrasena.verificarContrasena(cajaDeTextoContrasena.getText()))) {
            JOptionPane.showMessageDialog(this, "ERROR, ingrese los datos correctamente");
            Sonido.reproducirSonido();
            limpiarCajasDeTexto();
        } else if (e.getSource() == botonAceptar && VerificadorRut.validarRut(cajaDeTextoRut.getText()) &&
                VerificadorContrasena.verificarContrasena(cajaDeTextoContrasena.getText()) && !conjuntoJugadores.jugadorExiste(cajaDeTextoRut.getText())) {
            JOptionPane.showMessageDialog(this, "ERROR, Este usuario no se encuentra registrado");
            Sonido.reproducirSonido();

            limpiarCajasDeTexto();
        } else if (e.getSource() == botonAceptar && VerificadorRut.validarRut(cajaDeTextoRut.getText()) &&
                VerificadorContrasena.verificarContrasena(cajaDeTextoContrasena.getText()) &&
                !PortalDeInicio.validarContrasenaCorrecta(conjuntoJugadores,cajaDeTextoRut.getText(),cajaDeTextoContrasena.getText())) {
            JOptionPane.showMessageDialog(this, "ERROR, ha ingresado una contraseña incorrecta");
            Sonido.reproducirSonido();
            limpiarCajasDeTexto();

        } else if(e.getSource() == botonRegistrarse) {
            this.dispose();
            new VentanaCrearCuenta().setVisible(true);
        }else {
            JOptionPane.showMessageDialog(this, "ERROR, Estas haciendo algo mal :/ " +
                    "ingresa los datos correctamente\n");
            Sonido.reproducirSonido();
            limpiarCajasDeTexto();
        }
    }
}