import java.util.Scanner;

public class SimpleCatering {
    public static void main(String[] args) {
		String drinkName, sandwichName, snackName, snackSize;
		float drinkPrice, drinkCalories, sandwichPrice, sandwichCalories, snackPrice, snackCalories;
		int drinkQuantity, sandwichQuantity, snackQuantity;
		boolean drinkIsFizzy;

		System.out.print("\033[H\033[2J");
		System.out.flush();
		Scanner input = new Scanner(System.in);
		System.out.println("1. Coke");
		System.out.println("2. 7UP");
		System.out.println("3. Fanta");
		System.out.print("Choose your drink: ");
		short drinkChoice = input.nextShort();
		System.out.print("How many? ");
		drinkQuantity = input.nextInt();

		System.out.println("1. Chicken");
		System.out.println("2. Ham");
		System.out.println("3. Bacon");
		System.out.print("Choose your sandwich: ");
		short sandwichChoice = input.nextShort();
		System.out.print("How many? ");
		sandwichQuantity = input.nextInt();

		System.out.println("1. Fries");
		System.out.println("2. Popcorn");
		System.out.print("Choose your snack: ");
		short snackChoice = input.nextShort();
		System.out.print("How many? ");
		snackQuantity = input.nextInt();
		input.close();

		switch (drinkChoice) {
			case 1:
			drinkName = "Coke";
			drinkPrice = 1F;
			drinkCalories = 150F;
			drinkIsFizzy = true;
			break;
			case 2:
			drinkName = "7UP";
			drinkPrice = 1F;
			drinkCalories = 150F;
			drinkIsFizzy = true;
			break;
			case 3:
			drinkName = "Fanta";
			drinkPrice = 1F;
			drinkCalories = 150F;
			drinkIsFizzy = true;
			break;
			default:
			drinkName = " ";
			drinkPrice = 0F;
			drinkCalories = 0F;
			drinkIsFizzy = false;
			System.out.println("Incorrect choice of drink");
		}
		Drink myDrink = new Drink(drinkName, drinkPrice, drinkCalories, drinkQuantity, drinkIsFizzy);

		switch (sandwichChoice) {
			case 1:
			sandwichName = "Chicken";
			sandwichPrice = 5F;
			sandwichCalories = 200F;
			break;
			case 2:
			sandwichName = "Ham";
			sandwichPrice = 6F;
			sandwichCalories = 250F;
			break;
			case 3:
			sandwichName = "Bacon";
			sandwichPrice = 7F;
			sandwichCalories = 270F;
			break;
			default:
			sandwichName = " ";
			sandwichPrice = 0F;
			sandwichCalories = 0F;
			System.out.println("Incorrect choice of sandwich");
		}
		Sandwich mySandwich = new Sandwich(sandwichName, sandwichPrice, sandwichCalories, sandwichQuantity, (short) 2, (short) 3, true, true);

		switch (snackChoice) {
			case 1:
			snackName = "Fries";
			snackPrice = 2F;
			snackCalories = 350F;
			snackSize = "Small";
			break;
			case 2:
			snackName = "Popcorn";
			snackPrice = 3F;
			snackCalories = 375F;
			snackSize = "Large";
			break;
			default:
			snackName = " ";
			snackPrice = 0F;
			snackCalories = 0F;
			snackSize = " ";
			System.out.println("Incorrect choice of snack");
		}
		Snack mySnack = new Snack(snackName, snackPrice, snackCalories, snackQuantity, snackSize);

		System.out.print("\n\n\033[H\033[2J");
		System.out.flush();

		System.out.println("YOUR ORDER:\n");

		System.out.println("Drink: " + myDrink.getName());
		System.out.println("Drink Quantity: " + myDrink.getQuantity());
		System.out.println("Drink Price: " + myDrink.getPrice());
		System.out.println("Drink Info:");
		System.out.println("\tCalories: " + myDrink.getCalories());
		System.out.println("\tDrink type: " + (myDrink.IsFizzy() ? "Fizzy\n" : "Not Fizzy\n"));

		System.out.println("Sandwich: " + mySandwich.getName());
		System.out.println("Sandwich Quantity: " + mySandwich.getQuantity());
		System.out.println("Sandwich Price: " + mySandwich.getPrice());
		System.out.println("Sandwich Info:");
		System.out.println("\tCalories: " + mySandwich.getCalories());
		System.out.println("\tToppings:");
		System.out.println("\t\tTomatoes: " + mySandwich.hasTomato());
		System.out.println("\t\tLettuce: " + mySandwich.hasLettuce());
		System.out.println("\t\tMayo: " + mySandwich.hasMayo());
		System.out.println("\t\tKetchup: " + mySandwich.hasKetchup() + "\n");

		System.out.println("Snack: " + mySnack.getName());
		System.out.println("Snack Quantity: " + mySnack.getQuantity());
		System.out.println("Snack Price: " + mySnack.getPrice());
		System.out.println("Snack Info:");
		System.out.println("\tCalories: " + mySnack.getCalories());
		System.out.println("\tSnack Size: " + mySnack.getSize() + "\n");

		System.out.println("Final Bill: " + (myDrink.getPrice() + mySandwich.getPrice() + mySnack.getPrice()));
	}
}