public class LimiteInsuficiente extends RuntimeException {
    public LimiteInsuficiente(){
        super("O valor tá grande hein. Nem seu limite consegue cobri-lo");
    }
}