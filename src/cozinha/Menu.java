/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cozinha;

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
public class Menu extends Application {

    private static Stage novo_stage;
    public static Media media;
    public static MediaPlayer player;

    @Override
    public void start(Stage stage) throws Exception {
        novo_stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        media = new Media(this.getClass().getResource("/resources/mc.mp3").toExternalForm());
        player = new MediaPlayer(media);
        player.setOnEndOfMedia(() -> {
            player.seek(Duration.ZERO);
        });
        player.play();
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        
    }

    public static Stage getStage() {
        return Menu.novo_stage;
    }

    public static void setStage(Stage s) {
        Menu.novo_stage = s;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
