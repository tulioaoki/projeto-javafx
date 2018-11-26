package builders;

import classes.base.Recheio;

/**
 *
 * @author tulioaoki
 */
public class RecheioBuilder {
    
    public void RecheioBuider(){
        //empty
    }
    
    public Recheio getRecheio(String nome){
        Recheio to_return;
        switch(nome){
            case "creme":
                to_return = new Recheio(nome);
                break;
            case "chocolate":
                to_return = new Recheio(nome);
                break;
            case "morango":
                to_return = new Recheio(nome);
                break;
            case "leite":
                to_return = new Recheio(nome);
                break;
            case "coco":
                to_return = new Recheio(nome);
                break;
            default:
                to_return = null;
                System.err.println("Recheio inválido.");
                break;
        }
        return to_return;
    }
    
    
}

