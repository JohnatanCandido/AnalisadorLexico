public class Simbolo {

    private String nome;
    private Categoria categoria;
    private Integer nivel;
    private Object geralA;
    private Object geralB;

    public Simbolo(String nome, Categoria categoria, Integer nivel) {
        this.nome = nome;
        this.categoria = categoria;
        this.nivel = nivel;
        pegaGeralA();
        pegaGeralB();
    }

    public void atualizar(Categoria categoria, Integer nivel) {
        this.categoria = categoria;
        this.nivel = nivel;
        pegaGeralA();
        pegaGeralB();
    }

    private void pegaGeralA() {
        switch (categoria) {
            case VARIAVEL:
                this.geralA = "GeralA Variável";
                break;
            case CONSTANTE:
                this.geralA = "Valor na base 10";
                break;
            case PROCEDURE:
                this.geralA = "Onde inicia no código gerado";
            case PARAMETRO:
                this.geralA = "GeralA Parametro";
            default:
                this.geralA = "-";
        }
    }

    private void pegaGeralB() {
        if (Categoria.PROCEDURE.equals(categoria))
            this.geralB = "Número parâmetros";
        else
            this.geralB = "-";
    }

    public Integer getNivel() {
        return nivel;
    }

    public enum Categoria {
        VARIAVEL("VARIAVEL"),
        CONSTANTE("CONSTANTE"),
        PROCEDURE("PROCEDURE"),
        PARAMETRO("PARAMETRO");

        private final String valor;
        Categoria(String valor) {
            this.valor = valor;
        }
    }

    @Override
    public String toString() {
        return nome + " - " + categoria.valor + " - " + nivel + " - " + geralA + " - " + geralB;
    }
}
