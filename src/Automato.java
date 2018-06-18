import java.io.*;
import java.util.Scanner;

public class Automato {

    public static void main(String[] args) {
        File file = new File("src//exemplo1.txt");
        new Automato(file);
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
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                identificaPalavra(st);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void identificaPalavra(String linha) throws IOException {
        String ultimaPalavra = "";
        try {
            String estadoAtual = "q0";
            String descricao;
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i <= linha.length(); i++) {
                char letra = '¨';
                try {
                    letra = linha.charAt(i);
                    estadoAtual = Util.pegaProximoEstado(letra, estadoAtual);
                    buffer.append(letra);

                } catch (ArrayIndexOutOfBoundsException e) {
                    if (Util.estadosReconhecedores.contains(estadoAtual) && (letra == ' ' || Util.simbolosEspeciais.containsKey(String.valueOf(letra)) || Util.simbolosEspeciais.containsKey(buffer.toString()))) {
                        descricao = Util.pegaCodigoDescricao(buffer.toString());
                        System.out.println(descricao + ": " + buffer.toString());
                        buffer = new StringBuffer();
                        estadoAtual = "q0";
                        i--;
                    } else if (letra != ' ') {
                        throw new IOException("Impossível reconhcer simbolo: " + buffer.toString());
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    if (Util.estadosReconhecedores.contains(estadoAtual)) {
                        descricao = Util.pegaCodigoDescricao(buffer.toString());
                        System.out.println(descricao + ": " + buffer.toString());
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
}
