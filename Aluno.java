public class Aluno {
    private int rgm;
    private Materia primeiraMateria;

    public Aluno(int rgm){
        this.rgm = rgm;
        this.primeiraMateria = null;
    }

    public int getRgm(){
        return rgm;
    }

    public void addMateria(String nome, double nota) {
        Materia novaMateria = new Materia(nome, nota);

        if(primeiraMateria == null) {
            primeiraMateria = novaMateria;
        } else {
            Materia materiaAtual = primeiraMateria;
            while(materiaAtual.getProxima() != null) {
                materiaAtual = materiaAtual.getProxima();
            }
            materiaAtual.setProxima(novaMateria);
        }
    }

    public void mostrarMaterias() {
        Materia materiaAtual = primeiraMateria;
        System.out.println("Matérias:");

        do{
            System.out.println(materiaAtual.getNome() + " - " + materiaAtual.getNota());
            materiaAtual = materiaAtual.getProxima();
        } while(materiaAtual != null);
    }
}
