public class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(int numeroConta, double saldo, double taxaOperacao) {
        super(numeroConta, saldo, taxaOperacao);
    }

    @Override
    public void depositar(double valor) {
        this.setSaldo(this.getSaldo() + valor);
    }

    @Override
    public String sacar(double valor) {
        if (valor <= this.getSaldo() && valor >= 1) {
            this.setSaldo(this.getSaldo() - valor);
        } else {
            return "\nSaldo insuficiente!\n";
        }

        return null;
    }

    @Override
    public void transferir(double valor, int numeroConta) {
        this.sacar(valor);

        for (int i = 0; i < Banco.listaContasBancarias.size(); i++) {
            if (numeroConta == Banco.listaContasBancarias.get(i).getNumeroConta()) {
                Banco.listaContasBancarias.get(i).depositar(valor);
            }
        }
    }

    @Override
    public String mostrarDados() {
        return toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}