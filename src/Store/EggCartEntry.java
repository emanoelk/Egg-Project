package Store;
public class EggCartEntry {
		String name;
		double price;
		int quantity;
		double itemcost;

		public EggCartEntry(String name, double price, int quantity) {
			super();
			this.name = name;
			this.price = price;
			this.quantity = quantity;
			itemcost = price * quantity;

		}

		public double getItemcost() {
			return itemcost;
		}

		public void setItemcost(double itemcost) {
			this.itemcost = itemcost;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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