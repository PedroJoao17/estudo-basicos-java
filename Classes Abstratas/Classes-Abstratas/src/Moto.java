public class Moto extends Veiculo {

    public Moto(String modelo, String placa, int ano) {
        super(modelo, placa, ano);
    }

    @Override
    public void acelerar() {
        System.out.println("A moto está acelerando");
    }

    @Override
    public void frear() {
        System.out.println("A moto freiou");
    }

    @Override
    public void informacoes() {
        super.informacoes();
    }
}
