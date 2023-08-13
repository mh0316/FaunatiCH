package guis;

import dato.DatosJugadores;
import modelo.Animal;
import modelo.Ataque;
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

    private JButton[] botonesAtaque = new JButton[3];
    private JButton usarParchecuritaBtn;
    private JButton continuarBtn;
    private Jugador jugador;
    private Animal animalJugador;
    private Animal animalZona;

    public VentanaCombate(Jugador jugador, Animal animalJugador, Animal animalZona) {
        this.jugador = jugador;
        this.animalJugador = animalJugador;
        this.animalZona = animalZona;

        inicializarVentana();
        inicializarComponentes();
        mostrarInformacion();
    }

    private void inicializarComponentes() {
        inicializarEtiquetas();
        inicializarBotones();
    }

    private void inicializarBotones() {
        inicializarBotonesAtaque();
        usarParchecuritaBtn = this.generarBoton("Usar Parchecurita", 535, 330, 150, 20);
        usarParchecuritaBtn.addActionListener(this);

        continuarBtn = this.generarBoton("Continuar", 450, 420, 150, 20);
        continuarBtn.addActionListener(this);
    }

    private void inicializarBotonesAtaque() {
        int posY = 330;
        for (int i = 0; i < botonesAtaque.length; i++) {
            botonesAtaque[i] = this.generarBoton("", 355, posY, 150, 20);
            botonesAtaque[i].addActionListener(this);
            posY += 50;
        }
    }

    private void inicializarEtiquetas() {
        vidaAnimalJugador = this.generarEtiquetaBlanca("", 500, 270, 190, 20, "arial", 15);
        vidaAnimalZona = this.generarEtiquetaBlanca("", 500, 250, 190, 20, "arial", 15);

        imagenAnimalJugador = this.generarEtiqueta("", 150, 50, 200, 250);
        imagenAnimalZona = this.generarEtiqueta("", 490, -35, 200, 250);

        recuadroInformativo = this.generarEtiquetaBlanca("", 15, 250, 300, 200, "arial", 25);
    }

    private void inicializarVentana() {
        this.setContentPane(new JLabel(new ImageIcon("./src/main/resources/FondoVentanCombate(MOD).png")));
        this.setTitle("Combate");
    }

    public void mostrarInformacion() {
        imagenAnimalJugador.setIcon(new ImageIcon("./src/main/resources/" + animalJugador.getImagen()));
        imagenAnimalZona.setIcon(new ImageIcon("./src/main/resources/" + animalZona.getImagen()));

        vidaAnimalJugador.setText("Vida " + animalJugador.getNombre() + ": " + animalJugador.getVida());
        vidaAnimalZona.setText("Vida " + animalZona.getNombre() + ": " + animalZona.getVida());

        actualizarRecuadroInformativo();

        botonesAtaque[0].setText(animalJugador.getAtaques().get(0).getNombreAtaque());
        botonesAtaque[1].setText(animalJugador.getAtaques().get(1).getNombreAtaque());
        botonesAtaque[2].setText(animalJugador.getAtaques().get(2).getNombreAtaque());
    }

    private void actualizarRecuadroInformativo() {
        if (esTurnoJugador) {
            recuadroInformativo.setText("<html>" + "¿Qué ataque debería hacer " + animalJugador.getNombre() + "?" + "<html>");
        } else {
            // Aquí puedes agregar la lógica relacionada con el sleep que tenías.
            recuadroInformativo.setText("<html>" + "Turno de " + animalZona.getNombre() + "<html>");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object fuente = e.getSource();

        if (esTurnoJugador) {
            if (animalJugador.isVivo()) {
                recuadroInformativo.setText("<html>" + animalJugador.getNombre() + " no puede atacar, ha sido derrotado." + "<html>");
                return;
            }

            for (int i = 0; i < botonesAtaque.length; i++) {
                if (fuente == botonesAtaque[i]) {
                    Ataque ataqueSeleccionado = animalJugador.getAtaques().get(i);
                    animalJugador.atacar(ataqueSeleccionado, animalZona);
                    recuadroInformativo.setText("<html>" + animalJugador.getNombre() + " ha usado " + ataqueSeleccionado.getNombreAtaque() + "<html>");
                }
            }

            if (fuente == usarParchecuritaBtn) {
                // Aquí, implementa la lógica para curar al animal del jugador si tienes un item de curación.
                // Por ejemplo: animalJugador.curar(20);
                // recuadroInformativo.setText("<html>" + animalJugador.getNombre() + " ha sido curado." + "<html>");
            }

            esTurnoJugador = false;
        } else {
            if (animalZona.isVivo()) {
                recuadroInformativo.setText("<html>" + animalZona.getNombre() + " no puede atacar, ha sido derrotado." + "<html>");
                return;
            }

            Ataque ataqueSeleccionado = animalZona.ataqueRandom();
            animalZona.atacar(ataqueSeleccionado, animalJugador);
            recuadroInformativo.setText("<html>" + animalZona.getNombre() + " ha usado " + ataqueSeleccionado.getNombreAtaque() + "<html>");

            esTurnoJugador = true;
        }

        mostrarInformacion();
        comprobarFinCombate();
    }

    private void comprobarFinCombate() {
        if (animalJugador.isVivo()) {
            recuadroInformativo.setText("<html>" + animalJugador.getNombre() + " ha sido derrotado." + "<html>");
            // Aquí puedes agregar lógica para gestionar el fin del combate, por ejemplo, volver a la pantalla principal.
        } else if (animalZona.isVivo()) {
            recuadroInformativo.setText("<html>" + animalZona.getNombre() + " ha sido derrotado." + "<html>");
            // Aquí puedes agregar lógica para gestionar el fin del combate, por ejemplo, otorgar puntos de experiencia.
        }
    }



}