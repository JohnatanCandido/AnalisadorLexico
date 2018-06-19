import java.io.*;
import java.util.Scanner;

public class Automato {

    public static void main(String[] args) {
        File file = new File("src//exemplo1.txt");
        try {
            new Automato(file);
        } catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private Automato() {
        String palavra = "";
        try {
            while (!palavra.equals("sair")) {
                Scanner scanner = new Scanner(System.in);
                System.out.print(">> ");
                palavra = scanner.nextLine();
                identificaPalavra(palavra);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Automato(File file) {
        int linha = 1;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                identificaPalavra(st);
                linha++;
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Erro na linha " + linha + "\n" + e.getMessage());
        }
    }

    private void identificaPalavra(String linha) throws IOException{
        String ultimaPalavra = "";
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
                    if (Util.estadosReconhecedores.contains(estadoAtual) && (letra == ' ' || Util.simbolosEspeciais.containsKey(String.valueOf(letra)) || Util.simbolosEspeciais.containsKey(buffer.toString()))) {
                        try {
                            if (letra == '.' && i < linha.length() - 1) {
                               String prefixo = buffer.toString() + String.valueOf(letra) + String.valueOf(linha.charAt(i+1));
                               Double.valueOf(prefixo);
                               throw new IOException("Não permite números decimais!");
                            }
                            throw new NumberFormatException();
                        } catch (NumberFormatException excepttion) {
                            printCodigoDescricao(buffer);
                            buffer = new StringBuffer();
                            estadoAtual = "q0";
                            i--;
                        }
                    } else if (!buffer.toString().equals("") || letra != ' ') {
                        throw new IOException("Impossível reconhcer simbolo: " + buffer.toString());
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    if (Util.estadosReconhecedores.contains(estadoAtual)) {
                        printCodigoDescricao(buffer);
                    } else {
                        throw new IOException("Impossível reconhcer simbolo: " + buffer.toString());
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Impossível identificar símbolo: " + ultimaPalavra);
            throw new IOException(e.getMessage());
        }
    }

    private void printCodigoDescricao(StringBuffer buffer) {
        String descricao = Util.pegaCodigoDescricao(buffer.toString());
        if (!descricao.equals("Comentário")) {
            System.out.println(descricao + ": " + buffer.toString());
        }
    }
}
