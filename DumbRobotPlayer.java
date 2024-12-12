import java.util.*;
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
        String resourcetype = "DIAMOND";
        for(int k = 0; k < 5; k++){
            if(getAvailableResources().getNbResource(board.getAvailableResources().get(k)) >= 4){
                if (k == 0 ){
                    resourcetype = "DIAMOND";
                }
                if (k == 1 ){
                    resourcetype = "SAPPHIRE";
                }
                if (k == 2 ){
                    resourcetype = "EMERALD";
                }
                if (k == 3 ){
                    resourcetype = "RUBY";
                }
                if (k == 4 ){
                    resourcetype = "ONYX";
                }
                PickSameTokensAction psta = new PickSameTokensAction(resourcetype);
                return psta;
                }
            }
        int[] r=board.getResourcesOnBoard().getResources();
        ArrayList<String> type=new ArrayList<String>();
        for(int i=0;i<5;i++){
            if(r[i]>0){
                if(i==0){
                    type.add("DIAMOND");
                }
                if(i==1){
                    type.add("SAPPHIRE");
                }
                if(i==2){
                    type.add("EMERALD");
                }
                if(i==3){
                    type.add("RUBY");
                }
                if(i==4){
                    type.add("ONYX");
                }
            }
        }
        PassAction pa = new PassAction();
        return pa;        
    }
}
