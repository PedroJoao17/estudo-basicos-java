//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Ferrari", "asd123", 2001);
        Moto moto = new Moto("Kawasaki", "zxc456", 2005);

        carro.acelerar();
        carro.frear();
        carro.informacoes();
        System.out.println("\n");
        moto.acelerar();
        moto.frear();
        moto.informacoes();
    }
}