/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cozinha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author tulioaoki
 */
public class FailController implements Initializable {

    @FXML
    private ImageView gameOver;

    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Win.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
        public void handle(WindowEvent we) {                        
        Platform.setImplicitExit(false);
        Win.getStage().close();
        System.exit(0);
    }
});
    }    

    @FXML
    private void restartGame(MouseEvent event) throws Exception {
        Fail.failStage.close();
        Menu menu = new Menu();
        menu.start(new Stage());
    }
    
}
