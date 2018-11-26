package builders;

import classes.base.Bolo;
import classes.base.Bowl;
import classes.base.Cozinha;
import classes.base.Espatula;
import classes.base.Forma;
import classes.base.Forno;

/**
 *
 * @author tulioaoki
 */

public class CozinhaBuilder {
    
    private Bolo receita;
    private Forno forno;
    private Bowl bowl;
    private Espatula espatula;
    private Forma forma;
    private final GeradorReceita geradorReceita;
    
    public CozinhaBuilder(){
        geradorReceita = new GeradorReceita();
        receita = geradorReceita.gerarReceita();
        forno = new Forno();
        bowl = new Bowl();
        espatula = new Espatula();
        forma = new Forma();
    }
    
    public Cozinha getCozinha(){
        Cozinha nova = new Cozinha(receita, forno,bowl,espatula,forma);
        return nova;
    }
    
    public Cozinha getNewCozinha(){
        receita = geradorReceita.gerarReceita();
        forno = new Forno();
        bowl = new Bowl();
        espatula = new Espatula();
        forma = new Forma();
        Cozinha nova = new Cozinha(receita, forno,bowl,espatula,forma);
        return nova;
    }
    
}
