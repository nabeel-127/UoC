import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ProductFiles {
	public static void main(String[] args) {
		List<Product> myProduct = new ArrayList<Product>();
		// Product[] myProduct = new Product[3];
		String[] product = {"Fries", "Chicken", "Ham"};
		for (int i = 0; i < 3; i++) {
			myProduct.add(new Product(product[i], 2, 200, (1 + i)));
		}
		String FileName = "DataFile.dat";
		CreateFile(FileName);
		WriteStream(FileName, myProduct);
		myProduct = null;
		myProduct = ReadStream(FileName);
		boolean loopCondition = true;
		while (loopCondition) {
			int choice;
			Scanner input = new Scanner(System.in);
			System.out.println("1. Display all products");
			System.out.println("2. Add a product");
			System.out.println("3. Delete a product");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");
			choice = input.nextInt();
			// input.nextLine();
			// System.out.print("\033[H\033[2J");  
		    // System.out.flush();
			switch (choice) {
			case 1:
				myProduct = ReadStream(FileName);
				for (int i = 0; i < myProduct.size(); i++) {
					myProduct.get(i).display();
				}
				break;
			case 2:
				input.nextLine();
				System.out.print("Enter product name: ");
				String name = input.nextLine();
				System.out.print("Enter product price: ");
				float price = input.nextFloat();
				System.out.print("Enter product calories: ");
				int calories = input.nextInt();
				System.out.print("Enter product quantity: ");
				int quantity = input.nextInt();
				myProduct.add(new Product(name, price, calories, quantity));
				WriteStream(FileName, myProduct);
				break;
			case 3:
				System.out.print("Enter the product index: ");
				int index = input.nextShort();
				if ((myProduct.size() > 0) && (index <= myProduct.size()))
					myProduct.remove(index - 1);
				WriteStream(FileName, myProduct);
				break;
			case 4:
				loopCondition = false;
				input.close();
				break;
			default:
				System.out.println("Invalid input. Try again");
				break;
			}
		}
	}
	static void CreateFile(String fileName) {
		try {
			File dataFile = new File(System.getProperty("user.dir") + File.separator + fileName);
			dataFile.createNewFile();
		} catch (IOException e) {
			System.out.println("CreateFile error: " + e);
		}
	}
	static void WriteStream(String FileName, List<Product> Data) {
		try {
			FileOutputStream MyFileOutputStream = new FileOutputStream(System.getProperty("user.dir") + File.separator + FileName);
			ObjectOutputStream MyObjectOutputStream = new ObjectOutputStream(MyFileOutputStream);
			MyObjectOutputStream.writeObject(Data);
			MyObjectOutputStream.close();
		} catch (Exception e) {
			System.out.println("WriteStream error: " + e);
		}
	}
	static List<Product> ReadStream(String FileName) {
		List<Product> myProduct = new ArrayList<Product>();
		try {
			FileInputStream MyFileInputStream = new FileInputStream(System.getProperty("user.dir") + File.separator + FileName);
			ObjectInputStream MyObjectInputStream = new ObjectInputStream(MyFileInputStream);
			// myProduct = (List<Product>) MyObjectInputStream.readObject();
			Object object = MyObjectInputStream.readObject();
			if (object instanceof List<?>) {
				for (Object o : (List<?>) object) {
					myProduct.add(Product.class.cast(o));
				}
			}
			MyObjectInputStream.close();
		} catch (Exception e) {
			System.out.println("ReadStream error: " + e);
		}
		return myProduct;
	}
}