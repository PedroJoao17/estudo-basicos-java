public class Livro {

    String titulo;
    Status status;

    public Livro(String titulo) {

        this.titulo = titulo;
        this.status = Status.disponivel;
    }

    public String getTitulo() {
        return titulo;
    }

    public Status getStatus() {
        return status;
    }
}
