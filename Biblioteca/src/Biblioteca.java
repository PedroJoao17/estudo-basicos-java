import java.util.ArrayList;

public class Biblioteca {

    String nomeUsuario;
    String livroEmprestado;

    ArrayList<Livro> acervoLivros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();

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

    public String inserirUsuario(String nome) {
        Usuario novoUsuario = new Usuario(nome);
        usuarios.add(novoUsuario);

        return "usuario adicionado com sucesso";
    }

    public String inserirLivro(String titulo) {
        Livro novoLivro = new Livro(titulo);
        acervoLivros.add(novoLivro);

        return "livro adicionado com sucesso";
    }

    public String emprestarLivro(Usuario usuario, Livro livro) {
        Emprestimo novoEmprestimo = new Emprestimo(usuario, livro);
        emprestimos.add(novoEmprestimo);

        return "Emprestimo efetuado";
    }

    public String devolverLivro(Usuario usuario, Livro livro) {
        emprestimos.removeIf(e -> e.getUsuario().equals(usuario) && e.getLivro().equals(livro));

        return "livro devolvido com sucesso";
    }
}
