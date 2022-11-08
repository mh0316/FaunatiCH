package modelo;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Animal> animales;
    private String nombre;
    private String rut;
    private String contrasenia;

    public Jugador(String nombre, String rut, String contrasenia) {
        this.nombre = nombre;
        this.rut = rut;
        this.contrasenia = contrasenia;
    }


    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String toString() {
        return nombre +";"+rut+";"+ contrasenia;
    }

    public void agregarPokemon(Animal animal){
        animales.add(animal);
    }

    public void agregarPokemones(ArrayList<Animal> listaAnimal){
        this.animales = listaAnimal;
    }
}
