import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class CatHome {
	static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int choice;
		boolean exit = false;
		ArrayList<Cat> cats = new ArrayList<Cat>();
		cats.add(new Cat(false, "Birman", "White", 3, "Loves to play and chill", 123456));
		cats.add(new Cat(true, "Main Coon", "Grey", 4, "Enjoys its personal space", 123457));
		cats.add(new Cat(false, "Birman", "Dark Grey", 1, "Loves head scratches", 123458));

		while (!exit) {
			clearScreen();
			System.out.println("1. View available cats");
			System.out.println("2. View adopted cats");
			System.out.println("3. Add a new cat");
			System.out.println("4. Remove a cat");
			System.out.println("5. Adopt a cat");
			System.out.println("6. Edit a cat");
			System.out.println("7. Search");
			System.out.println("8. Exit");
			System.out.print("Choose an option: ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				clearScreen();
				availableCats(cats);
				pressEnterToContinue();
				break;
			case 2:
				clearScreen();
				unavailableCats(cats);
				pressEnterToContinue();
				break;
			case 3:
				clearScreen();
				addCat(cats);
				pressEnterToContinue();
				break;
			case 4:
				clearScreen();
				removeCat(cats);
				pressEnterToContinue();
				break;
			case 5:
				clearScreen();
				adoptCat(cats);
				pressEnterToContinue();
				break;
			case 6:
				clearScreen();
				editCatReference(cats);
				pressEnterToContinue();
				break;
			case 7:
				clearScreen();
				search(cats);
				pressEnterToContinue();
				break;
			case 8:
				exit = true;
				input.close();
				break;
			default:
				System.out.println("Invalid entry.");
				break;
			}
		}
		input.close();
	}
	static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	static void pressEnterToContinue()
	{
		System.out.println("Press Enter key to continue...");
		try {
			System.in.read();
			input.nextLine();
		} catch (Exception e) {}
	}

	static void availableCats(ArrayList<Cat> cats) {
		boolean exists = false;
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).isAdopted() == false) {
				exists = true;
				cats.get(i).displayInfo();
				System.out.println();
			}
		}
		if (exists == false)
			System.out.println("No cats currently up for adoption.");
	}
	static void unavailableCats(ArrayList<Cat> cats) {
		boolean exists = false;
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).isAdopted() == true) {
				exists = true;
				System.out.println("Owner: " + cats.get(i).getOwner());
				cats.get(i).displayInfo();
				System.out.println();
			}
		}
		if (exists == false)
			System.out.println("No cats currently adopted.");
	}
	static void addCat(ArrayList<Cat> cats) {
		input.nextLine();
		System.out.print("Enter breed of cat: ");
		String breed = input.nextLine();
		System.out.print("Enter color of cat: ");
		String color = input.nextLine();
		System.out.print("Enter age of cat: ");
		int age = input.nextInt();
		input.nextLine();
		System.out.print("Enter any description for the cat: ");
		String description = input.nextLine();
		int referenceNumber;
		while (true) {
			referenceNumber = generateReferenceNumber(cats);
			if (validReferenceNumber(cats, referenceNumber))
				break;
		}
		cats.add(new Cat(false, breed, color, age, description, referenceNumber));
	}
	static void removeCat(ArrayList<Cat> cats) {
		input.nextLine();
		System.out.print("Enter the reference number: ");
		long referenceNumber = input.nextLong();
		boolean exists = false;
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getReferenceNumber() == referenceNumber) {
				cats.remove(i);
				exists = true;
			}
		}
		if (exists == false)
			System.out.println("Cat not found in the system");
	}
	static void adoptCat(ArrayList<Cat> cats) {
		input.nextLine();
		System.out.print("Enter the reference number: ");
		long referenceNumber = input.nextLong();
		input.nextLine();
		boolean exists = false;
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getReferenceNumber() == referenceNumber) {
				exists = true;
				if (cats.get(i).isAdopted()) {
					System.out.println("Cat already adopted");
					break;
				}
				System.out.print("Enter owner name: ");
				String owner = input.nextLine();
				cats.get(i).setOwner(owner);
				cats.get(i).adopted(true);
				break;
			}
		}
		if (exists == false)
			System.out.println("Cat not found in the system");
	}
	static void editCatReference(ArrayList<Cat> cats) {
		input.nextLine();
		System.out.print("Enter the reference number: ");
		long referenceNumber = input.nextLong();
		input.nextLine();
		boolean exists = false;
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getReferenceNumber() == referenceNumber) {
				exists = true;
				editCat(cats, i);
			}
		}
		if (exists == false)
			System.out.println("Cat not found in the system");
	}
	static void editCat(ArrayList<Cat> cats, int i) {
		clearScreen();
		System.out.println("1. Owner");
		System.out.println("2. Breed");
		System.out.println("3. Color");
		System.out.println("4. Age");
		System.out.println("5. Description");
		System.out.print("Choose a parameter to edit: ");
		int choice = input.nextInt();
		input.nextLine();
		clearScreen();
		switch (choice) {
		case 1:
			editOwner(cats, i);
			break;
		case 2:
			editBreed(cats, i);
			break;
		case 3:
			editColor(cats, i);
			break;
		case 4:
			editAge(cats, i);
			break;
		case 5:
			editDescription(cats, i);
			break;
		default:
			System.out.println("Invalid entry");
		}
	}
	static void editOwner(ArrayList<Cat> cats, int i) {
		System.out.print("Enter new owner name: ");
		String owner = input.nextLine();
		cats.get(i).setOwner(owner);
	}
	static void editBreed(ArrayList<Cat> cats, int i) {
		System.out.print("Enter new breed: ");
		String breed = input.nextLine();
		cats.get(i).setBreed(breed);
	}
	static void editColor(ArrayList<Cat> cats, int i) {
		System.out.print("Enter new color: ");
		String color = input.nextLine();
		cats.get(i).setColor(color);
	}
	static void editAge(ArrayList<Cat> cats, int i) {
		System.out.print("Enter new age: ");
		int age = input.nextInt();
		input.nextLine();
		cats.get(i).setAge(age);
	}
	static void editDescription(ArrayList<Cat> cats, int i) {
		System.out.print("Enter new description: ");
		String description = input.nextLine();
		cats.get(i).setDescription(description);
	}
	static void search(ArrayList<Cat> cats) {
		input.nextLine();
		System.out.println("1. Search by cat breed");
		System.out.println("2. Search by cat age");
		System.out.print("Choose an option: ");
		int choice = input.nextInt();
		input.nextLine();
		switch (choice) {
			case 1:
				clearScreen();
				System.out.print("Enter cat breed: ");
				String breed = input.nextLine();
				searchCatBreed(cats, breed);
				break;
			case 2:
				clearScreen();
				System.out.print("Enter cat age: ");
				int age = input.nextInt();
				input.nextLine();
				searchCatAge(cats, age);
				break;
			default:
				System.out.print("Invalid entry");
		}
	}
	static void searchCatBreed(ArrayList<Cat> cats, String breed) {
		boolean exists = false;
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getBreed().equalsIgnoreCase(breed)) {
				cats.get(i).displayInfo();
				exists = true;
				System.out.print("Press 'Y' to edit this cat: ");
				String choice = input.nextLine();
				if (choice.equalsIgnoreCase("Y"))
					editCat(cats, i);
				System.out.println();
			}
		}
		if (exists == false)
			System.out.println("No such cat breed are present in out system");
	}
	static void searchCatAge(ArrayList<Cat> cats, int age) {
		boolean exists = false;
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getAge() == age) {
				cats.get(i).displayInfo();
				exists = true;
				System.out.print("Press 'Y' to edit this cat: ");
				String choice = input.nextLine();
				if (choice.equalsIgnoreCase("Y"))
					editCat(cats, i);
			}
		}
		if (exists == false)
			System.out.println("No such cats are present in our system");
	}

	static int generateReferenceNumber(ArrayList<Cat> cats) {
		Random random = new Random();
		return random.nextInt(123456, 999999);
	}
	static boolean validReferenceNumber(ArrayList<Cat> cats, int referenceNumber) {
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getReferenceNumber() == referenceNumber) {
				return false;
			}
		}
		return true;
	}
}