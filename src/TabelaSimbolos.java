import java.util.HashMap;
import java.util.Map;

public class TabelaSimbolos {

    private Map<String, Simbolo> simbolos = new HashMap<>();

    public TabelaSimbolos() {}

    public void adicionar(String nome, Simbolo.Categoria categoria, Integer nivel) {
        Simbolo simbolo = new Simbolo(nome, categoria, nivel);
        simbolos.put(nome, simbolo);
    }

    public String busca(String nome) {
        return simbolos.keySet().contains(nome) ? simbolos.get(nome).toString() : "Simbolo não encontrado!";
    }

    public void remover(String nome) {
        simbolos.remove(nome);
    }

    public void atualizar(String nome, Simbolo.Categoria categoria, Integer nivel) {
        Simbolo simbolo = simbolos.get(nome);
        simbolo.atualizar(categoria, nivel);
    }

    public void printaSimbolos() {
        for (Simbolo simbolo: simbolos.values()) {
            System.out.println(simbolo.toString());
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
    }

    public void removerNivel(Integer nivel) {
        simbolos.entrySet().removeIf(s -> s.getValue().getNivel().equals(nivel));
    }

}
