import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TelaController {

    @FXML
    TextArea texto;

    @FXML
    TextField retorno;

    @FXML
    public void compilar() {
        try {
            retorno.setText(Sintatico.fazAnaliseSintatica(texto.getText().split("\n")));
        } catch (ErroLexico | ErroSintatico e) {
            retorno.setText(e.getMessage());
        }
    }

}
