import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TelaController {

    @FXML
    TextArea texto;

    @FXML
    public void compilar() {
        try {
            Sintatico.fazAnaliseSintatica(texto.getText().split("\n"));
        } catch (ErroLexico | ErroSintatico e) {
            e.printStackTrace();
        }
    }

}
