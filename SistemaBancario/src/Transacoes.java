public class Transacoes {
    private static int contadorId;
    private int id;
    private int numeroTransacoes = 0;
    private String motivoTransacao;

    public Transacoes(String motivo) {
        contadorId++;
        this.id = contadorId;
        this.numeroTransacoes++;
        this.motivoTransacao = motivo;
    }

    public int getNumeroTransacoes() {
        return numeroTransacoes;
    }

    public String getMotivoTransacao() {
        return motivoTransacao;
    }
}