
public class DumbRobotPlayer extends Player
{
    public DumbRobotPlayer(int id, String name){
        super(id,name);
    }
    
    public Action chooseAction(Board board){
        for(int i = 0; i < 3; i++){
            for(int j = 0; i < 4; j++){
                if(canBuyCard(board.getCard(i, j))){
                    BuyCardAction bca = new BuyCardAction();
                    return bca;
                }
            }
        }
        for(int k = 0; k < 5; k++){
            if(getNbResource(board.getAvailableResources().get(k)) >= 4){
                PickSameTokensAction psta = new PickSameTokensAction();
                return psta;
            }
        }
        if(canBuyCard(board.getCard(i, j))){
            BuyCardAction bca = new BuyCardAction();
            return bca;
        }
        if(canBuyCard(board.getCard(i, j))){
            BuyCardAction bca = new BuyCardAction();
            return bca;
        }
    }
}
