import java.util.ArrayList;
public abstract class Player implements Displayable {
    private int id;
    private String name;
    private int points;
    private ArrayList<DevCard> purchasedCards;
    private Resources resources;
    
    public Player(int id, String name){
        this.id = id;
        this.name = name;
        purchasedCards = new ArrayList<DevCard>();
        points = 0;
        resources = new Resources(0,0,0,0,0);
    }
    /* --- Stringers --- */
    public String[] toStringArray(){
        /** EXAMPLE. The number of resource tokens is shown in brackets (), and the number of cards purchased from that resource in square brackets [].
         * Player 1: Camille
         * ⓪pts
         * 
         * ♥R (0) [0]
         * ●O (0) [0]
         * ♣E (0) [0]
         * ♠S (0) [0]
         * ♦D (0) [0]
         */
        String pointStr = " ";
        String[] strPlayer = new String[8];
         
            /* A decommenter une fois la classe implémentée */
        if(points>0){
            pointStr = new String(new int[] {getPoints()+9311}, 0, 1);
        }else{
            pointStr = "\u24EA";
        }

        
        strPlayer[0] = "Player "+(id+1)+": "+name;
        strPlayer[1] = pointStr + "pts";
        strPlayer[2] = "";
        for(Resource res:Resource.values()){ //-- parcourir l'ensemble des resources (res) en utilisant l'énumération Resource
            strPlayer[3+(Resource.values().length-1-res.ordinal())] = res.toSymbol() + " ("+resources.getNbResource(res)+") ["+getResFromCards(res)+"]";
        }
        
        return strPlayer;
    }
    
    public String getName(){
        return name;
    }
    
    public int getPoints(){
        return points;
    }
    
    public int getNbTokens(){
        int res = 0;
        res += resources.getNbResource("DIAMOND");
        res += resources.getNbResource("SAPPHIRE");
        res += resources.getNbResource("EMERALD");
        res += resources.getNbResource("ONYX");
        res += resources.getNbResource("RUBY");  
        return res;
        
    }
    
    public int getNbPurchasedCards(){
        return purchasedCards.size();
    }
    
    public int getNbResource(String resource){
        return resources.getNbResource(resource);
    }
    
    public Resources getAvailableResources(){
        return resources;
    }
    
    public int getResFromCards(Resource type){
        int res = 0;
        for(int i = 0; i < purchasedCards.size(); i++){
            DevCard card = purchasedCards.get(i);
            Resource cardType = card.getResourceType();
            if (type == cardType) {
                 res ++;
            }
        }
        return res;
    }
    
    public void updateNbResource(String type, int i){
        resources.updateNbResource(type, i);
    }
    
    public void updatePoints(int v){
        points += v;
    }
    
    public void addPurchasedCard(DevCard card){
        purchasedCards.add(card);
    }
    
    public Boolean canBuyCard(DevCard card){
        if(card.getCost().getNbResource("DIAMOND") <= resources.getNbResource("DIAMOND") &&
        card.getCost().getNbResource("SAPPHIRE") <= resources.getNbResource("SAPPHIRE" ) &&
        card.getCost().getNbResource("EMERALD") <= resources.getNbResource("EMERALD") &&
        card.getCost().getNbResource("ONYX") <= resources.getNbResource("ONYX") &&
        card.getCost().getNbResource("RUBY") <= resources.getNbResource("RUBY")){
            return true;
        }
        else{
            return false;
        }
    }
}
