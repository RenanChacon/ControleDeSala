import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sala s = new Sala();
        boolean repetir = true;
        Scanner entrada = new Scanner(System.in);

        while (repetir) {
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4: 
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
