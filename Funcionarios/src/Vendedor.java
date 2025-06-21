public class Vendedor extends Funcionarios {

    public Vendedor(String nome, float salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public void calcularSalario() {
        System.out.println("Salario base: " + salarioBase);
        float acrescimo = salarioBase * 10 / 100;
        System.out.println("Acréscimo de 10%: " + acrescimo);
        salarioBase += acrescimo;
        System.out.println("salário com acréscimo: " + salarioBase);
    }
}
