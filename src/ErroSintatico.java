public class ErroSintatico extends Exception {
    public ErroSintatico(String linha, String esperado) {
        super(String.format("Erro na linha %s. Era esperado %s", linha, esperado));
    }
}
