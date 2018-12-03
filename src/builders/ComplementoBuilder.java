package builders;

import classes.base.Complemento;
import java.util.ArrayList;

/**
 *
 * @author tulioaoki
 */
public class ComplementoBuilder {
    private ArrayList opcoes;
    public ComplementoBuilder(){
        opcoes = new ArrayList();
        opcoes.add("morango");
        opcoes.add("laranja");
        opcoes.add("granulado");
        opcoes.add("limao");
        opcoes.add("cereja");
        opcoes.add("marsh");
    }
    
    public Complemento getComplemento(String nome){
        if(opcoes.contains(nome)) return new Complemento(nome);
        System.err.println("Complemento inválido.");
        return null;
    }
}

