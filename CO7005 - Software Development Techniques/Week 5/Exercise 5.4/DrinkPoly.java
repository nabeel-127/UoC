public class DrinkPoly extends ProductPoly {
	private boolean isFizzy;
	
	DrinkPoly(String name, float price, float calories, int quantity, boolean isFizzy) {
		super(name, price, calories, quantity);
		this.isFizzy = isFizzy;
	}
	public boolean IsFizzy() {
		return isFizzy;
	}
	public void consume() {
		System.out.println("Glug, glug, glug.");
	}
}