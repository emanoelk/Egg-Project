package store;
 
public class Farm {
 
    int id;
    String farmName;
    String description;
     
    public Farm (){}
     
    public Farm (int id, String farmName, String description){
        super();
        this.farmName = farmName;
        this.description = description;
        this.id = id;
    }
 
    public int getId() {
        return id;
    }
 
    public String getfarmName() {
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