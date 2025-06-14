import java.util.ArrayList;

public class Biblioteca {

    String nomeUsuario;
    String livroEmprestado;

    ArrayList<Livro> acervoLivros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    String[] opcoes =
            {
                    "listar livros",
                    "listar usuarios",
                    "inserir usuario",
                    "inserir livro",
                    "emprestar",
                    "devolver"
            };

    public String listarUsuarios() {
        StringBuilder lista = new StringBuilder();

        int i = 1; // inicializa fora do loop

        for (Usuario usuario : usuarios) {
            lista.append(i).append(" - ").append(usuario.getNome()).append("\n");
            i++;
        }
        System.out.println("Usuários cadastrados: ");
        return lista.toString();
    }

    public String listarLivros() {
        StringBuilder lista = new StringBuilder();

        int i = 1;

        for (Livro livro : acervoLivros) {
            lista.append(i).append(" - ").append(livro.getTitulo()).append("\n");
        }
        System.out.println("Livros no acervo: ");
        return lista.toString();
    }

    public void inserirUsuario(String nome) {
        Usuario novoUsuario = new Usuario(nome);
        usuarios.add(novoUsuario);
        System.out.println("Usuário " + novoUsuario.getNome() + " adicionado com sucesso");
    }

    public void inserirLivro(String titulo) {
        Livro novoLivro = new Livro(titulo);
        acervoLivros.add(novoLivro);
        System.out.println("Livro " + novoLivro.getStatus() + " adicionado com sucesso");
    }

    public void emprestarLivro(Usuario usuario, Livro livro) {
        if (usuario != null && livro != null){
            Emprestimo novoEmprestimo = new Emprestimo(usuario, livro);
            emprestimos.add(novoEmprestimo);
            System.out.println("Empréstimo realizado com sucesso");
            System.out.println("Usuário que emprestou: " + usuario.getNome());
            System.out.println("Livro emprestado: " + livro.getTitulo());
        }else{
            System.out.println("Usuário e/ou livro inválidos");
        }
    }

    public void devolverLivro(Usuario usuario, Livro livro) {
        if(usuario != null && livro != null){
            emprestimos.removeIf(e -> e.getUsuario().equals(usuario) && e.getLivro().equals(livro));
            System.out.println("Devolução realizada com sucesso");
            System.out.println("Usuário que devolveu: " + usuario.getNome());
            System.out.println("Livro devolvido: " + livro.getTitulo());
        }else{
            System.out.println("Usuário e/ou livro inválidos");
        }
    }

    public void listarOpcoes() {
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(i + 1 + " - " + opcoes[i]);
        }
    }
}
