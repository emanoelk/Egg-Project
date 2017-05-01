package store;
 
public class Comment {
    int id;
    String message;
    String userName;
    int user_Id;
    int farmId;
      
     public Comment (){}
       
        public Comment (int id, String userName, String message, int user_Id, int farmId){
            super();
            this.id = id;
            this.userName = userName;
            this.message = message;
            this.user_Id = user_Id;
            this.farmId = farmId;
        }
  
        public int getId() {
            return id;
        }
  
        public void setId(int id) {
            this.id = id;
        }
          
          
          
        public String getUserName() {
            return userName;
        }
  
        public void setUserName(String userName) {
            this.userName = userName;
        }
  
        public String getMessage() {
            return message;
        }
  
        public void setMessage(String message) {
            this.message = message;
        }
  
        public int getUser_Id() {
            return user_Id;
        }
  
        public void setUser_Id(int user_Id) {
            this.user_Id = user_Id;
        }
  
        public int getFarmId() {
            return farmId;
        }
  
        public void setFarmId(int farmId) {
            this.farmId = farmId;
        }
          
          
}