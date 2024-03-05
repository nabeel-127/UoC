import java.util.Arrays;
import java.util.Random;

public class NumberSort {
	public static void main(String[] args) {
		Random random = new Random();
		int[] array = new int[25];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(100);
		}
		System.out.println("Unsorted array:");
		System.out.println(Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("Sorted array:");
		System.out.println(Arrays.toString(array));
	}
}