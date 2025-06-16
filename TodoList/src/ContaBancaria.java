import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class ContaBancaria {

    private int numeroConta;
    public String nome;
    private float qtdConta;

    ArrayList<ContaBancaria> contas = new ArrayList<>();

    public ContaBancaria(int numeroConta, String nome) {
        this.numeroConta = numeroConta;
        this.nome = nome;
    }

    public int getConta() {
        return numeroConta;
    }

    public String getNome() {
        return nome;
    }

    public float getQtdConta() {
        return qtdConta;
    }

    public void depositar(float deposito) {
        this.qtdConta += deposito;
        System.out.println("Depósito adicionado com sucesso, quantia depositada: " + deposito);
    }

    public void sacar(float saque) {
        this.qtdConta += saque;
        System.out.println("Saque realizado com sucesso, quantia sacada: " + saque);
    }

    public void creditar(ContaBancaria conta, float valor) {
        conta.qtdConta += valor;
    }

    public void debitar(ContaBancaria conta, float valor) {
        conta.qtdConta -= valor;
    }

    public void transferir(ContaBancaria contaOrigem, ContaBancaria contaDestino, float valorTransferencia) {
        if (valorTransferencia > contaOrigem.getQtdConta()) {
            System.out.println("saldo insuficiente para transferência");
            return;
        }

        for (ContaBancaria c : contas) {
            if (c.getConta() == contaDestino.getConta()) {
                debitar(contaOrigem, valorTransferencia);
                creditar(contaDestino, valorTransferencia);
            } else {
                System.out.println("Conta inexistente e/ou inválida");
            }
        }
        System.out.println("Conta inexistente e/ou inválida");
    }
}