public class Gerente extends Funcionarios {
    public Gerente(String nome, float salarioBase) {
        super(nome, salarioBase);
    }

    @Override
    public void calcularSalario() {
        System.out.println("Salario base: " + salarioBase);
        float acrescimo = salarioBase * 20 / 100;
        System.out.println("Acréscimo de 20%: " + acrescimo);
        salarioBase += acrescimo;
        System.out.println("salário com acréscimo: " + salarioBase);
    }
}
