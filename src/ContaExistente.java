public class ContaExistente extends RuntimeException {
    public ContaExistente(){
        super("Ei! Este código já existe! Você não pode criar uma conta com o mesmo.");
    }
}