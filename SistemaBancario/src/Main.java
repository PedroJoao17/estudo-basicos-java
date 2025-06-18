import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBancaria banco = new ContaBancaria();
        String exit = "";
        String novoNomeUsuario;
        Usuario novoUsuario;
        int opcao;

        System.out.println("Bem vindo ao banco, escolha uma opção");

        while (!exit.equals("exit")) {
            banco.listarOpções();
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuário: ");
                    novoNomeUsuario = sc.nextLine();
                    banco.criarUsuario(novoNomeUsuario);
                    break;

                case 2:
                    System.out.println("Insira o nome do usuário para criarmos a conta: ");
                    novoNomeUsuario = sc.nextLine();
                    banco.criarConta(novoNomeUsuario);
                    break;

                case 3:
                    System.out.println("Informe o quanto deseja depositar: ");


                case 7:
                    System.out.println("fim do programa");
                    exit = "exit";
                    break;

                default:
                    System.out.println("Entrada inválida");
            }
        }
    }
}