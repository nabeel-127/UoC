import java.util.Scanner;

public class FiveStudents {
	public static void main(String[] args) {
		Scanner inputObject = new Scanner(System.in);
		int[] scores = { 0, 0, 0, 0, 0 };
		for (int i = 0; i < 5; i++) {
			System.out.print("Enter the marks(0-100) of student " + i + ": ");
			scores[i] = inputObject.nextInt();
			if (scores[i] > 100 || scores[i] < 0) {
				i--;
			}
		}
		int average = (scores[0] + scores[1] + scores[2] + scores[3] + scores[4]) / 5;
		for (int i = 0; i < 5; i++) {
			System.out.print("Student " + i + " has ");
			System.out.println(scores[i] >= 50 ? "Passed" : "Failed");
		}
		System.out.println("Average is " + average);
		inputObject.close();
	}
}