package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Animal {

    private String id;
    private String nombre;
    private String vida;

    ArrayList<Ataque> ataques;
    ZonaGeografica zonaGeografica;

    private String imagen;

    public Animal(String id, String nombre, String vida, ArrayList<Ataque> ataques, ZonaGeografica zonaGeografica, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.vida = vida;
        this.ataques = ataques;
        this.zonaGeografica = zonaGeografica;
        this.imagen = imagen;
    }

    public static Animal buscarAnimalPorNombre(String nombre, ArrayList<Animal> animales) throws AnimalNoEncontradoException {
        for (Animal a: animales) {
            if(a.getNombre().equals(nombre)) {
                return a;
            }
        }

        throw new AnimalNoEncontradoException();
    }

    public ArrayList<Ataque> getAtaques() {
        return ataques;
    }



    public String getImagen() {
        return imagen;
    }


    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }



    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }




    public static Animal crearAnimalInicial(){
        Ataque picotazo = new Ataque("Picotazo", 5);
        Ataque embestida = new Ataque("Embestida", 3);
        Ataque extenderAlas = new Ataque("Extender Alas", 3);

        ArrayList<Ataque> ataquesCondor = new ArrayList<>();
        ataquesCondor.add(picotazo);
        ataquesCondor.add(embestida);
        ataquesCondor.add(extenderAlas);

        // Suponiendo que zonaGeografica es un enum o una clase que no has proporcionado,
        // usaré null por el momento. Asegúrate de reemplazarlo con el valor correcto.
        ZonaGeografica zonaGeografica = ZonaGeografica.ZONA_CENTRO;

        Animal animalInicial = new Animal("1", "Condor", "30", ataquesCondor, zonaGeografica, "condor.png");
        return animalInicial;
    }


    public Ataque ataqueRandom() {
        Random random = new Random();
        return this.ataques.get(random.nextInt(ataques.size()));
    }

    public void atacar(Ataque ataqueARealizar, Animal animalContrario){
        animalContrario.recibirAtaque(ataqueARealizar);
    }

    private void recibirAtaque(Ataque ataque) {
        int vidaActual = Integer.parseInt(this.vida);
        vidaActual -= ataque.getDanioAtaque();
        this.vida = String.valueOf(vidaActual);
    }

    public boolean isVivo(){
        return Integer.parseInt(vida) >=0 ;
    }
}