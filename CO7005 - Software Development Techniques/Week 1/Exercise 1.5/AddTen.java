import java.util.Scanner;

public class AddTen {
	public static void main(String[] args) {
		Scanner myObject = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int myNumber = myObject.nextInt();
		myObject.close();
		System.out.println("The sum of the given number with 10 is: " + (myNumber + 10));
	}
}