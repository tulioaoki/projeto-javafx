package classes.base;

public class Forno extends Item {
    private boolean ligado;
    private Forma forma;
    
    public Forno() {
    }
    
    public boolean has_forma(){
        return this.forma != null;
    }
    
    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }
    
    
    public void colocarForma(Forma f) {
        this.forma = f;
    }

    public Forma retirarForma() {
        return this.forma;
    }

    public void Assar() {
        if(this.ligado){
            this.forma.assarBolo();
        }
    }

    public void Queimar() {
        if(this.ligado){
            this.forma.assarBolo();
        }
    }
}
