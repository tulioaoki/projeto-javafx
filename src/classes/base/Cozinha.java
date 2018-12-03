package classes.base;

import builders.CoberturaBuilder;
import builders.ComplementoBuilder;
import builders.GeradorReceita;
import builders.IngredientBuilder;
import java.util.ArrayList;

/**
 *
 * @author tulioaoki
 */

public class Cozinha extends Item {
    private Bolo receita;
    private Forno forno;
    private Bowl bowl;
    private Espatula espatula;
    private Forma forma;
    private Bolo bolo;
    private final CoberturaBuilder coberturaBuilder;
    private final ComplementoBuilder complementoBuilder;
    private final IngredientBuilder ingredientBuilder;
    private GeradorReceita geradorReceita;
    
    public Cozinha(Bolo receita, Forno forno, Bowl bowl, Espatula espatula, Forma forma){
        this.receita = receita;
        this.forno = forno;
        this.bowl = bowl;
        this.espatula = espatula;
        this.forma = forma;
        this.coberturaBuilder = new CoberturaBuilder();
        this.complementoBuilder = new ComplementoBuilder();
        this.ingredientBuilder = new IngredientBuilder();
        this.bolo = new Bolo();
        geradorReceita = new GeradorReceita();

    }
    
    public boolean has_forma(){
        return this.forma != null;
    }
    
    public void colocarFormaForno() {
        this.forno.colocarForma(this.forma);
    }

    public void retirarFormaForno() {
        this.forno.retirarForma();
    }
    
    public Bolo getReceita(){
        return this.receita;
    }
    
    public void addCobertura(Espatula e){
        Cobertura c = coberturaBuilder.getCobertura(e.getSabor());
    }
    
    public void ligarForno(){
        this.forno.setLigado(true);
        assarBolo();
    }
    public void desligarForno(){
        this.forno.setLigado(false);
    }
    
    public boolean estadoForno(){
        return this.forno.isLigado();
    }
    
    public boolean assarBolo(){
        if(this.forma.has_massa() && this.forno.isLigado() && this.forma.has_massa()){
            this.forma.assarBolo();
        return true;
        }
        return false;
    }
    
    public boolean isBowlReady(){
        return this.bowl.isReady();
    }
    
    public boolean misturar(){
        if(this.bowl.isReady()){
            this.bolo = this.bowl.MixCake();
            return true;
        }
        return false;
    }
    
    public void enformarBolo(){
        this.forma.Enformar(bolo);
    }
    
    public void desenformarBolo(){
        this.bolo = this.forma.Desenformar();
    }
    
    public void setSaborEspatula(String sabor){
        this.espatula.setSabor(sabor);
    }


    public void setReceita(Bolo receita) {
        this.receita = receita;
    }

    public Forno getForno() {
        return forno;
    }

    public void setForno(Forno forno) {
        this.forno = forno;
    }
    
    public void setCobertura(String sabor){
        this.bolo.setCobertura(this.coberturaBuilder.getCobertura(sabor));
    }
    
    public String getCobertura(String sabor){
        return this.bolo.getCobertura().getSabor();
    }

    public Bowl getBowl() {
        return bowl;
    }

    public void setBowl(Bowl bowl) {
        this.bowl = bowl;
    }

    public Espatula getEspatula() {
        return espatula;
    }

    public void setEspatula(Espatula espatula) {
        this.espatula = espatula;
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
        this.forma = forma;
    }

    public Bolo getBolo() {
        return bolo;
    }

    public void setBolo(Bolo bolo) {
        this.bolo = bolo;
    }
    
    public int getQtdIngredientsBowl(){
        return this.bowl.getQtdIngredients();
    }
    
    public boolean hasMainIngredient(){
        return this.bolo.hasMainIngredient();
    }
    
    public boolean bowlHasMainIngredient(){
        return this.bowl.hasMainIngredient();
    }
    
    public ArrayList<Ingrediente> getIngredientesBowl() {
        return this.bowl.getIngredientes();
    }

    public void setIngredientesBowl(ArrayList<Ingrediente> ingredientes) {
        this.bowl.setIngredientes(ingredientes);
    }
    
    public void addIngredientes(Ingrediente i) {
        this.bowl.addIngrediente(i);
    }
    
    public void addOvos(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("ovos")));
    }
    
    public void addFarinha(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("farinha")));
    }
    
    public void addManteiga(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("manteiga")));
    }
    
    public void addAcucar(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("acucar")));
    }
    
    public void addLeite(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("leite")));
    }
    
    public void addFermento(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("fermento")));
    }
    
    public void addChocolate(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("chocolate")));
    }
    
    public void addMorango(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("morango")));
    }
    
    public void addLaranja(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("laranja")));
    }
    
    public void addLimao(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("limao")));
    }
    
    public void addBaunilha(){
        this.bowl.addIngrediente((ingredientBuilder.getIngredient("baunilha")));
    }
    
    public void esvaziarIngredientes(){
        this.bowl.esvaziar();
    }

    public void setComplemento(String sabor) {
        this.bolo.setComplemento(this.complementoBuilder.getComplemento(sabor));
    }
    
    public String getComplemento(){
        return this.bolo.getComplemento().getNome();
    }

    public void novaReceita() {
        this.receita = geradorReceita.gerarReceita();
    }
            
}
