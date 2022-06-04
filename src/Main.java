import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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

        try {
            switch (opcaoMenu) {
                case 1:
                    try {
                        System.out.print(Banco.inserirConta());
                        menuInicial();
                    } catch (ContaExistente exception) {
                        System.out.print("\n" + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
                        menuInicial();
                    }
                    break;

                case 2:
                    System.out.print("\nQual o número da conta desejas acessar?" +
                            "\nR: ");
                    numeroConta = sc.nextInt();

                    try {
                        ContaBancaria conta = Banco.procurarConta(numeroConta);
                        menuConta(conta);
                    } catch (ContaInexistente exception) {
                        System.out.print("\n" + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
                        menuInicial();
                    }
                    break;

                case 3:
                    System.out.print("\nQual o número da conta que desejas excluir?" +
                            "\nR: ");
                    numeroConta = sc.nextInt();

                    try {
                        System.out.print(Banco.removerConta(numeroConta));
                    } catch (ContaInexistente exception) {
                        System.out.print("\n" + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
                        menuInicial();
                    }
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

                default:
                    throw new OpcaoInvalida();
            }
        } catch (OpcaoInvalida exception) {
            System.out.print("\n" + exception.getClass().getSimpleName() + ": " + exception.getMessage());
            menuInicial();
        }
    }

    static void menuConta(ContaBancaria conta) throws OpcaoInvalida {
        System.out.print("\n---- MENU DA CONTA ----" +
                "\n1 - Depositar" +
                "\n2 - Sacar" +
                "\n3 - Transferir" +
                "\n4 - Gerar relatório" +
                "\n5 - Voltar" +
                "\nR: ");
        int opcaoMenu = sc.nextInt();

        double valor;

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

                try{
                    System.out.print(conta.sacar(valor));
                    menuConta(conta);
                } catch (SaldoInsuficiente | LimiteInsuficiente exception){
                    System.out.print("\n" + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
                }
                break;

            case 3:
                System.out.print("\nQual o valor que você desejas transferir?" +
                        "\nR: ");
                valor = sc.nextDouble();

                System.out.print("\nPara qual conta desejas transferir?" +
                        "\nR: ");
                int numeroConta = sc.nextInt();

                try {
                    conta.transferir(valor, numeroConta);
                } catch(ContaInexistente exception){
                    System.out.print("\n" + exception.getClass().getSimpleName() + ": " + exception.getMessage() + "\n");
                }

                menuConta(conta);
                break;

            case 4:
                System.out.print(conta.mostrarDados());

                menuConta(conta);
                break;

            case 5:
                menuInicial();
                break;

            default:
                throw new OpcaoInvalida();
        }
    }

    static int tipoConta() {
        System.out.print("\nQual o tipo da conta?" +
                "\n1 - Conta corrente" +
                "\n2 - Conta poupança" +
                "\nR: ");

        return sc.nextInt();
    }

    static ContaBancaria coletaDadosConta(int tipoConta) throws ContaExistente {
        System.out.print("\nQual é o número da conta?" +
                "\nR: ");
        int numeroConta = sc.nextInt();

        boolean condicao = false;

        for(int i = 0; i < Banco.listaContasBancarias.size(); i++){
            if(numeroConta == Banco.listaContasBancarias.get(i).getNumeroConta()){
                System.out.print("\nEntrou");
                condicao = false;
                break;
            } else{
                condicao = true;
            }
        }

        if(condicao == true) {
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
        } else{
            throw new ContaExistente();
        }
        
        return null;
    }
}