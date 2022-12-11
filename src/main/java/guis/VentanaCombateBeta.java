package guis;

import modelo.Animal;
import modelo.Jugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCombateBeta extends Ventana implements ActionListener {

    private JLabel imagenAnimalJugador;
    private JLabel imagenAnimalZona;
    private Jugador jugador;
    private Animal animalJugador;
    private Animal animalZona;

    public VentanaCombateBeta(Jugador jugador, Animal animalJugador, Animal animalZona){
        this.setContentPane(new JLabel(new ImageIcon("./src/main/resources/FondoVentanCombate(MOD).png")));

        this.jugador = jugador;
        this.animalJugador = animalJugador;
        this.animalZona = animalZona;

        this.setTitle("Combate");




        this.generarEtiquetaBlanca("Puntos de vida: ", 20, 130, 190, 20,"arial",20);


        imagenAnimalJugador = this.generarEtiqueta("", 150, 50, 200, 250);
        imagenAnimalZona = this.generarEtiqueta("", 490, -35, 200, 250);

        mostrarInformacionSeleccion();

    }

    public void mostrarInformacionSeleccion() {

        imagenAnimalJugador.setIcon(new ImageIcon("./src/main/resources/"+animalJugador.getImagen()));
        imagenAnimalZona.setIcon(new ImageIcon("./src/main/resources/"+animalZona.getImagen()));


    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
