package store;
  
public class Farm {
       
    int farmId;
    String farmName;
    String description;
    int inventory;
    int Farmer_Id;
       
    public Farm (){}
       
    public Farm (int farmId, String farmName, String description, int inventory, int Farmer_Id){
        super();
        this.farmName = farmName;
        this.description = description;
        this.farmId = farmId;
        this.inventory = inventory;
        this.Farmer_Id = Farmer_Id;
    }
   
    public int getFarmId() {
        return farmId;
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
  
    public int getInventory() {
        return inventory;
    }
  
    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
  
    public int getFarmer_Id() {
        return Farmer_Id;
    }
  
    public void setFarmer_Id(int Farmer_Id) {
        this.Farmer_Id = Farmer_Id;
    }
      
      
   
}