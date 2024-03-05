public class MyData implements MinMax {
	@Override public int min(int[] arrayIn) {
		int min = arrayIn[0];
		for (int i = 1; i < arrayIn.length; i++) {
			min = min < arrayIn[i] ? min : arrayIn[i];
		}
		return min;
	}
	@Override public int max(int[] arrayIn) {
		int max = arrayIn[0];
		for (int i = 0; i < arrayIn.length; i++) {
			max = max > arrayIn[i] ? max : arrayIn[i];
		}
		return max;
	}
	public static void main(String[] args) {
		int[] array1 = {2, 4, -10, 80, 10}, array2 = {3, 5, 7, 9, 11};
		MyData myData = new MyData();
		int min1 = myData.min(array1);
		int min2 = myData.min(array2);
		int max1 = myData.max(array1);
		int max2 = myData.max(array2);
		System.out.println("Min1 = " + min1);
		System.out.println("Max1 = " + max1);
		System.out.println("Min2 = " + min2);
		System.out.println("Max2 = " + max2);
	}
}