public class Simbolo {

    private String nome;
    private Categoria categoria;
    private Integer nivel;
    private Object geralA;
    private Object geralB;
    private Simbolo proximo;

    public Simbolo(String nome, Categoria categoria, Integer nivel, Object geralA, Object geralB) {
        this.nome = nome;
        this.categoria = categoria;
        this.nivel = nivel;
        this.geralA = geralA;
        this.geralB = geralB;
        this.proximo = null;
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
        PARAMETRO("PARAMETRO"),
        ROTULO("ROTULO");

        private final String valor;
        Categoria(String valor) {
            this.valor = valor;
        }
    }

    @Override
    public String toString() {
        return String.format("%2s, %10s, %2d, %20s, %20s", nome, categoria.valor, nivel, geralA, geralB);
    }

    public boolean isVariavel() {
        return categoria.equals(Categoria.VARIAVEL);
    }

//    GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    public Object getGeralA() {
        return geralA;
    }

    public void setGeralA(Object geralA) {
        this.geralA = geralA;
    }

    public Object getGeralB() {
        return geralB;
    }

    public void setGeralB(Object geralB) {
        this.geralB = geralB;
    }

    public Simbolo getProximo() {
        return proximo;
    }

    public void setProximo(Simbolo proximo) {
        this.proximo = proximo;
    }
}
