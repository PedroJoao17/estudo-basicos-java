public class Validador {
    public static void validarCpf(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new CpfInvalidoException("CPF inválido. Deve conter 11 dígitos.");
        }
        System.out.println("CPF válido: " + cpf);
    }
}
