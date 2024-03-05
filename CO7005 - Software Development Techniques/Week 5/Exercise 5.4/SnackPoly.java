public class SnackPoly extends ProductPoly {
	private String size;

	SnackPoly(String name, float price, float calories, int quantity, String size) {
		super(name, price, calories, quantity);
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	public void consume() {
		System.out.println("Chomp!");
	}
}