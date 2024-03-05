import java.util.Scanner;

public class Money {
	public static void main(String[] args) {
		Scanner inputObject = new Scanner(System.in);
		int pound10, pound20, pound50;
		long totalNotes, totalMoney;
		System.out.print("Enter the number of 10 pound notes: ");
		pound10 = inputObject.nextInt();
		System.out.print("Enter the number of 20 pound notes: ");
		pound20 = inputObject.nextInt();
		System.out.print("Enter the number of 50 pound notes: ");
		pound50 = inputObject.nextInt();
		totalNotes = pound10 + pound20 + pound50;
		totalMoney = (pound10 * 10) + (pound20 * 20) + (pound50 * 50);
		System.out.println("Total notes:\t" + totalNotes);
		System.out.println("Total money:\t" + totalMoney);
		inputObject.close();
	}
}