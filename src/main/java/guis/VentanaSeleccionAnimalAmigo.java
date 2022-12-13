package guis;

import dato.DatosAnimales;
import modelo.Animal;
import modelo.AnimalNoEncontradoException;
import modelo.Jugador;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class VentanaSeleccionAnimalAmigo extends Ventana implements ActionListener {
    private Jugador jugador;
    private Animal animalZona;

    private JLabel vida;
    private JLabel imagenAnimal;
    private JButton informacionBtn;

    private JButton seleccionarBtn;
    private JButton volverBtn;


    private JComboBox comboBoxAnimales;




    public VentanaSeleccionAnimalAmigo(Jugador jugador, Animal animalZona) {
        this.jugador = jugador;
        this.animalZona = animalZona;

        this.setContentPane(new JLabel(new ImageIcon("./src/main/resources/FondoVentanaSeleccionAnimal(MOD).jpeg")));

        this.setTitle("Selección animal para combate");

        this.generarEtiquetaBlanca("Selecciona un Animal ", 240, 50, 320, 20,"arial",22);


        this.generarEtiquetaBlanca("Puntos de vida: ", 20, 130, 190, 20,"arial",20);

        seleccionarBtn = this.generarBoton("Seleccionar", 420, 370, 150, 30);
        seleccionarBtn.addActionListener(this);

        volverBtn = this.generarBoton("Volver", 20, 20, 150, 30);
        volverBtn.addActionListener(this);

        informacionBtn = this.generarBoton("Ver animal", 100, 370, 150, 30);
        informacionBtn.addActionListener(this);

        vida = this.generarEtiquetaBlanca("", 180, 130, 30, 20,"arial", 20);
        imagenAnimal = this.generarEtiqueta("", 400, 60, 200, 250);


        comboBoxAnimales = this.generarComboBoxAnimales(jugador.getAnimales(), 150, 180, 150, 20);
    }

    public void mostrarInformacionAnimal() {

        Animal a = null;
        try {
            a = Animal.buscarAnimalPorNombre(comboBoxAnimales.getSelectedItem().toString(), this.jugador.getAnimales());
        } catch (AnimalNoEncontradoException e) {
            throw new RuntimeException(e);
        }
        vida.setText(a.getVida());
        imagenAnimal.setIcon(new ImageIcon("./src/main/resources/"+a.getImagen()));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == informacionBtn) {
            mostrarInformacionAnimal();
        } else if(e.getSource() == volverBtn) {
            this.dispose();
            try {
                var animales = new ArrayList<Animal>();
                DatosAnimales.leerArchivoAnimales(animales, "./src/main/resources/animales.txt");
                new VentanaSeleccionDeZona(this.jugador, animales).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == seleccionarBtn) {
            try {
                new VentanaCombate(this.jugador,
                        Animal.buscarAnimalPorNombre(comboBoxAnimales.getSelectedItem().toString(), this.jugador.getAnimales()),
                        this.animalZona).setVisible(true);
            } catch (AnimalNoEncontradoException ex) {
                throw new RuntimeException(ex);
            }
            this.dispose();
        }
    }


}