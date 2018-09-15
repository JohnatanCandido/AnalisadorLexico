public class ErroSintatico extends Exception {
    public ErroSintatico(Integer linha, String esperado) {
        super(String.format("Erro na linha %d. Era esperado %s", linha, esperado));
    }
}
