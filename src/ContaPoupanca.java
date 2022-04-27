public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(int numeroConta, double saldo, double taxaOperacao) {
        super(numeroConta, saldo, taxaOperacao);
    }

    @Override
    public void depositar() {
    }

    @Override
    public void sacar() {
    }

    @Override
    public void transferir() {

    }

    @Override
    public void mostrarDados() {
        toString();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n- - - - - - - - - - - - - - - - - - - -";
    }
}
