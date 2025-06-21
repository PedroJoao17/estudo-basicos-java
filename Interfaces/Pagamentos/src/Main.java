//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Boleto boleto = new Boleto();
        Cartao cartao = new Cartao();

        boleto.processarPagamento(100);
        cartao.processarPagamento(100);
    }
}