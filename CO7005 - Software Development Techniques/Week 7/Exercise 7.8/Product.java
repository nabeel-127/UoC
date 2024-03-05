import java.io.Serializable;

public class Product implements Serializable {
	private String name;
	private float price;
	private int calories, quantity;
	Product(String name, float price, int calories, int quantity) {
		this.name = name;
		this.price = price;
		this.calories = calories;
		this.quantity = quantity;
	}
	void display() {
		System.out.println("Name: " + name);
		System.out.println("Price: " + price);
		System.out.println("calories: " + calories);
		System.out.println("quantity: " + quantity);
	}
}