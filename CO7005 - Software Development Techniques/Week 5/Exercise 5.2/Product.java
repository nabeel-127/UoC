abstract public class Product {
    protected String name;
    protected float price, calories;
    protected int quantity;

	Product(String name, float price, float calories, int quantity) {
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.quantity = quantity;
	}
	String getName() {
		return name;
	}
	float getPrice() {
		return price;
	}
	float getCalories() {
		return calories;
	}
	int getQuantity() {
		return quantity;
	}
}