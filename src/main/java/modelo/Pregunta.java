package modelo;

public class Pregunta {
    private String enunciado;
    private String alternativaCorrecta;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;

    public Pregunta(String enunciado, String alternativaCorrecta, String alternativaA,
                    String alternativaB, String alternativaC) {
        this.enunciado = enunciado;
        this.alternativaCorrecta = alternativaCorrecta;
        this.alternativaA = alternativaA;
        this.alternativaB = alternativaB;
        this.alternativaC = alternativaC;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getAlternativaCorrecta() {
        return alternativaCorrecta;
    }

    public String getAlternativaA() {
        return alternativaA;
    }

    public String getAlternativaB() {
        return alternativaB;
    }

    public String getAlternativaC() {
        return alternativaC;
    }
}
