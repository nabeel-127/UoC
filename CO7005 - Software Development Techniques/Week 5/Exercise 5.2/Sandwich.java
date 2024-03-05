public class Sandwich extends Product {
	private short tomato;
	private short lettuce;
	private boolean mayo; 
	private boolean ketchup;

	Sandwich(String name, float price, float calories, int quantity, short tomato, short lettuce, boolean mayo, boolean ketchup) {
		super(name, price, calories, quantity);
		this.tomato = tomato;
		this.lettuce = lettuce;
		this.mayo = mayo;
		this.ketchup = ketchup;
	}
	public short hasTomato() {
		return tomato;
	}
	public short hasLettuce() {
		return lettuce;
	}
	public boolean hasMayo() {
		return mayo;
	}
	public boolean hasKetchup() {
		return ketchup;
	}
}