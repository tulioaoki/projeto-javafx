package classes.base;

import builders.BoloBuilder;
import java.util.ArrayList;

/**
 * 
 */
public class Bowl extends Item {
    private String cor;
    private ArrayList <Ingrediente> ingredientes;
    private final BoloBuilder bbuilder;
    
    public Bowl() {
        bbuilder= new BoloBuilder();
    }

    public Bolo MixCake() {
        Bolo b = this.bbuilder.buildBoloWithIngredients(this.ingredientes);
        b.setMisturado(true);
        return b;
    }
    
    public void addIngrediente(Ingrediente i){
        this.ingredientes.add(i);
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    public void esvaziar(){
        this.ingredientes.clear();
    }
    
    public boolean has_ingredient(String ingrediente){
        for(Ingrediente i: ingredientes){
            if(ingrediente.equalsIgnoreCase(i.getNome())){
                return true;
            }
        }return false;
    }
    
    public boolean has_main_ingredient(){
        for(Ingrediente i: ingredientes){
            if(i.is_principal()){
                return true;
            }
        }return false;
    }
    
    public boolean isReady(){
        boolean has_ovo = has_ingredient("ovos");
        boolean has_farinha = has_ingredient("farinha");
        boolean has_manteiga = has_ingredient("manteiga");
        boolean has_fermento = has_ingredient("fermento");
        boolean has_acucar = has_ingredient("acucar");
        boolean has_leite = has_ingredient("leite");
        boolean has_main_ingredient = this.has_main_ingredient();

        return has_leite && has_manteiga && has_acucar
                && has_ovo && has_farinha && has_fermento && has_main_ingredient;
        
    }
    
}