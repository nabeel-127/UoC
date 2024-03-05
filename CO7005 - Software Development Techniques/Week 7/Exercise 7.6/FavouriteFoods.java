import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FavouriteFoods {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] favouriteFoods = new String[5];
		for (int i = 0; i < 3; i++) {
			System.out.print("Enter your #" + (i + 1) + " favourite food: ");
			favouriteFoods[i] = input.nextLine();
		}
		System.out.print("Enter name of the file: ");
		String fileName = input.nextLine();
		CreateFile(fileName);
		WriteFile(fileName, favouriteFoods[0], false);
		WriteFile(fileName, favouriteFoods[1], true);
		WriteFile(fileName, favouriteFoods[2], true);
		ReadFile(fileName);
		for (int i = 3; i < favouriteFoods.length; i++) {
			System.out.print("Enter your #" + (i + 1) + " favourite food: ");
			favouriteFoods[i] = input.nextLine();
		}
		input.close();
		WriteFile(fileName, favouriteFoods[3], true);
		WriteFile(fileName, favouriteFoods[4], true);
	}
	static void CreateFile(String fileName) {
		try {
			File dataFile = new File(System.getProperty("user.dir") + File.separator + fileName);
			dataFile.createNewFile();
		} catch (IOException e) {
			System.out.println("CreateFile error: " + e);
		}
	}
	static void WriteFile(String fileName, String data, boolean append) {
		try {
			File dataFile = new File(System.getProperty("user.dir") + File.separator + fileName);
			FileWriter writer = new FileWriter(dataFile, append);
			writer.write(data + "\n");
			writer.close();
		} catch (IOException e) {
			System.out.println("WriteFile error: " + e);
		}
	}
	static void ReadFile(String fileName) {
		try {
			File dataFile = new File(System.getProperty("user.dir") + File.separator + fileName);
			Scanner read = new Scanner(dataFile);
			while (read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			read.close();
		} catch (FileNotFoundException e) {
			System.out.println("ReadFile error: " + e);
		}
	}
}