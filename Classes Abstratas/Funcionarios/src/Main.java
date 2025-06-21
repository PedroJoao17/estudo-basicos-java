//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vendedor vendedor = new Vendedor("Carlos", 1400);
        Gerente gerente = new Gerente("Joao", 2100);

        vendedor.calcularSalario();
        System.out.println("\n");
        gerente.calcularSalario();
    }
}