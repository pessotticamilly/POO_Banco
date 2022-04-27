public abstract class ContaBancaria {
    private int numeroConta;
    private double saldo, taxaOperacao;

    public ContaBancaria(int numeroConta, double saldo, double taxaOperacao) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.taxaOperacao = taxaOperacao;
    }

    public abstract void depositar();

    public abstract void sacar();

    public abstract void transferir();

    public abstract void mostrarDados();

    @Override
    public String toString() {
        return "\nNúmero da conta: " + numeroConta +
                "\nSaldo: " + saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTaxaOperacao() {
        return taxaOperacao;
    }

    public void setTaxaOperacao(double taxaOperacao) {
        this.taxaOperacao = taxaOperacao;
    }
}
