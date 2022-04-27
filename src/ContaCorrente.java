public class ContaCorrente extends ContaBancaria {
    private double limiteCreditoSaque;

    public ContaCorrente(int numeroConta, double saldo, double taxaOperacao, double creditoSaldo) {
        super(numeroConta, saldo, taxaOperacao);
        this.limiteCreditoSaque = limiteCreditoSaque;
    }

    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    public void sacar() {
    }

    @Override
    public void transferir() {

    }

    @Override
    public String mostrarDados() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nLimite de crédito para saque: " + limiteCreditoSaque +
                "\n- - - - - - - - - - - - - - - - - - - -";
    }

    public double getLimiteCreditoSaque() {
        return limiteCreditoSaque;
    }

    public void setLimiteCreditoSaque(double limiteCreditoSaldo) {
        this.limiteCreditoSaque = limiteCreditoSaldo;
    }
}
