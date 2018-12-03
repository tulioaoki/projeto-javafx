package classes.base;

import java.util.ArrayList;

public class Cobertura extends Item {

    private String sabor;
    private final ArrayList opcoes;

    public Cobertura(String sabor) {
        opcoes = new ArrayList();
        opcoes.add("limao");
        opcoes.add("laranja");
        opcoes.add("chocolate");
        opcoes.add("chantilly");
        opcoes.add("creme");
        opcoes.add("glace");
        opcoes.add("morango");
        if (opcoes.contains(sabor)) {
            this.sabor = sabor;
        } else {
            System.err.println("Sabor de cobertura invalida");
        }
    }

    public Cobertura() {
        opcoes = new ArrayList();
        opcoes.add("limao");
        opcoes.add("laranja");
        opcoes.add("chocolate");
        opcoes.add("chantilly");
        opcoes.add("creme");
        opcoes.add("glace");
        opcoes.add("morango");
    }

    public String getSabor() {
        return this.sabor;
    }

    private void setSabor(String sabor) {
        if (opcoes.contains(sabor)) {
            this.sabor = sabor;
        } else {
            System.err.println("Sabor de cobertura invalida");
        }
    }

    @Override
    public String toString() {
        return "Cobertura{" + "sabor=" + sabor + '}';
    }
    
}
