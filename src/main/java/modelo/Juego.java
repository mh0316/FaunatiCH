package modelo;

public class Juego {

    public static void combatir(Animal animalJugador, Animal animalZona){
        int vidaAnimalJugador = convertirStringAInt(animalJugador.getVida());
        int vidaAnimalZona = convertirStringAInt(animalZona.getVida());
        while (vidaAnimalZona >= 0 && vidaAnimalJugador >= 0){
            //la ventana le pregunta que ataque deberia hacer el animal del jugador
            //animalJugador.atacar(animalJugador.getAtaque1(),animalZona);
            //se deberia actualizar la vida del animal zona en la ventana
            //vidaAnimalZona.atacar(animalZona.getAtaque1(), animalJugador);

            int x = 1;
            //x.sumar(100);
            System.out.println(x);


        }
    }

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

    public static void usarParcheCurita(Animal animalJugador) {
        var vidaActual = convertirStringAInt(animalJugador.getVida());
        /*System.out.println("animalJugador = " + animalJugador.getVida());
        System.out.println("vidaActual = " + vidaActual);
        System.out.println("String.valueOf(vidaActual) = " + String.valueOf(vidaActual));*/
        animalJugador.setVida(String.valueOf(vidaActual+7)); //+4
        /*System.out.println("animalJugador xdxdxdxd= " + animalJugador.getVida());*/
    }


    public static boolean comprobarSiAnimalSigueVivo(Animal animal) {
        if (convertirStringAInt(animal.getVida()) > 0){
            return true;
        }else {
            return false;
        }
    }
}

