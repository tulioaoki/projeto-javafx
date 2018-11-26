package classes.base;

import java.util.ArrayList;

public class Cobertura extends Item {

    private String sabor;
    private final ArrayList opcoes;

    public Cobertura(String sabor) {
        opcoes = new ArrayList();
        opcoes.add("chantily");
        opcoes.add("ganache");
        opcoes.add("glace");
        if (opcoes.contains(sabor)) {
            this.sabor = sabor;
        } else {
            System.err.println("Sabor de cobertura invalida");
        }
    }

    public Cobertura() {
        opcoes = new ArrayList();
        opcoes.add("chantily");
        opcoes.add("ganache");
        opcoes.add("glace");
    }

    private String getSabor() {
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
