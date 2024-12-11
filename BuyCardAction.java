
/**
 * Décrivez votre classe BuyCardAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class BuyCardAction implements Action
{
    private Player joueur;
    private Board plateau;
    
    public BuyCardAction(Player joueur,Board plateau){
        this.joueur=joueur;
        this.plateau=plateau;
    }
    
    public void process(){
        
    }
    
    public String toString(){
        return null;
    }
}
