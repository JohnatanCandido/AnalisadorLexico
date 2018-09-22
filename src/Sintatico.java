import java.io.File;
import java.util.*;

public class Sintatico {

    private static Stack<Integer> pilha = new Stack<>();
    private static Stack<Integer[]> palavras;

    public static void main(String[] args) {
        try {
            fazAnaliseLexica(); // Pega lista de símbolos do analisador sintático
            Integer[] simboloLinha = palavras.pop(); // Pega o próximo símbolo da entrada

            pilha.push(ParserConstants.START_SYMBOL); // Coloca o símbolo inicial na pilha
            while(!pilha.isEmpty()) { // Enquanto a pilha não estiver vazia
                Integer topo = pilha.pop(); // Pega o símbolo no topo da pilha

                if (topo < ParserConstants.FIRST_NON_TERMINAL) { // Se for terminal
                    if (topo.equals(simboloLinha[0])) { // Verifica se é igual ao simbolo de entrada atual
                        System.out.println(ParserConstants.PARSER_ERROR[simboloLinha[0]]);

                        if (!palavras.isEmpty()) // Se ainda tiver mais simbolos a serem verificados
                            simboloLinha = palavras.pop(); // Pega o próximo símbolo de entrada

                    } else { // Se não for lança um erro de que não era o símbolo esperado
                        throw new ErroSintatico(simboloLinha[1], ParserConstants.PARSER_ERROR[topo]);
                    }
                } else { // Se não for terminal

                    // Busca na tabela de parsing
                    int idProducao = ParserConstants.PARSER_TABLE[topo-ParserConstants.FIRST_NON_TERMINAL][simboloLinha[0] - 1];

                    if (idProducao != -1) { // Se encontrar
                        int[] retorno = ParserConstants.PRODUCTIONS[idProducao]; // Pega os símbolos da expansão
                        empilha(retorno); // Empilha de trás para frente
                    } else { // Se não encontrar

                        // Lança um erro dizendo quais símbolos deveriam ter sido encontrados
                        throw new ErroSintatico(simboloLinha[1], Util.getMensagemTokensEsperados(topo, pilha));
                    }
                }
            }
            System.out.println("Término da execução");
        } catch (ErroSintatico e) {
            e.printStackTrace();
        }
    }

    private static void empilha(int[] lista) {
        for (int i = lista.length - 1; i >= 0; i--) {
            if (lista[i] > 0)
                pilha.add(lista[i]);
        }
    }

    private static void fazAnaliseLexica() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Digite o número do exemplo: ");
//        String n = scanner.nextLine().toLowerCase();
//        scanner.close();
        palavras = Lexico.getListaPalavrasReconhecidas(new File("exemplo" + 1 +".txt"));
    }
}
