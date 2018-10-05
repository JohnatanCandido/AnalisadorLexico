public class TabelaSimbolos {

    private final int tableSize = 25147;
    private Simbolo[] simbolos = new Simbolo[tableSize];

    public TabelaSimbolos() {}

    public void adicionar(String nome, Simbolo.Categoria categoria, Integer nivel) {
        Simbolo simbolo = new Simbolo(nome, categoria, nivel);
        int index = hash(nome);
        if (simbolos[index] != null)
            throw new IllegalArgumentException("Colisão");
        simbolos[index] = simbolo;
    }

    public String busca(String nome) {
        Simbolo simbolo = simbolos[hash(nome)];
        return simbolo != null ? simbolo.toString() : "Não foi possível encontrar o símbolo \"" + nome +"\"";
    }

//    public void remover(String nome) {
////        simbolos[hash(nome)] = null;
////    }

    public void atualizar(String nome, Simbolo.Categoria categoria, Integer nivel) {
        Simbolo simbolo = simbolos[hash(nome)];
        if (simbolo != null)
            simbolo.atualizar(categoria, nivel);
        else
            System.out.println("O simbolo " + nome + " não existe!");
    }

    public void printaSimbolos() {
        for (Simbolo simbolo: simbolos) {
            if (simbolo != null)
                System.out.println(simbolo.toString());
        }
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
    }

    public void removerNivel(Integer nivel) {
        for (int i = 0; i < simbolos.length; i++) {
            if (simbolos[i] != null && simbolos[i].getNivel().equals(nivel))
                simbolos[i] = null;
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
