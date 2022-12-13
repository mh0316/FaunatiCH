package guis;

import dato.DatosJugadores;
import modelo.Animal;
import modelo.Juego;
import modelo.Jugador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class VentanaCombate extends Ventana implements ActionListener {

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

        continuarBtn = this.generarBoton("Continuar",390,420,150,20);
        continuarBtn.addActionListener(this);

        mostrarInformacionInformacion();
    }

    public void mostrarInformacionInformacion() {
        imagenAnimalJugador.setIcon(new ImageIcon("./src/main/resources/"+animalJugador.getImagen()));
        imagenAnimalZona.setIcon(new ImageIcon("./src/main/resources/"+animalZona.getImagen()));

        vidaAnimalJugador.setText("Vida "+animalJugador.getNombre()+": "+animalJugador.getVida());
        vidaAnimalZona.setText("Vida "+animalZona.getNombre()+": "+animalZona.getVida());

        recuadroInformativo.setText("<html>"+"¿Qué ataque debería hacer "+animalJugador.getNombre()+"?"+"<html>");

        ataque1Btn.setText(animalJugador.getNombreAtaque1());
        ataque2Btn.setText(animalJugador.getNombreAtaque2());
        ataque3Btn.setText(animalJugador.getNombreAtaque3());
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == ataque1Btn){
            Juego.atacar(animalJugador.getAtaque1(), animalZona);


        } else if (e.getSource() == ataque2Btn) {
            Juego.atacar(animalJugador.getAtaque2(), animalZona);
            //JOptionPane.showMessageDialog(this, animalZona.getVida());
        } else if (e.getSource() == ataque3Btn) {
            Juego.atacar(animalJugador.getAtaque3(), animalZona);
            //JOptionPane.showMessageDialog(this, animalZona.getVida());
        }else if (e.getSource() == usarParchecuritaBtn){
            Juego.usarParcheCurita(animalJugador, jugador);
        } else if (e.getSource() == continuarBtn) {
            Juego.recibirAtaque(animalJugador, animalZona);
        }

        //vidaAnimalZona.setText("Vida "+animalZona.getNombre()+": "+animalZona.getVida());

        /*try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            System.out.println("Falló el temporizador");;
        }*/
        mostrarInformacionInformacion();

        //TODO REFACTORIZAR CON OPERADOR TERNARIO
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

        //Necesitamos crear un metodo del jugador o de la clase juego que compruebe si el jugador ya tiene un animal en
        //su lista de animales, si ya lo tiene no es posible agregar el animal (denuevo)

        //extras
        //en ventana hacer inutilizable los botones de atque y parchecuritas si ya los uso una vez, hasta que aprete continuar
        //o usar un JOptionPane que detenga el flujo y este muestra el ataque del animal enemigo
    }
}