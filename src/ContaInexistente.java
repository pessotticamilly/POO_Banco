public class ContaInexistente extends RuntimeException {
    public ContaInexistente() {
        super("Esta conta não foi encontrada no nosso sistema :(");
    }
}