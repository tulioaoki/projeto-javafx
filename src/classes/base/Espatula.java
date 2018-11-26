package classes.base;
/**
 * 
 */
public class Espatula extends Item {
    
    private String sabor;
    private Cobertura cobertura;
    private Recheio recheio;

    public Espatula() {
    }
    
    public Espatula(String sabor) {
        this.sabor = sabor;
    }

    private Bolo setRecheioBolo(Bolo b) {
        if(this.recheio != null){
            b.setRecheio(this.recheio);
            return b;
        }else{
            System.err.println("Espátula sem recheio");
            return b;
        }
    }

    private Bolo setCoberturaBolo(Bolo b) {
        if(this.cobertura != null){
            b.setCobertura(this.cobertura);
            return b;
        }else{
            System.err.println("Espátula sem cobertura");
            return b;
        }
    }

    private void setRecheio(Recheio r) {
        this.recheio = r;
    }

    private void setCobertura(Cobertura c) {
        this.cobertura = c;
    }

    private Recheio getRecheio() {
        return this.recheio;
    }

    private Cobertura getCobertura() {
        return this.cobertura;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
    
    
}