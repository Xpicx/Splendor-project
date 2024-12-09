import java.io.File;
import java.io.FileNotFoundException;
import java.util.Stack;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.Collections;
import java.util.Random;

public class Board implements Displayable {
    private DevCard[][] visibleCards;
    private ArrayList<Stack<DevCard>> stackCards;
    private Resources resourcesOnBoard;
    private ArrayList<DevCard> pileCartes;
    
    public Board(int nbPlayer) {
        //initialisation de la liste contenant les piles de cartes
        stackCards = new ArrayList<Stack<DevCard>>();
        
        //initialisation du tableau contenant les cartes visibles
         visibleCards = new DevCard[3][4];
         
        //initialisation du nombre de jetons en fonction du nombre de joueurs
        if (nbPlayer > 1 && nbPlayer < 5) {
            if (nbPlayer == 2) {
                resourcesOnBoard = new Resources(4, 4, 4, 4, 4);
            } else if (nbPlayer == 3) {
                resourcesOnBoard = new Resources(5, 5, 5, 5, 5);
            } else {
                resourcesOnBoard = new Resources(7, 7, 7, 7, 7);
            }
        }
        
        //lecture du fichier stat.csv
        pileCartes=new ArrayList<DevCard>();
        try
        {
        Scanner sc=new Scanner(new File("stats.csv"));
        String ligneFichier=sc.nextLine();
        Random rand=new Random();
        stackCards.add(new Stack<DevCard>());
        stackCards.add(new Stack<DevCard>());
        stackCards.add(new Stack<DevCard>());
        for(int i=0;i<98;i++){
            ligneFichier=sc.nextLine();
            String infoCarte[]=ligneFichier.split(",");
            if(infoCarte[7]!="NOBLE"){
                DevCard carte=new DevCard(Integer.parseInt(infoCarte[0]),Integer.parseInt(infoCarte[1]),Integer.parseInt(infoCarte[2]),Integer.parseInt(infoCarte[3]),Integer.parseInt(infoCarte[4]),Integer.parseInt(infoCarte[5]),Integer.parseInt(infoCarte[6]),infoCarte[7]);
                pileCartes.add(carte);  
        }
        }
        
        //initialisation des trois paquets de cartes
        for(int i=0;i<98;i++){
            int index=rand.nextInt(pileCartes.size());
            if(pileCartes.get(index).getNiveaux()==1){
                stackCards.get(0).add(pileCartes.get(index));
            }
            if(pileCartes.get(index).getNiveaux()==2){
                stackCards.get(1).add(pileCartes.get(index));
            }
            if(pileCartes.get(index).getNiveaux()==3){
                stackCards.get(2).add(pileCartes.get(index));
            }
                        
        }
        
        for(int i=0;i<stackCards.get(0).size();i++){
            System.out.println(stackCards.get(0).get(i));
        }
        }
        catch (FileNotFoundException fnfe)
        {
            fnfe.printStackTrace();
        }
        
        //initialisation des cartes visibles
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                visibleCards[i][j] = stackCards.get(i).pop();
            }
        }
    }
    
    public int getNbResource(String resource) {
        return resourcesOnBoard.getNbResource(resource);
    }
    
    public void setNbResource(String resource, int value) {
        resourcesOnBoard.setNbResource(resource, value);
    }
    
    public void updateNbResource(String resource, int value) {
        resourcesOnBoard.updateNbResource(resource, value);
    }
    
    public ArrayList<Resource> getAvailableResources() {
        return resourcesOnBoard.getAvailableResources();
    }
    
    
    /* --- Stringers --- */

    private String[] deckToStringArray(int tier){
        /** EXAMPLE
         * ┌────────┐
         * │        │╲ 
         * │ reste: │ │
         * │   16   │ │
         * │ cartes │ │
         * │ tier 3 │ │
         * │        │ │
         * └────────┘ │
         *  ╲________╲│
         */
        int nbCards = 0; //- AREMPLEACER par le nombre de cartes présentes
        String[] deckStr = {"\u250C\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510  ",
                            "\u2502        \u2502\u2572 ",
                            "\u2502 reste: \u2502 \u2502",
                            "\u2502   "+String.format("%02d", nbCards)+"   \u2502 \u2502",
                            "\u2502 carte"+(nbCards>1 ? "s" : " ")+" \u2502 \u2502",
                            "\u2502 tier "+tier+" \u2502 \u2502",
                            "\u2502        \u2502 \u2502",
                            "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518 \u2502",
                            " \u2572________\u2572\u2502"};
        return deckStr;
    }

    private String[] resourcesToStringArray(){
        /** EXAMPLE
         * Resources disponibles : 4♥R 4♣E 4♠S 4♦D 4●O
         */
        String[] resStr = {"Resources disponibles : "};
        /*
         * A decommenter
        for(ACOMPLETER){ //-- parcourir l'ensemble des resources (res) en utilisant l'énumération Resource
            resStr[0] += resources.getNbResource(res)+res.toSymbol()+" ";
        }
                 */
        resStr[0] += "        ";
        return resStr;
    }

    private String[] boardToStringArray(){
        String[] res = Display.emptyStringArray(0, 0);
        /*
         * 

        //Deck display
        String[] deckDisplay = Display.emptyStringArray(0, 0);
        for(int i=stackCards.size();i>0;i--){
            deckDisplay = Display.concatStringArray(deckDisplay, deckToStringArray(i), true);
        }

        //Card display
        String[] cardDisplay = Display.emptyStringArray(0, 0);
        for(ACOMPLETER){ //-- parcourir les différents niveaux de carte (i)
            String[] tierCardsDisplay = Display.emptyStringArray(8, 0);
            for(ACOMPLETER){ //-- parcourir les 4 cartes faces visibles pour un niveau donné (j)
                tierCardsDisplay = Display.concatStringArray(tierCardsDisplay, visibleCards[i][j]!=null ? visibleCards[i][j].toStringArray() : DevCard.noCardStringArray(), false);
            }
            cardDisplay = Display.concatStringArray(cardDisplay, Display.emptyStringArray(1, 40), true);
            cardDisplay = Display.concatStringArray(cardDisplay, tierCardsDisplay, true);
        }
        
        res = Display.concatStringArray(deckDisplay, cardDisplay, false);
        res = Display.concatStringArray(res, Display.emptyStringArray(1, 52), true);
        res = Display.concatStringArray(res, resourcesToStringArray(), true);
        res = Display.concatStringArray(res, Display.emptyStringArray(35, 1, " \u250A"), false);
        res = Display.concatStringArray(res, Display.emptyStringArray(1, 54, "\u2509"), true);
                 */
        return res;
    }

    @Override
    public String[] toStringArray() {
        return boardToStringArray();
    }
}
