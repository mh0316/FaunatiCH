package modelo;

public class Juego {


    public static int convertirStringAInt(String string){
        return Integer.parseInt(string);
    }


    public static void atacar(String ataque, Animal animalZona) {
        var vida = convertirStringAInt(animalZona.getVida());
        var ataqueRecibido = convertirStringAInt(ataque);
        animalZona.setVida(String.valueOf(vida-ataqueRecibido));
    }

    public static void recibirAtaque(Animal animalJugador, Animal animalZona) {
        var vida = convertirStringAInt(animalJugador.getVida());
        var ataqueRecibido = convertirStringAInt(animalZona.ataqueRandom());

        animalJugador.setVida(String.valueOf(vida-ataqueRecibido));
    }

    public static void usarParcheCurita(Animal animalJugador, Jugador jugador) {
        var numeroParcheCuritas = convertirStringAInt(jugador.getParcheCuritas());
        if(numeroParcheCuritas > 0){
            var vidaActual = convertirStringAInt(animalJugador.getVida());
            animalJugador.setVida(String.valueOf(vidaActual+(3)));
            jugador.setParcheCuritas(String.valueOf(numeroParcheCuritas-1));
        }
    }


    public static boolean comprobarSiAnimalSigueVivo(Animal animal) {
        return convertirStringAInt(animal.getVida()) > 0;
    }
}