
/**
 * Décrivez votre classe DiscardTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class DiscardTokensAction implements Action
{   
    public Resources discardRessources;
    
    public DiscardTokensAction(Resources discardRessources){
        this.discardRessources=discardRessources;
    }
    
    public void process(Player joueur,Board plateau){
        int[] couts= discardRessources.getResources();
        joueur.updateNbResource("DIAMOND",-couts[0]);
        joueur.updateNbResource("SAPPHIRE",-couts[1]);
        joueur.updateNbResource("EMERALD",-couts[2]);
        joueur.updateNbResource("RUBY",-couts[3]);
        joueur.updateNbResource("ONYX",-couts[4]);
    }
    
    public String toString(){
        return "Vous avez retirer";
    }
    
    
}
