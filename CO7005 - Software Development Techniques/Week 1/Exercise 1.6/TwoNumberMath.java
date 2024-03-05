import java.util.Scanner;

public class TwoNumberMath {
	public static void main(String[] args) {
		Scanner myObject = new Scanner(System.in);
		System.out.print("Enter the 1st number: ");
		int myNumber1 = myObject.nextInt();
		System.out.print("Enter the 2nd number: ");
		int myNumber2 = myObject.nextInt();
		myObject.close();
		System.out.println("The sum(" + myNumber1 + " + " + myNumber2 + ") of the given numbers is: " + (myNumber1 + myNumber2));
		System.out.println("The difference(" + myNumber1 + " - " + myNumber2 + ") of the given numbers is: " + (myNumber1 - myNumber2));
		System.out.println("The quotient(" + myNumber1 + " / " + myNumber2 + ") of the given numbers is: " + (myNumber1 / myNumber2));
		System.out.println("The product(" + myNumber1 + " * " + myNumber2 + ") of the given numbers is: " + (myNumber1 * myNumber2));
	}
}