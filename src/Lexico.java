import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lexico {

    private static List<Object[]> palavrasReconhecidas = new ArrayList<>();

    public static Stack<Object[]> getListaPalavrasReconhecidas(File file) {
        int linha = 1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                if (!st.trim().equals(""))
                    identificaPalavra(st.trim().toLowerCase(), linha);
                linha++;
            }
        } catch (ErroLexico | IOException e) {
            throw new IllegalArgumentException("Erro na linha " + linha + "\n" + e.getMessage());
        }
        Stack<Object[]> pilhaPalavrasReconhecidas = new Stack<>();
        for (int i = palavrasReconhecidas.size() - 1; i >= 0; i--)
            pilhaPalavrasReconhecidas.push(palavrasReconhecidas.get(i));
        return pilhaPalavrasReconhecidas;
    }

    public static Stack<Object[]> getListaPalavrasReconhecidas(String[] texto) throws ErroLexico {
        palavrasReconhecidas.clear();
        int linha = 0;
        try {
            while (linha < texto.length) {
                if (!texto[linha].trim().equals(""))
                    identificaPalavra(texto[linha].trim().toLowerCase(), linha + 1);
                linha++;
            }
        } catch (ErroLexico e) {
            throw new ErroLexico("Erro na linha " + (linha + 1) + "\n" + e.getMessage());
        }
        Stack<Object[]> pilhaPalavrasReconhecidas = new Stack<>();
        for (int i = palavrasReconhecidas.size() - 1; i >= 0; i--)
            pilhaPalavrasReconhecidas.push(palavrasReconhecidas.get(i));
        return pilhaPalavrasReconhecidas;
    }

    private static void identificaPalavra(String linha, Integer num_linha) throws ErroLexico {
        try {
            String estadoAtual = "q0";
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i <= linha.length(); i++) {
                char letra = '_';
                try {
                    letra = linha.charAt(i);
                    estadoAtual = Util.pegaProximoEstado(letra, estadoAtual);
                    buffer.append(letra);

                } catch (ArrayIndexOutOfBoundsException e) {
                    if (verificaPalavraValida(estadoAtual, buffer, letra)) {
                        try {
                            if (letra == '.' && i < linha.length() - 1) {
                                String possivelNumero = buffer.toString() + String.valueOf(letra) + String.valueOf(linha.charAt(i + 1));
                                Double.valueOf(possivelNumero);
                                throw new ErroLexico("Não permite números decimais!");
                            }
                            throw new NumberFormatException();
                        } catch (NumberFormatException excepttion) {
                            pegaCodigoPalavraReconhecida(buffer, num_linha);
                            buffer = new StringBuffer();
                            estadoAtual = "q0";
                            i--;
                        }
                    } else if (!buffer.toString().equals("") || letra != ' ') {
                        throw new ErroLexico("Impossível reconhcer simbolo: " + buffer.toString() + letra);
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    if (Util.estadosReconhecedores.contains(estadoAtual)) {
                        pegaCodigoPalavraReconhecida(buffer, num_linha);
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

    private static void pegaCodigoPalavraReconhecida(StringBuffer buffer, int linha) throws ErroLexico {
        Integer codigo = Util.pegaCodigoDescricao(buffer.toString());
        if (codigo > 0) {
//            System.out.println(buffer.toString());
            palavrasReconhecidas.add(new Object[]{codigo, linha, buffer.toString()});
        }
    }
}
