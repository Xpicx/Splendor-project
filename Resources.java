import java.util.ArrayList;

public class Resources {    
    private int[] resources;

    /**
     * Constructeur d'objets de classe Resources
     */
    public Resources() {
        resources = new int[5];
    }
    
    public Resources(int coutDiamond, int coutSapphire, int coutEmerald, int coutRuby, int coutOnyx) {
        resources = new int[5];
        setNbResource(Resource.DIAMOND, coutDiamond);
        setNbResource(Resource.SAPPHIRE, coutSapphire);
        setNbResource(Resource.EMERALD, coutEmerald);
        setNbResource(Resource.RUBY, coutRuby);
        setNbResource(Resource.ONYX, coutOnyx);
    }
    
    public int getNbResource(Resource resource) {
        return resources[resource.ordinal()];
    }
    
    public void setNbResource(Resource resource, int quantity) {
        if (quantity > 0) {
            resources[resource.ordinal()] = quantity;
        }
    }
    
    public void updateNbResource(Resource resource, int quantity) {
        if (resources[resource.ordinal()] + quantity >= 0) {
            resources[resource.ordinal()] += quantity;
        }
    }
    
    public ArrayList<Resource> getAvailableResources() {
        ArrayList<Resource> result = new ArrayList<Resource>();
        for (int i = 0; i < resources.length; i++) {
            if (resources[i] > 0) {
                result.add(Resource.values()[i]);
            }
        }
        return result;
    }
}

