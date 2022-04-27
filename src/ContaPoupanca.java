public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(int numeroConta, double saldo, double taxaOperacao) {
        super(numeroConta, saldo, taxaOperacao);
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
                "\n- - - - - - - - - - - - - - - - - - - -";
    }
}
