import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TelaController {

    private static final String SEARCH_DIRECTORY = "C:\\Users\\Usuário\\Desktop\\Trabalhos\\2018b\\Tradução das Linguagens Formais\\AnalisadorLexico";

    @FXML
    public TextArea texto;

    @FXML
    public TextArea log;

    public static StringBuilder saida;

    @FXML
    public void fazAnaliseLexica() {
        saida = new StringBuilder();
        try {
            for (Object[] token: Lexico.getListaPalavrasReconhecidas(texto.getText().split("\n"), true)) {
                saida.append(String.format("%2s %20s %40s", token[0].toString(), token[2].toString(), token[3].toString())).append("\n");
            }
            log.setText(saida.toString());
        } catch (ErroLexico e) {
            log.setText(e.getMessage());
        }
    }

    @FXML
    public void fazAnaliseSintatica() {
        try {
            saida = new StringBuilder();
            Sintatico.fazAnaliseSintatica(texto.getText().split("\n"), 0);
            log.setText(saida.toString());
        } catch (ErroLexico | ErroSintatico | ErroSemantico e) {
            log.setText(e.getMessage());
        }
    }

    @FXML
    public void fazAnaliseSemantica() {
        try {
            saida = new StringBuilder();
            Sintatico.fazAnaliseSintatica(texto.getText().split("\n"), 1);
            log.setText(saida.toString());
        } catch (ErroLexico | ErroSintatico | ErroSemantico e) {
            log.setText(e.getMessage());
        }
    }

    @FXML
    public void interpretar() {
        try {
            saida = new StringBuilder();
            Sintatico.fazAnaliseSintatica(texto.getText().split("\n"), 2);
            log.setText(saida.toString());
        } catch (ErroLexico | ErroSintatico | ErroSemantico e) {
            log.setText(e.getMessage());
        }
    }

    @FXML
    public void carregarArquivo() throws IOException {
        File arquivo = buscarArquivo();
        StringBuilder sb = new StringBuilder();

        if (arquivo != null) {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String st;
            while ((st = br.readLine()) != null) {
                sb.append(st);
                sb.append("\n");
            }

            texto.setText(sb.toString());
        }
    }

    private File buscarArquivo() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Imagens", "*.txt"));
        fileChooser.setInitialDirectory(new File(SEARCH_DIRECTORY));

        try {
            return fileChooser.showOpenDialog(null);
        } catch (Exception e) {
            texto.setText(e.getMessage());
        }
        return null;
    }

}
