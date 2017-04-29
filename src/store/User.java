package Store;
 
public class User {
 
    int user_id;
    String userName;
    String password;
    String type;
     
    public User (){}
     
    public User (int user_id, String userName, String password, String type){
        super();
        this.userName = userName;
        this.password = password;
        this.user_id = user_id;
        this.type = type;
    }
 
	public int getUser_id() {
		return user_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
 
	
   
 
}