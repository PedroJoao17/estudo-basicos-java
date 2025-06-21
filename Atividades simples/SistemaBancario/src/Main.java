import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContaBancaria banco = new ContaBancaria("");
        String exit = "";
        String usuario;
        String usuarioOrigem;
        String usuarioDestino;
        float deposito;
        float saque;
        float quantiaTransferencia;
        int opcao;

        System.out.println("Bem vindo ao banco, escolha uma opção");

        while (!exit.equals("exit")) {
            banco.listarOpcoes();
            opcao = sc.nextInt();
            sc.nextLine();  // Consome a quebra de linha pendente

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do usuário: ");
                    usuario = sc.nextLine();
                    banco.criarUsuario(usuario);
                    break;

                case 2:
                    System.out.println("Insira o nome do usuário para criarmos a conta: ");
                    usuario = sc.nextLine();
                    banco.criarConta(usuario);
                    break;

                case 3:
                    System.out.println("Informe quem irá receber: ");
                    usuario = sc.nextLine();
                    System.out.println("Informe o quanto deseja depositar: ");
                    deposito = sc.nextFloat();
                    sc.nextLine();
                    banco.depositar(usuario, deposito);
                    break;

                case 4:
                    System.out.println("Informe o quanto deseja sacar: ");
                    saque = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Informe quem vai sacar: ");
                    usuario = sc.nextLine();
                    banco.sacar(usuario, saque);
                    break;

                case 5:
                    System.out.println("Insira os dados para a transferência: ");
                    System.out.println("Usuário de origem: ");
                    usuarioOrigem = sc.nextLine();
                    System.out.println("Usuário destino: ");
                    usuarioDestino = sc.nextLine();
                    System.out.println("Quantia: ");
                    quantiaTransferencia = sc.nextFloat();
                    sc.nextLine();
                    banco.transferir(usuarioOrigem, usuarioDestino, quantiaTransferencia);
                    break;

                case 6:
                    System.out.println("Relatório de transferências: ");
                    banco.relatorioTransferencias();
                    break;

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