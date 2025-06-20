import java.util.ArrayList;

public class ContaBancaria {
    private float qtdConta = 0;
    Transacoes transacao;
    String titular;

    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<ContaBancaria> contas = new ArrayList<>();
    ArrayList<Transacoes> transacoes = new ArrayList<>();

    String[] opcoes = {"Criar usuário", "Criar conta", "Depositar", "Sacar", "Transferir", "Relatório de Transferências", "Sair do programa"};

    public ContaBancaria(String titular) {
        this.titular = titular;
    }

    public void criarUsuario(String nomeUsuario) {
        Usuario novoUsuario = new Usuario(nomeUsuario);
        usuarios.add(novoUsuario);
        System.out.println("Usuário criado com sucesso");
    }

    public void criarConta(String nomeTitular) {
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nomeTitular)) {
                ContaBancaria conta = new ContaBancaria(nomeTitular);
                contas.add(conta);
                System.out.println("Conta criada com sucesso");
            } else {
                System.out.println("Usuário não cadastrado, cadastre-o antes");
            }
        }
    }

    public void listarOpcoes() {
        for (int i = 0; i < opcoes.length; i++) {
            System.out.println(i + 1 + " - " + opcoes[i]);
        }
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
                c.qtdConta += deposito;
                transacao = new Transacoes("Depósito adicionado com sucesso, quantia depositada: " + deposito + " na conta do usuário " + c.getTitular());
                transacoes.add(transacao);
                System.out.println(transacao.getDescricaoTransacao());
            } else {
                System.out.println("Valor para depósito inválido");
            }
        }
    }

    public void sacar(String nomeTitular, float saque) {
        for (ContaBancaria c : contas) {
            if (c.getTitular().equalsIgnoreCase(nomeTitular) && c.getQtdConta() > saque) {
                this.qtdConta -= saque;
                transacao = new Transacoes("Saque realizado com sucesso, quantia sacada: " + saque + " da conta do usuário " + c.getTitular());
                transacoes.add(transacao);
                System.out.println(transacao.getDescricaoTransacao());
            } else {
                System.out.println("saldo insuficiente para saque.");
            }
        }
    }

    public void transferir(String usuarioOrigem, String usuarioDestino, float valorTransferencia) {
        String origem = "";
        String destino = "";
        ContaBancaria contaOrigem = null;
        ContaBancaria contaDestino = null;

        for (ContaBancaria c : contas) {
            if (c.getTitular().equalsIgnoreCase(usuarioOrigem)) {
                origem = c.getTitular();
                contaOrigem = c;
            }

            if (c.getTitular().equalsIgnoreCase(usuarioDestino)) {
                destino = c.getTitular();
                contaDestino = c;
            }
        }

        if (contaOrigem == null || contaDestino == null) {
            System.out.println("Conta de origem e/ou destino inexistente.");
            return;
        }

        System.out.println("Transferência realizada do usuário " + contaOrigem.getTitular() + "para o usuário " + contaDestino.getTitular());
        contaOrigem.debitar(origem, valorTransferencia);
        contaDestino.creditar(destino, valorTransferencia);
    }

    public void relatorioTransferencias() {
        StringBuilder lista = new StringBuilder();

        int i = 0;

        for (Transacoes t : transacoes) {
            lista.append(i).append(" - ").append(t.getNumeroTransacoes()).append(" - ").append(t.getDescricaoTransacao()).append("\n");
            i++;
        }
        System.out.println("Transações realizadas até agora: ");
        System.out.println(lista);
    }

    //recebe
    public void creditar(String usuario, float valor) {
        for (ContaBancaria c : contas) {
            if (c.getTitular().equalsIgnoreCase(usuario) && valor > 0) {
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
    public void debitar(String usuario, float valor) {
        for (ContaBancaria c : contas) {
            if (c.getTitular().equalsIgnoreCase(usuario) && c.getQtdConta() > valor) {
                c.qtdConta -= valor;
                transacao = new Transacoes("Valor debitado: " + valor);
                transacoes.add(transacao);
                System.out.println("Operação de débito realizada com sucesso");
            } else {
                System.out.println("Valor inválido ou saldo insuficiente");
            }
        }
    }

}

