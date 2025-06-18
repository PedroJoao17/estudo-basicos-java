import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class ContaBancaria {

    private int numeroConta;
    private static int contador;
    private float qtdConta = 0;
    Transacoes transacao;
    String titular;

    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<ContaBancaria> contas = new ArrayList<>();
    ArrayList<Transacoes> transacoes = new ArrayList<>();

    String[] opcoes = {
            "Criar usuário",
            "Criar conta",
            "Depositar",
            "Sacar",
            "Transferir",
            "Relatório de Transferências",
            "Sair do programa"
    };

    public void criarUsuario(String nomeUsuario) {
        if (!nomeUsuario.matches("^[a-zA-ZÀ-ú\\s]+$")) {
            Usuario novoUsuario = new Usuario(nomeUsuario);
            usuarios.add(novoUsuario);
            System.out.println("Usuário criado com sucesso");
        } else {
            System.out.println("Nome inválido");
        }
    }

    public void criarConta(String nomeTitular) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nomeTitular)) {
                ContaBancaria conta = new ContaBancaria();
                titular = nomeTitular;
                numeroConta = contador;
                System.out.println("Conta criada com sucesso");
            } else {
                System.out.println("Usuário não cadastrado, cadastre-o antes");
            }
        }
        System.out.println("Algo deu errado.");
    }

    public void listarOpções() {
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(i + 1 + " - " + opcoes[i]);
        }
    }

    public int getConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public float getQtdConta() {
        return qtdConta;
    }

    public void depositar(String nomeTitular, float deposito) {
        for (ContaBancaria c : contas) {
            if (c.getTitular().equalsIgnoreCase(nomeTitular) && deposito > 0) {
                this.qtdConta += deposito;
                transacao = new Transacoes("Depósito");
                transacoes.add(transacao);
                System.out.println("Depósito adicionado com sucesso, quantia depositada: " + deposito);
            } else {
                System.out.println("Valor para depósito inválido");
            }
        }
    }

    public void sacar(String nomeTitular, float saque) {
        for (ContaBancaria c : contas) {
            if (c.getTitular().equalsIgnoreCase(nomeTitular) && c.getQtdConta() > saque) {
                this.qtdConta -= saque;
                transacao = new Transacoes("Saque");
                transacoes.add(transacao);
                System.out.println("Saque realizado com sucesso, quantia sacada: " + saque);
            } else {
                System.out.println("saldo insuficiente para saque.");
            }
        }
    }

    //recebe
    public void creditar(int numeroConta, float valor) {
        for (ContaBancaria c : contas) {
            if (c.getConta() == numeroConta && valor > 0) {
                c.qtdConta += valor;
                transacao = new Transacoes("Valor creditado: " + valor);
                transacoes.add(transacao);
                System.out.println("operação de crédito realizada com sucesso.");
            } else {
                System.out.println("Valor inválido");
            }
        }
    }

    //envia/paga
    public void debitar(int numeroConta, float valor) {
        for (ContaBancaria c : contas) {
            if (c.getConta() == numeroConta && getQtdConta() > valor) {
                c.qtdConta -= valor;
                transacao = new Transacoes("Valor debitado: " + valor);
                transacoes.add(transacao);
                System.out.println("Operação de débito realizada com sucesso");
            } else {
                System.out.println("Valor inválido ou saldo insuficiente");
            }
        }
    }

    public void transferir(int contaOrigem, int contaDestino, float valorTransferencia) {
        ContaBancaria origem = null;
        ContaBancaria destino = null;

        for (ContaBancaria c : contas) {
            if (c.getConta() == contaOrigem) {
                origem = c;
            }

            if (c.getConta() == contaDestino) {
                destino = c;
            }
        }

        if (origem == null || destino == null) {
            System.out.println("Conta de origem e/ou destino inválidas");
            return;
        }

        if (valorTransferencia > origem.getQtdConta()) {
            System.out.println("saldo insuficiente para transferência");
            return;
        }

        origem.debitar(contaOrigem, valorTransferencia);
        destino.creditar(contaDestino, valorTransferencia);
    }

    public void relatorioTransferencias() {
        StringBuilder lista = new StringBuilder();

        int i = 0;

        for (Transacoes t : transacoes) {
            lista.append(i).append(" - ").append(t.getNumeroTransacoes()).append(" - ").append(t.getMotivoTransacao());
            i++;
        }
        System.out.println("Transações realizadas até agora: ");
        System.out.println(lista.toString());
    }
}

