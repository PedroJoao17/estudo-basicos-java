public class Carro extends Veiculo {

    public Carro(String modelo, String placa, int ano) {
        super(modelo, placa, ano);
    }

    @Override
    public void acelerar() {
        System.out.println("O carro está acelerando");
    }

    @Override
    public void frear() {
        System.out.println("O carro freiou");
    }

    @Override
    public void informacoes() {
        super.informacoes();
    }
}
