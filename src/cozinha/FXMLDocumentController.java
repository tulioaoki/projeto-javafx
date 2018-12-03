package cozinha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
    private ImageView sound_button;
    
    @FXML
    private void exitSys(ActionEvent event) {
        System.out.println("Fim de jogo!");
        System.exit(0);
    }
    
    @FXML
    private void iniciarButton(ActionEvent event) throws Exception {
        Menu.getStage().close();
        Kitchen cozinha = new Kitchen();
        Menu.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
        public void handle(WindowEvent we) {                        
        Platform.setImplicitExit(false);
        Menu.getStage().close();
    }
});
        cozinha.start(new Stage());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void change_sound(MouseEvent event) {
        String x;
        Image b;
        if(!Menu.isMuted.get()){
            Menu.isMuted.set(true);
            x = this.getClass().getResource("/resources/sound_off.png").toExternalForm();
            b = new Image(x);
            this.sound_button.setImage(b);
            Menu.player.pause();
        }else{
            Menu.isMuted.set(false);
            x = this.getClass().getResource("/resources/sound_on.png").toExternalForm();
            b = new Image(x);
            this.sound_button.setImage(b);
            Menu.player.play();
        }
        
    }
    
    
}
