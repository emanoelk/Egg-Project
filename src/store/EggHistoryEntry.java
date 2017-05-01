package store;
 
public class EggHistoryEntry {
 
    String name;
    String email;
    double price;
    int quantity;
 
    public EggHistoryEntry(String name, String email, double price, int quantity) {
        super();
        this.name = name;
        this.email = email;
        this.price = price;
        this.quantity = quantity;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
 
    public double getPrice() {
        return price;
    }
 
    public void setPrice(double price) {
        this.price = price;
    }
 
    public int getQuantity() {
        return quantity;
    }
 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
 
}