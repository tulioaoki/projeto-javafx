/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cozinha;

import static cozinha.Menu.media;
import static cozinha.Menu.player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author tulioaoki
 */
public class Fail extends Application{
    public static Stage failStage;

    @Override
    public void start(Stage stage) throws Exception {
        failStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Fail.fxml"));
        Scene scene = new Scene(root);
        media = new Media(this.getClass().getResource("/resources/fail.mp3").toExternalForm());
        player.stop();
        player = new MediaPlayer(media);
        player.setOnEndOfMedia(() -> {
            player.seek(Duration.ZERO);
        });
        player.play();
        failStage.centerOnScreen(); 
        failStage.setResizable(false);
        failStage.setScene(scene);
        failStage.show();
    }
    
}

