public class Snack extends Product {
	private String size;

	Snack(String name, float price, float calories, int quantity, String size) {
		super(name, price, calories, quantity);
		this.size = size;
	}
	public String getSize() {
		return size;
	}
}