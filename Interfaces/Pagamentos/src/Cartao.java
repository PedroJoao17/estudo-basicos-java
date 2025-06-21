public class Cartao implements Pagamentos{

    @Override
    public void processarPagamento(double valor) {
        System.out.println("Cobrança virá na próxima fatura");
    }
}
