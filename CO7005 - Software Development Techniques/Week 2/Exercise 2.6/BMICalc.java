import java.util.Scanner;

public class BMICalc {
	public static void main(String[] args) {
		Scanner inputObject = new Scanner(System.in);
		float weight, height;
		double BMI;
		System.out.print("Enter weight in kg: ");
		weight = inputObject.nextFloat();
		System.out.print("Enter height in metres: ");
		height = inputObject.nextFloat();
		BMI = weight / (height * height);
		System.out.println("BMI: " + BMI);
		inputObject.close();
	}
}