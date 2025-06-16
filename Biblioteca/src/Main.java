import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        Scanner sc = new Scanner(System.in);
        String novoUsuario;
        String novoLivro;
        String nomeUsuario;
        String tituloLivro;
        Usuario usuario;
        Livro livro;
        System.out.println("Olá, bem vindo a biblioteca, deseja fazer ?");
        boolean controle = true;

        while (controle) {
            biblioteca.listarOpcoes();
            int opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Usuários cadastrados: \n");
                    biblioteca.listarUsuarios();
                    break;

                case 2:
                    System.out.println("Livros cadastrados: \n");
                    biblioteca.listarLivros();
                    break;

                case 3:
                    System.out.println("Empréstimos realizados: \n");
                    biblioteca.listarEmprestimos();
                    break;

                case 4:
                    System.out.println("Insira o nome do usuário: ");
                    novoUsuario = sc.next();
                    biblioteca.inserirUsuario(novoUsuario);
                    break;

                case 5:
                    System.out.println("Insira o título do livro: ");
                    novoLivro = sc.next();
                    biblioteca.inserirLivro(novoLivro);
                    break;

                case 6:
                    System.out.println("Insira o nome usuário que vai emprestar: ");
                    System.out.println("Usuário: ");
                    nomeUsuario = sc.next();
                    usuario = biblioteca.buscarUsuario(nomeUsuario);
                    System.out.println("Livro: ");
                    tituloLivro = sc.next();
                    livro = biblioteca.buscarLivros(tituloLivro);

                    if (usuario != null && livro != null) {
                        biblioteca.emprestarLivro(usuario, livro);
                        System.out.println("Empréstimo realizado com sucesso");
                    } else {
                        System.out.println("Usuário e/ou inválidos");
                    }
                    break;

                case 7:
                    System.out.println("Insira o nome do usuário que vai devolver: ");
                    System.out.println("Usuário: ");
                    nomeUsuario = sc.next();
                    usuario = biblioteca.buscarUsuario(nomeUsuario);
                    System.out.println("Livro: ");
                    tituloLivro = sc.next();
                    livro = biblioteca.buscarLivros(tituloLivro);

                    if (usuario != null && livro != null) {
                        Emprestimo emprestimo = biblioteca.buscarEmprestimo(usuario, livro);
                        if (emprestimo != null) {
                            biblioteca.devolverLivro(usuario, livro);
                        } else {
                            System.out.println("emprestimo inexistente");
                        }
                    } else {
                        System.out.println("Usuário e/ou livro inválidos ou não possuem empréstimos");
                    }
                    break;

                case 8:
                    System.out.println("fim do programa");
                    controle = false;
                    break;

                default:
                    System.out.println("Número inválido");
                    break;
            }
        }
    }
}