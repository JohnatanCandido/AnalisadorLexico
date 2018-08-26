import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sintatico {

    private static List<Integer> pilha = new ArrayList<>();
    private static List<Integer> palavras;

    public static void main(String[] args) throws ErroSintatico{
        fazAnaliseLexica();

        pilha.add(ParserConstants.START_SYMBOL);
        while(!pilha.isEmpty()) {
            if (pilha.get(pilha.size() - 1) < ParserConstants.FIRST_NON_TERMINAL) {
                if (pilha.get(pilha.size() - 1).equals(palavras.get(0))) {
                    pilha.remove(pilha.size() - 1);
                    System.out.println(teste[palavras.get(0) - 2]);
                    palavras.remove(0);
                } else {
                    throw new ErroSintatico("Erro 1");
                }
            } else {
                int idProducao = ParserConstants.PARSER_TABLE[pilha.get(pilha.size() - 1)-46][palavras.get(0) - 1];
                if (idProducao != -1 /* M(X, a) = X Y1 Y2... Yk */) {
                    int[] retorno = ParserConstants.PRODUCTIONS[idProducao];
                    pilha.remove(pilha.size() - 1);
                    empilha(retorno);
                } else {
                    throw new ErroSintatico("Erro 2");
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
        String n = scanner.nextLine().toLowerCase();
        scanner.close();
        palavras = Lexico.getListaPalavrasReconhecidas(new File("exemplo" + n +".txt"));
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
