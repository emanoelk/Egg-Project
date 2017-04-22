package store;
 
public class Follow {
 
    int id;
    String farmName;
    String description;
    int user_Id;
     
    public Follow (){}
     
    public Follow (int id, String farmName, String description, int user_Id){
        super();
        this.farmName = farmName;
        this.description = description;
        this.id = id;
        this.user_Id = user_Id;
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

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
    
}