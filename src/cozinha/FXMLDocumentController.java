package cozinha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author tulioaoki
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button button;
    
    @FXML
    private void exitSys(ActionEvent event) {
        System.out.println("Fim de jogo!");
        System.exit(0);
    }
    
    @FXML
    private void iniciarButton(ActionEvent event) throws Exception {
        Menu.getStage().close();
        Kitchen cozinha = new Kitchen();
        cozinha.start(new Stage());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
