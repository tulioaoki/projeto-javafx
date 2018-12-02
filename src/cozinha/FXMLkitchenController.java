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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author tulioaoki
 */
public class FXMLkitchenController implements Initializable {

    private ImageView img;
    private Cozinha cozinha;
    private String selectedItem;
    private String selectedIgrediente;
    @FXML
    private ImageView fundo;
    @FXML
    private ImageView forno;
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
    private ImageView leite;
    @FXML
    private Button enformar_b;
    @FXML
    private Button misturar_b;

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Bolo b = new GeradorReceita().gerarReceita();
        this.cozinha = new CozinhaBuilder().getCozinha();
        System.out.println("Receita Gerada:\n" + b);

    }

    public boolean hasMainIngredient() {
        return this.cozinha.hasMainIngredient();
    }

    @FXML
    private void selectLaranja(MouseEvent event) {
        this.selectedIgrediente = "laranja";
    }

    @FXML
    private void selectFarinha(MouseEvent event) {
        this.selectedIgrediente = "farinha";
    }

    @FXML
    private void selectAcucar(MouseEvent event) {
        this.selectedIgrediente = "acucar";
    }

    @FXML
    private void selectFermento(MouseEvent event) {
        this.selectedIgrediente = "fermento";
    }

    @FXML
    private void selectManteiga(MouseEvent event) {
        this.selectedIgrediente = "manteiga";
    }

    @FXML
    private void selectLeite(MouseEvent event) {
        this.selectedIgrediente = "leite";
    }

    @FXML
    private void selectChocolate(MouseEvent event) {
        this.selectedIgrediente = "chocolate";
    }

    @FXML
    private void selectLimao(MouseEvent event) {
        this.selectedIgrediente = "limao";
    }

    @FXML
    private void selectMorango(MouseEvent event) {
        this.selectedIgrediente = "morango";
    }

    @FXML
    private void selectOvos(MouseEvent event) throws Exception {
        this.selectedIgrediente = "ovos";
    }

    @FXML
    private void interactBowl(MouseEvent event) {
        if (this.selectedIgrediente != null) {
            switch (this.selectedIgrediente) {
                case "farinha":
                    this.cozinha.addFarinha();
                    removeItem(this.selectedItem);
                    updateBowl();
                    break;
                case "acucar":
                    this.cozinha.addAcucar();
                    removeItem(this.selectedItem);
                    updateBowl();
                    break;
                case "chocolate":
                    if (!this.cozinha.bowlHasMainIngredient()) {
                        this.cozinha.addChocolate();
                        removeItem(this.selectedItem);
                        updateBowl();
                    }
                    break;
                case "manteiga":
                    this.cozinha.addManteiga();
                    removeItem(this.selectedItem);
                    updateBowl();
                    break;
                case "fermento":
                    this.cozinha.addFermento();
                    removeItem(this.selectedItem);
                    updateBowl();
                    break;
                case "laranja":
                    if (!this.cozinha.bowlHasMainIngredient()) {
                        this.cozinha.addLaranja();
                        removeItem(this.selectedItem);
                        updateBowl();
                    }
                    break;
                case "limao":
                    if (!this.cozinha.bowlHasMainIngredient()) {
                        this.cozinha.addLimao();
                        removeItem(this.selectedItem);
                        updateBowl();
                    }
                    break;
                case "morango":
                    if (!this.cozinha.bowlHasMainIngredient()) {
                        this.cozinha.addMorango();
                        removeItem(this.selectedItem);
                        updateBowl();
                    }
                    break;
                case "leite":
                    this.cozinha.addLeite();
                    removeItem(this.selectedItem);
                    updateBowl();
                    break;
                case "ovos":
                    this.cozinha.addOvos();
                    removeItem(this.selectedItem);
                    updateBowl();
                    break;
            }
            this.selectedIgrediente = null;
            if(this.cozinha.isBowlReady()){
                this.misturar_b.setDisable(false);
                this.misturar_b.setVisible(true);
            }
        }
    }

    private void updateBowl() {
        System.out.println(this.cozinha.getQtdIngredientsBowl());
        if (this.cozinha.getQtdIngredientsBowl() > 0 && this.cozinha.getQtdIngredientsBowl() < 5) {
            String x = this.getClass().getResource("/resources/bowl_meio_cheio.png").toExternalForm();
            Image bowl = new Image(x);
            this.bowl.setImage(bowl);
        } else if (this.cozinha.getQtdIngredientsBowl() > 5) {
            String x = this.getClass().getResource("/resources/bowl_cheio.png").toExternalForm();
            Image bowl = new Image(x);
            this.bowl.setImage(bowl);
        }
    }

    private void removeItem(String selectedItem) {
        switch (this.selectedIgrediente) {
            case "farinha":
                this.farinha.setVisible(false);
                this.farinha.setDisable(true);
                break;
            case "acucar":
                this.acucar.setVisible(false);
                this.acucar.setDisable(true);
                updateBowl();
                break;
            case "chocolate":
                this.chocolate.setVisible(false);
                this.chocolate.setDisable(true);
                updateBowl();
                break;
            case "manteiga":
                this.manteiga.setVisible(false);
                this.manteiga.setDisable(true);
                updateBowl();
                break;
            case "fermento":
                this.fermento.setVisible(false);
                this.fermento.setDisable(true);
                updateBowl();
                break;
            case "laranja":
                this.laranja.setVisible(false);
                this.laranja.setDisable(true);
                updateBowl();
                break;
            case "limao":
                this.limao.setVisible(false);
                this.limao.setDisable(true);
                updateBowl();
                break;
            case "morango":
                this.morango.setVisible(false);
                this.morango.setDisable(true);
                updateBowl();
                break;
            case "leite":
                this.leite.setVisible(false);
                this.leite.setDisable(true);
                updateBowl();
                break;
            case "ovos":
                this.ovos.setVisible(false);
                this.ovos.setDisable(true);
                updateBowl();
                break;
        }
    }

    private void endGame() throws Exception {
        Kitchen.getStage().close();
        Win win = new Win();
        win.start(new Stage());
    }

    @FXML
    private void selectForma(MouseEvent event) {
    }

    @FXML
    private void EnformarBolo(ActionEvent event) {
        this.cozinha.enformarBolo();
        this.forma_massa.setDisable(false);
        this.forma_massa.setVisible(true);
        String x = this.getClass().getResource("/resources/bowl_vazio.png").toExternalForm();
        Image bowl = new Image(x);
        this.bowl.setImage(bowl);
        
    }

    @FXML
    private void MisturarMassa(ActionEvent event) {
        this.cozinha.misturar();
        String x = this.getClass().getResource("/resources/bowl_cremoso.png").toExternalForm();
        Image bowl = new Image(x);
        this.bowl.setImage(bowl);
        this.misturar_b.setDisable(false);
        this.misturar_b.setVisible(false);
        this.enformar_b.setDisable(false);
        this.enformar_b.setVisible(true);
    }

}
