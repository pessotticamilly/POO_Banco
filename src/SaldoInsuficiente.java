public class SaldoInsuficiente extends RuntimeException {
    public SaldoInsuficiente(){
        super("Querido, seu saldo é insuficiente para realizar esta ação.");
    }
}