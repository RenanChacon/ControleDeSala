public class Materia {
    private String nome;
    private double nota;
    private Materia proxima;

    public Materia(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
        this.proxima = null;
    }

    public Materia getProxima() {
        return proxima;
    }

    public void setProxima(Materia materia) {
        this.proxima = materia;
    }

    public double getNota() {
        return nota;
    }

    public String getNome() {
        return nome;
    }
}
