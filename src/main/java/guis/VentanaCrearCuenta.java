package guis;

import dato.DatosJugadores;
import modelo.Jugador;
import modelo.PortalDeInicio;
import utils.VerificadorContrasena;
import utils.VerificadorNombre;
import utils.VerificadorRut;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearCuenta extends JFrame implements ActionListener {
    FondoVentanaCrearCuenta fondo = new FondoVentanaCrearCuenta();
    private JPanel panel;
    private JTextField cajaDeTextoNombre;
    private JTextField cajaDeTextoRut;
    private JTextField cajaDeTextoContrasena;
    private JLabel etiquetaNombre;
    private JLabel etiquetaRut;
    private JLabel etiquetaContrasena;
    private JLabel etiquetaInstruccionesIngresoRut1;
    private JLabel etiquetaInstruccionesIngresoRut2;
    private JLabel etiquetaInstruccionesIngresoContrasena1;
    private JLabel etiquetaInstruccionesIngresoContrasena2;
    private JLabel etiquetaInstruccionesIngresoContrasena3;
    private JLabel etiquetaInstruccionesIngresoNombre1;
    private JButton botonRegistrar;
    private JButton botonVolver;



    public VentanaCrearCuenta(){
        this.setTitle("Creación de cuenta");
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

    public void agregarBotones(FondoVentanaCrearCuenta fondo) {
        botonRegistrar = new JButton("Registrar");
        botonRegistrar.setBounds(500, 350, 100, 30);
        botonRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonRegistrar);
        botonRegistrar.setOpaque(true);
        botonRegistrar.setBackground(Color.white);
        botonRegistrar.setForeground(Color.black);
        botonRegistrar.addActionListener(this);

        botonVolver = new JButton("Volver");
        botonVolver.setBounds(360, 350, 100, 30);
        botonVolver.setHorizontalAlignment(SwingConstants.CENTER);
        fondo.add(botonVolver);
        botonVolver.setOpaque(true);
        botonVolver.setBackground(Color.white);
        botonVolver.setForeground(Color.black);
        botonVolver.addActionListener(this);

        agregarCajasDeTexto();
    }

    public void añadirEtiquetas(){
        etiquetaNombre = new JLabel("Ingrese un nombre:");
        etiquetaNombre.setBounds(330,200,480,30);
        etiquetaNombre.setFont(new Font("arial",Font.BOLD,15));
        fondo.add(etiquetaNombre);

        etiquetaRut = new JLabel("Ingrese su rut:");
        etiquetaRut.setBounds(330,240,480,30);
        etiquetaRut.setFont(new Font("arial",Font.BOLD,15));
        fondo.add(etiquetaRut);

        etiquetaContrasena = new JLabel("Ingrese una contraseña:");
        etiquetaContrasena.setBounds(330,280,480,30);
        etiquetaContrasena.setFont(new Font("arial",Font.BOLD,15));
        fondo.add(etiquetaContrasena);

        etiquetaInstruccionesIngresoNombre1 = new JLabel();
        etiquetaInstruccionesIngresoNombre1.setText("Deberá ingresar un nombre con entre 5 y 10 caracteres.");
        etiquetaInstruccionesIngresoNombre1.setBounds(330,50,480,30);
        etiquetaInstruccionesIngresoNombre1.setFont(new Font("arial",Font.BOLD,10));
        fondo.add(etiquetaInstruccionesIngresoNombre1);

        etiquetaInstruccionesIngresoRut1 = new JLabel();
        etiquetaInstruccionesIngresoRut1.setText("A continuación deberá ingresar su rut, sin puntos ni guión");
        etiquetaInstruccionesIngresoRut1.setBounds(330,70,480,30);
        etiquetaInstruccionesIngresoRut1.setFont(new Font("arial",Font.BOLD,10));
        fondo.add(etiquetaInstruccionesIngresoRut1);

        etiquetaInstruccionesIngresoRut2 = new JLabel();
        etiquetaInstruccionesIngresoRut2.setText("y con dígito verificador.");
        etiquetaInstruccionesIngresoRut2.setBounds(330,90,480,30);
        etiquetaInstruccionesIngresoRut2.setFont(new Font("arial",Font.BOLD,10));
        fondo.add(etiquetaInstruccionesIngresoRut2);

        etiquetaInstruccionesIngresoContrasena1 = new JLabel();
        etiquetaInstruccionesIngresoContrasena1.setText("Seguido de esto deberá ingresar una contraseña, la cual");
        etiquetaInstruccionesIngresoContrasena1.setBounds(330,110,480,30);
        etiquetaInstruccionesIngresoContrasena1.setFont(new Font("arial",Font.BOLD,10));
        fondo.add(etiquetaInstruccionesIngresoContrasena1);

        etiquetaInstruccionesIngresoContrasena2 = new JLabel();
        etiquetaInstruccionesIngresoContrasena2.setText("puede tener letras, números, o letras y números y por lo menos");
        etiquetaInstruccionesIngresoContrasena2.setBounds(330,130,480,30);
        etiquetaInstruccionesIngresoContrasena2.setFont(new Font("arial",Font.BOLD,10));
        fondo.add(etiquetaInstruccionesIngresoContrasena2);

        etiquetaInstruccionesIngresoContrasena3 = new JLabel();
        etiquetaInstruccionesIngresoContrasena3.setText("5 caracteres y máximo 10.");
        etiquetaInstruccionesIngresoContrasena3.setBounds(330,150,480,30);
        etiquetaInstruccionesIngresoContrasena3.setFont(new Font("arial",Font.BOLD,10));
        fondo.add(etiquetaInstruccionesIngresoContrasena3);
    }

    public void agregarCajasDeTexto(){
        cajaDeTextoNombre = new JTextField();
        cajaDeTextoNombre.setBounds(520,200,130,30);
        fondo.add(cajaDeTextoNombre);

        cajaDeTextoRut = new JTextField();
        cajaDeTextoRut.setBounds(520,240,130,30);
        fondo.add(cajaDeTextoRut);

        cajaDeTextoContrasena = new JTextField();
        cajaDeTextoContrasena.setBounds(520,280,130,30);
        fondo.add(cajaDeTextoContrasena);
    }

    public boolean cajasDeTextoVacias() {
        return cajaDeTextoNombre.getText().equals("") || cajaDeTextoRut.getText().equals("") ||
                cajaDeTextoContrasena.getText().equals("");
    }

    public void limpiarCajasDeTexto() {
        cajaDeTextoNombre.setText("");
        cajaDeTextoRut.setText("");
        cajaDeTextoContrasena.setText("");
    }

    public boolean verificarEspaciosEnCajasDeTexto(){
        return (cajaDeTextoNombre.getText().contains(" ") && cajaDeTextoRut.getText().contains(" ") && cajaDeTextoContrasena.getText().contains(" "));}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == botonVolver){
            this.dispose();
            new VentanaInicioDeSesion().setVisible(true);
        }else if (e.getSource() == botonRegistrar && cajasDeTextoVacias()){
            JOptionPane.showMessageDialog(this,"Por favor, no deje campos de texto vacíos");
            limpiarCajasDeTexto();

        } else if(e.getSource() == botonRegistrar && VerificadorNombre.validarNombre(String.valueOf(cajaDeTextoNombre.getText()))
                  && VerificadorRut.validarRut(cajaDeTextoRut.getText()) && VerificadorContrasena.verificarContrasena(cajaDeTextoContrasena.getText())) {
            DatosJugadores.registrarDatos(PortalDeInicio.crearCuentaParaVentana(cajaDeTextoNombre.getText(),
                    cajaDeTextoRut.getText(),cajaDeTextoContrasena.getText()),"./src/main/resources/conjuntoJugadores.txt");
            System.out.println(DatosJugadores.registrarDatos(PortalDeInicio.crearCuentaParaVentana(cajaDeTextoNombre.getText(),
                    cajaDeTextoRut.getText(),cajaDeTextoContrasena.getText()),"./src/main/resources/conjuntoJugadores.txt"));

            JOptionPane.showMessageDialog(this,"USUARIO REGISTRADO :)");
            this.dispose();
            new VentanaInicioDeSesion().setVisible(true);
        } else if(e.getSource() == botonRegistrar && (!VerificadorNombre.validarNombre(cajaDeTextoNombre.getText()) ||
                !VerificadorRut.validarRut(cajaDeTextoRut.getText()) || !VerificadorContrasena.verificarContrasena(cajaDeTextoContrasena.getText()))) {
            JOptionPane.showMessageDialog(this,"ERROR, ingrese los datos correctamente");
            limpiarCajasDeTexto();
        }
    }
}