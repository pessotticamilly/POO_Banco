import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Banco banco = new Banco(1);

        menuInicial();
    }

    static void menuInicial() {
        System.out.print("\n---- MENU ----" +
                "\n1 - Criar conta" +
                "\n2 - Selecionar conta" +
                "\n3 - Excluir conta" +
                "\n4 - Gerar relatório" +
                "\n5 - Encerrar" +
                "\nR: ");
        int opcaoMenu = sc.nextInt();

        int numeroConta;

        switch(opcaoMenu) {
            case 1:
                System.out.print(Banco.inserirConta());
                menuInicial();
                break;

            case 2:
                System.out.print("\nQual o número da conta desejas acessar?" +
                                 "\nR: ");
                numeroConta = sc.nextInt();

                Banco.procurarConta(numeroConta);
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
                Banco.mostrarDados();
                menuInicial();
                break;

            case 5:
                System.out.print("\nEncerrando...");
                System.exit(0);
                break;
        }
    }

    static void menuConta(int numeroConta) {

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

        if(tipoConta == 1){
            System.out.print("\nQual é o limite de crédito para saque?" +
                             "\nR: ");
            double limiteCreditoSaque = sc.nextDouble();

            return new ContaCorrente(numeroConta, saldo, taxaOperacao, limiteCreditoSaque);

        } else if(tipoConta == 2){
            return new ContaPoupanca(numeroConta, saldo, taxaOperacao);
        }

        return null;
    }
}
