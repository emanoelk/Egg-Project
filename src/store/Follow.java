package store;
  
public class Follow {
       
    int id;
    int farmId;
    String farmName;
    int user_Id;
    String descriptin;
       
    public Follow (){}
       
    public Follow (int id, int farmId, String farmName, String descriptin, int user_Id){
        super();
        this.id = id;
        this.farmId = farmId;
        this.farmName = farmName; 
        this.descriptin = descriptin;   
        this.user_Id = user_Id;
    }
   
    public int getId() {
        return id;
    }
  
      
   
    public int getFarmId() {
        return farmId;
    }
  
    public void setFarmId(int farmId) {
        this.farmId = farmId;
    }
  
    public String getfarmName() {
        return farmName;
    }
   
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }
      
    public String getDescriptin() {
        return descriptin;
    }
  
    public void setDescriptin(String descriptin) {
        this.descriptin = descriptin;
    }
  
    public int getUser_Id() {
        return user_Id;
    }
  
    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }
      
}