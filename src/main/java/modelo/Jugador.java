package modelo;

import java.util.ArrayList;

public class Jugador {
    private ArrayList<Animal> listaAnimal;
    private String nombre;
    private String rut;
    private String contraseña;

    public Jugador(String nombre, String rut, String contraseña) {
        this.nombre = nombre;
        this.rut = rut;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRut() {
        return rut;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String toString() {
        return nombre +";"+rut+";"+contraseña;
    }

    public void agregarPokemon(Animal animal){
        listaAnimal.add(animal);
    }

    public void agregarPokemon(ArrayList<Animal> listaAnimal){
        this.listaAnimal = listaAnimal;
    }
}
