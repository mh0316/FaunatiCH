package modelo;

import dato.DatosAnimales;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private String rut;
    private String contrasenia;
    private ArrayList<Animal> animales;



    public Jugador(String nombre, String rut, String contrasenia, ArrayList<Animal> animales) {
        this.nombre = nombre;
        this.rut = rut;
        this.contrasenia = contrasenia;
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




    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    @Override
    public String toString() {
        return nombre+";"+rut+";"+contrasenia+";"+ obtenerIdsAnimales();
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

    public static void main(String[] args) {
        Animal animal1 = new Animal("1","animal1","7","6","5","4");
        Animal animal2 = new Animal("2","animal2","6","5","4","3");
        Animal animal3 = new Animal("3","animal3","5","4","3","2");


        //var animales = new ArrayList<Animal>(); animales.add(animal1); animales.add(animal2); animales.add(animal3);
        //Jugador jugador1 = new Jugador("nicolas","210241507","nicopass",animales);
        //System.out.println(jugador1.toString());

        System.out.println("----------------------------------");
        var animalesArrayList = new ArrayList<Animal>();
        DatosAnimales.leerArchivoAnimales(animalesArrayList, "./src/main/resources/animales.txt");
        System.out.println(animalesArrayList.toString());
        for (int i = 0; i < animalesArrayList.size(); i++) {
            System.out.println(animalesArrayList.get(i).getAtaque1().toString());
        }
        System.out.println("-------------------");
        System.out.println(animalesArrayList.toString().
                replace("[","").replace("]","").replace(",",";").replace(" ",""));
        System.out.println("......");
        System.out.println(animalesArrayList.toString());
    }

}
