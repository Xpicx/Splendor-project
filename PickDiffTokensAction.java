
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
    private Player joueur;
    private Board plateau;

    /**
     * Constructeur d'objets de classe PickDiffTokensAction
     */
    public PickDiffTokensAction(Player joueur,Board plateau,String type1,String type2,String type3)
    {
        this.type1=type1;
        this.type2=type2;
        this.type3=type3;
        this.joueur=joueur;
        this.plateau=plateau;
    }

    public void process(){
        
    }
    
    public String toString(){
        return "Vous avez pris"+type1+", "+type2+", "+type3+". ";
    }
}