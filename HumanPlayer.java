
public class HumanPlayer extends Player
{
    public HumanPlayer(int id, String name){
        super(id,name);
    }
    public Action chooseAction(){
    System.out.println("Veuillez choisir une action: ");
        System.out.println("Entrer 1 pour: Prendre deux jetons de la même ressource");
        System.out.println("Entrer 2 pour: Prendre trois jetons de ressources différentes");
        System.out.println("Entrer 3 pour: Acheter une carte développement");
        Scanner scanner=new Scanner(System.in);
        int choix=scanner.nextInt(); //Lecture entrée clavier
        
        //Choix que peut faire le joueur
        while(choix!=1 || choix!=2 || choix!=3){
            System.out.println("Choisir un chiffre entre 1 et 3");
            choix=scanner.nextInt();
        }
        
        if(choix==1){
            System.out.println("Veuiller entrer un type de ressource");
            String choixRessource=scanner.nextLine();
            while(choixRessource.equals("DIAMOND") || choixRessource.equals("SAPHIRE") || choixRessource.equals("EMERALD") || choixRessource.equals("RUBY") || choixRessource.equals("ONYX") ){
                System.out.println("Veuiller choisir un type de ressource");
                choix=scanner.nextInt();
            }
            PickSameTokensAction action= new PickSameTokensAction(player,board,choixRessource);
        }
        if(choix==2){
            PickDiffTokensAction action=new PickDiffTokensAction(player,board);
        }
        if(choix==3){
            BuyCardAction action=new BuyCardAction(player,board);
        }
    }
    
}
