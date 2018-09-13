import java.io.File;
import java.util.*;

public class Sintatico {

    private static Stack<Integer> pilha = new Stack<>();
    private static Stack<Integer[]> palavras;

    public static void main(String[] args) throws ErroSintatico{
        fazAnaliseLexica();
        Integer[] simboloLinha = palavras.pop();

        pilha.push(ParserConstants.START_SYMBOL);
        while(!pilha.isEmpty()) {
            Integer topo = pilha.pop();
            if (topo < ParserConstants.FIRST_NON_TERMINAL) {
                if (topo.equals(simboloLinha[0])) {
                    System.out.println(teste[simboloLinha[0] - 2]);
                    if (!palavras.isEmpty())
                        simboloLinha = palavras.pop();
                } else {
                    throw new ErroSintatico(simboloLinha[1], ParserConstants.PARSER_ERROR[topo]);
                }
            } else {
                int idProducao = ParserConstants.PARSER_TABLE[topo-46][simboloLinha[0] - 1];
                if (idProducao != -1) {
                    int[] retorno = ParserConstants.PRODUCTIONS[idProducao];
                    empilha(retorno);
                } else {
                    throw new ErroSintatico(simboloLinha[1], ParserConstants.PARSER_ERROR[topo]);
                }
            }
        }
        System.out.println("Término da execução");
    }

    private static void empilha(int[] lista) {
        for (int i = lista.length - 1; i >= 0; i--) {
            if (lista[i] > 0)
                pilha.add(lista[i]);
        }
    }

    private static void fazAnaliseLexica() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do exemplo: ");
        //String n = scanner.nextLine().toLowerCase();
        scanner.close();
        palavras = Lexico.getListaPalavrasReconhecidas(new File("exemplo" + "3" +".txt"));
    }

    private static String[] teste = {
            "program",
            "identificador",
            ";",
            ".",
            ",",
            "const",
            "=",
            "inteiro",
            "var",
            ":",
            "integer",
            "procedure",
            "(",
            ")",
            "begin",
            "end",
            ":=",
            "call",
            "if",
            "then",
            "else",
            "while",
            "do",
            "repeat",
            "until",
            "readln",
            "writeln",
            "literal",
            "case",
            "of",
            "for",
            "to",
            "<",
            ">",
            ">=",
            "<=",
            "<>",
            "+",
            "-",
            "or",
            "*",
            "/",
            "and",
            "not"
    };
}
