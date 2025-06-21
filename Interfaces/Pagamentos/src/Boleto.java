public class Boleto implements Pagamentos{

    @Override
    public void processarPagamento(double valor) {
        System.out.println("pagamento será compensado em até três dias");
    }
}
