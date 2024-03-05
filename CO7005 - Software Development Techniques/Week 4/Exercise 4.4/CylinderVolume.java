import java.util.Scanner;

public class CylinderVolume {
	static float calculateVolume(float height, float radius) {
		return 3.14159F * (radius * radius) * height;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the radius of the cylinder: ");
		float radius = input.nextFloat();
		System.out.print("Enter the height of the cylinder: ");
		float height = input.nextFloat();
		input.close();

		System.out.print("The volume of a cylinder with a radius of ");
		System.out.print(radius + "and a height of ");
		System.out.print(height + " is ");
		System.out.print(calculateVolume(height, radius) + " cubic centimetres");
	}
}