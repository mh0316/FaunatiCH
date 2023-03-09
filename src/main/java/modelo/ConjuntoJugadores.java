package modelo;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoJugadores {
    private ArrayList<Jugador> jugadores;

    public ConjuntoJugadores() {
        this.jugadores = new ArrayList<>();
    }


    public boolean jugadorExiste(String rut) {
        return jugadores.stream().anyMatch(jugador -> jugador.getCorreoElectrico().equals(rut));
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Jugador buscarJugadorPorRut(String rut) throws JugadorNoEncontradoException {

        if(!jugadorExiste(rut)) {
            throw new JugadorNoEncontradoException();
        }

        return jugadores.stream().filter(jugador -> jugador.getCorreoElectrico().equals(rut))
                .findFirst().get();
    }

    public int buscarPosicionJugador(String rut) throws JugadorNoEncontradoException {
        for (int i = 0; i < this.jugadores.size(); i++) {
            if (this.jugadores.get(i).getCorreoElectrico().equals(rut)){
                return i;
            }
        }
        throw new JugadorNoEncontradoException();
    }

    public void actualizarDatosJugador(Jugador jugador) throws JugadorNoEncontradoException {
        int posicion = buscarPosicionJugador(jugador.getCorreoElectrico());
        this.jugadores.remove(posicion);
        this.jugadores.add(posicion, jugador);
    }

}