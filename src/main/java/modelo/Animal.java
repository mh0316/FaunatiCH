package modelo;

public class Animal {
    private String nombre;
    private String vida;
    private String ataque1;
    private String ataque2;
    private String ataque3;

    public Animal(String nombre, String vida, String ataque1, String ataque2, String ataque3) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
        this.ataque3 = ataque3;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public void setAtaque1(String ataque1) {
        this.ataque1 = ataque1;
    }

    public String getAtaque2() {
        return ataque2;
    }

    public void setAtaque2(String ataque2) {
        this.ataque2 = ataque2;
    }

    public String getAtaque3() {
        return ataque3;
    }

    public void setAtaque3(String ataque3) {
        this.ataque3 = ataque3;
    }
}
