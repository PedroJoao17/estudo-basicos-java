public abstract class Veiculo {
    String modelo;
    String placa;
    int ano;

    public Veiculo(String modelo, String placa, int ano) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    public abstract void acelerar();

    public abstract void frear();

    public void informacoes() {
        System.out.println("Modelo do veículo: " + modelo);
        System.out.println("Número da placa: " + placa);
        System.out.println("Ano do veículo: " + ano);
    }
}
