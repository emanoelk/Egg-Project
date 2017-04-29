package Store;

public class EggHistoryEntry {

	String name;
	String email;
	String farm;
	double price;
	int quantity;

	public EggHistoryEntry(String name, String email, String farm, double price, int quantity) {
		super();
		this.name = name;
		this.email = email;
		this.farm = farm;
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