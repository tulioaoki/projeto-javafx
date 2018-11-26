package classes.base;
/**
 * 
 */
public class Forma extends Item {
    private Bolo massa;

    public Forma() {
    }

    public void Enformar(Bolo bolo) {
        this.massa = bolo;
    }

    public Bolo Desenformar() {
        Bolo aux = this.massa;
        this.massa = null;
        return aux;
    }

    public void assarBolo() {
        this.massa.setCozido(true);
    }

    public void queimarBolo() {
        this.massa.setQueimado(true);
    }
    
    public boolean has_massa(){
        return this.massa != null;
    }
    
}