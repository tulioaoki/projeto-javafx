package classes.base;

import java.util.ArrayList;

public class Bolo extends Item {

    private String sabor;
    private boolean cozido;
    private boolean queimado;

    private Cobertura cobertura;
    private Complemento complemento;
    private Recheio recheio;
    
    private boolean misturado;

    private ArrayList<Ingrediente> ingredientes;

    public Bolo() {

    }

    public boolean isMisturado() {
        return misturado;
    }

    public void setMisturado(boolean misturado) {
        this.misturado = misturado;
    }
    
    

    public String getSabor() {
        return this.sabor;
    }

    public boolean getCozido() {
        return this.cozido;
    }

    public void setCozido(boolean cozido) {
        this.cozido = cozido;
    }

    public boolean getQueimado() {
        return this.queimado;
    }

    public void setQueimado(boolean q) {
        this.queimado = q;
    }

    public Cobertura getCobertura() {
        return this.cobertura;
    }

    public void setCobertura(Cobertura c) {
        this.cobertura = c;
    }

    public Recheio getRecheio() {
        return this.recheio;
    }

    public void setRecheio(Recheio r) {
        this.recheio = r;
    }

    public void setComplemento(Complemento c) {
        this.complemento = c;
    }

    public Complemento getComplemento() {
        return this.complemento;
    }

    public ArrayList getIngredientes() {
        return this.ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> lista) {
        this.ingredientes = lista;
        for (Ingrediente ingrediente : this.ingredientes) {
                if(ingrediente.is_principal()){
                    this.sabor = ingrediente.getNome();
                    break;
                }
            }
    }

    public boolean addIngredientes(Ingrediente i) {
        boolean has_principal = false;
        if (i.is_principal()) {
            for (Ingrediente ingrediente : this.ingredientes) {
                if(ingrediente.is_principal()){
                    has_principal = true;
                    break;
                }
            }
            if(!has_principal){
                this.ingredientes.add(i);
                this.sabor = i.getNome();
                return true;
            }else{
                return false;
            }
        }else{
            for (Ingrediente ingrediente : this.ingredientes) {
                if(ingrediente.getNome().equalsIgnoreCase(i.getNome())){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean hasValidIngredients() {
        // @TODO implement here
        return false;
    }

    @Override
    public String toString() {
        return "Bolo{" + "sabor=" + sabor + ", cozido=" + cozido + ", queimado=" + queimado + ", cobertura=" + cobertura + ", complemento=" + complemento + ", recheio=" + recheio + ", ingredientes=" + ingredientes + '}';
    }
    
    
    
}
