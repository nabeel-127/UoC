import Utilities.Calculator;

public class MyMath {
	public static void main(String[] args) {
		double a = 50, b = 10;
		Calculator calculator = new Calculator();

		double sum = calculator.sum(a, b);
		double difference = calculator.diffence(a, b);
		double multiplication = calculator.multiplication(a, b);
		double division = calculator.division(a, b);
		
		System.out.println("Sum = " + sum);
		System.out.println("Difference = " + difference);
		System.out.println("Multiplication = " + multiplication);
		System.out.println("Division = " + division);
	}
}