package classes.base;

import java.util.ArrayList;

/**
 * 
 */
public class Complemento extends Item {
    
    private String nome;
    private final ArrayList opcoes;
    
    public Complemento() {
        opcoes = new ArrayList();
        opcoes.add("morango");
        opcoes.add("laranja");
        opcoes.add("granulado");
        opcoes.add("raspas-limao");
        opcoes.add("coco");
        opcoes.add("marsh");
        opcoes.add("crocante");
    }
    
    public Complemento(String nome){
        opcoes = new ArrayList();
        opcoes.add("morango");
        opcoes.add("laranja");
        opcoes.add("granulado");
        opcoes.add("raspas-limao");
        opcoes.add("coco");
        opcoes.add("marsh");
        opcoes.add("crocante");
        if(opcoes.contains(nome)) this.nome = nome;
        else{
            System.err.println("Complemento invalido");
        }
    }
    
    private String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        if(opcoes.contains(nome)) this.nome = nome;
        else{
            System.err.println("Complemento invalido");
        }
    }

    @Override
    public String toString() {
        return "Complemento{" + "nome=" + nome + '}';
    }
    
}