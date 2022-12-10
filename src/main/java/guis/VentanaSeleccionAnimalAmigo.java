package guis;

import modelo.Animal;
import modelo.AnimalNoEncontradoException;
import modelo.Jugador;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaSeleccionAnimalAmigo extends Ventana implements ActionListener {
    private Jugador jugador;

    private JLabel vida;
    private JLabel imagenAnimal;
    private JButton informacionBtn;

    private JButton seleccionarBtn;
    private JButton volverBtn;


    private JComboBox comboBoxAnimales;




    public VentanaSeleccionAnimalAmigo(Jugador jugador) {
        this.jugador = jugador;
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
                new VentanaSeleccionDeZona(this.jugador).setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == seleccionarBtn) {
            new VentanaCombate(this.jugador);
            this.dispose();
        }
    }


}