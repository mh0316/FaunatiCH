package modelo;

import java.util.ArrayList;

public class Animal {
    private String id;
    private String nombre;
    private String vida;

    private String nombreAtaque1;
    private String nombreAtaque2;
    private String nombreAtaque3;

    private String ataque1;
    private String ataque2;
    private String ataque3;

    private String imagen;

    public Animal(String id, String nombre, String vida, String nombreAtaque1, String nombreAtaque2, String nombreAtaque3,
                  String ataque1, String ataque2, String ataque3, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.vida = vida;
        this.nombreAtaque1 = nombreAtaque1;
        this.nombreAtaque2 = nombreAtaque2;
        this.nombreAtaque3 = nombreAtaque3;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.ataque3 = ataque3;
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




    public String getNombreAtaque1() {
        return nombreAtaque1;
    }



    public String getNombreAtaque2() {
        return nombreAtaque2;
    }



    public String getNombreAtaque3() {
        return nombreAtaque3;
    }


    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    public String getAtaque1() {
        return ataque1;
    }



    public String getAtaque2() {
        return ataque2;
    }


    public String getAtaque3() {
        return ataque3;
    }


    public static Animal crearAnimalInicial(){
        return new Animal("1","Condor","30","5","3","3",
                "Picotazo","Embestida","Extender Alas","condor.png");
    }


    public String ataqueRandom() {
        var numeroRandom = (int) (Math.random()*(10-1)) + 1;
        if (numeroRandom == 1){
            return ataque1;
        } else if (numeroRandom == 2) {
            return ataque2;
        }else {
            return ataque3;
        }

    }

}