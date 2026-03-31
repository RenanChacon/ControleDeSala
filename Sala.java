public class Sala {
    private Aluno[] alunos = new Aluno[60];
    private int tamanho = 0;

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

    public void listar() {
    if (estaVazia()) {
        System.out.println("Lista vazia");
        return;
        }

    for (int i = 0; i < tamanho; i++) {
        System.out.println("RGM: " + alunos[i].getRgm());
        }
    }



}
