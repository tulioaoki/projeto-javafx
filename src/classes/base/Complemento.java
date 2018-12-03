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
        opcoes.add("limao");
        opcoes.add("cereja");
        opcoes.add("marsh");
    }
    
    public Complemento(String nome){
        opcoes = new ArrayList();
        opcoes.add("morango");
        opcoes.add("laranja");
        opcoes.add("granulado");
        opcoes.add("limao");
        opcoes.add("cereja");
        opcoes.add("marsh");
        if(opcoes.contains(nome)) this.nome = nome;
        else{
            System.out.println("COMPLEMENTO INVALIDO AQUI");
            System.err.println("Complemento invalido");
        }
    }
    
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
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