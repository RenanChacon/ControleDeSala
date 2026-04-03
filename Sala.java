import java.util.Scanner;

public class Sala {
    private  Scanner entrada = new Scanner(System.in);
    
    private Aluno[] alunos = new Aluno[60];
    private int tamanho = 0;

    public Aluno getAluno(int pos) {
        return alunos[pos];
    }
    
    public boolean estaVazia(){
        return (tamanho == 0);
    }
    public boolean estaCheia(){
        return (tamanho == alunos.length);
    }
    public int tamanhoLista(){
        return tamanho;
    }

    public int buscaPorRgm(int rgm) {
        for (int i = 0; i < tamanho; i++) {
            if (alunos[i].getRgm() == rgm) {
            return i;
            }
        }
        return -1;
        } 

    public boolean compara (Aluno s1, Aluno s2){
        return s1.getRgm() == s2.getRgm();
    }

    public int retornaPos(Aluno aluno) {
        for(int i = 0; i < tamanho; i++){
            if (compara(alunos[i], aluno)){
                return i; }
         }
        return -1;
                
    }

    public void deslocarDireita(int pos){
        for(int i = tamanho; i > pos; i--)
            alunos[i] = alunos[i-1];
    }

    public void deslocarEsquerda(int pos){
        for(int i = pos; i < (tamanho - 1); i++)
            alunos[i] = alunos[i+1];
    }

    public boolean inserirOrdenado (Aluno s1){
        if(estaCheia())
            return false;
        int i;
        for (i = tamanho - 1; i >= 0 && alunos[i].getRgm() > s1.getRgm(); i--);

        deslocarDireita(i + 1);
        alunos[i + 1] = s1;
        tamanho++;
        return true;
    }

    public boolean remover (int pos){
        if((pos >= tamanho) || (pos < 0))
            return false;

        deslocarEsquerda(pos);
        tamanho--;
        return true;
    }

    public void listarAlunos() {
        if (estaVazia()) {
            System.out.println("Lista vazia");
            return;
            }

        for (int i = 0; i < tamanho; i++) {
            System.out.println();
            System.out.println("RGM: " + alunos[i].getRgm());
            alunos[i].mostrarMaterias();
        }
    }

    public void addAluno() {
        System.out.println("Digite o RGM do aluno: ");
        int rgm = entrada.nextInt(); entrada.nextLine();
                        
        Aluno aluno = new Aluno(rgm);
                        
        boolean repetir2 = true;
        while(repetir2){
            System.out.println("Digite o nome da matéria que queira adicionar: ");
            String nome = entrada.nextLine();
            System.out.println("Digite a nota do aluno nessa materia: ");
            double nota = entrada.nextDouble(); entrada.nextLine();
            aluno.addMateria(nome, nota);

            System.out.println("Deseja adicionar mais uma matéria?(s/n): ");

            if(entrada.nextLine().equalsIgnoreCase("n")) {
                repetir2= false;
            }
        }

        inserirOrdenado(aluno);
    }
}
