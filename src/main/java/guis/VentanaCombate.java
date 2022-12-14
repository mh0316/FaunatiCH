package guis;

import dato.DatosJugadores;
import modelo.Animal;
import modelo.Juego;
import modelo.Jugador;
import utils.Sonido;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VentanaCombate extends Ventana implements ActionListener {
    private boolean esTurnoJugador = true;

    private JLabel imagenAnimalJugador;
    private JLabel imagenAnimalZona;
    private JLabel vidaAnimalJugador;
    private JLabel vidaAnimalZona;


    private JLabel recuadroInformativo;

    private JButton ataque1Btn;
    private JButton ataque2Btn;
    private JButton ataque3Btn;
    private JButton usarParchecuritaBtn;
    private JButton continuarBtn;
    private Jugador jugador;
    private Animal animalJugador;
    private Animal animalZona;

    public VentanaCombate(Jugador jugador, Animal animalJugador, Animal animalZona){
        this.setContentPane(new JLabel(new ImageIcon("./src/main/resources/FondoVentanCombate(MOD).png")));

        this.jugador = jugador;
        this.animalJugador = animalJugador;
        this.animalZona = animalZona;

        this.setTitle("Combate");

        vidaAnimalJugador = this.generarEtiquetaBlanca("",500,270,190,20,"arial",15);
        vidaAnimalZona = this.generarEtiquetaBlanca("",500,250,190,20,"arial",15);

        imagenAnimalJugador = this.generarEtiqueta("", 150, 50, 200, 250);
        imagenAnimalZona = this.generarEtiqueta("", 490, -35, 200, 250);

        recuadroInformativo = this.generarEtiquetaBlanca("",15,250,300,200,"arial",25);


        ataque1Btn = this.generarBoton("",355,330,150,20);
        ataque1Btn.addActionListener(this);

        ataque2Btn = this.generarBoton("",355,380,150,20);
        ataque2Btn.addActionListener(this);

        ataque3Btn = this.generarBoton("",535,380,150,20);
        ataque3Btn.addActionListener(this);

        usarParchecuritaBtn = this.generarBoton("Usar Parchecurita",535,330,150,20);
        usarParchecuritaBtn.addActionListener(this);

        continuarBtn = this.generarBoton("Continuar",450,420,150,20);
        continuarBtn.addActionListener(this);

        mostrarInformacionInformacion();
    }

    public void mostrarInformacionInformacion() {
        imagenAnimalJugador.setIcon(new ImageIcon("./src/main/resources/"+animalJugador.getImagen()));
        imagenAnimalZona.setIcon(new ImageIcon("./src/main/resources/"+animalZona.getImagen()));

        vidaAnimalJugador.setText("Vida "+animalJugador.getNombre()+": "+animalJugador.getVida());
        vidaAnimalZona.setText("Vida "+animalZona.getNombre()+": "+animalZona.getVida());

        if (this.esTurnoJugador){
            recuadroInformativo.setText("<html>"+"¿Qué ataque debería hacer "+animalJugador.getNombre()+"?"+"<html>");
        }else {
            try {
                TimeUnit.MILLISECONDS.sleep(1800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            recuadroInformativo.setText("<html>"+"Turno de "+animalZona.getNombre()+"<html>");
        }

        ataque1Btn.setText(animalJugador.getNombreAtaque1());
        ataque2Btn.setText(animalJugador.getNombreAtaque2());
        ataque3Btn.setText(animalJugador.getNombreAtaque3());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.esTurnoJugador){

            if (e.getSource() == ataque1Btn){
                Juego.atacar(animalJugador.getAtaque1(), animalZona);

            } else if (e.getSource() == ataque2Btn) {
                Juego.atacar(animalJugador.getAtaque2(), animalZona);

            } else if (e.getSource() == ataque3Btn) {
                Juego.atacar(animalJugador.getAtaque3(), animalZona);

            }else if (e.getSource() == usarParchecuritaBtn){
                if (!jugador.getParcheCuritas().equals("0")){
                    Juego.usarParcheCurita(animalJugador, jugador);
                }else{
                    JOptionPane.showMessageDialog(this, "No te quedan parchecuritas D: \nPerdiste el turno!");

                }

            } else if (e.getSource() == continuarBtn) {
                JOptionPane.showMessageDialog(this, "Es tu turno de realizar un ataque!");
            }

            this.esTurnoJugador = false;

        }else {

            if (e.getSource() == ataque1Btn || e.getSource() == ataque2Btn || e.getSource() == ataque3Btn || e.getSource() == usarParchecuritaBtn){
                JOptionPane.showMessageDialog(this, "Para seguir el combate presiona continuar!");
            } else if (e.getSource() == continuarBtn) {
                Sonido.reproducirSonido();
                Juego.recibirAtaque(animalJugador, animalZona);
                this.esTurnoJugador = true;
            }

        }

        
        mostrarInformacionInformacion();

        
        if (!Juego.comprobarSiAnimalSigueVivo(animalZona)){
            JOptionPane.showMessageDialog(this, "Ganaste, se ha agregado "+animalZona.getNombre()+
                    "\n a tu coleccion de amigos");
            jugador.agregarAnimal(this.animalZona);
            DatosJugadores.registrarDatos(jugador, "./src/main/resources/conjuntoJugadores.txt");
            try {
                new VentanaMenuPrincipal(jugador).setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (!Juego.comprobarSiAnimalSigueVivo(animalJugador)) {
            JOptionPane.showMessageDialog(this, "Perdiste, prueba obtener mas parche curitas");
            try {
                new VentanaMenuPrincipal(jugador).setVisible(true);
                this.dispose();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}