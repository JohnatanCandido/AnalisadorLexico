public class ErroSemantico extends Exception {
    public ErroSemantico(String linha, String msg) {
        super(String.format("Erro na linha %s. %s.", linha, msg));
    }
}
