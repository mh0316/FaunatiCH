package modelo;

public class Ataque {
    private String nombreAtaque;
    private int danioAtaque;

    public Ataque(String nombreAtaque, int danioAtaque) {
        this.nombreAtaque = nombreAtaque;
        this.danioAtaque = danioAtaque;
    }

    public String getNombreAtaque() {
        return nombreAtaque;
    }

    public int getDanioAtaque() {
        return danioAtaque;
    }
}
