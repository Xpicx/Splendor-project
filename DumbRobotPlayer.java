
public class DumbRobotPlayer extends Player
{
    public DumbRobotPlayer(int id, String name){
        super(id,name);
    }
    
    public Action chooseAction(Board board){
        for(int i = 0; i < 3; i++){
            for(int j = 0; i < 4; j++){
                if(canBuyCard(board.getCard(i, j))){
                    BuyCardAction bca = new BuyCardAction(board.getCard(i, j));
                    return bca;
                }
            }
        }
        for(int k = 0; k < 5; k++){
            if(getAvailableResources().getNbResource(board.getAvailableResources().get(k)) >= 4){
                if (k == 0 ){
                    String resourceType = "DIAMOND";
                }
                if (k == 1 ){
                    String resourceType = "SAPPHIRE";
                }
                if (k == 2 ){
                    String resourceType = "EMERALD";
                }
                if (k == 3 ){
                    String resourceType = "RUBY";
                }
                if (k == 4 ){
                    String resourceType = "ONYX";
                }
                PickSameTokensAction psta = new PickSameTokensAction(resourceType);
                return psta;
                }
            }
        
        String type1 = "DIAMOND";
        String type2 = "SAPPHIRE";
        String type3 = "EMERALD";
        
            if(){
            PickDiffTokensAction pdta = new PickDiffTokensAction();
            return pdta;
        }
        else{
            PassAction pa = new PassAction();
            return pa;
        }
    }
}
