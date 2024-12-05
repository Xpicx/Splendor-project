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
        setNbResource("DIAMOND", coutDiamond);
        setNbResource("SAPPHIRE", coutSapphire);
        setNbResource("EMERALD", coutEmerald);
        setNbResource("RUBY", coutRuby);
        setNbResource("ONYX", coutOnyx);
    }
    
    public int getNbResource(String resource) {
        int result = 0;
        if (resource == "DIAMOND") {
            result = resources[0];
        }
        if (resource == "SAPPHIRE") {
            result = resources[1];
        }
        if (resource == "EMERALD") {
            result = resources[2];
        }
        if (resource == "RUBY") {
            result = resources[3];
        }
        if (resource == "ONYX") {
            result = resources[4];
        }
        return result;
    }
    
    public void setNbResource(String resource, int quantity) {
        if (quantity > 0) {
            if (resource == "DIAMOND") {
                resources[0] = quantity;
            }
            if (resource == "SAPPHIRE") {
                resources[1] = quantity;
            }
            if (resource == "EMERALD") {
                resources[2] = quantity;
            }
            if (resource == "RUBY") {
                resources[3] = quantity;
            }
            if (resource == "ONYX") {
                resources[4] = quantity;
            }
        }
    }
    
    public void updateNbResource(String resource, int quantity) {
        if (resource == "DIAMOND") {
            if (resources[0] + quantity >= 0) {
                resources[0] += quantity;
            }
        }
        if (resource == "SAPPHIRE") {
            if (resources[1] + quantity >= 0) {
                resources[1] += quantity;
            }
        }
        if (resource == "EMERALD") {
            if (resources[2] + quantity >= 0) {
                resources[2] += quantity;
            }
        }
        if (resource == "RUBY") {
            if (resources[3] + quantity >= 0) {
                resources[3] += quantity;
            }
        }
        if (resource == "ONYX") {
            if (resources[4] + quantity >= 0) {
                resources[4] += quantity;
            }
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

