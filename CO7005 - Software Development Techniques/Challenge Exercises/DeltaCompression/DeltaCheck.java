import java.util.Scanner;
import java.util.Map;

public class DeltaCheck {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.print("Enter the initial value: ");
			String original = input.nextLine();
			System.out.print("Enter the changed value: ");
			String modified = input.nextLine();
			String restored;

			Map<Integer, Byte> delta = DeltaCompression.dataEncode(original, modified);
			restored = DeltaCompression.dataDecode(original, delta);

			System.out.println("\nOriginal: " + original);
			System.out.println("Modified: " + modified);
			System.out.println("Result after applying delta to original: " + restored);

			System.out.println("\nEnter 'Y' to exit, any other key to try again: ");
			if ((input.nextLine()).equalsIgnoreCase("Y")) {
				input.close();
				break;
			}
		}
	}
}