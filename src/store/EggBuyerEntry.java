package store;
 
public class EggBuyerEntry {
 
    String farm;
    double price;
    int quantity;
 
    public EggBuyerEntry(String farm, double price, int quantity) {
        super();
        this.farm = farm;
        this.price = price;
        this.quantity = quantity;
    }
 
    public String getFarm() {
        return farm;
    }
 
    public void setItemname(String farm) {
        this.farm = farm;
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