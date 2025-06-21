public abstract class Funcionarios {
    String nome;
    float salarioBase;

    public Funcionarios(String nome, float salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public abstract void calcularSalario();
}
