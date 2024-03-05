public class Drink extends Product {
	private boolean isFizzy;
	
	Drink(String name, float price, float calories, int quantity, boolean isFizzy) {
		super(name, price, calories, quantity);
		this.isFizzy = isFizzy;
	}
	public boolean IsFizzy() {
		return isFizzy;
	}
}