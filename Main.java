import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sala sala = new Sala();
        boolean repetir = true;
        Scanner entrada = new Scanner(System.in);

        while (repetir) {
            System.out.println();
            System.out.println("Escolha uma opção:\n" +
            "1 - Inserir aluno\n" +
            "2 - Mostrar alunos\n" +
            "3 - Buscar aluno pelo RGM\n" +
            "4 - Apagar aluno pelo RGM\n" +
            "5 - Sair\n"
            );

            int opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    if(sala.estaCheia()) {
                        System.out.println("A sala está cheia com 60 alunos, por favor remova um aluno!");
                    } else {
                        sala.addAluno();
                    }
                    break;
                case 2:
                    sala.listarAlunos();
                    break;
                case 3:
                    System.out.println("Informe o RGM para busca: ");
                    int rgm = entrada.nextInt(); entrada.nextLine();
                    int pos = sala.buscaPorRgm(rgm);

                    if(pos==-1) {
                        System.out.println("Nenhum aluno possue esse RGM");
                    }else{
                        Aluno aluno = sala.getAluno(pos);
                        System.out.println("RGM: "  + aluno.getRgm());
                        aluno.mostrarMaterias();
                    }
                    break;
                case 4: 
                    System.out.println("Informe o RGM para remover: ");
                    int rgm2 = entrada.nextInt(); entrada.nextLine();
                    int pos2 = sala.buscaPorRgm(rgm2);

                    if(pos2==-1) {
                        System.out.println("Nenhum aluno possue esse RGM");
                    }else{
                        sala.remover(pos2);
                        sala.listarAlunos();
                    }

                    break;
                case 5:
                    repetir = false;
                    break;
                default:
                    System.out.println("Escolha inválida");
                    break;
            }
        }
    }
}
