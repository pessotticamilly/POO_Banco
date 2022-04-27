import java.util.ArrayList;

public class Banco {
    private int codigo;
    static ArrayList<ContaBancaria> listaContasBancarias = new ArrayList<>();

    public Banco(int codigo) {
        this.codigo = codigo;
    }

    public static String inserirConta() {
        int tipoConta = Main.tipoConta();

        ContaBancaria conta = Main.coletaDadosConta(tipoConta);
        listaContasBancarias.add(conta);

        return "\nConta cadastrada com sucesso!";
    }

    public static void procurarConta(int numeroConta) {
        for(int i = 0; i < listaContasBancarias.size(); i++){
            if(numeroConta == listaContasBancarias.get(i).getNumeroConta()){
            }
        }
    }

    public static String removerConta(int numeroConta) {
        for(int i = 0; i < listaContasBancarias.size(); i++){
            if(numeroConta == listaContasBancarias.get(i).getNumeroConta()){
                listaContasBancarias.remove(i);

                return "\nConta excluída com sucesso!";
            }
        }

        return "\nConta inexistente!";
    }

    public static void mostrarDados() {
        for(int i = 0; i < listaContasBancarias.size(); i++){
                listaContasBancarias.get(i).toString();
        }
    }
    }
