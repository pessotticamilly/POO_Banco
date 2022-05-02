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
    public void sacar(double valor) {
        if (valor <= this.getSaldo() && valor >= 1) {
            this.setSaldo(this.getSaldo() - valor);
        } else if (valor <= (this.getSaldo() + this.limiteCreditoSaque) && valor >= 1) {
            valor = valor - this.getSaldo();
            this.setSaldo(0);
            this.limiteCreditoSaque = this.limiteCreditoSaque - valor;
        } else {
            Main.semSaldo();
        }
    }

    @Override
    public void transferir(double valor, int numeroConta) {
        sacar(valor);

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
        return super.toString() +
                "\nLimite de crédito para saque: " + limiteCreditoSaque;
    }
}