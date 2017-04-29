package store;

public class FarmInventoryEntry {

    int id;
    String farmName;
    String description;
     
    public FarmInventoryEntry (){}
     
    public FarmInventoryEntry (int id, String farmName, String description){
        super();
        this.farmName = farmName;
        this.description = description;
        this.id = id;
    }
 
    public int getId() {
        return id;
    }
 
    public String getFarmName() {
        return farmName;
    }
 
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
     
    public String getDescription(){
        return description;
    }
 
    public void setDescription(String description){
        this.description = description;
    }
 
}