public class ContaBancaria {
    private double saldo;

    public ContaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente. Saldo atual: " + saldo);
        }
        saldo -= valor;
        System.out.println("Saque realizado. Saldo restante: " + saldo);
    }
}