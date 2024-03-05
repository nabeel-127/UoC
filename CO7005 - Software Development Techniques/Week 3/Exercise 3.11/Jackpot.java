import java.util.Scanner;
import java.util.Random;

public class Jackpot {
	public static void main(String[] args) {

		Random random = new Random();
		int [] userNumbers = {0, 0, 0, 0, 0, 0}, randomNumbers = {0, 0, 0, 0, 0, 0};
		int count = 0;
		
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			System.out.print("Enter the '" + (i + 1) + "' number: ");
			userNumbers[i] = input.nextInt();
			for (int j = i - 1; j >= 0; j--) {
				if (userNumbers[i] == userNumbers[j]) {
					i--;
					break;
				}
			}
		}
		input.close();

		System.out.print("Random numbers: ");
		for (int i = 0; i < 6; i++) {
			randomNumbers[i] = 1 + random.nextInt(7);
			System.out.print(randomNumbers[i] + " ");
			for (int j = i - 1; j >= 0; j--) {
				if (randomNumbers[i] == randomNumbers[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if (userNumbers[i] == randomNumbers[j]) {
					count++;
					break;
				}
			}
		}
		System.out.println("\nCount: " + count);

		switch (count) {
			case 3:
				System.out.println("You've won \u00A350!");
				break;
			case 4:
				System.out.println("You've won \u00A325,000!");
				break;
			case 5:
				System.out.println("You've won \u00A3120,000!");
				break;
			case 6:
				System.out.println("You've won \u00A32,400,000 (jackpot!)");
				break;
			default:
				System.out.println("Better luck next time...");
		}
	}
}