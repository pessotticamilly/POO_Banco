public abstract class ContaBancaria {
    private int numeroConta;
    private double saldo, taxaOperacao;

    public ContaBancaria(int numeroConta, double saldo, double taxaOperacao) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.taxaOperacao = taxaOperacao;
    }

    public abstract void depositar(double valor);

    public abstract void sacar(double valor);

    public abstract void transferir(double valor, int numeroConta);

    public abstract String mostrarDados();

    @Override
    public String toString() {
        return "\nNúmero da conta: " + numeroConta +
                "\nSaldo: " + saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}