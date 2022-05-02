import java.util.ArrayList;

public class Banco {
    static ArrayList<ContaBancaria> listaContasBancarias = new ArrayList<>();

    public Banco() {}

    public static String inserirConta() {
        int tipoConta = Main.tipoConta();

        ContaBancaria conta = Main.coletaDadosConta(tipoConta);
        listaContasBancarias.add(conta);

        return "\nConta cadastrada com sucesso!";
    }

    public static ContaBancaria procurarConta(int numeroConta) {
        for (ContaBancaria listaContasBancaria : listaContasBancarias) {
            if (numeroConta == listaContasBancaria.getNumeroConta()) {
                return listaContasBancaria;
            }
        }

        return null;
    }

    public static String removerConta(int numeroConta) {
        for (int i = 0; i < listaContasBancarias.size(); i++) {
            if (numeroConta == listaContasBancarias.get(i).getNumeroConta()) {
                listaContasBancarias.remove(i);

                return "\nConta excluída com sucesso!";
            }
        }

        return "\nConta inexistente!";
    }

    public static String mostrarDados(int i) {
        return listaContasBancarias.get(i).toString() + "\n- - - - - - - - - - - - - - - -\n";
    }
}