package modelo;

public enum ZonaGeografica {
    ZONA_NORTE("Zona Norte", "src/main/resources/FondoAnimalesZonaNorte.jpeg"),
    ZONA_CENTRO("Zona Centro", "src/main/resources/FondoAnimalesZonaCentro.jpeg"),
    ZONA_SUR("Zona Sur","src/main/resources/FondoAnimalesZonaSur.jpeg");

    private final String nombre;
    private final String rutaImagen;

    ZonaGeografica(String nombre, String rutaImagen) {
        this.nombre = nombre;
        this.rutaImagen = rutaImagen;
    }
}
