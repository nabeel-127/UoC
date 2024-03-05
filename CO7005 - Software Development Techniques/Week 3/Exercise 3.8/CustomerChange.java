import java.util.Scanner;
import java.math.BigDecimal;

public class CustomerChange {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter the customer change: ");
		double number = input.nextDouble();
		input.close();

		BigDecimal Number = BigDecimal.valueOf(number);

		int pounds = Number.intValue();
		int pences = Number.subtract(BigDecimal.valueOf(pounds)).movePointRight(2).intValue();

		int[] poundNotes = { 0, 0, 0, 0 };
		int[] penceCoins = { 0, 0, 0, 0, 0, 0, 0 };
		float[] poundMultiplier = { 50F, 20F, 10F, 5F }, penceMultiplier = { 100F, 50F, 20F, 10F, 5F, 2F, 1F };

		if (number <= 0)
			System.exit(1);

		for (int i = 0; number > 0; i++) {
			if (i >= poundNotes.length)
				break;
			poundNotes[i] = (int) (pounds / poundMultiplier[i]);
			pounds -= poundNotes[i] * poundMultiplier[i];
		}
		if (pounds != 0) {
				pences += pounds * 100;
		}
		for (int i = 0; number > 0; i++) {
			if (i >= penceCoins.length)
				break;
			
			penceCoins[i] = (int) (pences / penceMultiplier[i]);
			pences -= penceCoins[i] * penceMultiplier[i];
		}
		System.out.println("\n50\u00A3 note(s): " + poundNotes[0]);
		System.out.println("20\u00A3 note(s): " + poundNotes[1]);
		System.out.println("10\u00A3 note(s): " + poundNotes[2]);
		System.out.println("5\u00A3 note(s): " + poundNotes[3]);
		System.out.println("100 pence(s): " + penceCoins[0]);
		System.out.println("50 pence(s): " + penceCoins[1]);
		System.out.println("20 pence(s): " + penceCoins[2]);
		System.out.println("10 pence(s): " + penceCoins[3]);
		System.out.println("5 pence(s): " + penceCoins[4]);
		System.out.println("2 pence(s): " + penceCoins[5]);
		System.out.println("1 pence(s): " + penceCoins[6]);
	}
}