class Cat {
	private boolean adopted;
	private String breed;
	private String color;
	private int age;
	private String description;
	private long referenceNumber;
	private String owner = "N/A";

	Cat(boolean adopted, String breed, String color, int age, String description, long referenceNumber) {
		this.adopted = adopted;
		this.breed = breed;
		this.color = color;
		this.age = age;
		this.description = description;
		this.referenceNumber = referenceNumber;
	}
	boolean isAdopted() {
		return adopted;
	}
	String getBreed() {
		return breed;
	}
	String getColor() {
		return color;
	}
	int getAge() {
		return age;
	}
	String getDescription() {
		return description;
	}
	long getReferenceNumber() {
		return referenceNumber;
	}
	String getOwner() {
		return owner;
	}
	void adopted(boolean adopted) {
		this.adopted = adopted;
	}
	void setBreed(String breed) {
		this.breed = breed;
	}
	void setColor(String color) {
		this.color = color;
	}
	void setAge(int age) {
		this.age = age;
	}
	void setDescription(String description) {
		this.description = description;
	}
	void setOwner(String owner) {
		this.owner = owner;
	}
	void displayInfo() {
		System.out.println("Reference # " + referenceNumber);
		System.out.println("Cat breed: " + breed);
		System.out.println("Cat color: " + color);
		System.out.println("Cat age: " + age);
		System.out.println("Cat description: " + description);
		if (adopted == true)
			System.out.println("Cat is unavailable for adoption");
		else 
			System.out.println("Cat is still available for adoption");
	}
}