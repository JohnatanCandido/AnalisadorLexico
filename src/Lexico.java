import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lexico {

    private static List<Integer> palavrasReconhecidas = new ArrayList<>();

    public static void main(String[] args) {

        File file = new File("exemplo1.txt");
        try {
            new Lexico(file);
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
        System.out.print(palavrasReconhecidas);
    }

    private Lexico() {
        String palavra = "";
        try {
            while (!palavra.equals("sair")) {
                Scanner scanner = new Scanner(System.in);
                System.out.print(">> ");
                palavra = scanner.nextLine().toLowerCase();
                identificaPalavra(palavra);
            }
        } catch (ErroLexico e) {
            e.printStackTrace();
        }
        System.out.print(palavrasReconhecidas);
    }

    private Lexico(File file) {
        int linha = 1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                identificaPalavra(st.trim().toLowerCase());
                linha++;
            }
        } catch (ErroLexico | IOException e) {
            throw new IllegalArgumentException("Erro na linha " + linha + "\n" + e.getMessage());
        }
    }

    public static List<Integer> getListaPalavrasReconhecidas(File file) {
        int linha = 1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                if (!st.equals(""))
                    identificaPalavra(st.trim().toLowerCase());
                linha++;
            }
        } catch (ErroLexico | IOException e) {
            throw new IllegalArgumentException("Erro na linha " + linha + "\n" + e.getMessage());
        }
        return palavrasReconhecidas;
    }

    private static void identificaPalavra(String linha) throws ErroLexico{
        try {
            String estadoAtual = "q0";
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i <= linha.length(); i++) {
                char letra = '¨';
                try {
                    letra = linha.charAt(i);
                    estadoAtual = Util.pegaProximoEstado(letra, estadoAtual);
                    buffer.append(letra);

                } catch (ArrayIndexOutOfBoundsException e) {
                    if (verificaPalavraValida(estadoAtual, buffer, letra)) {
                        try {
                            if (letra == '.' && i < linha.length() - 1) {
                               String possivelNumero = buffer.toString() + String.valueOf(letra) + String.valueOf(linha.charAt(i+1));
                               Double.valueOf(possivelNumero);
                               throw new ErroLexico("Não permite números decimais!");
                            }
                            throw new NumberFormatException();
                        } catch (NumberFormatException excepttion) {
                            pegaCodigoPalavraReconhecida(buffer);
                            buffer = new StringBuffer();
                            estadoAtual = "q0";
                            i--;
                        }
                    } else if (!buffer.toString().equals("") || letra != ' ') {
                        throw new ErroLexico("Impossível reconhcer simbolo: " + buffer.toString() + letra);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    if (Util.estadosReconhecedores.contains(estadoAtual)) {
                        pegaCodigoPalavraReconhecida(buffer);
                    } else {
                        throw new ErroLexico("Impossível reconhcer simbolo: " + buffer.toString() + letra);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Impossível identificar símbolo: teste");
            throw new ErroLexico(e.getMessage());
        }
    }

    private static boolean verificaPalavraValida(String estadoAtual, StringBuffer buffer, char letra) {
        return Util.estadosReconhecedores.contains(estadoAtual)
                && (letra == ' '
                    || Util.simbolosEspeciais.containsKey(String.valueOf(letra))
                    || Util.simbolosEspeciais.containsKey(buffer.toString()));
    }

    private static void pegaCodigoPalavraReconhecida(StringBuffer buffer) throws ErroLexico {
        Integer codigo = Util.pegaCodigoDescricao(buffer.toString());
        if (codigo > 0) {
//            System.out.println(buffer.toString());
            palavrasReconhecidas.add(codigo);
        }
    }
}
