package modelo;

import dato.DatosAnimales;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private String rut;
    private String contrasenia;

    private String parcheCuritas;
    private ArrayList<Animal> animales;


    public Jugador(String nombre, String rut, String contrasenia, String parcheCuritas, ArrayList<Animal> animales) {
        this.nombre = nombre;
        this.rut = rut;
        this.contrasenia = contrasenia;
        this.parcheCuritas = parcheCuritas;
        this.animales = animales;
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

    public String getParcheCuritas() {
        return parcheCuritas;
    }

    public void setParcheCuritas(String parcheCuritas) {
        this.parcheCuritas = parcheCuritas;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    @Override
    public String toString() {
        return nombre+";"+rut+";"+contrasenia+";"+parcheCuritas+";"+obtenerIdsAnimales();
    }

    private String obtenerIdsAnimales() {
        StringBuilder ids_Animales = new StringBuilder();
        for (int i = 0; i < this.animales.size() ; i++) {
            if (i != this.animales.size() - 1 ){
                ids_Animales = new StringBuilder(ids_Animales + this.animales.get(i).getId()+";");

            }else {
                ids_Animales = new StringBuilder(ids_Animales + this.animales.get(i).getId());
            }
        }
        return String.valueOf(ids_Animales);
    }

    public void agregarAnimal(Animal animal){
        animales.add(animal);
    }

    public void agregarAnimal(ArrayList<Animal> listaAnimal){
        this.animales = listaAnimal;
    }

    public void agregarUnParcheCuritas() {
        int numeroDeParchecuritas = Integer.parseInt(this.parcheCuritas) + 1;
        this.parcheCuritas = String.valueOf(numeroDeParchecuritas);
    }



}