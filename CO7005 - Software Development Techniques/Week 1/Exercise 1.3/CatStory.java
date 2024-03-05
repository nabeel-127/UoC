import java.util.Scanner;

public class CatStory {
	public static void main(String[] args) {
		Scanner myObject = new Scanner(System.in);
		System.out.print("Enter a name of your choice for a pet cat: ");
		String catName = myObject.nextLine();
		myObject.close();
		System.out.print("Amina strolled through the park with her beloved pet cat, " + catName);
		System.out.print(", nestled comfortably in her arms. " + catName);
		System.out.print(", with his soft fur and bright green eyes, had been her faithful companion for years. As the sun began to set, Amina whispered to " + catName);
		System.out.print(", urging him to head home, their bond stronger than ever." + catName);
	}
}