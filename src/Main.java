import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Banco banco = new Banco(1);
        ContaBancaria conta1 = new ContaCorrente(1, 100, 0.2, 1000);
        Banco.listaContasBancarias.add(conta1);

        ContaBancaria conta2 = new ContaCorrente(2, 100, 0.2, 1000);
        Banco.listaContasBancarias.add(conta2);

        menuInicial();
    }

    static void menuInicial() {
        System.out.print("\n---- MENU INICIAL ----" +
                "\n1 - Criar conta" +
                "\n2 - Selecionar conta" +
                "\n3 - Excluir conta" +
                "\n4 - Gerar relatório" +
                "\n5 - Encerrar" +
                "\nR: ");
        int opcaoMenu = sc.nextInt();

        int numeroConta;

        switch (opcaoMenu) {
            case 1:
                System.out.print(Banco.inserirConta());
                menuInicial();
                break;

            case 2:
                System.out.print("\nQual o número da conta desejas acessar?" +
                        "\nR: ");
                numeroConta = sc.nextInt();

                ContaBancaria conta = Banco.procurarConta(numeroConta);

                if (conta == null) {
                    System.out.print("\nConta inexistente!");
                } else {
                    menuConta(conta);
                }

                menuInicial();
                break;

            case 3:
                System.out.print("\nQual o número da conta que desejas excluir?" +
                        "\nR: ");
                numeroConta = sc.nextInt();

                System.out.print(Banco.removerConta(numeroConta));
                menuInicial();
                break;

            case 4:
                for (int i = 0; i < Banco.listaContasBancarias.size(); i++) {
                    System.out.print(Banco.mostrarDados(i));

                }
                menuInicial();
                break;

            case 5:
                System.out.print("\nEncerrando...");
                System.exit(0);
                break;
        }
    }

    static void menuConta(ContaBancaria conta) {
        System.out.print("\n---- MENU DA CONTA ----" +
                "\n1 - Depositar" +
                "\n2 - Sacar" +
                "\n3 - Transferir" +
                "\n4 - Gerar relatório" +
                "\n5 - Voltar" +
                "\nR: ");
        int opcaoMenu = sc.nextInt();

        double valor = 0;

        switch (opcaoMenu) {
            case 1:
                System.out.print("\nQual o valor que você desejas depositar?" +
                        "\nR: ");
                valor = sc.nextDouble();

                conta.depositar(valor);

                menuConta(conta);
                break;

            case 2:
                System.out.print("\nQual o valor que você desejas sacar?" +
                        "\nR: ");
                valor = sc.nextDouble();

                conta.sacar(valor);

                menuConta(conta);
                break;

            case 3:
                System.out.print("\nQual o valor que você desejas sacar?" +
                        "\nR: ");
                valor = sc.nextDouble();

                System.out.print("\nPara qual conta desejas transferir?" +
                        "\nR: ");
                int numeroConta = sc.nextInt();

                conta.transferir(valor, numeroConta);

                menuConta(conta);
                break;

            case 4:
                System.out.print(conta.mostrarDados());

                menuConta(conta);
                break;

            case 5:
                menuInicial();
                break;
        }
    }

    static int tipoConta() {
        System.out.print("\nQual o tipo da conta?" +
                "\n1 - Conta corrente" +
                "\n2 - Conta poupança" +
                "\nR: ");
        int tipoConta = sc.nextInt();

        return tipoConta;
    }

    static ContaBancaria coletaDadosConta(int tipoConta) {
        System.out.print("\nQual é o número da conta?" +
                "\nR: ");
        int numeroConta = sc.nextInt();

        System.out.print("\nQual é o saldo?" +
                "\nR: ");
        double saldo = sc.nextDouble();

        System.out.print("\nQual é a taxa de operação?" +
                "\nR: ");
        double taxaOperacao = sc.nextDouble();

        if (tipoConta == 1) {
            System.out.print("\nQual é o limite de crédito para saque?" +
                    "\nR: ");
            double limiteCreditoSaque = sc.nextDouble();

            return new ContaCorrente(numeroConta, saldo, taxaOperacao, limiteCreditoSaque);

        } else if (tipoConta == 2) {
            return new ContaPoupanca(numeroConta, saldo, taxaOperacao);
        }

        return null;
    }

    static void semSaldo() {
        System.out.print("\nSaldo insuficiente!");
    }
}