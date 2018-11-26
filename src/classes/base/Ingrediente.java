package classes.base;

public class Ingrediente extends Item {
    
    private final String nome;
    private final boolean principal;
    
    public Ingrediente(String nome) {
        this.nome = nome;
        switch(nome){
            case "chocolate":
                principal = true;
                break;
            case "baunilha":
                principal = true;
                break;
            case "morango":
                principal = true;
                break;
            case "laranja":
                principal = true;
                break;
            case "limao":
                principal = true;
                break;
            default:
                principal = false;
                break;
        }
    }
    
    public boolean is_principal(){
        return this.principal;
    }
    
    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "nome=" + nome + ", principal=" + principal + '}';
    }
    
}