import java.util.ArrayList;

public class Biblioteca {

    String nomeUsuario;
    String livroEmprestado;

    ArrayList<Livro> acervoLivros = new ArrayList<>();
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    String[] opcoes =
            {
                    "listar usuarios",
                    "listar livros",
                    "inserir usuario",
                    "inserir livro",
                    "emprestar",
                    "devolver",
                    "sair"
            };

    public String listarUsuarios() {
        StringBuilder lista = new StringBuilder();

        int i = 1;

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
            lista.append(i).append(" - ").append(livro.getTitulo()).append(" - ").append(livro.getStatus()).append("\n");
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
        if (usuario != null && livro != null) {
            Emprestimo novoEmprestimo = new Emprestimo(usuario, livro);
            emprestimos.add(novoEmprestimo);
            System.out.println("Empréstimo realizado com sucesso");
            System.out.println("Usuário que emprestou: " + usuario.getNome());
            System.out.println("Livro emprestado: " + livro.getTitulo());
        } else {
            System.out.println("Usuário e/ou livro inválidos");
        }
    }

    public void devolverLivro(Usuario usuario, Livro livro) {
        if (usuario != null && livro != null) {
            emprestimos.removeIf(e -> e.getUsuario().equals(usuario) && e.getLivro().equals(livro));
            System.out.println("Devolução realizada com sucesso");
            System.out.println("Usuário que devolveu: " + usuario.getNome());
            System.out.println("Livro devolvido: " + livro.getTitulo());
        } else {
            System.out.println("Usuário e/ou livro inválidos");
        }
    }

    public void listarOpcoes() {
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(i + 1 + " - " + opcoes[i]);
        }
    }

    public Usuario buscarUsuario(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equalsIgnoreCase(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public Livro buscarLivros(String tituloLivro) {
        for (Livro livro : acervoLivros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) {
                return livro;
            }
        }
        return null;
    }

    public Emprestimo buscarEmprestimo(Usuario usuario, Livro livro) {
        for (Emprestimo e : emprestimos) {
            if (e.getUsuario().equals(usuario) && e.getLivro().equals(livro)) {
                return e;
            }
        }
        return null;
    }
}
