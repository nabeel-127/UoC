import java.util.Scanner;

class CestrianInsurance {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalPremium = 0;
		String vehicle;
		while (true) {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.print("Enter the type of vehicle (car/motorcycle): ");
			vehicle = input.next();
			if (vehicle.equalsIgnoreCase("car")) {
				totalPremium += 305;
				break;
			} else if (vehicle.equalsIgnoreCase("motorcycle")) {
				totalPremium += 360;
				break;
			}
		}

		System.out.print("Enter your age: ");
		int age = input.nextInt();
		if (age < 1 || age > 125)
			System.exit(1);
		else if (age < 25)
			totalPremium += (int) (totalPremium * 0.3);

		System.out.print("Enter your penalty points: ");
		int points = input.nextInt();
		input.close();
		if (points < 0)
			System.exit(1);
		else if (points > 6)
			totalPremium += 100;
		else
			totalPremium += 0;

		System.out.print("Total Premium: " + totalPremium);
	}
}