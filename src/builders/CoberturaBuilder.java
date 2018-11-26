/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import classes.base.Cobertura;

/**
 *
 * @author tulioaoki
 */
public class CoberturaBuilder {
    
    public void CoberturaBuider(){
        //empty
    }
    
    public Cobertura getCobertura(String nome){
        Cobertura to_return;
        switch(nome){
            case "ganache":
                to_return = new Cobertura(nome);
                break;
            case "chantily":
                to_return = new Cobertura(nome);
                break;
            case "glace":
                to_return = new Cobertura(nome);
                break;
            default:
                to_return = null;
                System.err.println("Cobertura inválida.");
                break;
        }
        return to_return;
    }
    
    
}
