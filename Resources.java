import java.util.ArrayList;

public class Resources {    
    private int[] resources; //liste d'entiers ordonnée selon l'ordre des types de ressource dans l'énumération Resource

    /**
     * Constructeur par défaut : initialise toutes les ressources à 0.
     */
    public Resources() {
        resources = new int[Resource.values().length];
    }

    /**
     * Constructeur qui initialise toutes les ressources à partir de valeurs données.
     */
    public Resources(int coutDiamond, int coutSapphire, int coutEmerald, int coutRuby, int coutOnyx) {
        resources = new int[Resource.values().length];
        setNbResource("DIAMOND", coutDiamond);
        setNbResource("SAPPHIRE", coutSapphire);
        setNbResource("EMERALD", coutEmerald);
        setNbResource("RUBY", coutRuby);
        setNbResource("ONYX", coutOnyx);
        }
    }

    /**
     * Renvoie la quantité disponible d'un type de ressource, passé en paramètre
     */
    public int getNbResource(String resource) {
        int result = 0;
        if (resource.equals("DIAMOND")) {
            result = resources[0];
        }
        if (resource.equals("SAPPHIRE")) {
            result = resources[1];
        }
        if (resource.equals("EMERALD")) {
            result = resources[2];
        }
        if (resource.equals("RUBY")) {
            result = resources[3];
        }
        if (resource.equals("ONYX")) {
            result = resources[4];
        }
        return result;
    }

    /**
     * Réécriture de getNbResource, qui prends en paramètre un type de ressource
     */
    public int getNbResource(Resource resource) {
        return resources[resource.ordinal()];
    }    

    /**
     * Change la valeur d'une ressource, passée en paramètre par un entier positif ou nul, passé en paramètre.
     */
    public void setNbResource(String resource, int quantity) {
        if (quantity > 0) {
            if (resource.equals("DIAMOND")) {
                resources[0] = quantity;
            }
            if (resource.equals("SAPPHIRE")) {
                resources[1] = quantity;
            }
            if (resource.equals("EMERALD")) {
                resources[2] = quantity;
            }
            if (resource.equals("RUBY")) {
                resources[3] = quantity;
            }
            if (resource.equals("ONYX")) {
                resources[4] = quantity;
            }
        }
    }

    /**
     * Met a jour une ressource passée en paramètre, avec un entier passé en paramètre.
     * Vérifie que la nouvelle valeur de la ressource est positive ou nulle.
     */
    public void updateNbResource(String resource, int quantity) {
        if (resource.equals("DIAMOND")) {
            if (resources[0] + quantity >= 0) {
                resources[0] += quantity;
            }
        }
        if (resource.equals("SAPPHIRE")) {
            if (resources[1] + quantity >= 0) {
                resources[1] += quantity;
            }
        }
        if (resource.equals("EMERALD")) {
            if (resources[2] + quantity >= 0) {
                resources[2] += quantity;
            }
        }
        if (resource.equals("RUBY")) {
            if (resources[3] + quantity >= 0) {
                resources[3] += quantity;
            }
        }
        if (resource.equals("ONYX")) {
            if (resources[4] + quantity >= 0) {
                resources[4] += quantity;
            }
        }
    
    }

    /**
     * Renvoie une liste contenant les ressources pour lesquelles le quantité est supérieure à zéro
     */
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

