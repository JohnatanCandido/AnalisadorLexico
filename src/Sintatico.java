import java.io.File;
import java.util.Stack;


public class Sintatico {

    public static void main(String[] args) {
        try {
            fazAnaliseSintatica(null, 2);
        } catch (ErroLexico | ErroSintatico | ErroSemantico e) {
            e.printStackTrace();
        }
    }

    public static void fazAnaliseSintatica(String[] texto, int cod) throws ErroLexico, ErroSintatico, ErroSemantico {
        Stack<Integer> pilha = new Stack<>();
        String ultimaPalavra = "$";

        // Pega lista de símbolos do analisador sintático
        Stack<Object[]> palavras = texto == null ? fazAnaliseLexica() : fazAnaliseLexica(texto);

        // Pega o próximo símbolo da entrada
        Object[] simboloLinha = palavras.pop();

        pilha.push(ParserConstants.START_SYMBOL); // Coloca o símbolo inicial na pilha
        while(!pilha.isEmpty()) { // Enquanto a pilha não estiver vazia
            Integer topo = pilha.pop(); // Pega o símbolo no topo da pilha

            if (topo < ParserConstants.FIRST_NON_TERMINAL) { // Se for terminal
                if (topo.equals(simboloLinha[0])) { // Verifica se é igual ao simbolo de entrada atual
//                    System.out.println(ParserConstants.PARSER_ERROR[(int) simboloLinha[0]]);
                    ultimaPalavra = simboloLinha[2].toString();

                    if (!palavras.isEmpty()) // Se ainda tiver mais simbolos a serem verificados
                        simboloLinha = palavras.pop(); // Pega o próximo símbolo de entrada

                } else { // Se não for lança um erro de que não era o símbolo esperado
                    throw new ErroSintatico(simboloLinha[1].toString(), ParserConstants.PARSER_ERROR[topo]);
                }
            } else { // Se não for terminal

                if (topo < ParserConstants.FIRST_SEMANTIC_ACTION) {
                    // Busca na tabela de parsing
                    int idProducao = ParserConstants.PARSER_TABLE[topo-ParserConstants.FIRST_NON_TERMINAL][(int) simboloLinha[0] - 1];

                    if (idProducao != -1) { // Se encontrar
                        int[] retorno = ParserConstants.PRODUCTIONS[idProducao]; // Pega os símbolos da expansão
                        empilha(pilha, retorno); // Empilha de trás para frente
                    } else { // Se não encontrar lança um erro dizendo quais símbolos deveriam ter sido encontrados
                        throw new ErroSintatico(simboloLinha[1].toString(), Util.getMensagemTokensEsperados(topo, pilha));
                    }
                } else if (cod > 0){
                    Semantico.trataAcaoSemantica(topo, ultimaPalavra, simboloLinha[1].toString(), cod == 2);
                }
            }
        }
        TelaController.saida.append("\nExecução completa.");
    }

    private static void empilha(Stack<Integer> pilha, int[] lista) {
        for (int i = lista.length - 1; i >= 0; i--) {
            if (lista[i] > 0)
                pilha.add(lista[i]);
        }
    }

    private static Stack<Object[]> fazAnaliseLexica() {
        return Lexico.getListaPalavrasReconhecidas(new File("exemplo2.txt"));
    }

    private static Stack<Object[]> fazAnaliseLexica(String[] texto) throws ErroLexico{
        return (Stack<Object[]>) Lexico.getListaPalavrasReconhecidas(texto, false);
    }
}
