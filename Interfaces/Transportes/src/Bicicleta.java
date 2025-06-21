public class Bicicleta implements Transportavel {

    @Override
    public void iniciar() {
        System.out.println("Pedalando");
    }

    @Override
    public void parar() {
        System.out.println("Parando de pedalar");
    }
}
