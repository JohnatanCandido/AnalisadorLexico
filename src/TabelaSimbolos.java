import java.util.*;

public class TabelaSimbolos {

    private final int tableSize;
    private Simbolo[] simbolos;

    public TabelaSimbolos() {
        tableSize = 25147;
        simbolos = new Simbolo[tableSize];
    }

    public void insere(String nome, Simbolo.Categoria categoria, Integer nivel, Object geralA, Object geralB) throws ErroSemantico {
        Simbolo simbolo = new Simbolo(nome, categoria, nivel, geralA, geralB);
        int index = hash(nome);
        if (simbolos[index] != null) {
            Simbolo symbol = simbolos[index];
            while (symbol.getProximo() != null) {
                if (symbol.getNome().equals(nome) && symbol.getNivel().equals(nivel))
                    throw new ErroSemantico("Nome " + nome + " já declarado.");
                symbol = symbol.getProximo();
            }
            symbol.setProximo(simbolo);
            } else
            simbolos[index] = simbolo;
    }

    public Simbolo busca(String nome) throws ErroSemantico {
        Simbolo simbolo = simbolos[hash(nome)];
        List<Simbolo> simbolos = new ArrayList<>();
        simbolos.add(simbolo);
        while (simbolo.getProximo() != null) {
            simbolo = simbolo.getProximo();
            if (simbolo.getNome().equals(nome))
                simbolos.add(simbolo);
        }
        if (simbolos.get(0) != null) {
            simbolos.sort(Collections.reverseOrder(Comparator.comparing(Simbolo::getNivel)));
            return simbolos.get(0);
        }
        throw new ErroSemantico("Não foi possível encontrar o símbolo \"" + nome +"\"");
    }

    public Simbolo buscaParametro(String nome) throws ErroSemantico {
        Simbolo simbolo = busca(nome);
        while (!simbolo.getNome().equals(nome) && !simbolo.getCategoria().equals(Simbolo.Categoria.PARAMETRO)) {
            simbolo = simbolo.getProximo();
        }
        return simbolo;
    }

    public void remover(String nome) {
        simbolos[hash(nome)] = null;
    }

    public void atualizar(String nome, Simbolo.Categoria categoria, Integer nivel) {
        Simbolo simbolo = simbolos[hash(nome)];
        if (simbolo != null)
            simbolo.atualizar(categoria, nivel);
        else
            System.out.println("O simbolo " + nome + " não existe!");
    }

    public void removerNivel(Integer nivel) {
        for (int i = 0; i < simbolos.length; i++) {
            if (simbolos[i] != null && simbolos[i].getNivel().equals(nivel)) {
                simbolos[i] = simbolos[i].getProximo();
                i--;
            }
            Simbolo simbolo = simbolos[i];
            while (simbolo != null) {
                if (simbolo.getProximo() != null && simbolo.getProximo().getNivel().equals(nivel))
                    simbolo.setProximo(simbolo.getProximo().getProximo());
                simbolo = simbolo.getProximo();
            }
        }
    }

    private int hash(String key){
        int hashVal = 0; //uses Horner’s method to evaluate a polynomial
        for( int i = 0; i < key.length( ); i++ )
            hashVal = 37 * hashVal + key.charAt( i );
        hashVal %= tableSize;
        if( hashVal < 0 )
            hashVal += tableSize; //needed if hashVal is negative
        return hashVal;
    }

}
