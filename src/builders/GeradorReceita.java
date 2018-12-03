package builders;
import java.security.SecureRandom;
import java.util.ArrayList;
import classes.base.Bolo;
import classes.base.Cobertura;
import classes.base.Complemento;
import classes.base.Ingrediente;

/**
 *
 * @author tulioaoki
 */

public class GeradorReceita {
    private Bolo pedido;
    SecureRandom random;
    CoberturaBuilder cobertura_builder;
    ComplementoBuilder complemento_builder;
    IngredientBuilder ingredient_builder;
    
    public GeradorReceita(){
        random = new SecureRandom();
        pedido = new Bolo(); 
        cobertura_builder = new CoberturaBuilder();
        complemento_builder = new ComplementoBuilder();
        ingredient_builder = new IngredientBuilder();

    }
    
    public Bolo gerarReceita(){
        Cobertura cobertura = this.gerarCoberturaAleatoria();
        Complemento complemento = this.gerarComplementoAleatorio();
        ArrayList ingredientes = this.gerarIngredientesAleatorios();
        pedido.setCobertura(cobertura);
        pedido.setComplemento(complemento);
        pedido.setIngredientes(ingredientes);
        pedido.setQueimado(false);
        pedido.setCozido(true);
        return pedido;
    }
    
    public ArrayList gerarIngredientesAleatorios(){
        ArrayList aux = new ArrayList();
        IngredientBuilder builder = new IngredientBuilder();
        int principal = random.nextInt(4);
        
        Ingrediente ovos = builder.getIngredient("ovos");
        Ingrediente farinha = builder.getIngredient("farinha");
        Ingrediente fermento = builder.getIngredient("fermento");
        Ingrediente acucar = builder.getIngredient("acucar");
        Ingrediente leite = builder.getIngredient("leite");
        Ingrediente manteiga = builder.getIngredient("manteiga");
        Ingrediente p;
        aux.add(ovos);
        aux.add(farinha);
        aux.add(fermento);
        aux.add(acucar);
        aux.add(leite);
        aux.add(manteiga);
        
        switch(principal){
            case 0:
                p = builder.getIngredient("chocolate");
                break;
            case 1:
                p = builder.getIngredient("morango");
                break;
            case 2:
                p = builder.getIngredient("limao");
                break;
            case 3:
                p = builder.getIngredient("laranja");
                break;
            default:
                p = null;
                System.err.println("Erro na geracao de ingrediente principal aleatorio.");
                break;
        }
        aux.add(p);
        return aux;

    }
    
    public Complemento gerarComplementoAleatorio(){
        Complemento complemento;  
        int complemento_num = random.nextInt(6);
        
        switch(complemento_num){
            case 0:
                complemento = complemento_builder.getComplemento("morango");
                break;
            case 1:
                complemento = complemento_builder.getComplemento("laranja");
                break;
            case 2:
                complemento = complemento_builder.getComplemento("granulado");
                break;
            case 3:
                complemento = complemento_builder.getComplemento("limao");
                break;
            case 4:
                complemento = complemento_builder.getComplemento("cereja");
                break;
            case 5:
                complemento = complemento_builder.getComplemento("marsh");
                break;
            default:
                complemento = null;
                System.err.println("Erro na geracao de complemento aleatorio.");
                break;
        }
        return complemento;
    }
    
    public Cobertura gerarCoberturaAleatoria(){
        int cobertura_num = random.nextInt(3);
        System.out.println(cobertura_num);
        Cobertura cobertura;

        switch(cobertura_num){
            case 0:
                cobertura = cobertura_builder.getCobertura("chocolate");
                break;
            case 1:
                cobertura = cobertura_builder.getCobertura("glace");
                break;
            case 2:
                cobertura = cobertura_builder.getCobertura("chantilly");
                break;
            case 3:
                cobertura = cobertura_builder.getCobertura("morango");
                break;
            case 4:
                cobertura = cobertura_builder.getCobertura("laranja");
                break;
            case 5:
                cobertura = cobertura_builder.getCobertura("limao");
                break;
            case 6:
                cobertura = cobertura_builder.getCobertura("creme");
                break;
            default:
                cobertura = null;
                System.err.println("Erro na geracao de cobertura aleatoria.");
                break;
        }
        
        return cobertura;
    }
    
}
