/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import classes.base.Cobertura;
import java.util.ArrayList;

/**
 *
 * @author tulioaoki
 */
public class CoberturaBuilder {
    
    private ArrayList opcoes;
    
    public CoberturaBuilder(){
        opcoes = new ArrayList();
        opcoes.add("limao");
        opcoes.add("laranja");
        opcoes.add("chocolate");
        opcoes.add("chantilly");
        opcoes.add("creme");
        opcoes.add("glace");
        opcoes.add("morango");
    }
    
    public Cobertura getCobertura(String nome){
        if(opcoes.contains(nome)) return new Cobertura(nome);
        System.err.println("Cobertura inválida.");
        return null;
    }
    
    
}
