package builders;

import classes.base.Ingrediente;

/**
 *
 * @author tulioaoki
 */
public class IngredientBuilder {
    
    public IngredientBuilder(){
        //empty
    }
    
    public Ingrediente getIngredient(String nome){
        Ingrediente to_return;
        switch(nome){
            case "ovos":
                to_return = new Ingrediente(nome);
                break;
            case "farinha":
                to_return = new Ingrediente(nome);
                break;
            case "leite":
                to_return = new Ingrediente(nome);
                break;
            case "manteiga":
                to_return = new Ingrediente(nome);
                break;
            case "fermento":
                to_return = new Ingrediente(nome);
                break;
            case "acucar":
                to_return = new Ingrediente(nome);
                break;
            case "baunilha":
                to_return = new Ingrediente(nome);
                break;
            case "chocolate":
                to_return = new Ingrediente(nome);
                break;
            case "morango":
                to_return = new Ingrediente(nome);
                break;
            case "laranja":
                to_return = new Ingrediente(nome);
                break;
            case "limao":
                to_return = new Ingrediente(nome);
                break;
            default:
                to_return = null;
                System.err.println("Ingrediente inválido.");
                break;
        }
        return to_return;
    }
    
}
