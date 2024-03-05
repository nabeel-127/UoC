import java.util.Scanner;

public class SalaryCheck {
	public static void main(String[] args) {
		System.out.print("\n\n\033[H\033[2J");
		System.out.flush();
		Scanner input = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Enter an integer: ");
				int number = input.nextInt();
				if (number < 0)
					throw new IllegalArgumentException("Negative Number Entered");
				else {
					System.out.println("Correct input: " + number);
					break;
				}
			} catch (IllegalArgumentException e) {
				System.out.print("\n\n\033[H\033[2J");
				System.out.flush();
				System.out.println("Invalid input, enter a positive integer...");
			} catch (Exception e) {
				input.nextLine();
				System.out.print("\n\n\033[H\033[2J");
				System.out.flush();
				System.out.println("Invalid input, enter an integer...");
			}
		}
		input.close();
	}
}