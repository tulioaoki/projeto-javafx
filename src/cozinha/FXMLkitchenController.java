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
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FXMLkitchenController implements Initializable {
    static int interval = 59;
    private boolean alreadyBaked;
    private ImageView img;
    private Cozinha cozinha;
    private String selectedItem;
    private String selectedIngrediente;
    private Timer timer;
    
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
    @FXML
    private ImageView bolo;
    @FXML
    private ImageView table_coberturas;
    private ImageView table_coberturas1;
    @FXML
    private Button cobertura_morango;
    @FXML
    private Button cobertura_laranja;
    @FXML
    private Button cobertura_chocolate;
    @FXML
    private Button cobertura_limao;
    @FXML
    private Button cobertura_glace;
    @FXML
    private Button cobertura_chantilly;
    @FXML
    private Button cobertura_creme;
    @FXML
    private Button complemento_morango;
    @FXML
    private Button complemento_cereja;
    @FXML
    private Button complemento_granulado;
    @FXML
    private Button select_complemento;
    @FXML
    private Button complemento_laranja;
    @FXML
    private Button complemento_marsh;
    @FXML
    private Button confirm_cobertura;
    @FXML
    private ImageView table_complementos;
    @FXML
    private Button complemento_limao;
    @FXML
    private ImageView complemento;
    @FXML
    private ImageView chantilly_flutuante;
    @FXML
    private Label ingrediente_principal;
    @FXML
    private Label cobertura_label;
    @FXML
    private Label complemento_label;

    private void checkEspatula(ActionEvent event) {
        System.out.println("Fim de jogo!");
        System.exit(0);
    }

    @FXML
    private void powerForno(ActionEvent event) throws InterruptedException {
        if (this.cozinha.estadoForno()) {
            desligarForno();
        } else {
            ligarForno();
        }
    }

    private void ligarForno() throws InterruptedException {
        if(alreadyBaked) return;
        if (!this.cozinha.getForno().has_forma()) {
            this.cozinha.ligarForno();
            String x = this.getClass().getResource("/resources/fonroligado.png").toExternalForm();
            Image forno_ligado = new Image(x);
            this.forno.setImage(forno_ligado);
        }else{
            this.cozinha.ligarForno();
            TimeUnit.SECONDS.sleep(1);
            String x = this.getClass().getResource("/resources/forno_ligado_massa_meio.png").toExternalForm();
            Image forno_ligado = new Image(x);
            this.forno.setImage(forno_ligado);
            TimeUnit.SECONDS.sleep(1);
            x = this.getClass().getResource("/resources/forno_ligado_massa_cheia.png").toExternalForm();
            forno_ligado = new Image(x);
            this.forno.setImage(forno_ligado);
            alreadyBaked = true;
        }

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
        
        Kitchen.getStage().setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {                        
            Platform.setImplicitExit(true);
            Kitchen.getStage().close();
            System.exit(0);
            }
        });
        this.cozinha = new CozinhaBuilder().getCozinha();
        this.cozinha.novaReceita();
        this.ingrediente_principal.setText(this.cozinha.getReceita().getSabor().toUpperCase());
        this.cobertura_label.setText(this.cozinha.getReceita().getCobertura().getSabor());
        this.complemento_label.setText(this.cozinha.getReceita().getComplemento().getNome());
        this.setTimer();
    }

    public boolean hasMainIngredient() {
        return this.cozinha.hasMainIngredient();
    }

    @FXML
    private void selectLaranja(MouseEvent event) {
        this.selectedIngrediente = "laranja";
    }

    @FXML
    private void selectFarinha(MouseEvent event) {
        this.selectedIngrediente = "farinha";
    }

    @FXML
    private void selectAcucar(MouseEvent event) {
        this.selectedIngrediente = "acucar";
    }

    @FXML
    private void selectFermento(MouseEvent event) {
        this.selectedIngrediente = "fermento";
    }

    @FXML
    private void selectManteiga(MouseEvent event) {
        this.selectedIngrediente = "manteiga";
    }

    @FXML
    private void selectLeite(MouseEvent event) {
        this.selectedIngrediente = "leite";
    }

    @FXML
    private void selectChocolate(MouseEvent event) {
        this.selectedIngrediente = "chocolate";
    }

    @FXML
    private void selectLimao(MouseEvent event) {
        this.selectedIngrediente = "limao";
    }

    @FXML
    private void selectMorango(MouseEvent event) {
        this.selectedIngrediente = "morango";
    }

    @FXML
    private void selectOvos(MouseEvent event) throws Exception {
        this.selectedIngrediente = "ovos";
    }

    @FXML
    private void interactBowl(MouseEvent event) {
        if (this.selectedIngrediente != null) {
            switch (this.selectedIngrediente) {
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
            this.selectedIngrediente = null;
            if (this.cozinha.isBowlReady()) {
                this.misturar_b.setDisable(false);
                this.misturar_b.setVisible(true);
            }
        }
    }

    private void updateBowl() {
        System.out.println(this.cozinha.getQtdIngredientsBowl());
        if (this.cozinha.getQtdIngredientsBowl() > 0 && this.cozinha.getQtdIngredientsBowl() < 5) {
            String x = this.getClass().getResource("/resources/bowl_meio_cheio.png").toExternalForm();
            Image bowl_ = new Image(x);
            this.bowl.setImage(bowl_);
        } else if (this.cozinha.getQtdIngredientsBowl() > 5) {
            String x = this.getClass().getResource("/resources/bowl_cheio.png").toExternalForm();
            Image bowl_ = new Image(x);
            this.bowl.setImage(bowl_);
        }
    }

    private void removeItem(String selectedItem) {
        switch (this.selectedIngrediente) {
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
    private void interactForno(MouseEvent event) throws InterruptedException {
        if ("forma".equals(this.selectedItem)) {
            if(this.cozinha.estadoForno()){
                String x = this.getClass().getResource("/resources/forno_ligado_massa_meio.png").toExternalForm();
                Image forno_ligado = new Image(x);
                this.forno.setImage(forno_ligado);
                TimeUnit.SECONDS.sleep(1);
                x = this.getClass().getResource("/resources/forno_ligado_massa_cheia.png").toExternalForm();
                forno_ligado = new Image(x);
                this.forno.setImage(forno_ligado);
                alreadyBaked = true;
            }
            this.cozinha.colocarFormaForno();
            this.forma_massa.setVisible(false);
            this.forma_massa.setDisable(true);
            this.selectedItem = null;
        } else if (this.selectedItem == null
                && this.cozinha.getForno().has_forma()
                && this.cozinha.getBolo().getCozido() == true) {
            String x = this.getClass().getResource("/resources/fonroligado.png").toExternalForm();
            Image forno_ligado = new Image(x);
            this.forno.setImage(forno_ligado);
            this.cozinha.retirarFormaForno();
            this.showCake();
        }
    }

    @FXML
    private void selectForma(MouseEvent event) {
        System.out.println("Forma selecionada");
        this.selectedItem = "forma";
    }

    @FXML
    private void EnformarBolo(ActionEvent event) {
        this.cozinha.enformarBolo();
        this.forma_massa.setDisable(false);
        this.forma_massa.setVisible(true);
        String x = this.getClass().getResource("/resources/bowl_vazio.png").toExternalForm();
        Image bowl = new Image(x);
        this.bowl.setImage(bowl);
        this.enformar_b.setVisible(false);
        this.enformar_b.setDisable(true);
        this.bowl.setVisible(false);
        this.bowl.setDisable(false);

    }

    @FXML
    private void MisturarMassa(ActionEvent event) {
        this.cozinha.misturar();
        String x = this.getClass().getResource("/resources/bowl_cremoso.png").toExternalForm();
        Image bowl_ = new Image(x);
        this.bowl.setImage(bowl_);
        this.misturar_b.setDisable(false);
        this.misturar_b.setVisible(false);
        this.enformar_b.setDisable(false);
        this.enformar_b.setVisible(true);
    }

    private void showCake() {
        String x;
        Image bolo_;
        switch (this.cozinha.getBolo().getSabor()) {
            case ("chocolate"):
                x = this.getClass().getResource("/resources/bolos/bolo_chocolate.png").toExternalForm();
                bolo_ = new Image(x);
                this.bolo.setImage(bolo_);
                this.bolo.setVisible(true);
                this.bolo.setDisable(false);
                break;
            case ("morango"):
                x = this.getClass().getResource("/resources/bolos/bolo_morango.png").toExternalForm();
                bolo_ = new Image(x);
                this.bolo.setImage(bolo_);
                this.bolo.setVisible(true);
                this.bolo.setDisable(false);
                break;
            case ("laranja"):
                x = this.getClass().getResource("/resources/bolos/bolo_laranja.png").toExternalForm();
                bolo_ = new Image(x);
                this.bolo.setImage(bolo_);
                this.bolo.setVisible(true);
                this.bolo.setDisable(false);
                break;
            case ("limao"):
                x = this.getClass().getResource("/resources/bolos/bolo_limao.png").toExternalForm();
                bolo_ = new Image(x);
                this.bolo.setImage(bolo_);
                this.bolo.setVisible(true);
                this.bolo.setDisable(false);
                break;
            default:
                x = this.getClass().getResource("/resources/bolos/bolo_trigo.png").toExternalForm();
                bolo_ = new Image(x);
                this.bolo.setImage(bolo_);
                this.bolo.setVisible(true);
                this.bolo.setDisable(false);
                break;
        }
        this.cleanTable();
        this.showCoberturaOptions();
    }

    @FXML
    private void select_cobertura_morango(MouseEvent event) {
        deactivateChantilly();
        String x;
        Image bolo_;
        this.allow_confirm_cobertura();
        this.selectedItem = "morango";
        x = this.getClass().getResource("/resources/bolos/cobertura_morango.png").toExternalForm();
        bolo_ = new Image(x);
        this.bolo.setImage(bolo_);
        this.bolo.setVisible(true);
        this.bolo.setDisable(false);
    }

    @FXML
    private void select_cobertura_laranja(MouseEvent event) {
        deactivateChantilly();
        this.allow_confirm_cobertura();
        this.selectedItem = "laranja";
        String x;
        Image bolo_;
        x = this.getClass().getResource("/resources/bolos/cobertura_laranja.png").toExternalForm();
        bolo_ = new Image(x);
        this.bolo.setImage(bolo_);
        this.bolo.setVisible(true);
        this.bolo.setDisable(false);
    }

    @FXML
    private void select_cobertura_creme(MouseEvent event) {
        deactivateChantilly();
        String x;
        Image bolo_;
        this.allow_confirm_cobertura();
        this.selectedItem = "creme";
        x = this.getClass().getResource("/resources/bolos/cobertura_creme.png").toExternalForm();
        bolo_ = new Image(x);
        this.bolo.setImage(bolo_);
        this.bolo.setVisible(true);
        this.bolo.setDisable(false);
    }

    @FXML
    private void select_cobertura_chocolate(MouseEvent event) {
        deactivateChantilly();
        String x;
        Image bolo_;
        this.allow_confirm_cobertura();
        this.selectedItem = "chocolate";
        x = this.getClass().getResource("/resources/bolos/cobertura_chocolate.png").toExternalForm();
        bolo_ = new Image(x);
        this.bolo.setImage(bolo_);
        this.bolo.setVisible(true);
        this.bolo.setDisable(false);
    }

    @FXML
    private void select_cobertura_limao(MouseEvent event) {
        deactivateChantilly();

        this.allow_confirm_cobertura();
        this.selectedItem = "limao";
        String x;
        Image bolo_;
        x = this.getClass().getResource("/resources/bolos/cobertura_limao.png").toExternalForm();
        bolo_ = new Image(x);
        this.bolo.setImage(bolo_);
        this.bolo.setVisible(true);
        this.bolo.setDisable(false);
    }

    @FXML
    private void select_cobertura_glace(MouseEvent event) {
        deactivateChantilly();
        this.allow_confirm_cobertura();
        this.selectedItem = "glace";
        String x;
        Image bolo_;
        x = this.getClass().getResource("/resources/bolos/cobertura_glace.png").toExternalForm();
        bolo_ = new Image(x);
        this.bolo.setImage(bolo_);
        this.bolo.setVisible(true);
        this.bolo.setDisable(false);
    }

    @FXML
    private void select_cobertura_chantily(MouseEvent event) {
        this.allow_confirm_cobertura();
        this.selectedItem = "chantilly";
        Image bolo_;
        String x, sabor_atual, imagem_bolo;
        sabor_atual = this.cozinha.getBolo().getSabor();
        if (sabor_atual == null) {
            sabor_atual = "trigo";
        }
        imagem_bolo = ("/resources/bolos/bolo_sub.png".replaceAll("sub", sabor_atual));
        x = this.getClass().getResource(imagem_bolo).toExternalForm();
        this.chantilly_flutuante.setVisible(true);
        this.chantilly_flutuante.setDisable(false);
        bolo_ = new Image(x);
        this.bolo.setImage(bolo_);
        this.bolo.setVisible(true);
        this.bolo.setDisable(false);
    }

    @FXML
    private void confirm_cobertura(MouseEvent event) {
        this.cozinha.setCobertura(this.selectedItem);
        System.out.println(this.cozinha.getBolo());
        this.confirm_cobertura.setVisible(false);
        this.confirm_cobertura.setDisable(true);
        this.selectedItem = null;
        hideCoberturaOptions();
        showComplementoOptions();
    }

    @FXML
    private void select_complemento_morango(MouseEvent event) {
        this.selectedItem = "morango";
        Image comp;
        String x;
        x = this.getClass().getResource("/resources/bolos/complemento_morango.png").toExternalForm();
        comp = new Image(x);
        this.complemento.setImage(comp);
        this.complemento.setVisible(true);
        this.complemento.setDisable(false);
        allow_confirm_complemento();
    }

    @FXML
    private void select_complemento_cereja(MouseEvent event) {
        this.selectedItem = "cereja";
        String x;
        Image comp;
        x = this.getClass().getResource("/resources/bolos/complemento_cereja_top.png").toExternalForm();
        comp = new Image(x);
        this.complemento.setImage(comp);
        this.complemento.setVisible(true);
        this.complemento.setDisable(false);
        allow_confirm_complemento();
    }

    @FXML
    private void select_complemento_granulado(MouseEvent event) {
        this.selectedItem = "granulado";
        String x;
        Image comp;
        x = this.getClass().getResource("/resources/bolos/complemento_granulado_top.png").toExternalForm();
        comp = new Image(x);
        this.complemento.setImage(comp);
        this.complemento.setVisible(true);
        this.complemento.setDisable(false);
        allow_confirm_complemento();
    }

    @FXML
    private void confirm_complemento(MouseEvent event) throws Exception {
        this.cozinha.setComplemento(this.selectedItem);
        System.out.println(this.cozinha.getBolo());
        this.confirm_cobertura.setVisible(false);
        this.confirm_cobertura.setDisable(true);
        this.selectedItem = null;
        timer.cancel();
        interval = 59;
        cakeIsCompatible();

    }

    @FXML
    private void select_complemento_laranja(MouseEvent event) {
        this.selectedItem = "laranja";
        String x;
        Image comp;
        x = this.getClass().getResource("/resources/bolos/complemento_laranja.png").toExternalForm();
        comp = new Image(x);
        this.complemento.setImage(comp);
        this.complemento.setVisible(true);
        this.complemento.setDisable(false);
        allow_confirm_complemento();
    }

    @FXML
    private void select_complemento_marsh(MouseEvent event) throws Exception {
        this.selectedItem = "marsh";
        Image comp;
        String x;
        x = this.getClass().getResource("/resources/bolos/complemento_marsh_top.png").toExternalForm();
        comp = new Image(x);
        this.complemento.setImage(comp);
        this.complemento.setVisible(true);
        this.complemento.setDisable(false);
        allow_confirm_complemento();
    }

    private void cleanTable() {
        this.acucar.setDisable(true);
        this.acucar.setVisible(false);
        this.chocolate.setDisable(true);
        this.chocolate.setVisible(false);
        this.leite.setDisable(true);
        this.leite.setVisible(false);
        this.laranja.setDisable(true);
        this.laranja.setVisible(false);
        this.limao.setDisable(true);
        this.limao.setVisible(false);
        this.morango.setDisable(true);
        this.morango.setVisible(false);
        this.fermento.setDisable(true);
        this.fermento.setVisible(false);
        this.farinha.setDisable(true);
        this.farinha.setVisible(false);
        this.ovos.setDisable(true);
        this.ovos.setVisible(false);
        this.bowl.setDisable(true);
        this.bowl.setVisible(false);
    }

    private void showCoberturaOptions() {
        this.table_coberturas.setVisible(true);
        this.table_coberturas.setDisable(false);
        this.cobertura_chocolate.setVisible(true);
        this.cobertura_chocolate.setDisable(false);
        this.cobertura_chantilly.setVisible(true);
        this.cobertura_chantilly.setDisable(false);
        this.cobertura_creme.setVisible(true);
        this.cobertura_creme.setDisable(false);
        this.cobertura_glace.setVisible(true);
        this.cobertura_glace.setDisable(false);
        this.cobertura_laranja.setVisible(true);
        this.cobertura_laranja.setDisable(false);
        this.cobertura_limao.setVisible(true);
        this.cobertura_limao.setDisable(false);
        this.cobertura_morango.setVisible(true);
        this.cobertura_morango.setDisable(false);
    }

    private void showComplementoOptions() {
        this.table_complementos.setVisible(true);
        this.table_complementos.setDisable(false);
        this.complemento_cereja.setVisible(true);
        this.complemento_cereja.setDisable(false);
        this.complemento_granulado.setVisible(true);
        this.complemento_granulado.setDisable(false);
        this.complemento_laranja.setVisible(true);
        this.complemento_laranja.setDisable(false);
        this.complemento_marsh.setVisible(true);
        this.complemento_marsh.setDisable(false);
        this.complemento_morango.setVisible(true);
        this.complemento_morango.setDisable(false);
        this.complemento_limao.setVisible(true);
        this.complemento_limao.setDisable(false);
    }

    private void allow_confirm_cobertura() {
        this.confirm_cobertura.setVisible(true);
        this.confirm_cobertura.setDisable(false);
    }

    private void allow_confirm_complemento() {
        this.select_complemento.setVisible(true);
        this.select_complemento.setDisable(false);
    }

    @FXML
    private void interactBolo(MouseEvent event) {
    }

    @FXML
    private void select_complemento_limao(MouseEvent event) {
        this.selectedItem = "limao";
        String x;
        Image comp;
        x = this.getClass().getResource("/resources/bolos/complemento_limao_top.png").toExternalForm();
        comp = new Image(x);
        this.complemento.setImage(comp);
        this.complemento.setVisible(true);
        this.complemento.setDisable(false);
        allow_confirm_complemento();
    }

    private void deactivateChantilly() {
        this.chantilly_flutuante.setVisible(false);
        this.chantilly_flutuante.setDisable(false);
    }

    private void hideCoberturaOptions() {
        this.table_coberturas.setVisible(false);
        this.table_coberturas.setDisable(false);
        this.cobertura_chocolate.setVisible(false);
        this.cobertura_chocolate.setDisable(false);
        this.cobertura_chantilly.setVisible(false);
        this.cobertura_chantilly.setDisable(false);
        this.cobertura_creme.setVisible(false);
        this.cobertura_creme.setDisable(false);
        this.cobertura_glace.setVisible(false);
        this.cobertura_glace.setDisable(false);
        this.cobertura_laranja.setVisible(false);
        this.cobertura_laranja.setDisable(false);
        this.cobertura_limao.setVisible(false);
        this.cobertura_limao.setDisable(false);
        this.cobertura_morango.setVisible(false);
        this.cobertura_morango.setDisable(false);
    }

    private void hideComplementoOptions() {
        this.table_complementos.setVisible(false);
        this.table_complementos.setDisable(false);
        this.complemento_cereja.setVisible(false);
        this.complemento_cereja.setDisable(false);
        this.complemento_granulado.setVisible(false);
        this.complemento_granulado.setDisable(false);
        this.complemento_laranja.setVisible(false);
        this.complemento_laranja.setDisable(false);
        this.complemento_marsh.setVisible(false);
        this.complemento_marsh.setDisable(false);
        this.complemento_morango.setVisible(false);
        this.complemento_morango.setDisable(false);
        this.complemento_limao.setVisible(false);
        this.complemento_limao.setDisable(false);
    }

    private void cakeIsCompatible() throws Exception {
        int cont = 0;
        Bolo receita = this.cozinha.getReceita();
        Bolo feito = this.cozinha.getBolo();
      
        if (feito.getSabor() == null ? receita.getSabor() == null : feito.getSabor().equals(receita.getSabor())) {
            cont++;
        }
        if (feito.getCobertura().getSabor() == null ? receita.getCobertura().getSabor() == null : feito.getCobertura().getSabor().equals(receita.getCobertura().getSabor())) {
            cont++;
        }
        if (feito.getComplemento().getNome() == null ? receita.getComplemento().getNome() == null : feito.getComplemento().getNome().equals(receita.getComplemento().getNome())) {
            cont++;
        }
        if (cont > 1) {endGame();}
        else{
            failGameOver();
        }
    }
    
    private void failGameOver() throws Exception{
        Kitchen.getStage().close();
        Fail fail = new Fail();
        fail.start(new Stage());
    }
    
    public void setTimer() {
    timer = new Timer();
    timer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            if(interval > 0)
            {
                
                System.out.println(interval);
                interval--;
            }
            else
                Platform.runLater(() -> {
                    timer.cancel();
                try {
                    failGameOver();
                } catch (Exception ex) {
                    Logger.getLogger(FXMLkitchenController.class.getName()).log(Level.SEVERE, null, ex);
                }
                timer.cancel();
                interval = 59;
                
            });
        }
    }, 1000,1000);
    
}
    
}
