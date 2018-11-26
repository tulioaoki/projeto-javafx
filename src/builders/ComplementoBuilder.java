package builders;

import classes.base.Complemento;

/**
 *
 * @author tulioaoki
 */
public class ComplementoBuilder {
    
    public void ComplementoBuider(){
        //empty
    }
    
    public Complemento getComplemento(String nome){
        Complemento to_return;
        switch(nome){
            case "laranja":
                to_return = new Complemento(nome);
                break;
            case "granulado":
                to_return = new Complemento(nome);
                break;
            case "morango":
                to_return = new Complemento(nome);
                break;
            case "raspas-limao":
                to_return = new Complemento(nome);
                break;
            case "coco":
                to_return = new Complemento(nome);
                break;
            case "marsh":
                to_return = new Complemento(nome);
                break;
            case "crocante":
                to_return = new Complemento(nome);
                break;
            default:
                to_return = null;
                System.err.println("Complemento inválido.");
                break;
        }
        return to_return;
    }
}

