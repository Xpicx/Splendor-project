
/**
 * Décrivez votre classe PickDiffTokensAction ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PickDiffTokensAction
{
    private String type1;
    private String type2;
    private String type3;


    /**
     * Constructeur d'objets de classe PickDiffTokensAction
     */
    public PickDiffTokensAction(String type1,String type2,String type3)
    {
        this.type1=type1;
        this.type2=type2;
        this.type3=type3;
    }

    public void process(Player joueur,Board plateau){
        plateau.updateNbResource(type1,-1);
        joueur.updateNbResource(type1,1);
        plateau.updateNbResource(type2,-1);
        joueur.updateNbResource(type2,1);
        plateau.updateNbResource(type3,-1);
        joueur.updateNbResource(type3,1);
        
    }
    
    public String toString(){
        return "Vous avez pris: 1"+type1+", 1"+type2+", 1"+type3+". ";
    }
}
