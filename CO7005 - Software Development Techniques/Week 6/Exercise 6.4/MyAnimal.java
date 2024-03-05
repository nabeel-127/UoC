public class MyAnimal implements Pet, Rabbit {
	@Override public void stroke() {
		System.out.println("Stroke!!!");
	}
	@Override public void bark() {
		System.out.println("Bark!!!");
	}
	public static void main(String[] args) {
		MyAnimal animal = new MyAnimal();
		animal.stroke();
		animal.bark();
	}
}