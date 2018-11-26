/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import classes.base.Bolo;
import classes.base.Ingrediente;
import java.util.ArrayList;

/**
 *
 * @author tulioaoki
 */
public class  BoloBuilder {
    
    public BoloBuilder(){
        //empty
    }
    
    public Bolo buildBoloWithIngredients(ArrayList<Ingrediente> lista){
        Bolo b = new Bolo();
        for (Ingrediente i: lista){
            b.addIngredientes(i);
        }
        return b;
    }
    
}
