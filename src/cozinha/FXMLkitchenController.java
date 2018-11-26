/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cozinha;

import builders.CozinhaBuilder;
import builders.GeradorReceita;
import classes.base.Bolo;
import classes.base.Cozinha;
import classes.base.Ingrediente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 *
 * @author tulioaoki
 */
public class FXMLkitchenController implements Initializable {

    private ImageView img;
    private Cozinha cozinha;
    private Object selectedItem;
    private Ingrediente selectedIgrediente;
    @FXML
    private ImageView fundo;
    @FXML
    private ImageView forno;
    @FXML
    private Label timer;
    @FXML
    private ImageView bowl;
    @FXML
    private ImageView laranja;
    @FXML
    private ImageView limao;
    @FXML
    private ImageView morango;
    @FXML
    private ImageView manteiga;
    @FXML
    private ImageView geleia_morango;
    @FXML
    private ImageView chantily;
    @FXML
    private ImageView chocolate;
    @FXML
    private ImageView farinha;
    @FXML
    private ImageView forma_massa;
    @FXML
    private ImageView fermento;
    @FXML
    private ImageView acucar;
    @FXML
    private ImageView ovos;

    @FXML
    private void checkEspatula(ActionEvent event) {
        System.out.println("Fim de jogo!");
        System.exit(0);
    }

    @FXML
    private void powerForno(ActionEvent event) {
        if (this.cozinha.estadoForno()) {
            desligarForno();
        } else {
            ligarForno();
        }
    }

    private void ligarForno() {
        this.cozinha.ligarForno();
        String x = this.getClass().getResource("/resources/fonroligado.png").toExternalForm();
        Image forno_ligado = new Image(x);
        this.forno.setImage(forno_ligado);
        System.out.println("O forno esta ligado = " + this.cozinha.estadoForno());
    }

    private void desligarForno() {
        this.cozinha.desligarForno();
        String x = this.getClass().getResource("/resources/microwave-vector-3.png").toExternalForm();
        Image forno_ligado = new Image(x);
        this.forno.setImage(forno_ligado);
        System.out.println("O forno esta ligado = " + this.cozinha.estadoForno());
    }

    private void iniciarButton(ActionEvent event, Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("kitchen.fxml"));
        
        Scene scene = new Scene(root);

        stage.setScene(scene);
        
        
        
        stage.show();
        
        
    }
    /*
    public static void updateTimer(String t){
        if(FXMLkitchenController.timer == null){
            timer = new Label();
        }
        timer.setText(t);
    }
    
    */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Bolo b = new GeradorReceita().gerarReceita();
        this.cozinha = new CozinhaBuilder().getCozinha();
        System.out.println("Receita Gerada:\n" + b);
        
    }
}
