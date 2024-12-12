
public class BuyCardAction implements Action
{
    public DevCard carte;
    
    public BuyCardAction(DevCard carte){
        this.carte=carte;
    }
    
    public void process(Player joueur,Board plateau){
        plateau.updateCard(carte);
        joueur.addPurchasedCard(carte);
        int[] couts= carte.getCost().getResources();
        joueur.updateNbResource("DIAMOND",-couts[0]);
        joueur.updateNbResource("SAPPHIRE",-couts[1]);
        joueur.updateNbResource("EMERALD",-couts[2]);
        joueur.updateNbResource("RUBY",-couts[3]);
        joueur.updateNbResource("ONYX",-couts[4]);
        
    }
    
    public String toString(){
        return "Vous avez acheté "+carte+" !";
    }
}
