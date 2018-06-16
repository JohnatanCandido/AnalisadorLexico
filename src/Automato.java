import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Automato {

    public static void main(String[] args) {
        File file = new File("src//exemplo2.txt");
        new Automato(file);
    }

    private Automato() {
        String palavra = "";
        try {
            while (!palavra.equals("sair")) {
                Scanner scanner = new Scanner(System.in);
                System.out.print(">> ");
                palavra = scanner.nextLine();
                identificaPalavra(separaLinha(palavra));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Automato(File file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                identificaPalavra(separaLinha(st));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void identificaPalavra(List<String> palavras) throws IOException{
        String ultimaPalavra = "";
        try {
            for (String palavra: palavras) {
                String estadoAtual = "q0";
                ultimaPalavra = palavra;
                int i = 0;
                while(i < palavra.length() || !Util.estadosReconhecedores.contains(estadoAtual)) {
                    estadoAtual = Util.pegaProximoEstado(palavra.charAt(i), estadoAtual);
                    i++;
                }
                System.out.println(Util.pegaCodigoDescricao(palavra) + ": " + palavra);
            }
        } catch (StringIndexOutOfBoundsException | ArrayIndexOutOfBoundsException e) {
            throw new IOException("Impossível identificar símbolo: " + ultimaPalavra);

        } catch (IllegalArgumentException e) {
            System.out.println("Impossível identificar símbolo: " + ultimaPalavra);
            throw new IOException(e.getMessage());
        }
    }

    private List<String> separaLinha(String linha) {
        StringBuilder linhaSeparada = new StringBuilder();
        StringBuilder buffer = new StringBuilder();
        for (int i=0; i<linha.length(); i++) {
            char c = linha.charAt(i);
            int isString = verificaString(buffer, c);
            if (isString > 0) {
                if (isString == 2)
                    buffer = novaLinha(buffer, linhaSeparada);
                if (i == linha.length() - 1)
                    linhaSeparada.append(buffer);
                continue;
            } else if (verificaComentario(buffer, c)) {
                if (buffer.charAt(buffer.length()-2) == '*' && c == ')') {
                    buffer = novaLinha(buffer, linhaSeparada);
                }
                if (i == linha.length() - 1)
                    linhaSeparada.append(buffer);
                continue;
            } else {
                int isPalavraReservada = verificaPalavraReservada(buffer, c);
                if (isPalavraReservada > 0) {
                    buffer = novaLinha(buffer, linhaSeparada);
                    if (isPalavraReservada == 2)
                        continue;
                } else if(Util.simbolosEspeciais.keySet().contains(buffer.toString())) {
                    if (c == '=') {
                        if (buffer.charAt(0) == '<' || buffer.charAt(0) == '>' || buffer.charAt(0) == ':') {
                            buffer.append(linha.charAt(i));
                            buffer = novaLinha(buffer, linhaSeparada);
                            continue;
                        }
                    } else if (c == '>' && buffer.charAt(0) == '<') {
                        buffer.append(linha.charAt(i));
                        buffer = novaLinha(buffer, linhaSeparada);
                        continue;
                    } else {
                        buffer = novaLinha(buffer, linhaSeparada);
                    }
                } else if (Util.simbolosEspeciais.keySet().contains(String.valueOf(c)) && buffer.length() == 0) {
                    if (i == linha.length()-1 || (linha.charAt(i+1) != '=' && linha.charAt(i+1) != '>' && linha.charAt(i+1) != '*')) {
                        buffer.append(c);
                        buffer = novaLinha(buffer, linhaSeparada);
                        continue;
                    }
                }
            }
            if (linha.charAt(i) == ' ') {
                if (buffer.length() > 0)
                    buffer = novaLinha(buffer, linhaSeparada);
                continue;
            }
            if (buffer.length() > 0 && Util.simbolosEspeciais.keySet().contains(String.valueOf(c))) {
                try {
                    Integer.valueOf(buffer.toString());
                    Integer.valueOf(String.valueOf(c));
                } catch (NumberFormatException e) {
                    buffer = novaLinha(buffer, linhaSeparada);
                }
            }
            if (buffer.length() > 0 || linha.charAt(i) != ' ')
                buffer.append(linha.charAt(i));
            if (i == linha.length() - 1) {
                linhaSeparada.append(buffer);
            }
        }
        return Arrays.asList(linhaSeparada.toString().split("\n"));
    }

    private StringBuilder novaLinha(StringBuilder buffer, StringBuilder linhaSeparada) {
        buffer.append("\n");
        linhaSeparada.append(buffer);
        return new StringBuilder();
    }

    private int verificaString(StringBuilder buffer, char c) {
        if (buffer.length() > 0 && buffer.charAt(0) == '"') {
            buffer.append(c);
            if (c == '"')
                return 2;
            return 1;
        }
        return 0;
    }

    private boolean verificaComentario(StringBuilder buffer, char c) {
        if (buffer.length() > 0 && buffer.charAt(0) == '(') {
            if (c == '*' || (buffer.length() > 1 && buffer.charAt(1) == '*')) {
                buffer.append(c);
                return true;
            }
        }
        return false;
    }

    private int verificaPalavraReservada(StringBuilder buffer, char c) {
        if (Util.palavrasReservadas.keySet().contains(buffer.toString())) {
            return 1;
        } else if (Util.palavrasReservadas.keySet().contains(buffer.toString() + c)) {
            buffer.append(c);
            return 2;
        }
        return 0;
    }
}
