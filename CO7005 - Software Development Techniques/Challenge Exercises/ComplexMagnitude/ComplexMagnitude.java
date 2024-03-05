import java.util.Random;

public class ComplexMagnitude {
	public static void main(String[] args) {
		int[] data = new int[100000];
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            data[i] = random.nextInt(10000);
        }
		long startTime = System.nanoTime();
		ON1(data);
		long endTime = System.nanoTime();
		System.out.println("O(n) Time taken: " + (endTime - startTime) / 1000 + " \u00B5s");
		startTime = System.nanoTime();
		ON2(data);
		endTime = System.nanoTime();
		System.out.println("O(n^2) Time taken: " + (endTime - startTime) / 1000 + " \u00B5s");
		startTime = System.nanoTime();
		ON3(data);
		endTime = System.nanoTime();
		System.out.println("O(n^3) Time taken: " + (endTime - startTime) / 1000 + " \u00B5s");
	}
	public static int ON1(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			result = array[i] * 2;
		}
		return result;
	}
	public static int ON2(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				result = array[i] * array[j];
			}
		}
		return result;
	}
	public static int ON3(int[] array) {
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				for (int k = 0; k < array.length; k++) {
					result = array[i] * array[j] * array[k];
				}
			}
		}
		return result;
	}
}