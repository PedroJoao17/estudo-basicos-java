//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Olá, bem vindo a biblioteca, deseja fazer ?");

        int opcao;
        String[] opcoes =
                {
                        "listar livros",
                        "listar usuarios",
                        "inserir usuario",
                        "inserir livro",
                        "emprestar",
                        "devolver"
                };

        for (int i = 0; i <= opcoes.length; i++) {
            System.out.println(i + 1 + " - " + opcoes[i]);
        }
    }
}