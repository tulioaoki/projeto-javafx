package classes.base;

import java.util.ArrayList;

public class Recheio {
   
    private String sabor;
    private final ArrayList opcoes;
    
    public Recheio(String sabor) {
        opcoes = new ArrayList();
        opcoes.add("creme");
        opcoes.add("chocolate");
        opcoes.add("leite");
        opcoes.add("morango");
        opcoes.add("coco");
        if(opcoes.contains(sabor)) this.sabor = sabor;
        else{
            System.err.println("Sabor de recheio invalido");
        }
    }
    
    public Recheio() {
        opcoes = new ArrayList();
        opcoes.add("creme");
        opcoes.add("chocolate");
        opcoes.add("leite");
        opcoes.add("morango");
        opcoes.add("coco");
    }
    
    private String getSabor() {
        return this.sabor;
    }

    private void setSabor(String sabor) {
        opcoes.add("creme");
        opcoes.add("chocolate");
        opcoes.add("leite");
        opcoes.add("morango");
        opcoes.add("coco");
        if(opcoes.contains(sabor)) this.sabor = sabor;
        else{
            System.err.println("Sabor de recheio invalido");
        }
    }

    @Override
    public String toString() {
        return "Recheio{" + "sabor=" + sabor + '}';
    }

}