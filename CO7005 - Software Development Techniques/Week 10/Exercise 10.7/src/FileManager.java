import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	static short WriteFile(String fileName, String data, boolean append) {
		try {
			File dataFile = new File(System.getProperty("user.dir") + File.separator + fileName);
			FileWriter writer = new FileWriter(dataFile, append);
			writer.write(data + "\n");
			writer.close();
			return 0;
		} catch (IOException e) {
			System.out.println("WriteFile error: " + e);
			return 1;
		}
	}
	static short ReadFile(String fileName) throws IOException {
		try {
			File dataFile = new File(System.getProperty("user.dir") + File.separator + fileName);
			Scanner read = new Scanner(dataFile);
			while (read.hasNextLine()) {
				System.out.println(read.nextLine());
			}
			read.close();
			return 0;
		} catch (FileNotFoundException e) {
			System.out.println("ReadFile error: " + e);
			throw new IOException("ExceptionAlwaysThrown");
		}
	}
}